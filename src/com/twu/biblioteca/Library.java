package com.twu.biblioteca;

import java.util.Scanner;
import static com.twu.biblioteca.UsersRepository.users;

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
            System.out.println("Please enter your library number: ");
            String userLibraryNumber = scanner.next();
            System.out.println("Please enter your password: ");
            String userPassword = scanner.next();

            for (User user : users) {

                if (user.getLibraryNumber().equals(userLibraryNumber) && user.getPassword().equals(userPassword)) {
                    System.out.println("Login successful!");
                    System.out.println("Current User: \n" + "Name: " + user.getName() + "\nEmail: " + user.getEmail() +
                            "\nPhone Number: " + user.getPhoneNumber() + "\nLibrary Number: " + user.getLibraryNumber());

                    UserOperate existUser = new UserOperate(user.getName(), user.getEmail(), user.getPhoneNumber(), user.getLibraryNumber(), user.getPassword());

                    while (true) {
                        System.out.println("Please choose your operation: 1.Go into library  2.Quit");
                        int choice = scanner.nextInt();
                        if (choice == 2) {
                            System.out.println("Quit!");
                            return;
                        } else if (choice == 1) {
                            existUser.operate();
                        } else {
                            System.out.println("Please enter a valid choice!");
                        }
                    }

                }

            }

            System.out.println("Login failed! Please enter valid username and password!");
            login();

    }else if (n == 2) {
            return;
        } else {
            System.out.println("Please select a valid option!");
        }
    }


}
