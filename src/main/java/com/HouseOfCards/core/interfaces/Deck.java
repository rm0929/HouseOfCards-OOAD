package com.HouseOfCards.core.interfaces;

import com.HouseOfCards.core.models.Card;

public interface Deck {
    void shuffle();
    Card draw();
    int remaining();
}
