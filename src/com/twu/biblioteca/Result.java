package com.twu.biblioteca;

public class Result {
    private final String checkOutBookSuccessful;
    private final String checkOutBookFailed;
    private final String returnBookSuccessful;
    private final String returnBookFailed;
    private final String checkOutMovieSuccessful;
    private final String checkOutMovieFailed;
    private final String returnMovieSuccessful;
    private final String returnMovieFailed;

    public Result() {
        this.checkOutBookSuccessful = "Thank you! Enjoy the book!";
        this.checkOutBookFailed = "Sorry, that book is not available.";
        this.returnBookSuccessful = "Thank you for returning the book!";
        this.returnBookFailed = "That is not a valid book to return.";
        this.checkOutMovieSuccessful = "Thank you! Enjoy the movie!";
        this.checkOutMovieFailed = "Sorry, that movie is not available.";
        this.returnMovieSuccessful = "Thank you for returning the movie!";
        this.returnMovieFailed = "That is not a valid movie to return.";
    }

    public String getCheckOutBookSuccessful() { return checkOutBookSuccessful; }

    public String getCheckOutBookFailed() { return checkOutBookFailed; }

    public String getReturnBookSuccessful() { return returnBookSuccessful; }

    public String getReturnBookFailed() { return returnBookFailed; }

    public String getCheckOutMovieSuccessful() { return checkOutMovieSuccessful; }

    public String getCheckOutMovieFailed() { return checkOutMovieFailed; }

    public String getReturnMovieSuccessful() { return returnMovieSuccessful; }

    public String getReturnMovieFailed() { return returnMovieFailed; }

}
