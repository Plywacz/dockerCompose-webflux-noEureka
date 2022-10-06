package org.plywacz.rest;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("books")
@AllArgsConstructor
@Log4j2
class BookController {
    private final BookService bookService;

    @GetMapping()
    Collection<Book> allBooks() {
        log.always().log("allBooks");

        return bookService.getAll();
    }
}
