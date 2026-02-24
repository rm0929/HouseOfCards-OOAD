package com.HouseOfCards.core.Games.War;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PlayerHand {
    Deque<Card> cards;
    // queue

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
