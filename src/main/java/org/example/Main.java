package org.example;

import org.example.socket.User;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            User server = new User(3000);
            while(true) {
                server.obtainsSockets();
            }
        } catch (IOException e) {
            System.out.println("Another client can't be connect");
        }
    }
}