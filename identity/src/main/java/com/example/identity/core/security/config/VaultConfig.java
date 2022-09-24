/*
package com.example.identity.core.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

import java.net.URI;

//docker run --name vault -p 8200:8200 --cap-add=IPC_LOCK -e 'VAULT_DEV_ROOT_TOKEN_ID=myroot' -e 'VAULT_DEV_LISTEN_ADDRESS=0.0.0.0:8200' vault
@Configuration
public class VaultConfig extends AbstractVaultConfiguration {

    @Override
    public VaultEndpoint vaultEndpoint() {
        return VaultEndpoint.from(URI.create(getEnvironment().getProperty("spring.cloud.vault.uri", "")));
    }

    @Override
    public ClientAuthentication clientAuthentication() {
        return new TokenAuthentication(getEnvironment().getProperty("spring.cloud.vault.token", ""));
    }
}

@Component
@VaultPropertySource(value = "secret/jwt", ignoreSecretNotFound = false)
public class JwtProperties {

    @Value("${expirationMillis}")
    private long expirationMillis;

    @Value("${issuer}")
    private String issuer;

    @Value("${secret}")
    private String secret;

    public JwtProperties() {
    }

    public JwtProperties(long expirationMillis, String issuer, String secret) {
        this.expirationMillis = expirationMillis;
        this.issuer = issuer;
        this.secret = secret;
    }

    public long getExpirationMillis() {
        return expirationMillis;
    }

    public String getIssuer() {
        return issuer;
    }

    public String getSecret() {
        return secret;
    }

}
*/
