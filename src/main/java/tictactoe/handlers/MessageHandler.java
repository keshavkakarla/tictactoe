package tictactoe.handlers;

import com.google.gson.Gson;
import java.util.List;
import javafx.util.Pair;
import org.eclipse.jetty.websocket.api.Session;
import tictactoe.domain.Game;

public abstract class MessageHandler {
    
    private static Gson gson = new Gson();
    
    // Unused method (so far).
    // Will be used for private games/lobby browser.
    // Update available games for everyone.
    public static void broadcastGames(List<Game> games) {
        UserHandler.getUsers().keySet().stream().forEach(user -> {
            try {
                user.getRemote().sendString(gson.toJson(games));
            } catch (Exception ex) {
                // Do nothing.
            }
        });
    }
    
    // Unused method (so far).
    // Will be used for private games/lobby browser.
    // Update available games for a single person connecting.
    public static void updateGameList(Session session, List<Game> games) {
        try { 
            session.getRemote().sendString(gson.toJson(games, Game.class));
        } catch (Exception ex) {
            // Do nothing.
        }
    }
    
    public static void sendGameUpdate(Game game) throws Exception {
        Pair<Session, Session> players = game.getPlayers();
        players.getKey().getRemote().sendString(gson.toJson(game));
        players.getValue().getRemote().sendString(gson.toJson(game));
    }
    
}
