package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/books")

public class Bookcontroller {

    private final BookService service;
    public Bookcontroller(BookService service) {
        this.service = service;
    }
    
    //create
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
            return ResponseEntity.ok(service.createBook(book));
    }
    //Read all
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(service.getAllBooks());
    }
// Read by Id
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return service.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

}
//Update
@PutMapping("/{id}")
public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
    return ResponseEntity.ok(service.updateBook(id, book));
}

//Delete
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    service.deleteBook(id);
    return ResponseEntity.noContent().build();
}

//Temporary endpoint for browser testing only
@GetMapping("/delete/{id}")
public String deleteBookGet(@PathVariable Long id) {
    service.deleteBook(id);
    return "Book with ID "+ id + " deleted successfully";
}
//Temporary endpoint for browser testing
@GetMapping("/update")
public String updateBookGet(@RequestParam Long id,@RequestParam String title, @RequestParam String author, @RequestParam(required = false) String isbn, @RequestParam(required = false) Integer publishedYear, @RequestParam(required = false) Boolean available,@RequestParam(required = false)String info) {
    Book updatedBook = new Book();
    updatedBook.setTitle(title);
    updatedBook.setAuthor(author);
    service.updateBook(id, updatedBook);
    return "Book with ID " + id + " updated successfully";
}

}

