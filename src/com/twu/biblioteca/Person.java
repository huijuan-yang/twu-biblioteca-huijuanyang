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
    static {
        books.add(new Book("00000","Learning Java", "Amy", 2001, true));
        books.add(new Book("00001", "Learning Javascript", "Bob", 2006, true));
        books.add(new Book("00002", "Learning HTML", "Chris", 1997, true));
        books.add(new Book("00003", "Learning CSS", "David", 2014, true));
    }

    public static List<Movie> movies = new ArrayList<>();
    static {
        movies.add(new Movie("Charlie and the Chocolate Factory", 2005, "Tim Burton", 8.8, true));
        movies.add(new Movie("The Croods", 2013, "Kirk DeMicco/Chris Sanders", 9.2, true));
        movies.add(new Movie("Charlotte's Web", 2006, "Gary Winick", 8.6, true));
        movies.add(new Movie("Forrest Gump", 1994, "Robert Zemeckis", 9.6, true));
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void  setEmail(String email) { this.email = email; }

    public int getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber() { this.phoneNumber = phoneNumber; }

    public abstract void operate();

}
