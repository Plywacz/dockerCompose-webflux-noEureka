package org.plywacz.client;

import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@AllArgsConstructor
class BookClient {
    private final WebClient webClient;

    Mono<List<Book>> fetchAllBooks() {
        return webClient
                .get()
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }
}
