package ca.sheridancollege.project;

import java.util.ArrayList;

public class Deck {
    private static ArrayList<Card> cardDeck = new ArrayList<>();

    private void createDeck(){
        for (CardSuit mySuit:CardSuit.values()){
            for (CardNumber myNumber:CardNumber.values()){
                cardDeck.add(new Card(mySuit, myNumber));
            }
        }
    }

    public Deck(){
        createDeck();
    }

    public Card dealCard(){
        int numberOfCardsInDeck = cardDeck.size();
        int index = (int) (Math.random() * (numberOfCardsInDeck -1));
        Card card = cardDeck.get(index);
        cardDeck.remove(card);
        return card;
    }

    public ArrayList<Card> getDeck(){
        return cardDeck;
    }
    public int getCardLeft(){
        return cardDeck.size();
    }
}
