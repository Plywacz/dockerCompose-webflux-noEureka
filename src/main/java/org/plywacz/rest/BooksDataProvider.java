package org.plywacz.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
@Log4j2
class BooksDataProvider {
    private final List<Book> books;

    public BooksDataProvider() {
        books = new ArrayList<>();
        books.add(new Book("Some Book", 1));
        books.add(new Book("Another Book", 2));
        books.add(new Book("Super Book", 1988));
    }

    public Collection<Book> all() {
        simulateHeavyDataSelect();
        return Collections.unmodifiableList(books);
    }

    private void simulateHeavyDataSelect() {
        log.always().log("simulating fetching BOOK data from DB: takes 1 sec");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.always().log("Thread.sleep(1000) error", e);
        }
    }
}
