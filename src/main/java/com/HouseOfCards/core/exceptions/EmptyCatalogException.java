package com.HouseOfCards.core.exceptions;

public class EmptyCatalogException extends GameException{

    public EmptyCatalogException() {
        super("The games catalog is Empty. Please add games.");
    }
}
