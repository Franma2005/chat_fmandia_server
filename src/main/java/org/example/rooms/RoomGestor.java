package org.example.rooms;

import org.example.services.RoomServices;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class RoomGestor implements RoomServices {

    private ConcurrentHashMap<String ,Room> roomsList;
    private static RoomGestor instance;

    public RoomGestor() {}

    public static RoomGestor instance() {
        if (instance == null)
            instance = new RoomGestor();
        return instance;
    }

    @Override
    public void createRoom(String name) {
        roomsList.put(name ,new Room(name));
    }

    @Override
    public ConcurrentHashMap<String, Room> getRooms() {
        return roomsList;
    }
}
