package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.twu.biblioteca.BooksRepository.books;
import static com.twu.biblioteca.MoviesRepository.movies;

public class UserOperate extends User {

    public UserOperate(String name, String email, String phoneNumber, String libraryNumber, String password) {
        super (name, email, phoneNumber, libraryNumber, password);
    }


    public List<Book> getBooks() { return books; }
    public List<Movie> getMovies() { return movies; }

    Scanner scanner = new Scanner(System.in);

    public void operate() {
        System.out.println("Hi " + this.getName() + "! Please enter your choice:\n 1.All Books  2.Available Books  3.Check Out Book  4.Return Book\n " +
                "5.All Movies  6.Available Movies  7.Check Out Movie  8.Return Movie\n 9.Quit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllBooks();
                break;
            case 2:
                showAllAvailableBooks();
                break;
            case 3:
                System.out.println("Hi " + this.getName() + "! Please enter the book isbn: ");
                String isbnOfBook = scanner.next();
                checkOutBook(isbnOfBook);
                break;
            case 4:
                System.out.println("Hi " + this.getName() + "! Please enter the book isbn: ");
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
                System.out.println("Hi " + this.getName() + "! Please enter the movie name: ");
                String nameOfMovie = scanner.next();
                checkOutMovie(nameOfMovie);
                break;
            case 8:
                System.out.println("Hi " + this.getName() + "! Please enter the movie name: ");
                String nameOfReturnedMovie = scanner.next();
                returnMovie(nameOfReturnedMovie);
                break;
            case 9:
                System.out.println("Quit!");
                break;
            default:
                System.out.println("Wrong input!");
                operate();
        }
    }


    public String showAllBooks() {
        StringBuilder allBooksList = new StringBuilder();
        for (Book book : books) {
            allBooksList.append("Name: ").append(book.getName()).append(" | Author: ")
                    .append(book.getAuthor()).append(" | Published Year: ").append(book.getPublishedYear()).append("\n");
        }

        System.out.println(allBooksList.toString());
        return allBooksList.toString();
    }


    public String showAllAvailableBooks() {
        StringBuilder allAvailableBooks = new StringBuilder();
        for (Book book : books.stream().filter(Book::getAvailable).collect(Collectors.toList())) {
            allAvailableBooks.append("Name: ").append(book.getName()).append(" | Author: ")
                    .append(book.getAuthor()).append(" | Published Year: ").append(book.getPublishedYear()).append("\n");
        }

        System.out.println(allAvailableBooks.toString());
        return allAvailableBooks.toString();
    }


    Result result = new Result();

    public String checkOutBook(String isbn) {
        String checkOutResult = "";
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.getAvailable()) {
                book.setAvailable(false);
                checkOutResult = result.getCheckOutBookSuccessful();
                break;
            } else {
                checkOutResult = result.getCheckOutBookFailed();
            }
        }

        System.out.println(checkOutResult);
        return checkOutResult;
    }


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

        System.out.println(returnResult);
        return returnResult;
    }


    public String showAllMovies() {
        StringBuilder allMoviesList = new StringBuilder();
        for (Movie movie : movies) {
            allMoviesList.append("Name: ").append(movie.getName()).append(" | Year: ").append(movie.getYear())
                    .append(" | Director: ").append(movie.getDirector()).append(" | Rate: ")
                    .append(movie.getRate()).append("\n");
        }

        System.out.println(allMoviesList.toString());
        return allMoviesList.toString();
    }


    public String showAllAvailableMovies() {
        StringBuilder allAvailableMovies = new StringBuilder();
        for (Movie movie : movies.stream().filter(Movie::getStatus).collect(Collectors.toList())) {
            allAvailableMovies.append("Name: ").append(movie.getName()).append(" | Year: ").append(movie.getYear())
                    .append(" | Director: ").append(movie.getDirector()).append(" | Rate: ")
                    .append(movie.getRate()).append("\n");
        }

        System.out.println(allAvailableMovies.toString());
        return allAvailableMovies.toString();
    }


    public String checkOutMovie(String name) {
        String checkoutResult = "";
        for (Movie movie : movies) {
            if (movie.getName().equals(name) && movie.getStatus()) {
                movie.setStatus(false);
                checkoutResult = result.getCheckOutMovieSuccessful();
                break;
            } else {
                checkoutResult = result.getCheckOutMovieFailed();
            }
        }

        System.out.println(checkoutResult);
        return checkoutResult;
    }


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

        System.out.println(returnResult);
        return returnResult;
    }
}
