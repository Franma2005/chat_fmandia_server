package org.example.rooms;

import org.example.interfaces.MyObservable;
import org.example.socket.SocketManager;

import java.util.concurrent.CopyOnWriteArrayList;

public class Room implements MyObservable {

    private String name;
    private CopyOnWriteArrayList<SocketManager> users;

    public Room(String name) {
        this.name = name;
        this.users = new CopyOnWriteArrayList<>();
    }

    @Override
    public void addObservable(SocketManager socketClient) {
        users.add(socketClient);
    }

    @Override
    public void deleteObservable(SocketManager socketClient) {
        users.remove(socketClient);
        for (SocketManager user : users) {
            System.out.println(user.getName());
        }
    }

    @Override
    public void broadcast(String message) {
        for (SocketManager user : users) {
            user.update(message);
        }
    }
}
