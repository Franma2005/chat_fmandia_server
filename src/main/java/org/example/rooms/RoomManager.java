package org.example.rooms;

import org.example.socket.MessageHandler;

import java.util.HashMap;


public class RoomManager implements RoomServices {

    private HashMap<String ,Room> roomsList;
    private static RoomManager instance;

    private RoomManager() {
        roomsList = new HashMap<>();
        createRoom("General");
    }

    public static RoomManager getInstance() {
        if (instance == null)
            instance = new RoomManager();
        return instance;
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
