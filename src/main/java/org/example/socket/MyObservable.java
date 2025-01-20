package org.example.socket;

public interface MyObservable {

    public void addObservable(SocketTcp socketClient);

    public void deleteObservable(SocketTcp socketClient);

    public void broadcast();
}
