package org.example.services;

import org.example.rooms.Room;
import org.example.socket.User;

import java.util.ArrayList;

public interface RoomServices {

    public Room createRoom(String name);
    public ArrayList<String> getRoomsNames();
    public ArrayList<String> getUsersNames();

}
