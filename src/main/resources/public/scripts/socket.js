    
    var siteAddress = "localhost:4567";
    var socketName = "xoxo";
    var socket = new WebSocket("ws://" + siteAddress + "/" + socketName);
    
    socket.onmessage = function(message) {
        var data = JSON.parse(message.data);
        if (Array.isArray(data)) {
            listGames(data);
        } else { updateGame(data); }
        return false;
    };
    
    socket.onclose = function() {
        //alert("hello!");
    };
    
    function queueGame() {
        socket.send("queue");
    }