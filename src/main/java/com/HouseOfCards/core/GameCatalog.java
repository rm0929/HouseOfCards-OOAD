package com.HouseOfCards.core;

import com.HouseOfCards.core.Games.Game;
import java.util.ArrayList;
import java.util.List;

public class GameCatalog {
    private final List<Game> listOfGames = new ArrayList<>();

    public List<Game> getAllGames(){
        return this.listOfGames;
    }

    public void addGame(Game game){
        listOfGames.add(game);
    }

    public void removeGame(Game game){
        listOfGames.remove(game);
    }

    public Game getById(String id) {
        for (Game game : listOfGames) {
            if (game.getID().equalsIgnoreCase(id)) {
                return game;
            }
        }
        return null;
    }
}
