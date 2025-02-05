package org.example.interfaces;

//* Patrón observable se coloca en el middleware de MessageHandler para que se envie el mensaje cuando el servidor lo
//* requiera
public interface MyObserver {

    public void update(String message);

}
