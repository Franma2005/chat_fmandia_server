package org.example.command;

import org.example.interfaces.MyCommand;
import org.example.middleware.ActionMiddleware;

public class CreateChatRoom implements MyCommand {
    private ActionMiddleware middleware;

    public CreateChatRoom(ActionMiddleware middleware) {
        this.middleware = middleware;
    }

    @Override
    public void execute(String message) {
        middleware.createChatRoom();
    }
}
