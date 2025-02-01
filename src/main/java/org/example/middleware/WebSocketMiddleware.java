package org.example.middleware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.entities.Message;


public class WebSocketMiddleware {

    private Gson gson;

    public WebSocketMiddleware() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public String buildJson(Message message) {
        return gson.toJson(message);
    }

    public Message destructureJson(String message) {
        return gson.fromJson(message, Message.class);
    }

    public void messageManager(Message message) {
        message.getAction();
    }

    public void sendMessage() {

    }

    public void closeSocketClient() {

    }

    public void createChatRoom() {

    }

    public void changeChatRoom() {}
}
