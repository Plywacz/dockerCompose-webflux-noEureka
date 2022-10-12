package com.plywacz.rest2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class AuthorService {
    private final AuthorRepo authorRepo;

    List<Author> getAuthors() {
        return authorRepo.allAuthors();
    }
}
