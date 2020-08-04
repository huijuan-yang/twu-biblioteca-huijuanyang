package com.twu.biblioteca;

public class Movie {
    private final String name;
    private final int year;
    private final String director;
    private final double rate;
    private boolean status;

    public Movie(String name, int year, String director, double rate) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rate = rate;
        this.status = true;
    }

    public String getName() { return name; }

    public int getYear() { return year; }

    public String getDirector() { return director; }

    public double getRate() { return rate; }

    public boolean getStatus() { return status; }

    public void setStatus(boolean status) { this.status = status; }


}

