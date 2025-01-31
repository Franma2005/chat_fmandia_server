package org.example.socket;

import org.example.rooms.RoomGestor;
import org.example.services.UserNameCreator;
import java.io.*;
import java.net.ServerSocket;

public class SocketTcpServer {

    private RoomGestor roomGestor;
    private UserNameCreator nameCreator;
    private ServerSocket serverSocket;

    public SocketTcpServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        nameCreator = UserNameCreator.getInstance();
        roomGestor = new RoomGestor();
    }

    public void obtainsSockets() throws IOException {
        // Este es el momento en el que obtenemos la conexion con el cliente
        SocketManager temporal = new SocketManager(serverSocket.accept(), nameCreator.createName());
        roomGestor.roomEntry(temporal, "General");
        temporal.start();
    }
}
