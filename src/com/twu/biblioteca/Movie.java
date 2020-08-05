package com.twu.biblioteca;

public class Movie {
    private final String id;
    private final String name;
    private final int year;
    private final String director;
    private final double rate;
    private boolean status;
    private String borrower;

    public Movie(String id, String name, int year, String director, double rate) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rate = rate;
        this.status = true;
        this.borrower = "none";
    }
    public String getId() { return id; }

    public String getName() { return name; }

    public int getYear() { return year; }

    public String getDirector() { return director; }

    public double getRate() { return rate; }

    public boolean getStatus() { return status; }

    public void setStatus(boolean status) { this.status = status; }

    public String getBorrower() { return borrower; }

    public void setBorrower(String borrower) { this.borrower = borrower; }


}

