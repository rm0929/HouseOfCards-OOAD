package com.HouseOfCards;

import com.HouseOfCards.core.GameCatalog;
import com.HouseOfCards.core.Games.Blackjack.Blackjack;
import com.HouseOfCards.core.Games.Poker.Poker;
import com.HouseOfCards.core.app.App;
import com.HouseOfCards.core.io.ConsoleLogger;
import com.HouseOfCards.core.io.ILogger;

public class Main {
    public static void main(String[] args) {
        ILogger logger = new ConsoleLogger();

        GameCatalog catalog = new GameCatalog();
        catalog.addGame(new Poker());
        catalog.addGame(new Blackjack());

        App app = new App(logger, catalog);
        app.start();
    }
}