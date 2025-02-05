package org.example.middleware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.entities.Message;

public class JsonMiddleware {

    private Gson gson;

    public JsonMiddleware() {
        gson = new GsonBuilder().create();
    }

    // Metodos para trabajar con el json
    public String buildJson(Message message) {
        return gson.toJson(message);
    }

    public Message destructureJson(String message) {
        System.out.println(message);
        return gson.fromJson(message, Message.class);
    }
}
