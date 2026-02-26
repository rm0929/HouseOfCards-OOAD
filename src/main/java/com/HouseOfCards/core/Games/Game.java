package com.HouseOfCards.core.Games;

import com.HouseOfCards.core.io.ILogger;

public interface Game {
    String getID();
    String getName();
    void play(ILogger logger);
}
// Add more methods for the gameplay and
// add a Card "interface" which stores all the card properties
