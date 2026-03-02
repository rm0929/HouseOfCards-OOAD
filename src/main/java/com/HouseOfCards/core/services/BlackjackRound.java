package com.HouseOfCards.core.services;

import com.HouseOfCards.core.models.StandardDeck;
import com.HouseOfCards.core.models.BlackjackHand;
import com.HouseOfCards.core.interfaces.Deck;
import com.HouseOfCards.core.io.ILogger;
import com.HouseOfCards.core.models.Card;
import com.HouseOfCards.core.enums.Rank;

public class BlackjackRound {
    private final ILogger logger;
    private final Deck deck;
    private final BlackjackHand player;
    private final BlackjackHand dealer;

    public BlackjackRound(ILogger logger){
        this.logger = logger;
        this.deck = new StandardDeck();
        this.deck.shuffle();
        this.player = new BlackjackHand();
        this.dealer = new BlackjackHand();
    }

    public void play(){
        initialDeal();
        playerTurn();
        if (handValue(player) > 21) return;
        dealerTurn();
        decideWinner();
    }

    private void initialDeal() {
        player.add(deck.draw());
        dealer.add(deck.draw());
        player.add(deck.draw());
        dealer.add(deck.draw());

        logger.response("Dealer shows: " + dealer.getCards().getFirst() + " and [Hidden]");
        logger.response("Your hand: " + player + " (value: " + handValue(player) + ")");
    }

    private void playerTurn() {
        while (true) {
            int v = handValue(player);
            if (v > 21) {
                logger.response("You busted! (" + v + ")");
                logger.response("Dealer wins.");
                return;
            }

            String action = logger.ask("Hit or Stand? (h/s)").trim().toLowerCase();
            if (action.equals("h")) {
                Card drawn = deck.draw();
                player.add(drawn);
                logger.response("You drew: " + drawn);
                logger.response("Your hand: " + player + " (value: " + handValue(player) + ")");
            } else if (action.equals("s")) {
                return;
            } else {
                logger.response("Invalid input. Type 'h' or 's'.");
            }
        }
    }

    private void dealerTurn() {
        logger.response("");
        logger.response("Dealer reveals: " + dealer + " (value: " + handValue(dealer) + ")");

        while (handValue(dealer) < 17) {
            Card drawn = deck.draw();
            dealer.add(drawn);
            logger.response("Dealer draws: " + drawn);
            logger.response("Dealer hand: " + dealer + " (value: " + handValue(dealer) + ")");
        }
    }

    private void decideWinner() {
        int pv = handValue(player);
        int dv = handValue(dealer);

        logger.response("");

        if (dv > 21) {
            logger.response("Dealer busted! (" + dv + ")");
            logger.response("You win!");
            return;
        }

        if (pv > dv) logger.response("You win! " + pv + " vs " + dv);
        else if (pv < dv) logger.response("Dealer wins! " + dv + " vs " + pv);
        else logger.response("Push (tie)! " + pv + " vs " + dv);
    }

    private int handValue(BlackjackHand hand) {
        int total = 0;
        int aces = 0;

        for (Card c : hand.getCards()) {
            total += c.getRank().getCardValue();
            if (c.getRank() == Rank.ACE) aces++;
        }

        // convert Aces 11 -> 1 if busted
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    }
}
