package com.twu.biblioteca;

import java.util.Objects;

public class Book {
    private String isbn;
    private String name;
    private String author;
    private int publishedYear;
    private boolean isAvailable;

    public Book(String isbn, String name, String author, int publishedYear, boolean isAvailable) {
        this.isbn = isbn;
        this.name = Objects.requireNonNull(name);
        this.author = Objects.requireNonNull(author);
        this.publishedYear = publishedYear;
        this.isAvailable = isAvailable;
    }

    public String getIsbn() { return isbn; }

    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public int getPublishedYear() { return publishedYear; }

    public void setPublishedYear(int year) { this.publishedYear = year; }

    public boolean getAvailable() { return isAvailable; }

    public void setAvailable(boolean boo) { this.isAvailable = boo; }

}

