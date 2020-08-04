package com.twu.biblioteca;

import java.util.List;

public interface Operate {
    String showAllBooks();
    String showAllAvailableBooks();
    String checkOutBook(String isbn);
    String returnBook(String string);

    String showAllMovies();
    String showAllAvailableMovies();
    String checkOutMovie(String string);
    String returnMovie(String string);
}
