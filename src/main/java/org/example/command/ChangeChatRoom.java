package org.example.command;

import org.example.entities.Message;
import org.example.interfaces.MyCommand;
import org.example.middleware.ActionMiddleware;

//* Patrón command para ejecutar la acción cambiarse de habitación
public class ChangeChatRoom implements MyCommand {
    private ActionMiddleware middleware;

    public ChangeChatRoom(ActionMiddleware middleware) {
        this.middleware = middleware;
    }

    // El usuario ejecuta el metodo del middleware cambiarse de habitacion
    @Override
    public void execute(Message message) {
        middleware.changeChatRoom();
    }
}
