package com.twu.biblioteca;

import java.util.Scanner;

public class Library {
    Scanner scanner = new Scanner(System.in);

    public String printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public void login() {
        System.out.println("Log In: 1.User  2.Quit");

        int n = scanner.nextInt();

        if (n == 1) {
            System.out.println("Please enter your name: ");
            String userName = scanner.next();
            System.out.println("Please enter your email: ");
            String userEmail = scanner.next();
            System.out.println("Please enter your phone number: ");
            int userPhoneNumber = scanner.nextInt();

            UserOperate user = new UserOperate(userName, userEmail, userPhoneNumber);
            System.out.println("Login successful!");
            System.out.println("Current User: \n" + "name: " + user.getName() + "\nemail: " + user.getEmail() + "\nphone number: " + user.getPhoneNumber());

            while (true) {
                System.out.println("Please choose your operation: 1.Go into library  2.Quit");
                int choice = scanner.nextInt();
                if (choice == 2) {
                    System.out.println("Quit!");
                    break;
                } else if (choice == 1){
                    user.operate();
                } else {
                    System.out.println("Please enter a valid choice!");
                }
            }
        } else if (n == 2) {
            return;
        } else {
            System.out.println("Please select a valid option!");
        }
    }
}
