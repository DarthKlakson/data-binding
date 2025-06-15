package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.domain.Book;
import pl.coderslab.repository.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable long id, @RequestBody Book book) {
       Book fromDb = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found"));

       fromDb.setAuthor(book.getAuthor());
       fromDb.setTitle(book.getTitle());
       fromDb.setIsbn(book.getIsbn());
       fromDb.setPublisher(book.getPublisher());
       fromDb.setType(book.getType());

       return bookRepository.save(fromDb);
    }

}
