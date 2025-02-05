package org.example.command;

import org.example.interfaces.MyCommand;
import org.example.middleware.ActionMiddleware;

public class SendMessage implements MyCommand {
    private ActionMiddleware middleware;

    public SendMessage(ActionMiddleware middleware) {
        this.middleware = middleware;
    }

    @Override
    public void execute(String message) {
        middleware.notifyServer(message);
    }
}
