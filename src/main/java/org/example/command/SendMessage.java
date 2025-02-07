package org.example.command;

import org.example.entities.Message;
import org.example.interfaces.MyCommand;
import org.example.middleware.ActionMiddleware;

//* Patrón command para enviar mensajes
public class SendMessage implements MyCommand {
    private ActionMiddleware middleware;

    public SendMessage(ActionMiddleware middleware) {
        this.middleware = middleware;
    }

    // Metodo para enviar mensajes
    @Override
    public void execute(Message message) {
        middleware.notifyServer(message);
    }
}
