package org.example.socket;

public interface MyObserver {

    public void addObservable(SocketTcp socketClient);

    public void deleteObservable(SocketTcp socketClient);

    public void broadcast();
}
