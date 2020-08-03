package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class User extends Person implements Operate {
    private String userName;
    private String userEmail;
    private int userPhoneNumber;

    public User(String name, String email, int phoneNumber) {
        super (name, email, phoneNumber);
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void operate() {
        System.out.println("Please enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllBooks();
                break;
            case 2:
                showAllAvailableBooks();
                break;
            case 3:
                System.out.println("Please enter the book isbn: ");
                String isbnOfBook = scanner.next();
                checkOutBook(isbnOfBook);
                break;
            case 4:
                System.out.println("Please enter the book isbn: ");
                String isbnOfReturnedBook = scanner.next();
                returnBook(isbnOfReturnedBook);
                break;
            case 5:
                showAllMovies();
                break;
            case 6:
                showAllAvailableMovies();
                break;
            case 7:
                System.out.println("Please enter the movie name: ");
                String nameOfMovie = scanner.next();
                checkOutMovie(nameOfMovie);
                break;
            case 8:
                System.out.println("Please enter the movie name: ");
                String nameOfReturnedMovie = scanner.next();
                returnMovie(nameOfReturnedMovie);
                break;
            default:
                System.out.println("Wrong input!");
        }
    }

    @Override
    public List<Book> showAllBooks() {
        return books;
    }

    @Override
    public List<Book> showAllAvailableBooks() {
        return books.stream().filter(Book::getAvailable).collect(Collectors.toList());
    }

    Result result = new Result();

    @Override
    public String checkOutBook(String isbn) {
        String checkOutResult = "";
        for (int i = 0; i < showAllAvailableBooks().size(); i++) {
            if (showAllAvailableBooks().get(i).getIsbn().equals(isbn)) {
                showAllAvailableBooks().get(i).setAvailable(false);
                checkOutResult = result.getCheckOutBookSuccessful();
                break;
            } else {
                checkOutResult = result.getCheckOutBookFailed();
            }
        }

        return checkOutResult;
    }

    @Override
    public String returnBook(String isbn) {
        String returnResult = "";
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.setAvailable(true);
                returnResult = result.getReturnBookSuccessful();
                break;
            } else {
                returnResult = result.getReturnBookFailed();
            }
        }

        return returnResult;
    }

    @Override
    public List<Movie> showAllMovies() {
        return movies;
    }

    @Override
    public List<Movie> showAllAvailableMovies() {
        return movies.stream().filter(Movie::getStatus).collect(Collectors.toList());
    }

    @Override
    public String checkOutMovie(String name) {
        String checkoutResult = "";
        for (int i = 0; i < showAllAvailableMovies().size(); i++) {
            if (showAllAvailableMovies().get(i).getName().equals(name)) {
                showAllAvailableMovies().get(i).setStatus(false);
                checkoutResult = result.getCheckOutMovieSuccessful();
                break;
            } else {
                checkoutResult = result.getCheckOutMovieFailed();
            }
        }

        return checkoutResult;
    }

    @Override
    public String returnMovie(String name) {
        String returnResult = "";
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                movie.setStatus(true);
                returnResult = result.getReturnMovieSuccessful();
                break;
            } else {
                returnResult = result.getReturnMovieFailed();
            }
        }

        return returnResult;
    }
}
