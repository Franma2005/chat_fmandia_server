package org.example.command;

import org.example.interfaces.MyCommand;
import org.example.middleware.ActionMiddleware;

public class ChangeChatRoom implements MyCommand {
    private ActionMiddleware middleware;

    public ChangeChatRoom(ActionMiddleware middleware) {
        this.middleware = middleware;
    }

    @Override
    public void execute(String message) {
        middleware.changeChatRoom();
    }
}
