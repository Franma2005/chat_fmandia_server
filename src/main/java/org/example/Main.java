package org.example;

import org.example.socket.SocketTcp;
import org.example.socket.SocketTcpServer;

import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        while(true) {
            try {
                SocketTcpServer server = new SocketTcpServer(3000);
                Socket socket = server.obtainsSockets();
                new SocketTcp(socket).start();
            } catch (IOException e) {
                System.out.println("Another client can't be connect");
            }
        }
    }
}