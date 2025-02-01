package org.example.rooms;

import org.example.socket.MessageHandler;
import org.example.socket.SocketManager;

import java.util.HashMap;


public class RoomGestor implements RoomServices {

    private HashMap<String ,Room> roomsList;

    public RoomGestor() {
        roomsList = new HashMap<>();
        createRoom("General");
    }

    @Override
    public void roomEntry(MessageHandler user, String nameRoom) {
        user.setRoom(roomsList.get(nameRoom));
        roomsList.get(nameRoom).addObservable(user);
    }

    @Override
    public void createRoom(String name) {
        roomsList.put(name ,new Room(name));
    }

    @Override
    public Room getRoom(String roomName) {
        return roomsList.get(roomName);
    }
}
