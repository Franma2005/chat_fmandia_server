package org.example.entities;

//* Clase que usamos para poder trabajar con el mensaje de manera más sencilla y controlada
public class Message {

    private Action action;
    private String content;
    private String time;

    // Incluye la acción que realizará el servidor y el mensaje que imprimira este
    public Message(Action type, String content) {
        this.action = type;
        this.content = content;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    };

    public void setTime(String time) {
        this.time = time;
    }
}
