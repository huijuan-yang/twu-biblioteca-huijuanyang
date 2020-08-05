package com.twu.biblioteca;

public class User {
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final String libraryNumber;
    private final String password;

    public User(String name, String email, String phoneNumber, String libraryNumber, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getName() { return name; }

    public String getEmail() { return email; }

    public String getPhoneNumber() { return phoneNumber; }

    public String getLibraryNumber() { return libraryNumber; }

    public String getPassword() { return password; }

    public void operate() {}

}
