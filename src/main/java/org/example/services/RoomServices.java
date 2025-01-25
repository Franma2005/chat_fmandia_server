package org.example.services;

import org.example.rooms.Room;
import org.example.socket.User;

import java.util.ArrayList;

public interface RoomServices {

    Room createRoom(String name, int capacity);
    boolean joinRoom(User user, String roomId);
    ArrayList<User> getUsersInRoom(String roomId);


}
