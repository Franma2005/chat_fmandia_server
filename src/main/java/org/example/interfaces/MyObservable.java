package org.example.interfaces;

import org.example.socket.MessageHandler;
import org.example.socket.SocketManager;

public interface MyObservable {

    public void addObservable(MessageHandler socketClient);

    public void deleteObservable(MessageHandler socketClient);

    public void broadcast(String message);
}
