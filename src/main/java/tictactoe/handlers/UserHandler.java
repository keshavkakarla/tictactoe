package tictactoe.handlers;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.jetty.websocket.api.Session;
import tictactoe.domain.User;

public abstract class UserHandler {
    
    private static Map<Session, User> users = new HashMap<>();
    
    public static Map<Session, User> getUsers() {
        return users;
    }
    
    public static void addUser(Session session) {
        users.put(session, new User("Player"));
    }
    
    public static void removeUser(Session session) {
        users.remove(session);
    }
    
    public static String getUsername(Session session) {
        return users.get(session).getName();
    }
    
    public static void setUsername(Session session, String name) {
        users.get(session).changeUsername(name);
    }
    
}