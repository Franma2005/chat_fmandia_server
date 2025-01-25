package org.example.socket;

import org.example.interfaces.MyObservable;

import java.io.*;
import java.net.ServerSocket;
import java.util.ArrayList;

public class SocketTcpServer {

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


}
