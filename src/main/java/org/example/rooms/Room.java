package org.example.rooms;

import org.example.interfaces.MyObservable;
import org.example.socket.MessageHandler;
import org.example.socket.SocketManager;

import java.util.concurrent.CopyOnWriteArrayList;

public class Room implements MyObservable {

    private String name;
    private CopyOnWriteArrayList<MessageHandler> users;

    public Room(String name) {
        this.name = name;
        this.users = new CopyOnWriteArrayList<>();
    }

    @Override
    public void addObservable(MessageHandler messageHandler) {
        users.add(messageHandler);
    }

    @Override
    public void deleteObservable(MessageHandler messageHandler) {
        users.remove(messageHandler);
        for (MessageHandler user : users) {
            System.out.println(user.getName());
        }
    }

    @Override
    public void broadcast(String message) {
        for (MessageHandler user : users) {
            user.update(message);
        }
    }
}
