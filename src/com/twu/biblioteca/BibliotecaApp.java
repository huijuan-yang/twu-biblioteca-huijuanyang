package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class BibliotecaApp {

    public static void main(String[] args) {
        Account account = new Account();
        account.printWelcomeMessage();
        account.login();
    }

}
