package org.example.interfaces;

//* Patrón observable se utiliza para informar a todos las clases que contienen socket que deben enviar el mensaje
import org.example.socket.MessageHandler;

public interface MyObservable {

    public void addObservable(MessageHandler socketClient);

    public void deleteObservable(MessageHandler socketClient);

    public void broadcast(String message);
}
