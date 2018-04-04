package tictactoe.sockets;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import tictactoe.handlers.UserHandler;
import tictactoe.handlers.GameHandler;

@WebSocket
public class Websocket {
    
    @OnWebSocketConnect
    public void connected(Session session) {
        UserHandler.addUser(session);
        //MessageHandler.updateGameList(session,
            //GameHandler.getOpenGames());
    }
    
    @OnWebSocketMessage
    public void message(Session session, String message) {
        String[] data = message.split(":");
        switch (data[0]) {
            case "queue":
                GameHandler.queueGame(session);
                break;
            case "name":
                UserHandler.setUsername(session, data[1]);
                break;
            case "xx":
                break;
            default:
                break;
        }
    }
    
    @OnWebSocketClose
    public void close(Session session, int statusCode, String reason) {
        
    }
    
}