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

    public void startServer() throws IOException{
        System.out.println("(Server) Opening the channels of communication");
        socket = serverSocket.accept();
        is = socket.getInputStream();
        os = socket.getOutputStream();
        System.out.println("(Client) The channels of communication have been opened");
    }

    public void startTextChannels() {
        System.out.println("(Server) Opening the text channels of communication");
        br = new BufferedReader(new InputStreamReader(is));
        pw = new PrintWriter(os, true);
        System.out.println("(Server) The text channels of communication have been openned");
    }

    public void stopServer() throws IOException {
        System.out.println("(Server) Closing the channels of communication");
        os.close();
        is.close();
        socket.close();
        System.out.println("(Server) The channels of communication have been opened");
    }

    public void stopTextChannels() throws IOException {
        System.out.println("(Server) Closing the text channels of communicantion");
        br.close();
        pw.close();
        System.out.println("(Server) The text channels of communication have been closed");
    }

    public void sendMessage(String message) {
        System.out.println("(Server) " + message);
        pw.println(message);
        pw.flush();
    }

    public String reciveMessage() throws IOException {
        return "(Client) " + br.readLine();
    }

    @Override
    public void run() {
        try {
            startServer();
            startTextChannels();

            String mensaje;
            do {
                reciveMessage();
                sendMessage();
            } while();
            stopTextChannels();
            stopServer();
        } catch(IOException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
