package com.twu.biblioteca;

abstract class Person {
    public String name;
    public String email;
    public int phoneNumber;

    public Person(String name, String email, int phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() { return name; }

    public String getEmail() { return email; }

    public int getPhoneNumber() { return phoneNumber; }

    public abstract void operate();

}
