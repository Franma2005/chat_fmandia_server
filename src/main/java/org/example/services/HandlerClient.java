package org.example.services;

public class HandlerClient {

    private static HandlerClient instance;

    private HandlerClient() {
    }

    public static HandlerClient getInstance() {
        if (instance == null)
            instance = new HandlerClient();
        return instance;
    }
}
