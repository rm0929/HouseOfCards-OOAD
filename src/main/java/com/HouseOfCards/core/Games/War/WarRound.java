package com.HouseOfCards.core.Games.War;

import com.HouseOfCards.core.Games.War.Deck;
import com.HouseOfCards.core.Games.War.PlayerHand;
import com.HouseOfCards.core.io.ILogger;

import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class WarRound {
    private final ILogger logger;
    private final Deck deck;

    private final PlayerHand player1;
    private final PlayerHand player2;

    public WarRound(ILogger logger){
        // initialize logger
        // initialize deck
        // shuffle deck
        // initialize players
        // start the game
        this.logger = logger;
        this.deck = new WarDeck();
        this.deck.shuffle();
        this.player1 = new PlayerHand();
        this.player2 = new PlayerHand();
    }

    public void play(){
        // initial cards deal: cards dealing logic -> 26 cards each
        // show first card (both)
        // compare cards
        initialDeal();
        gameplay();
        declareResult();
    }

    public void initialDeal(){
        //logic to deal the cards to two players- 26 each
        while(deck.remaining() > 0){
            player1.getCard(deck.draw());
            player2.getCard(deck.draw());
        }
        logger.response("Cards are successfully dealt to both the players");
        logger.response("Game is starting now...");
    }

    public void gameplay(){
        while(player1.remainingCards() != 0 && player2.remainingCards() != 0 ){
            playCards();
        }
    }

    public void playCards(){

        List<Card> holdCards = new ArrayList<>();

        while(true){
            if (player1.remainingCards() == 0 || player2.remainingCards() == 0) {
                return;
            }

            Card card1 = player1.playCard();
            Card card2 = player2.playCard();

            displayCards(card1, card2);

            holdCards.add(card1);
            holdCards.add(card2);
            // compare cards
            int result = card1.compare(card2);

            if (result > 0) {
                awardCards(player1, holdCards);
                logger.response("Both the cards go to Player1");
                return;
            }
            else if (result < 0) {
                awardCards(player2, holdCards);
                logger.response("Both the cards go to Player2");
                return;
            }
            else {
                logger.response("WAR!");

                if (player1.remainingCards() < 4 ||
                        player2.remainingCards() < 4) {
                    return;
                }

                // Each player must place 3 face-down cards
                for (int i = 0; i < 3; i++) {

                    if (player1.remainingCards() == 0 ||
                            player2.remainingCards() == 0) {
                        return;
                    }

                    holdCards.add(player1.playCard());
                    holdCards.add(player2.playCard());
                }
                // Loop continues → next comparison
            }
        }
    }

    private void awardCards(PlayerHand winner, List<Card> holdCards) {
        for (Card card : holdCards) {
            winner.addCardAtEnd(card);
        }
    }

    private void displayCards(Card c1, Card c2){
        logger.response("Player1 card value: "+ c1.getRank().getCardValue());
        logger.response("Player2 card value: "+ c2.getRank().getCardValue());
    }

    private PlayerHand getWinner() {
        return player1.remainingCards() > 0 ? player1 : player2;
    }

    public void declareResult() {
        PlayerHand winner = getWinner();
        if (winner == player1) {
            logger.response("Player 1 wins the game!");
        } else {
            logger.response("Player 2 wins the game!");
        }
    }
}
