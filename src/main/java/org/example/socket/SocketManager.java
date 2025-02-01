package org.example.socket;

import org.example.interfaces.MyObserver;
import org.example.rooms.Room;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;

public class SocketManager {

    private Socket socket;
    private InputStream is;
    private OutputStream os;
    private BufferedReader br;
    private PrintWriter pw;

    public SocketManager(Socket socket) {
        this.socket = socket;
    }

    public void startSocket() throws IOException {
        is = socket.getInputStream();
        os = socket.getOutputStream();
    }

    public void startTextChannels() {
        br = new BufferedReader(new InputStreamReader(is));
        pw = new PrintWriter(os, true);
    }

    public void stopSocket() throws IOException {
        os.close();
        is.close();
        socket.close();
    }

    public void stopTextChannels() throws IOException {
        br.close();
        pw.close();
    }

    public BufferedReader getBr() {
        return br;
    }

    public PrintWriter getPw() {
        return pw;
    }
}
