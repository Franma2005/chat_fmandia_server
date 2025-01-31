package org.example.rooms;

import org.example.socket.SocketManager;

public interface RoomServices {

    public void roomEntry(SocketManager user, String nameRoom);
    public void createRoom(String name);
    public Room getRoom(String roomName);

}
