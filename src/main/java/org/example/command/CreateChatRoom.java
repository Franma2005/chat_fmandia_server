package org.example.command;

import org.example.interfaces.MyCommand;
import org.example.middleware.ActionMiddleware;

//* Patrón command para crear nuevas salas de chat
public class CreateChatRoom implements MyCommand {
    private ActionMiddleware middleware;

    public CreateChatRoom(ActionMiddleware middleware) {
        this.middleware = middleware;
    }

    // Metodo para crear nuevas salas de chat
    @Override
    public void execute(String message) {
        middleware.createChatRoom(message);
    }
}
