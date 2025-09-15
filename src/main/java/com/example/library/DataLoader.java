package com.example.library;

import com.example.library.entity.Book;
import com.example.library.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    
    private final BookService bookService;

    public DataLoader(BookService bookService) {
        this.bookService = bookService;
    }
    @Override
    public void run(String... args) throws Exception {
        //Add your books here
        bookService.createBook(new Book("Clean Code", "Robert C. Martin", "978013250884", 2008));
        bookService.createBook(new Book("Design Patterns", "Erich Gamma", "9780201633610", 1994));
        bookService.createBook(new Book("Effective Java", "Joshua Bloch", "9780134685991", 1996));
        bookService.createBook(new Book("Java learning", "Robert", "978745301234556", 2000));
        bookService.createBook(new Book("System software", "Edwin", "767584898836224", 2000));
        bookService.createBook(new Book("Web Appilication", "Edwin", "98774653321239", 2017));
    }
}
