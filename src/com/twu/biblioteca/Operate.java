package com.twu.biblioteca;

import java.util.List;

public interface Operate {
    List<Book> showAllBooks();
    List<Book> showAllAvailableBooks();
    String checkOutBook(String isbn);
    String returnBook(String string);

    List<Movie> showAllMovies();
    List<Movie> showAllAvailableMovies();
    String checkOutMovie(String string);
    String returnMovie(String string);
}
