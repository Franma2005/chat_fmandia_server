package org.example.socket;

import java.io.*;
import java.net.Socket;

//* Esta clase maneja las operaciones principales del socket. Abrir y cerrar canales, abrir y cerrar canales de texto...
public class SocketManager {

    // Atributos de la clase
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    private BufferedReader br;
    private PrintWriter pw;

    // Contructor de la clase, solo necesitamos el socket que nos proporciona SocketTcpServer
    public SocketManager(Socket socket) {
        this.socket = socket;
    }

    // Abrimos los canales de bytes del socket
    public void startByteChannels() throws IOException {
        is = socket.getInputStream();
        os = socket.getOutputStream();
    }

    // Creamos canales de texto a partir de los canales de bytes
    public void startTextChannels() {
        br = new BufferedReader(new InputStreamReader(is));
        pw = new PrintWriter(os, true);
    }

    // Cerramos los canales de bytes
    public void stopByteChannels() throws IOException {
        os.close();
        is.close();
        socket.close();
    }

    // Cerramos los canales de texto
    public void stopTextChannels() throws IOException {
        br.close();
        pw.close();
    }

    // Getter necesarios de la clase
    public Socket getSocket() {
        return socket;
    }

    public BufferedReader getBr() {
        return br;
    }

    public PrintWriter getPw() {
        return pw;
    }
}
