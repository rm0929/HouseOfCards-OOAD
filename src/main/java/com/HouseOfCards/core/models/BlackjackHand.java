package com.HouseOfCards.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlackjackHand {
    private final List<Card> cards;

    public BlackjackHand(){
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
