package com.HouseOfCards.core.Games;
import com.HouseOfCards.core.interfaces.Game;
import com.HouseOfCards.core.io.ILogger;
import com.HouseOfCards.core.services.WarRound;

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
