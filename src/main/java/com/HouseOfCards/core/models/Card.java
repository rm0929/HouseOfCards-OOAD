package com.HouseOfCards.core.models;

import com.HouseOfCards.core.enums.Rank;
import com.HouseOfCards.core.enums.Suit;

import java.util.Objects;

public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public int compare(Card other) {
        return Integer.compare(
                this.rank.getCardValue(),
                other.rank.getCardValue()
        );
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        return suit == card.suit && rank == card.rank;
    }

    public int hashcode() { return Objects.hash(suit, rank);}


}
