package com.HouseOfCards.core.Games;

import com.HouseOfCards.core.io.ILogger;

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
    public void play(ILogger logger) {
        logger.response("========== Welcome to POKER ==========");
        logger.response("OOPS! logic not yet defined...");
    }
}
