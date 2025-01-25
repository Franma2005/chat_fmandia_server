package org.example.rooms;

import org.example.interfaces.MyObservable;
import org.example.socket.User;

import java.util.ArrayList;

public class Room implements MyObservable {

    private String name;
    private ArrayList<User> users;

    public Room(String name, ArrayList<User> users) {
        this.name = name;
        this.users = users;
    }

    @Override
    public void addObservable(User socketClient) {
        users.add(socketClient);
    }

    @Override
    public void deleteObservable(User socketClient) {
        users.remove(socketClient);
    }

    @Override
    public void broadcast(String message) {
        for (User user : users) {
            user.update(message);
        }
    }
}
