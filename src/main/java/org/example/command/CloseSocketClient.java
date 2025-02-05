package org.example.command;

import org.example.interfaces.MyCommand;
import org.example.middleware.ActionMiddleware;

public class CloseSocketClient implements MyCommand {
    private ActionMiddleware middleware;

    public CloseSocketClient(ActionMiddleware middleware) {
        this.middleware = middleware;
    }

    @Override
    public void execute(String message) {
        middleware.closeSocketClient();
    }
}
