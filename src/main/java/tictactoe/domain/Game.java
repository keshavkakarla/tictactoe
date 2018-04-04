package tictactoe.domain;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import javafx.util.Pair;
import org.eclipse.jetty.websocket.api.Session;

public class Game implements Serializable {
    
    private Board gameBoard;
    private transient Pair<Session, Session> players;
    @SerializedName("gameAlive") private boolean isAlive;
    private transient boolean isOpen;
    
    public Game(Session session) {
        this.gameBoard = new Board();
        this.players = new Pair<>(session, null);
        this.isAlive = true;
        this.isOpen = true;
    }
    
    public boolean joinLobby(Session session) {
        if (isOpen && players.getKey() != session 
            && players.getValue() == null) {
            players = new Pair<>
                (players.getKey(), session);
            isOpen = false;
            return true;
        }
        return false;
    }
    
    public Pair<Session, Session> getPlayers() {
        return players;
    }

    public boolean isOpen() {
        return isOpen;
    }
    
    public boolean isAlive() {
        return isAlive;
    }
    
}