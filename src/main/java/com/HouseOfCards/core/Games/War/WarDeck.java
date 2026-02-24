package com.HouseOfCards.core.Games.War;

import com.HouseOfCards.core.exceptions.EmptyDeckException;

import java.util.ArrayList;
import java.util.List;


public class WarDeck implements Deck {

    List<Card> cards;

    public WarDeck(){
        this.cards = new ArrayList<>();
        for(Suit suit: Suit.values()){
            for(Rank rank : Rank.values()){
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle(){
        // to add logic
    }

    @Override
    public Card draw() {
        if(cards.isEmpty()){
            throw new EmptyDeckException();
        }
        return cards.removeFirst();
    }

    @Override
    public int remaining() {
        return cards.size();
    }
}
