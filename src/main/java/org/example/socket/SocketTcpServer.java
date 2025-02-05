package org.example.socket;

import org.example.rooms.RoomManager;
import org.example.services.UserNameCreator;
import java.io.*;
import java.net.ServerSocket;

//* Clase principal del servidor que devuelve el socket de cada cliente en el servidor
public class SocketTcpServer {

    private RoomManager roomGestor;
    private UserNameCreator nameCreator;
    private ServerSocket serverSocket;

    public SocketTcpServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        nameCreator = UserNameCreator.getInstance();
        roomGestor = RoomManager.getInstance();
    }

    // Este es el momento en el que obtenemos la conexion con el cliente
    public void obtainsSockets() throws IOException {
        MessageHandler temporalUser = new MessageHandler(serverSocket.accept(), nameCreator.createName(), roomGestor.getRoom("General"));
        roomGestor.roomEntry(temporalUser, "General");
        temporalUser.start();
    }
}
