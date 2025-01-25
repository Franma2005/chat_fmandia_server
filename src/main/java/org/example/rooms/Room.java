package org.example.rooms;

import org.example.socket.User;

import java.util.ArrayList;

public class Room {

    private int id;
    private ArrayList<User> users;

    public Room(int id, ArrayList<User> users) {
        this.id = id;
        this.users = users;
    }


}
