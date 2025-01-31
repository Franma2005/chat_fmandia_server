package org.example.services;

public class UserNameCreator {

    private String name;
    private int number;
    private static UserNameCreator instance;

    private UserNameCreator() {
        name = "chatter";
        number = 0;
    }

    public static UserNameCreator getInstance() {
        if(instance == null)
            instance = new UserNameCreator();
        return instance;
    }

    public String createName() {
        number += 1;
        return name + number;
    }
}
