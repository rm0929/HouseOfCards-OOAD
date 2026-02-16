package com.HouseOfCards.core.app;

import com.HouseOfCards.core.GameCatalog;
import com.HouseOfCards.core.Games.Game;
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

        List<Game> games = gameCatalog.getAllGames();
        if (games.isEmpty()) {
            logger.response("No games registered.");
            return;
        }

        for (Game game : games) {
            logger.response("[" + game.getID() + "] " + game.getName());
        }
        logger.response("");
    }

    private Game selectGame(){
        while (true) {
            String id = logger.ask("Select a game by id:");
            Game game = gameCatalog.getById(id);

            if (game == null) {
                logger.response("Invalid game id. Try again.");
                continue;
            }

            return game;
        }
    }

    private void runSelectedGame(Game selected) {
        logger.response("");
        logger.response("Launching: " + selected.getName());
        logger.response("--------------------------------");
        selected.play(logger);
        logger.response("--------------------------------");
        logger.response("Exiting House of Cards.");
    }
}
