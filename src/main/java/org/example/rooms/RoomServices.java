package org.example.rooms;

import org.example.socket.MessageHandler;

//* Interfaz con métodos básicos que debe contener RoomManager
public interface RoomServices {

    public void roomEntry(MessageHandler user, String nameRoom);
    public void createRoom(String name);
    public Room getRoom(String roomName);

}
