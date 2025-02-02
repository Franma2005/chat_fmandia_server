package org.example.socket;

import org.example.entities.Message;
import org.example.interfaces.MyCommand;
import org.example.interfaces.MyObserver;
import org.example.middleware.ActionMiddleware;
import org.example.middleware.WebSocketMiddleware;
import org.example.rooms.Room;

import java.io.IOException;
import java.net.Socket;

//* Esta clase maneja las operaciones básicas como recibir mensajes, enviar. Además contiene cada instancia su propia
//* instancia de middleware que interpreta el mensaje y decide en consecuencia
public class MessageHandler extends Thread {

    // Atributos de la clase
    private String userName;
    private SocketManager socketUser;
    private WebSocketMiddleware middleware;
    private ActionMiddleware middlewareAction;
    private Room room;

    // Constructor de la clase
    public MessageHandler(Socket socket, String userName) {
        this.socketUser = new SocketManager(socket);
        this.middleware = new WebSocketMiddleware(this);
        this.userName = userName;
    }

    // Vamos a gestionar la recepción de mensajes
    public Message reciveMessage() throws IOException {
        return middlewareAction.destructureJson(socketUser.getBr().readLine());
    }

    // Metodo para realizar la acción que llegue en el json
    public void makeAction(Message message) {

    }

    //! Son necesarios para que el WebSocketMiddleware trabaje con ellos
    // Manejo básico de las operaciones de envio y recepción de mensajes. Se usa en el update
    public void sendMessage(String message) {
        socketUser.getPw().println(message);
        socketUser.getPw().flush();
    }

    // Metodo para obtener la sala en la que se encuentra nuestro MessageHandler
    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public void run() {
        try {
            socketUser.startSocket();
            socketUser.startTextChannels();

            Message message;
            do {
                message = reciveMessage();
                notifyServer(message + " " + getHour());
            } while(!message.equals("/END"));
            System.out.println("Salgo");
            room.deleteObservable(this);
            socketUser.stopTextChannels();
            socketUser.stopSocket();
        } catch(IOException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
