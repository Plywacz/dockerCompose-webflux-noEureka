package org.plywacz.client;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Collection;

@RestController
@RequestMapping("extendedBooks")
@AllArgsConstructor
@Log4j2
class BookController {
    private final BookService bookService;

    @GetMapping()
    public Mono<Collection<ExtendedBook>> allExtendedBooks() {
        log.always().log("allExtendedBooks: getting mono");
        Mono<Collection<ExtendedBook>> monoBooks = bookService.allExtendedBooks();
        log.always().log("allExtendedBooks: returning mono");
        return monoBooks;
    }
}
