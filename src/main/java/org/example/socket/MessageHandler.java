package org.example.socket;

import org.example.entities.Message;
import org.example.interfaces.MyObserver;
import org.example.middleware.WebSocketMiddleware;
import org.example.rooms.Room;

import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;

//* Esta clase maneja las operaciones básicas como recibir mensajes, enviar. Además contiene cada instancia su propia
//* instancia de middleware que interpreta el mensaje y decide en consecuencia
public class MessageHandler extends Thread implements MyObserver {

    // Atributos de la clase
    private String userName;
    private SocketManager socketUser;
    private WebSocketMiddleware middleware;
    private Message message;
    private Room room;

    // Constructor de la clase
    public MessageHandler(Socket socket, String userName) {
        this.socketUser = new SocketManager(socket);
        this.middleware = new WebSocketMiddleware();
        this.userName = userName;
    }

    // Manejo básico de las operaciones de envio y recepción de mensajes. Se usa en el update
    public void sendMessage(String message) {
        socketUser.getPw().println(message);
        socketUser.getPw().flush();
    }

    public String reciveMessage() throws IOException {
        String messageJson = socketUser.getBr().readLine();
        Message message = middleware.destructureJson(messageJson);
        middleware.messageManager(message);
        return messageJson;
    }

    // Metodos necesarios patrón observer
    public void notifyServer(String message) {
        this.room.broadcast(message);
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    // Metodo para obtener la hora en el momento en el que el servidor recibe el mensaje
    public String getHour() {
        LocalDateTime time = LocalDateTime.now();
        int hour = time.getHour();
        int minutes = time.getMinute();
        return hour + ":" + minutes;
    }

    @Override
    public void run() {
        try {
            socketUser.startSocket();
            socketUser.startTextChannels();

            String message;
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

    @Override
    public void update(String message) {
        sendMessage(message);
    }
}
