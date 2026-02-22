package com.HouseOfCards.core.Games.Blackjack;

public interface Deck {
    void shuffle();
    Card draw();
    int remaining();
}
