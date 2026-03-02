package com.HouseOfCards.core.interfaces;

import com.HouseOfCards.core.io.ILogger;

public interface Game {
    String getID();
    String getName();
    void play(ILogger logger);
}
// Add more methods for the gameplay and
// add a Card "interface" which stores all the card properties
