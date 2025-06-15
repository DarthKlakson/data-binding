package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.domain.Book;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable long id) {
        return bookService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookService.create(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        bookService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable long id, @RequestBody Book book) {
        return bookService.update(id, book);
    }

}
