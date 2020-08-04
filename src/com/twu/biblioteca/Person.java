package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

abstract class Person {
    public String name;
    public String email;
    public int phoneNumber;

    public Person(String name, String email, int phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public static List<Book> books = new ArrayList<>();
    public static List<Movie> movies = new ArrayList<>();

    static {
        books.add(new Book("9780321356680","Effective Java", "Joshua Bloch", 2001));
        books.add(new Book("9780132350884", "Clean Code", "Robert C. Martin", 2009));
        books.add(new Book("9780596007126", "Head First Design Patterns", "Eric Freeman", 2015));
        books.add(new Book("9781617294945", "Spring in Action", "Craig Walls", 2005));
    }

    static {
        movies.add(new Movie("Charlie and the Chocolate Factory", 2005, "Tim Burton", 8.8));
        movies.add(new Movie("The Croods", 2013, "Kirk DeMicco/Chris Sanders", 9.2));
        movies.add(new Movie("Charlotte's Web", 2006, "Gary Winick", 8.6));
        movies.add(new Movie("Forrest Gump", 1994, "Robert Zemeckis", 9.6));
    }

    public String getName() { return name; }

    public String getEmail() { return email; }

    public int getPhoneNumber() { return phoneNumber; }

    public abstract void operate();

}
