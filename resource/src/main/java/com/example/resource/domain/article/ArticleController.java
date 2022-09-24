package com.example.resource.domain.article;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @GetMapping
    @PreAuthorize("hasAuthority('INITIAL_AUTHORITY')")
    public ResponseEntity<String> getArticle() {
        Collection<? extends GrantedAuthority> bla = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return new ResponseEntity<>("Article 1", HttpStatus.OK) ;
    }
}
