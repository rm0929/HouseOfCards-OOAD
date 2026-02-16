package com.HouseOfCards.core;

import com.HouseOfCards.core.Games.Game;
import com.HouseOfCards.core.Games.Poker;
import com.HouseOfCards.core.io.ILogger;
import java.util.List;

public class GameCatalog {
    private final ILogger logger;
    private List<Game> listOfGames;

    public GameCatalog(ILogger logger){
            this.logger = logger;
            greet();
    }

    private void greet(){
        logger.response("========== WELCOME TO HOUSE OF CARDS ==========");
        logger.response("// iterate over all the games"); // rohan
        String selectedGameID = logger.ask("Select a game to begin playing... :)");
        // get Game name from selectedGameID
    }

    public List<Game> getAllGames(){
        return this.listOfGames;
    }

    // Add Game -> rohan
    public void addGame(Game game){

    }

    public void removeGame(){

    }

}
