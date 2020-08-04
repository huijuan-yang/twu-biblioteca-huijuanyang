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

    Repository repository = new Repository();
    List<Book> books = repository.getBookList();
    List<Movie> movies = repository.getMoviesList();

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
    public String showAllBooks() {
        StringBuilder allBooksList = new StringBuilder();
        for (Book book : books) {
            allBooksList.append("Name: ").append(book.getName()).append(" | Author: ")
                    .append(book.getAuthor()).append(" | Published Year: ").append(book.getPublishedYear()).append("\n");
        }

        System.out.println(allBooksList.toString());
        return allBooksList.toString();
    }

    @Override
    public String showAllAvailableBooks() {
        StringBuilder allAvailableBooks = new StringBuilder();
        for (Book book : books.stream().filter(Book::getAvailable).collect(Collectors.toList())) {
            allAvailableBooks.append("Name: ").append(book.getName()).append(" | Author: ")
                    .append(book.getAuthor()).append(" | Published Year: ").append(book.getPublishedYear()).append("\n");
        }

        return allAvailableBooks.toString();
    }

    Result result = new Result();

    @Override
    public String checkOutBook(String isbn) {
        String checkOutResult = "";
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn) && books.get(i).getAvailable()) {
                books.get(i).setAvailable(false);
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

    @Override
    public String showAllAvailableMovies() {
        StringBuilder allAvailableMovies = new StringBuilder();
        for (Movie movie : movies.stream().filter(Movie::getStatus).collect(Collectors.toList())) {
            allAvailableMovies.append("Name: ").append(movie.getName()).append(" | Year: ").append(movie.getYear())
                    .append(" | Director: ").append(movie.getDirector()).append(" | Rate: ")
                    .append(movie.getRate()).append("\n");
        }

        return allAvailableMovies.toString();
    }

    @Override
    public String checkOutMovie(String name) {
        String checkoutResult = "";
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equals(name) && movies.get(i).getStatus()) {
                movies.get(i).setStatus(false);
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
