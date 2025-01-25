package org.example.rooms;

import org.example.services.RoomServices;
import org.example.socket.User;

import java.util.ArrayList;

public class RoomGestor implements RoomServices {
    @Override
    public Room createRoom(String name, int capacity) {
        return null;
    }

    @Override
    public boolean joinRoom(User user, String roomId) {
        return false;
    }

    @Override
    public ArrayList<User> getUsersInRoom(String roomId) {
        return null;
    }
}
