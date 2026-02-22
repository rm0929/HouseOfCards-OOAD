package com.HouseOfCards.core.Games.Blackjack;

import com.HouseOfCards.core.exceptions.EmptyDeckException;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

public class BlackJackDeck implements Deck {

    private final List<Card> cards;

    public BlackJackDeck(){
        this.cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    @Override
    public void shuffle() {
        // logic to shuffle based on what kind of shuffle we want
    }

    @Override
    public Card draw() {
        if (cards.isEmpty()) throw new EmptyDeckException();
        return cards.removeFirst();
    }

    @Override
    public int remaining() {
        return cards.size();
    }
}
