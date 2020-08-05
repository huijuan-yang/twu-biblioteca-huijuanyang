package com.twu.biblioteca;

import java.util.Objects;

public class Book {
    private final String isbn;
    private final String name;
    private final String author;
    private final int publishedYear;
    private boolean isAvailable;
    private String borrower;

    public Book(String isbn, String name, String author, int publishedYear) {
        this.isbn = isbn;
        this.name = Objects.requireNonNull(name);
        this.author = Objects.requireNonNull(author);
        this.publishedYear = publishedYear;
        this.isAvailable = true;
        this.borrower = "none";
    }

    public String getIsbn() { return isbn; }

    public String getName() { return name; }

    public String getAuthor() { return author; }

    public int getPublishedYear() { return publishedYear; }

    public boolean getAvailable() { return isAvailable; }

    public void setAvailable(boolean boo) { this.isAvailable = boo; }

    public String getBorrower() { return borrower; }

    public void setBorrower(String borrower) { this.borrower = borrower; }

}

