
    function listGames(gameList) {
        for (var i = 0; i < gameList.length; i++) {
            getId("gameList").innerHTML 
                += "<div class='game'>" + gameList[i].gameHost + "</div>";
        }
    }
    
    function updateGame(data) {
        if (data.gameAlive) {
            for (var i = 0; i < 9; i++) {
                getId(i).innerHTML = data.gameBoard.data[i];
            }
        }
    }
    
    function getId(id) {
        return document.getElementById(id);
    }