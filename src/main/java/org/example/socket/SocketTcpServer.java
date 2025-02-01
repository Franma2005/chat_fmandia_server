package org.example.socket;

import org.example.rooms.RoomManager;
import org.example.services.UserNameCreator;
import java.io.*;
import java.net.ServerSocket;

public class SocketTcpServer {

    private RoomManager roomGestor;
    private UserNameCreator nameCreator;
    private ServerSocket serverSocket;

    public SocketTcpServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        nameCreator = UserNameCreator.getInstance();
        roomGestor = new RoomManager();
    }

    public void obtainsSockets() throws IOException {
        // Este es el momento en el que obtenemos la conexion con el cliente
        MessageHandler temporalUser = new MessageHandler(serverSocket.accept(), nameCreator.createName());
        roomGestor.roomEntry(temporalUser, "General");
        temporalUser.start();
    }
}
