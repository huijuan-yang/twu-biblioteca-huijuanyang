package com.twu.biblioteca;

import java.util.Scanner;

public class Account {
    Scanner scanner = new Scanner(System.in);

    public String printWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public void login() {
        System.out.println("Log In: 1.User  2.Administrator  3.Quit");

        int n = scanner.nextInt();
        if (n == 3) {
            return;
        }
        switch (n) {
            case 1:
                System.out.println("Please enter your name: ");
                String userName = scanner.next();
                System.out.println("Please enter your email: ");
                String userEmail = scanner.next();
                System.out.println("Please enter your phone number: ");
                int userPhoneNumber = scanner.nextInt();

                User user = new User(userName, userEmail, userPhoneNumber);
                System.out.println("Login successful!");
                System.out.println("Current User: \n" + "name: " + user.getName() + "\nemail: " + user.getEmail() + "\nphone number: " + user.getPhoneNumber());

                while (true) {
                    System.out.println("Please choose your operation: ");
                    int choice = scanner.nextInt();
                    if (choice == 9) {
                        System.out.println("Quit!");
                        break;
                    } else {
                        user.operate();
                    }
                }
                break;
            case 2:
                System.out.println("Please enter your name: ");
                String adminName = scanner.next();
                System.out.println("Please enter your email: ");
                String adminEmail = scanner.next();
                System.out.println("Please enter your phone number: ");
                int adminPhoneNumber = scanner.nextInt();

                Administrator admin = new Administrator(adminName, adminEmail, adminPhoneNumber);
                System.out.println("Login successful!");
                System.out.println("Current Administrator: \n" + "name: " + admin.getName() + "\nemail: " + admin.getEmail() + "\nphone number: " + admin.getPhoneNumber());

                while (true) {
                    System.out.println("Please choose your operation: ");
                    int choice = scanner.nextInt();
                    if (choice == 9) {
                        System.out.println("Quit!");
                        break;
                    } else {
                        admin.operate();
                    }
                }
                break;
        }
    }
}
