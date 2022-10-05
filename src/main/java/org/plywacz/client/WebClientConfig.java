package org.plywacz.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
class WebClientConfig {
    @Value("${booksProviderUrl}")
    private String booksProviderUrl;

    @Bean
    WebClient webClient() {
        return WebClient.create(booksProviderUrl);
    }
}
