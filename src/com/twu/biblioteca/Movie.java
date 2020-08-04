package com.twu.biblioteca;

public class Movie {
    private String name;
    private int year;
    private String director;
    private double rate;
    private boolean status;

    public Movie(String name, int year, String director, double rate) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rate = rate;
        this.status = true;
    }

    public String getName() { return name; };

    public void setName(String name) { this.name = name; };

    public int getYear() { return year; };

    public void setYear(int year) { this.year = year; };

    public String getDirector() { return director; };

    public void setDirector(String director) { this.director = director; };

    public double getRate() { return rate; };

    public void setRate(float rate) { this.rate = rate; };

    public boolean getStatus() { return status; };

    public void setStatus(boolean status) { this.status = status; };


}

