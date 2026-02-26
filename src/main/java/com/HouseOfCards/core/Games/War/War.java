package com.HouseOfCards.core.Games.War;
import com.HouseOfCards.core.Games.Game;
import com.HouseOfCards.core.io.ILogger;

public class War implements Game {
    private static final String ID = "1";
    private static final String NAME = "War";

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
        logger.response("========== Welcome to The game of WAR ==========");
        new WarRound(logger).play();
    }
}
