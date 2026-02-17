package com.HouseOfCards.core.exceptions;

public class GameNotFoundException extends GameException{

    public GameNotFoundException(String id) {
        super("Game with ID '" + id + "' does not exist.");
    }
}
