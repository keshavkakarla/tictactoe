package tictactoe.messages;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class GameMsg extends Message implements Serializable {
    
    @SerializedName("gameID") private int gameID;
    @SerializedName("gameAlive") private boolean isAlive;
    
}