package com.HouseOfCards.core.exceptions;

public abstract class GameException extends RuntimeException{

    public GameException(String error){
        super(error);
    }

}
