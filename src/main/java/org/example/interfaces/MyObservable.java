package org.example.interfaces;

import org.example.socket.User;

public interface MyObservable {

    public void addObservable(User socketClient);

    public void deleteObservable(User socketClient);

    public void broadcast(String message);
}
