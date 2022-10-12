package org.plywacz.client;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.List;

@Service
@Log4j2
class AuthorClient {
    private final WebClient webClient;

    AuthorClient(@Value("${booksProviderUrl}") String authorsProviderUrl) {
        this.webClient = WebClient.create(authorsProviderUrl);
    }


    Mono<Collection<Author>> fetchAllBooks() {
        return webClient
                .get()
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Collection<Author>>() {
                })
                .onErrorReturn(error -> {
                            log.error("Error during fetching data from Authors rest api", error);
                            return true;
                        },
                        List.of()
                );

    }
}