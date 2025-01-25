package org.example.socket;

import org.example.interfaces.MyObservable;

import java.io.*;
import java.net.ServerSocket;
import java.util.ArrayList;

public class SocketTcpServer implements MyObservable {

    private ArrayList<User> socketsClients = new ArrayList<>();
    private ServerSocket serverSocket;

    public SocketTcpServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void obtainsSockets() throws IOException {
        // Este es el momento en el que obtenemos la conexion con el cliente
        addObservable(new User(serverSocket.accept(), this));
        socketsClients.getLast().start();
    }

    @Override
    public void addObservable(User socketClient) {
        socketsClients.add(socketClient);
    }

    @Override
    public void deleteObservable(User socketClient) {
        socketsClients.remove(socketClient);
    }

    @Override
    public void broadcast(String message) {
        for (User socketsClient : socketsClients) {
            socketsClient.update(message);
        }
    }
}
