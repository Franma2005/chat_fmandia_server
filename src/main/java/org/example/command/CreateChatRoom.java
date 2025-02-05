package org.example.command;

import org.example.entities.Message;
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
    public void execute(Message message) {
        middleware.createChatRoom(message);
    }
}
