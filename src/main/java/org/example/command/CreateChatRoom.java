package org.example.command;

import org.example.interfaces.MyCommand;
import org.example.middleware.WebSocketMiddleware;

public class CreateChatRoom implements MyCommand {
    private WebSocketMiddleware middleware;

    public CreateChatRoom(WebSocketMiddleware middleware) {
        this.middleware = middleware;
    }

    @Override
    public void execute() {

    }
}
