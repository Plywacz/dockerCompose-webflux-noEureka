package org.plywacz.client;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Log4j2
class BookService {
    private final BookClient bookClient;

    @GetMapping()
    Mono<ExtendedBookOutput> allExtendedBooks() {
        return bookClient.fetchAllBooks()
                .map(this::extendBooks)
                .map(this::createExtendedBookOutput)
                .onErrorReturn(exc -> {
                            log.error("error during extending books", exc);
                            return true;
                        },
                        new ExtendedBookOutput(Optional.of("error during extending books"), List.of())
                );
    }

    private ExtendedBookOutput createExtendedBookOutput(Collection<ExtendedBook> extendedBooks) {
        if (extendedBooks.isEmpty()) {
            return new ExtendedBookOutput(Optional.of("No books received from books rest api"), Collections.emptyList());
        } else {
            return new ExtendedBookOutput(Optional.empty(), extendedBooks);
        }
    }

    private Collection<ExtendedBook> extendBooks(Collection<Book> books) {
        return books.stream()
                .map(this::extendBook)
                .collect(Collectors.toList());
    }

    private ExtendedBook extendBook(Book book) {
        return new ExtendedBook(book, generateSomeExtendingData());
    }

    private String generateSomeExtendingData() {
        simulateHeavyOperationSoReactivityMakesSense();
        return "extension: " + new Random().nextInt(9999);
    }

    private static void simulateHeavyOperationSoReactivityMakesSense() {
        try {
            log.always().log("Processing one book from remote service: will take 700ms (heavy operation)");
            Thread.sleep(700);
        } catch (InterruptedException e) {
            log.always().log("Thread sleep error: ", e);
        }
    }
}
