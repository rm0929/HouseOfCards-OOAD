package com.HouseOfCards.core.Games.War;

import java.util.Deque;
import java.util.LinkedList;

public class PlayerHand {
    Deque<Card> cards;

    public PlayerHand(){
        this.cards = new LinkedList<>();
    }

    public void getCard(Card card){
        cards.addFirst(card);
    }
    public void addCardAtEnd(Card card){
        cards.addLast(card);
    }

    public Card playCard(){
        return cards.removeFirst();

    }
    public int remainingCards(){
        return cards.size();
    }

}
