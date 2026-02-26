package com.HouseOfCards.core.Games;

import com.HouseOfCards.core.Games.Cards.Card;

public interface Deck {
    void shuffle();
    Card draw();
    int remaining();
}
