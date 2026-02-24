package com.HouseOfCards.core.Games.War;

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


    public int compare(Card other) {
        return Integer.compare(
                this.rank.getCardValue(),
                other.rank.getCardValue()
        );
    }
}
