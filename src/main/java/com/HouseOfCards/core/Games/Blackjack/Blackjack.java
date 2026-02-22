package com.HouseOfCards.core.Games.Blackjack;

import com.HouseOfCards.core.Games.Game;
import com.HouseOfCards.core.io.ILogger;

public class Blackjack implements Game {
    private static final String ID = "2";
    private static final String NAME = "Blackjack";

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void play(ILogger logger) {
        logger.response("========== Welcome to BLACKJACK ==========");
        new BlackjackRound(logger).play();
    }
}
