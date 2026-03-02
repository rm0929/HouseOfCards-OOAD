package com.HouseOfCards.core.models;

import java.util.Deque;
import java.util.LinkedList;

public class WarHand {
    Deque<Card> cards;

    public WarHand(){
        this.cards = new LinkedList<>();
    }

    public void addToTop(Card card){
        cards.addFirst(card);
    }
    public void addToBottom(Card card){
        cards.addLast(card);
    }

    public Card playCard(){
        return cards.removeFirst();

    }
    public int remainingCards(){
        return cards.size();
    }

}
