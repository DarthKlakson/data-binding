package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.domain.Book;
import pl.coderslab.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    public Book update(long id, Book book) {
        Book fromDb = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found"));

        fromDb.setAuthor(book.getAuthor());
        fromDb.setTitle(book.getTitle());
        fromDb.setIsbn(book.getIsbn());
        fromDb.setPublisher(book.getPublisher());
        fromDb.setType(book.getType());

        return bookRepository.save(fromDb);
    }
}
