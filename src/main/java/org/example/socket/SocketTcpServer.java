package org.example.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SocketTcpServer implements MyObserver {

    private ArrayList<SocketTcp> socketsClients = new ArrayList<>();
    private ServerSocket serverSocket;

    public SocketTcpServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void obtainsSockets() throws IOException {
        // Este es el momento en el que obtenemos la conexion con el cliente
        addObservable(new SocketTcp(serverSocket.accept()));
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
    public void broadcast() {
        for (SocketTcp socketsClient : socketsClients) {

        }
    }
}
