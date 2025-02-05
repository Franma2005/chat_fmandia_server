package org.example.middleware;

import org.example.interfaces.MyObserver;
import org.example.rooms.Room;
import org.example.rooms.RoomManager;
import org.example.socket.MessageHandler;

import java.time.LocalDateTime;

public class ActionMiddleware implements MyObserver {

    private MessageHandler user;
    private Room room;
    private RoomManager roomManager;

    public ActionMiddleware(MessageHandler user) {
        this.user = user;
    }

    public void closeSocketClient() {

    }

    public void createChatRoom() {

    }

    public void changeChatRoom() {}

    // Metodos necesarios patrón observer
    public void notifyServer(String message) {
        this.room.broadcast(message);
    }

    // Metodo para obtener la hora en el momento en el que el servidor recibe el mensaje
    public String getHour() {
        LocalDateTime time = LocalDateTime.now();
        int hour = time.getHour();
        int minutes = time.getMinute();
        return hour + ":" + minutes;
    }

    @Override
    public void update(String message) {
        user.sendMessage(message);
    }

}
