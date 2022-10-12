package com.plywacz.rest2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("authors")
@RequiredArgsConstructor
class AuthorController {
    private final AuthorService authorService;

    @GetMapping()
    List<Author> allAuthors() {
        return authorService.getAuthors();
    }
}
