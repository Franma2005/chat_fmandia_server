package org.example;

import org.example.socket.SocketTcpServer;

import java.io.IOException;

//* En la clase main de java inicia el programa
public class Main {
    public static void main(String[] args) {
        // Creamos un servidor en el puerto 3000
        try {
            SocketTcpServer server = new SocketTcpServer(3000);
            // Mantenemos el programa siempre abierto porque siempre queremos que se puedan conectar clientes
            while(true) {
                server.obtainsSockets();
            }
        } catch (IOException e) {
            System.out.println("Another client can't be connect" + e);
        }
    }
}