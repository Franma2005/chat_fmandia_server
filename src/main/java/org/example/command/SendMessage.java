package org.example.command;

import org.example.interfaces.MyCommand;
import org.example.middleware.WebSocketMiddleware;

public class SendMessage implements MyCommand {
    private WebSocketMiddleware middleware;

    public SendMessage(WebSocketMiddleware middleware) {
        this.middleware = middleware;
    }

    @Override
    public void execute() {

    }
}
