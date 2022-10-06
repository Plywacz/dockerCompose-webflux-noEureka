package org.plywacz.client;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
class BookClient {
    private final WebClient webClient;

    Mono<Collection<Book>> fetchAllBooks() {
        return webClient
                .get()
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Collection<Book>>() {
                })
                .onErrorReturn(error -> {
                            log.error("Error during fetching data from Books rest api", error);
                            return true;
                        },
                        List.of()
                );

    }
}
