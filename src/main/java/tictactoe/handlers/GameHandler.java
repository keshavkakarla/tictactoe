package tictactoe.handlers;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.eclipse.jetty.websocket.api.Session;
import tictactoe.domain.Game;

public abstract class GameHandler {
    
    private static int gameNumber = 0;
    private static Map<Integer, Game> games =
        new ConcurrentHashMap<>();
    
    public static List<Game> getOpenGames() {
        return games.values().stream().filter(game
            -> game.isOpen()).collect(Collectors.toList());
    }
    
    public static void queueGame(Session session) {
        for (Game game : getOpenGames()) {
            if (game.joinLobby(session)) {
                updateGameList();
                startGame(game);
                return;
            }
        }
        // No games found, start a new lobby.
        createGame(session);
    }
    
    private static void createGame(Session session) {
        // Do not allow a user to create more than one lobby.
        if (games.values().stream().filter(game
            -> game.getPlayers().getKey() == session).count() == 0) {
            gameNumber++;
            games.put(gameNumber, new Game(session));
            updateGameList();
        }
    }
    
    private static void updateGameList() {
        // Game browser not yet implemented.
        //MessageHandler.broadcastGames(getOpenGames());
    }
    
    private static void startGame(Game game) {
        try { 
            MessageHandler.sendGameUpdate(game);
        } catch (Exception ex) {
            // Do nothing. // 
        }
    }
    
}