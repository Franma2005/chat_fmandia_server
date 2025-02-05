package org.example.middleware;

import org.example.entities.Message;
import org.example.rooms.RoomManager;
import org.example.socket.MessageHandler;

import java.io.IOException;
import java.time.LocalDateTime;

public class ActionMiddleware {

    private MessageHandler user;
    private RoomManager roomManager;

    public ActionMiddleware(MessageHandler user) {
        this.user = user;
        this.roomManager = RoomManager.getInstance();
    }

    public void closeSocketClient() {
        try {
            user.getSocketUser().stopTextChannels();
            user.getSocketUser().stopByteChannels();
            user.getRoom().deleteObservable(user);
        } catch (IOException e) {
            System.out.println("Error al cerrar los canales del socket");
        }
    }

    public void createChatRoom(Message message) {
        notifyServer(message);
        roomManager.createRoom(message.getContent());
    }

    public void changeChatRoom() {

    }

    // Metodos necesarios patrón observer
    public void notifyServer(Message message) {
        this.user.getRoom().broadcast(this.user.getMiddlewareJson().buildJson(message) + " :" + getHour());
    }

    // Metodo para obtener la hora en el momento en el que el servidor recibe el mensaje
    public String getHour() {
        LocalDateTime time = LocalDateTime.now();
        int hour = time.getHour();
        int minutes = time.getMinute();
        return hour + ":" + minutes;
    }

}
