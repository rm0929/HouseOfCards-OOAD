package com.HouseOfCards.core.Games;

import com.HouseOfCards.core.io.ILogger;

public interface Game {
    String getID();
    String getName();
    void play(ILogger logger);
}
