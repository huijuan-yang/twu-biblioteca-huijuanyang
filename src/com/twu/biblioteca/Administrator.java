package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Administrator extends Person implements Operate {
    private String adminName;
    private String adminEmail;
    private int adminPhoneNumber;

    public Administrator(String name, String email, int phoneNumber) {
        super(name, email, phoneNumber);
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

    @Override
    //Checking out for administrator is to delete the book they want.
    public String checkOutBook(String isbn) {
        int num = books.size();
        if (books.stream().filter(element -> !element.getIsbn().equals(isbn)).count() < num) {
            return "Check out successful!";
        }
        return "Check out failed!";
    }

    @Override
    //Return for administrator is to add the book.
    public String returnBook(String isbn) {
        System.out.println("Please enter the name: ");
        String name = scanner.next();
        System.out.println("Please enter the author: ");
        String author = scanner.next();
        System.out.println("Please enter the published year: ");
        int publishedYear = scanner.nextInt();
        System.out.println("Please enter the status: ");
        boolean isAvailable = scanner.hasNext();

        books.add(new Book(isbn, name, author, publishedYear, isAvailable));
        return "Successful for adding the book!";
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
    //Checking out for administrator is to delete the movie they want.
    public String checkOutMovie(String name) {
        int num = movies.size();
        if (movies.stream().filter(element -> !element.getName().equals(name)).count() < num) {
            return "Check out successful!";
        }

        return "Check out failed!";
    }

    @Override
    //Return for administrator is to add the movie.
    public String returnMovie(String name) {
        System.out.println("Please enter the year: ");
        int year = scanner.nextInt();
        System.out.println("Please enter the director: ");
        String director = scanner.next();
        System.out.println("Please enter the rate: ");
        double rate = scanner.nextDouble();
        System.out.println("Please enter the status: ");
        boolean status = scanner.hasNext();

        movies.add(new Movie(name, year, director, rate, status));
        return "Successful for adding the movie!";
    }

}
