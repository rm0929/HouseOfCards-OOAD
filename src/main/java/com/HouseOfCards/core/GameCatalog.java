package com.HouseOfCards.core;

import com.HouseOfCards.core.Games.Game;
import com.HouseOfCards.core.exceptions.DuplicateGameException;
import com.HouseOfCards.core.exceptions.EmptyCatalogException;
import com.HouseOfCards.core.exceptions.GameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class GameCatalog {
    private final List<Game> listOfGames = new ArrayList<>();

    public List<Game> getAllGames(){
        if (listOfGames.isEmpty()) {
            throw new EmptyCatalogException();
        }
        return listOfGames;
    }

    public void addGame(Game game){
        // check if the game already exist

        for (Game existing : listOfGames) {
            if (existing.getID().equals(game.getID())) {
                throw new DuplicateGameException(game.getID());
            }
        }

        listOfGames.add(game);
    }

    public void removeGame(Game game){
        // check if the game exist
        listOfGames.remove(game);
    }

    public Game getById(String id) {

        for (Game game : listOfGames) {
            if (game.getID().equalsIgnoreCase(id)) {
                return game;
            }
        }

        throw new GameNotFoundException(id);
    }
}
