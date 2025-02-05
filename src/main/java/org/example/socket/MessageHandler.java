package org.example.socket;

import org.example.command.ChangeChatRoom;
import org.example.command.CloseSocketClient;
import org.example.command.CreateChatRoom;
import org.example.command.SendMessage;
import org.example.entities.Action;
import org.example.entities.Message;
import org.example.interfaces.MyCommand;
import org.example.interfaces.MyObserver;
import org.example.middleware.JsonMiddleware;
import org.example.middleware.ActionMiddleware;
import org.example.rooms.Room;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

//* Esta clase maneja las operaciones básicas como recibir mensajes, enviar. Además contiene cada instancia su propia
//* instancia de middleware que interpreta el mensaje y decide en consecuencia
public class MessageHandler extends Thread implements MyObserver {

    // Atributos de la clase
    private String userName;
    private SocketManager socketUser;
    private Room room;

    // Estos son los middleware uno para tratar el json y otro que gracias al patrón command nos permite realizar diferentes
    // acciones
    private ActionMiddleware middlewareAction;
    private JsonMiddleware middlewareJson;

    //Parte necesaria para el patrón command
    HashMap<Action, MyCommand> commands;

    // Constructor de la clase
    public MessageHandler(Socket socket, String userName, Room room) {
        this.socketUser = new SocketManager(socket);
        this.userName = userName;
        this.room = room;
        this.middlewareAction = new ActionMiddleware(this);
        this.middlewareJson = new JsonMiddleware();
        this.commands = new HashMap<>() {{
            put(Action.SEND_MESSAGE, new SendMessage(middlewareAction));
            put(Action.CHANGE_CHAT_ROOM, new ChangeChatRoom(middlewareAction));
            put(Action.CLOSE_WINDOW, new CloseSocketClient(middlewareAction));
            put(Action.CREATE_CHAT_ROOM, new CreateChatRoom(middlewareAction));
        }};
    }

    // Vamos a gestionar la recepción de mensajes
    public Message reciveMessage() throws IOException {
        return middlewareJson.destructureJson(socketUser.getBr().readLine());
    }

    // Metodo para realizar la acción que llegue en el json
    public void makeAction(Message message) {
        commands.get(message.getAction()).execute(message.getContent());
    }

    //! Son necesarios para que el WebSocketMiddleware trabaje con ellos
    // Manejo básico de las operaciones de envio y recepción de mensajes. Se usa en el update
    public void sendMessage(String message) {
        socketUser.getPw().println(message);
        socketUser.getPw().flush();
    }

    // Es necesario para cerrar los socket en el middleware
    public SocketManager getSocketUser() {
        return socketUser;
    }

    public void setSocketUser(SocketManager socketUser) {
        this.socketUser = socketUser;
    }

    // Metodo para obtener la sala en la que se encuentra nuestro MessageHandler
    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public ActionMiddleware getMiddlewareAction() {
        return middlewareAction;
    }

    @Override
    public void run() {
        try {
            socketUser.startByteChannels();
            socketUser.startTextChannels();
            Message message;
            do {
                message = reciveMessage();
                makeAction(message);
            } while(!socketUser.getSocket().isClosed());
            System.out.println("Salgo");
        } catch(IOException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    @Override
    public void update(String message) {
        sendMessage(message);
    }
}
