package com.plywacz.rest2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
class AuthorRepo {
    private final List<Author> authors = List.of(
            new Author("Janusz Stawarz", 1),
            new Author("Jan Kowal", 2),
            new Author("Damian Ruromski", 3)
    );

    List<Author> allAuthors() {
        return authors;
    }
}
