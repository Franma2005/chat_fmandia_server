package org.example.entities;

public class Message {

    private Action action;
    private String content;

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
}
