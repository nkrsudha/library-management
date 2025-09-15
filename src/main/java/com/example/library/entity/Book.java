package com.example.library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //properties
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private int publishedYear;
    private boolean isAvailable;
    private String info;

    public Book() {
        
    }
//constructors
    public Book( String title, String author, String isbn, int publishedYear)
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.isAvailable = true;
    }
    //Getters  and setters for all properties

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isAvailable() {
        return isAvailable;

    }

    //Methods to manage availability
    public void checkOut() {
        isAvailable = false;
    }

    public void returnItem() {
        isAvailable = true;
    }

    public String getInfo() {
        String status = isAvailable ? "Available": "Checked Out";
        return  title + " by " + author + " ("+ publishedYear+ ") - "+ status;

    }
}


