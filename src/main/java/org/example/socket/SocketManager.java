package org.example.socket;

import org.example.interfaces.MyObserver;
import org.example.rooms.Room;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;

public class SocketManager extends Thread implements MyObserver {

    private Socket socket;
    private String name;
    private InputStream is;
    private OutputStream os;
    private BufferedReader br;
    private PrintWriter pw;

    private Room room;

    public SocketManager(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
    }

    public void startSocket() throws IOException {
        System.out.println("(Server) Opening the channels of communication");
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

    public void stopSocket() throws IOException {
        System.out.println("(Server) Closing the channels of communication");
        os.close();
        is.close();
        socket.close();
        System.out.println("(Server) The channels of communication have been closed");
    }

    public void stopTextChannels() throws IOException {
        System.out.println("(Server) Closing the text channels of communicantion");
        br.close();
        pw.close();
        System.out.println("(Server) The text channels of communication have been closed");
    }

    public void sendMessage(String message) {
        pw.println(message);
        pw.flush();
    }

    public String reciveMessage() throws IOException {
        String message = br.readLine();
        if(message == null) message = "";
        return message;
    }

    public void notifyServer(String message) {
        //System.out.println("Me han llamado " + name);
        room.broadcast(message);
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public void run() {
        try {
            startSocket();
            startTextChannels();

            LocalDateTime time = LocalDateTime.now();
            int hour = time.getHour();
            int minutes = time.getMinute();
            String actualTime;
            String message;
            do {
                actualTime = hour + ":" + minutes;
                message = reciveMessage();
                notifyServer(message + " " + actualTime);
                //System.out.println("El mensaje que se compara es: " + message + " de " + name);
            } while(!message.equals("/END"));
            System.out.println("Salgo");
            room.deleteObservable(this);
            stopTextChannels();
            stopSocket();
        } catch(IOException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    @Override
    public void update(String message) {
        sendMessage(message);
    }
}
