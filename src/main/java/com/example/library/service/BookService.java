package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book createBook(Book book) {
        return repository.save(book);
    }
    
    
    public List<Book> getAllBooks() {
        return repository.findAll();
 
    }
    public Optional<Book> getBookById(Long id) {
        return repository.findById(id);
    }

    public Book updateBook(Long id, Book bookDetails) {
        return repository.findById(id).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setIsbn(bookDetails.getIsbn());
            book.setPublishedYear(bookDetails.getPublishedYear());
            return repository.save(book);
        }).orElseThrow(() -> new RuntimeException("Book not found with id "+ id));
        }    
    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}


