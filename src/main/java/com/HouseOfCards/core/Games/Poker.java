package com.HouseOfCards.core.Games;

public class Poker implements Game{
    private final String id = "1";
    private final String name = "Poker";

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void play() {
        // Logic to play game
    }
}
