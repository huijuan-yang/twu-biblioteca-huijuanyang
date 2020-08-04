package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    public static List<Book> books = new ArrayList<>();
    public static List<Movie> movies = new ArrayList<>();

    static {
        books.add(new Book("9780321356680","Effective Java", "Joshua Bloch", 2001, true));
        books.add(new Book("9780132350884", "Clean Code", "Robert C. Martin", 2009, true));
        books.add(new Book("9780596007126", "Head First Design Patterns", "Eric Freeman", 2015, true));
        books.add(new Book("9781617294945", "Spring in Action", "Craig Walls", 2005, true));
    }

    static {
        movies.add(new Movie("Charlie and the Chocolate Factory", 2005, "Tim Burton", 8.8, true));
        movies.add(new Movie("The Croods", 2013, "Kirk DeMicco/Chris Sanders", 9.2, true));
        movies.add(new Movie("Charlotte's Web", 2006, "Gary Winick", 8.6, true));
        movies.add(new Movie("Forrest Gump", 1994, "Robert Zemeckis", 9.6, true));
    }

    public List<Book> getBookList() {
        return books;
    }
    public List<Movie> getMoviesList() {
        return movies;
    }

}
