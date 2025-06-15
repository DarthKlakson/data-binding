package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.domain.Author;
import pl.coderslab.repository.AuthorRepository;

@RestController
@RequestMapping("/api/authors/")
public class AuthorController {

    AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Author not found"));
    }
}
