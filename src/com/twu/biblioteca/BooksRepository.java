package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BooksRepository {
    public static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book("9780321356680","Effective Java", "Joshua Bloch", 2001));
        books.add(new Book("9780132350884", "Clean Code", "Robert C. Martin", 2009));
        books.add(new Book("9780596007126", "Head First Design Patterns", "Eric Freeman", 2015));
        books.add(new Book("9781617294945", "Spring in Action", "Craig Walls", 2005));
    }

}
