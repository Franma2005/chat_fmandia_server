package org.example;

import org.example.socket.SocketTcpServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            SocketTcpServer server = new SocketTcpServer(3000);
            while(true) {
                server.obtainsSockets();
            }
        } catch (IOException e) {
            System.out.println("Another client can't be connect");
        }
    }
}