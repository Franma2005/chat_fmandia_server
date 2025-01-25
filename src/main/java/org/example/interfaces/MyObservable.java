package org.example.interfaces;

import org.example.socket.SocketTcp;

public interface MyObservable {

    public void addObservable(SocketTcp socketClient);

    public void deleteObservable(SocketTcp socketClient);

    public void broadcast(String message);
}
