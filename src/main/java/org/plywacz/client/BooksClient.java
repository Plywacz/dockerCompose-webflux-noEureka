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
class BooksClient {
    private final WebClient webClient;

    BooksClient(@Value("${booksProviderUrl}") String booksProviderUrl) {
        this.webClient = WebClient.create(booksProviderUrl);
    }


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
