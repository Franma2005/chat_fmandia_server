package org.example.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTcpServer implements Runnable {

    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    private BufferedReader br;
    private PrintWriter pw;

    public SocketTcpServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void obtainsSockets() throws IOException {
        // Este es el momento en el que obtenemos la conexion con el cliente
        socket = serverSocket.accept();
    }




}
