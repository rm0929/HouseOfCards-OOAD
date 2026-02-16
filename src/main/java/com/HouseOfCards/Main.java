package com.HouseOfCards;

import com.HouseOfCards.core.GameCatalog;
import com.HouseOfCards.core.io.ConsoleLogger;
import com.HouseOfCards.core.io.ILogger;

public class Main {
    public static void main(String[] args) {
        // Logger - io operations
        ILogger logger = new ConsoleLogger();

        // GameCatalog -> like menu for games
        GameCatalog gameCatelog = new GameCatalog(logger);

        // App -> running the selected game


    }
}