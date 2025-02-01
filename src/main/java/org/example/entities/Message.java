package org.example.entities;

public class Message {

    private Action type;
    private String content;

    public Message(Action type, String content) {
        this.type = type;
        this.content = content;
    }

    public Action getType() {
        return type;
    }

    public void setType(Action type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
