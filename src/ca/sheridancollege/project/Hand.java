package ca.sheridancollege.project;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cardsInHand;

    public void addCardtoHand(Card card){
        cardsInHand.add(card);

    }
    public Card playCardFromHand(int index){
        return cardsInHand.get(index);

    }
    
}
