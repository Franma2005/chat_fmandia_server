package org.example.command;

import org.example.interfaces.MyCommand;
import org.example.middleware.WebSocketMiddleware;

public class ChangeChatRoom implements MyCommand {
    private WebSocketMiddleware middleware;

    public ChangeChatRoom(WebSocketMiddleware middleware) {
        this.middleware = middleware;
    }

    @Override
    public void execute() {

    }
}
