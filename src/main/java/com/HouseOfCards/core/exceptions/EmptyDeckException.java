package com.HouseOfCards.core.exceptions;

public class EmptyDeckException extends GameException {
    public EmptyDeckException() {
        super("Sorry the Deck is Empty");
    }
}
