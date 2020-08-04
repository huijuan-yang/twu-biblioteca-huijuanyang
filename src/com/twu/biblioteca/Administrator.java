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
            allBooksList.append("Isbn: ").append(book.getIsbn()).append(" | Name: ")
                    .append(book.getName()).append(" | Author: ").append(book.getAuthor()).append(" | Published Year: ")
                    .append(book.getPublishedYear()).append(" | Status: ").append(book.getAvailable()).append("\n");
        }

        System.out.println(allBooksList.toString());
        return allBooksList.toString();
    }

    @Override
    public String showAllAvailableBooks() {
        StringBuilder allAvailableBooks = new StringBuilder();
        for (Book book : books.stream().filter(Book::getAvailable).collect(Collectors.toList())) {
            allAvailableBooks.append("Isbn: ").append(book.getIsbn()).append(" | Name: ")
                    .append(book.getName()).append(" | Author: ").append(book.getAuthor()).append(" | Published Year: ")
                    .append(book.getPublishedYear()).append(" | Status: ").append(book.getAvailable()).append("\n");
        }

        return allAvailableBooks.toString();
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
    public String showAllMovies() {
        StringBuilder allMoviesList = new StringBuilder();
        for (Movie movie : movies) {
            allMoviesList.append("Name: ").append(movie.getName()).append(" | Year: ").append(movie.getYear())
                    .append(" | Director: ").append(movie.getDirector()).append(" | Rate: ")
                    .append(movie.getRate()).append(" | Status: ").append(movie.getStatus()).append("\n");
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
                    .append(movie.getRate()).append(" | Status: ").append(movie.getStatus()).append("\n");
        }

        return allAvailableMovies.toString();
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
