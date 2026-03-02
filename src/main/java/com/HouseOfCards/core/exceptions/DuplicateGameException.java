package com.HouseOfCards.core.exceptions;

public class DuplicateGameException extends GameException{

    public DuplicateGameException(String id){
        super("game with id '" + id+ "' already exists..");
    }

}
