package com.example.library.controller;

import com.example.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookViewController {

    private final BookService service;

    public BookViewController(BookService service) {
        this.service = service;
    }
    
//serve the books.html template

@GetMapping("/books-page")
public String showBookPage(Model model) {
    model.addAttribute("books", service.getAllBooks());
    return "books";
}

 // Handle book updates
    @PostMapping("/update-book/{id}")
    @ResponseBody
    public String updateBook(
            @PathVariable Long id,
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam String isbn,
            @RequestParam int publishedYear,
            @RequestParam String info,
            @RequestParam boolean available) {

        service.updateBook(id, title, author, isbn, publishedYear, info, available);
        return "success";
    }

}
