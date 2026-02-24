package com.HouseOfCards.core.Games.War;

import com.HouseOfCards.core.Games.War.Card;

public interface Deck {
    void shuffle();
    Card draw();
    int remaining();
}
