package org.example.socket;

import org.example.interfaces.MyObservable;
import org.example.rooms.Room;

import java.io.*;
import java.net.ServerSocket;
import java.util.ArrayList;

public class SocketTcpServer {

    private ArrayList<Room> roomsList;
    private ServerSocket serverSocket;

    //Debbugging
    int number = 0;

    public SocketTcpServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        roomsList = new ArrayList<>();
        roomsList.add(new Room("General"));
    }

    public void obtainsSockets() throws IOException {
        // Este es el momento en el que obtenemos la conexion con el cliente
        roomsList.get(0).addObservable(new User(serverSocket.accept(), roomsList.get(0), "hola" + getNumber()));
    }

    public void cambiarDeChat() {

    }

    public int getNumber() {
        return number++;
    }
}
