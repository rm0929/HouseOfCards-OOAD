package com.HouseOfCards.core.app;

import com.HouseOfCards.core.GameCatalog;
import com.HouseOfCards.core.Games.Game;
import com.HouseOfCards.core.exceptions.EmptyCatalogException;
import com.HouseOfCards.core.exceptions.GameException;
import com.HouseOfCards.core.io.ILogger;

import java.util.List;

public class App {
    private final ILogger logger;
    private final GameCatalog gameCatalog;

    public App(ILogger logger, GameCatalog gameCatalog){
        this.logger = logger;
        this.gameCatalog = gameCatalog;
    }

    public void start(){
        greet();
        showCatalog();
        Game selectedGame = selectGame();
        runSelectedGame(selectedGame);    }

    private void greet(){
        logger.response("========== WELCOME TO HOUSE OF CARDS ==========");
    }

    private void showCatalog(){
        logger.response("");
        logger.response("Available games:");

        try {
            List<Game> games = gameCatalog.getAllGames();

            for (Game game : games) {
                logger.response("[" + game.getID() + "] " + game.getName());
            }
        } catch (GameException e){
            logger.response("ERROR: " + e.getMessage());
        }


        logger.response("");
    }

    private Game selectGame(){
        while (true) {
            try {
                String id = logger.ask("Select a game by id:");

                Game game = gameCatalog.getById(id);

                return game;   // valid → exit loop

            } catch (GameException e) {
                logger.response("ERROR: " + e.getMessage());
            }
        }
    }

    private void runSelectedGame(Game game) {
        logger.response("");
        logger.response("Launching: " + game.getName());
        logger.response("--------------------------------");
        game.play(logger);
        logger.response("--------------------------------");
        logger.response("Exiting House of Cards.");
    }
}
