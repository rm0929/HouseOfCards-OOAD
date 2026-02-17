package com.HouseOfCards.core.exceptions;

import com.HouseOfCards.core.Games.Game;

public class DuplicateGameException extends GameException{

    public DuplicateGameException(String id){
        super("game with id '" + id+ "' already exists..");
    }

}
