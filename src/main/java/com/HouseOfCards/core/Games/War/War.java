package com.HouseOfCards.core.Games.War;

import com.HouseOfCards.core.Games.Game;
import com.HouseOfCards.core.io.ILogger;

public class War implements Game {
    private final String id = "1";
    private final String name = "War";

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
        logger.response("========== Welcome to The game of WAR ==========");
        new WarRound(logger).play();
    }
}
