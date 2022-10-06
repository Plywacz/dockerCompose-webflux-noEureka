package org.plywacz.client;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
@RequestMapping("extendedBooks")
@AllArgsConstructor
@Log4j2
class BookController {
    private final BookService bookService;

    @GetMapping()
    public Mono<ExtendedBookOutput> allExtendedBooks() {
        log.always().log("Thread comes to->allExtendedBooks: getting mono");
        Mono<ExtendedBookOutput> monoBooks = bookService.allExtendedBooks();
        log.always().log("Thread gets Mono and is released from allExtendedBooks: returning mono");
        return monoBooks;
    }
}
