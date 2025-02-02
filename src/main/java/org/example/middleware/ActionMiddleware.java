package org.example.middleware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.entities.Message;

import java.util.HashMap;

public class ActionMiddleware {

    private Gson gson;

    public ActionMiddleware() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    // Metodos para trabajar con el json
    public String buildJson(Message message) {
        return gson.toJson(message);
    }

    public Message destructureJson(String message) {
        return gson.fromJson(message, Message.class);
    }
}
