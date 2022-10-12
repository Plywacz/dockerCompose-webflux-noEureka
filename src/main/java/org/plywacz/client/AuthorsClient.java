package org.plywacz.client;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Log4j2
class AuthorsClient {
    private final WebClient webClient;

    AuthorsClient(@Value("${authorsProviderUrl}") String authorsProviderUrl) {
        this.webClient = WebClient.create(authorsProviderUrl);
    }


    List<Author> fetchAllAuthors() {
        return webClient
                .get()
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Author>>() {
                })
                .onErrorReturn(error -> {
                            log.error("Error during fetching data from Authors rest api", error);
                            return true;
                        },
                        List.of()
                ).block();

    }
}