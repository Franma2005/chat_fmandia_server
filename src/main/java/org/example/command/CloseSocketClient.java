package org.example.command;

import org.example.interfaces.MyCommand;
import org.example.middleware.WebSocketMiddleware;

public class CloseSocketClient implements MyCommand {
    private WebSocketMiddleware middleware;

    public CloseSocketClient(WebSocketMiddleware middleware) {
        this.middleware = middleware;
    }

    @Override
    public void execute() {

    }
}
