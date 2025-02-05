package org.example.interfaces;

import org.example.entities.Message;

//* Patrón command se usa en la implementación del middleware
public interface MyCommand {

    public void execute(Message message);

}
