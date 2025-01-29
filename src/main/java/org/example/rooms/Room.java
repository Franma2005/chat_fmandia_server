package org.example.rooms;

import org.example.interfaces.MyObservable;
import org.example.socket.User;

import java.util.concurrent.CopyOnWriteArrayList;

public class Room implements MyObservable {

    private String name;
    private CopyOnWriteArrayList<User> users;

    public Room(String name) {
        this.name = name;
        this.users = new CopyOnWriteArrayList<>();
    }

    @Override
    public void addObservable(User socketClient) {
        users.add(socketClient);
        users.getLast().start();
    }

    @Override
    public void deleteObservable(User socketClient) {
        users.remove(socketClient);
    }

    @Override
    public void broadcast(String message) {
        for (User user : users) {
            System.out.println(user.getName());
            user.update(message);
        }
    }
}
