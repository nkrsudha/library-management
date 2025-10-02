package com.example.library.controller;

import com.example.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookViewController {

    private final BookService service;

    public BookViewController(BookService service) {
        this.service = service;
    }
    
//serve the books.html template

@GetMapping("/books-table")
public String showBookPage(Model model) {
    model.addAttribute("books", service.getAllBooks());
    return "books";
}
}
