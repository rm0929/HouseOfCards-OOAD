package com.HouseOfCards.core.Games.Blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
    private final List<Card> cards;

    public Hand(){
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public List<Card> getCards(){
        return Collections.unmodifiableList(cards);
    }

    @Override
    public String toString(){
        return cards.toString();
    }
}
