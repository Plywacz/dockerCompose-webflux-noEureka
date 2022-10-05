package org.plywacz.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@Service
@AllArgsConstructor
class BookService {
    private final BookClient bookClient;

    @GetMapping()
    Mono<Collection<ExtendedBook>> allExtendedBooks() {
        return bookClient
                .fetchAllBooks()
                .map(this::extendBooks);
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
        return "extension: " + new Random().nextInt(9999);
    }
}
