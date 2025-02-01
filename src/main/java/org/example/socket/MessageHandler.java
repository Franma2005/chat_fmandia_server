package org.example.socket;

import org.example.interfaces.MyObserver;
import org.example.rooms.Room;

import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;

public class MessageHandler extends Thread implements MyObserver {

    private SocketManager socketUser;
    private String userName;
    private Room room;

    public MessageHandler(Socket socket, String userName) {
        this.socketUser = new SocketManager(socket);
        this.userName = userName;
    }

    public void sendMessage(String message) {
        socketUser.getPw().println(message);
        socketUser.getPw().flush();
    }

    public String reciveMessage() throws IOException {
        String message = socketUser.getBr().readLine();
        if(message == null) message = "";
        return message;
    }

    public void notifyServer(String message) {
        //System.out.println("Me han llamado " + name);
        this.room.broadcast(message);
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public void run() {
        try {
            socketUser.startSocket();
            socketUser.startTextChannels();

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
            socketUser.stopTextChannels();
            socketUser.stopSocket();
        } catch(IOException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    @Override
    public void update(String message) {
        sendMessage(message);
    }
}
