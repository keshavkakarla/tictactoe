package tictactoe.domain;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.eclipse.jetty.websocket.api.Session;

public class Board implements Serializable {
    
    @SerializedName("data") private String gameBoard;
    @SerializedName("turn") private Session gameTurn;
    
    public Board() {
        this.gameBoard = "123456789";
    }
    
    public void move() {
        
    }
    
}
