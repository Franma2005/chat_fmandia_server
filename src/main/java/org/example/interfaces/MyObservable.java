package org.example.interfaces;

import org.example.socket.SocketManager;

public interface MyObservable {

    public void addObservable(SocketManager socketClient);

    public void deleteObservable(SocketManager socketClient);

    public void broadcast(String message);
}
