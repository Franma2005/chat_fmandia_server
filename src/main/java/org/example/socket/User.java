package org.example.socket;

import org.example.interfaces.MyObservable;

import java.io.*;
import java.net.ServerSocket;
import java.util.ArrayList;

public class User implements MyObservable {

    private ArrayList<SocketTcp> socketsClients = new ArrayList<>();
    private ServerSocket serverSocket;

    public User(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void obtainsSockets() throws IOException {
        // Este es el momento en el que obtenemos la conexion con el cliente
        addObservable(new SocketTcp(serverSocket.accept(), this));
        socketsClients.getLast().start();
    }

    @Override
    public void addObservable(SocketTcp socketClient) {
        socketsClients.add(socketClient);
    }

    @Override
    public void deleteObservable(SocketTcp socketClient) {
        socketsClients.remove(socketClient);
    }

    @Override
    public void broadcast(String message) {
        for (SocketTcp socketsClient : socketsClients) {
            socketsClient.update(message);
        }
    }
}
