package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User("Amy", "amy@thoughtworks.com", "12534564567", "123-2345", "Amy4567%"));
        users.add(new User("Bob", "bob@thoughtworks.com", "12545675678", "234-3456", "Bob5678%"));
        users.add(new User("Chris", "chris@thoughtworks.com", "12556786789", "345-4567", "Chris6789%"));
        users.add(new User("David", "david@thoughtworks.com", "12567897890", "456-5678", "David7890%"));
    }

}
