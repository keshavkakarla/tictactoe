package tictactoe;

import static spark.Spark.get;
import static spark.Spark.init;
import static spark.Spark.staticFileLocation;
import static spark.Spark.webSocket;
import tictactoe.sockets.Websocket;

public class Main {
    
    public static void main(String... args) {
        staticFileLocation("public");
        webSocket("/xoxo", Websocket.class);
        
        get("/", (request, response) -> {
            response.redirect("index.html");
            return null;
        });
        
        init();
        
    }
    
}