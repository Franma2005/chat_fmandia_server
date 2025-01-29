package org.example.services;

import org.example.rooms.Room;
import java.util.concurrent.ConcurrentHashMap;

public interface RoomServices {

    public void createRoom(String name);
    public ConcurrentHashMap<String, Room> getRooms();

}
