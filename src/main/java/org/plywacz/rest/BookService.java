package org.plywacz.rest;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
class BookService {
    private final BooksDataProvider booksDataProvider;
    public Collection<Book> getAll() {
        return booksDataProvider.all();
    }
}
