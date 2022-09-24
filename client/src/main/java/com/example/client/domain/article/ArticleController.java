package com.example.client.domain.article;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final WebClient webClient;

    @Autowired
    public ArticleController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping()
    @CircuitBreaker(name = "general", fallbackMethod = "")
    public Mono<String> getArticle(@RegisteredOAuth2AuthorizedClient("gateway-authorization-code") OAuth2AuthorizedClient authorizedClient) {

        return this.webClient
                .get()
                .uri("lb://RESOURCE/articles")
                .attributes(oauth2AuthorizedClient(authorizedClient))
                .retrieve()
                .onStatus(HttpStatus::isError,
                        response -> switch (response.rawStatusCode()) {
                            case 403 -> Mono.error(new Exception("insufficient authorities to settle request"));
                            default -> Mono.error(new Exception("general exception"));
                        })
                .bodyToMono(String.class);
    }
}