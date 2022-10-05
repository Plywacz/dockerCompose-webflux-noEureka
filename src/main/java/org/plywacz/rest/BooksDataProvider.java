package org.plywacz.rest;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
class BooksDataProvider {
    private final List<Book> books;

    public BooksDataProvider() {
        books = new ArrayList<>();
        books.add(new Book("Some Book", "Jan Nowak", 1992));
        books.add(new Book("Another Book", "Miłosz Kowal", 2020));
        books.add(new Book("Super Book", "Kamil Slup", 1988));
    }

    public Collection<Book> all() {
        return Collections.unmodifiableList(books);
    }
}
