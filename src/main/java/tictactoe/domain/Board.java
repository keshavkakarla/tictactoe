package tictactoe.domain;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Board implements Serializable {
    
    @SerializedName("data") private StringBuilder gameBoard;
    
    public Board() {
        this.gameBoard = new StringBuilder(".........");
    }
    
}