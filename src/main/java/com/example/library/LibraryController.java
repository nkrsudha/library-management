package com.example.library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LibraryController {

    @GetMapping("/library/books") //url to access the book list
    public String getBooks(Model model) {

        List<Map<String, Object>> books = new ArrayList<>();

        books.add(Map.of(
            "id", 1,
            "title", "Clean Code",
            "author", "Robert C. Martin",
            "isbn", "978013250884",
            "publishedYear", 2008,
            "info", "Clean Code by Robert C. Martin (2008) - Available",
            "available", true ));
        
        books.add(Map.of(
            "id", 2,
            "title", "Effective Java",
            "author", "Robert",
            "isbn", "97801325991",
            "publishedYear", 2018,
            "info", "Effective Java by Robert (2018) - Available",
            "available", true));

        books.add(Map.of(
            "id", 3,
            "title", "Engineering",
            "author", "Martin",
            "isbn", "97801325089",
            "publishedYear", 1998,
            "info", "Engineering by  Martin (1998) - Available",
            "available", true));

        books.add(Map.of(
            "id", 4,
            "title", "Graphics",
            "author", "Robert ",
            "isbn", "97801325345",
            "publishedYear", 1988,
            "info", "Graphics by Robert (1988) - Available",
            "available", true));

        books.add(Map.of(
            "id", 5,
            "title", "Mathematics",
            "author", "James",
            "isbn", "978013298765",
            "publishedYear", 2004,
            "info", "Mathematics by James (2004) - Available",
            "available", true));
            
        books.add(Map.of(
            "id", 6,
            "title", "Software Analysis",
            "author", "Robin",
            "isbn", "978013250898",
            "publishedYear", 2000,
            "info", "Software Analysis by Robin (2000) - Available",
            "available", true));

            model.addAttribute("books", books);
        return "books";
    }
}
