package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private static ArrayList<Card> deck = null;

    private Deck(){

    }

    public static ArrayList<Card> getDeck(){
        if (deck == null){
            deck = new ArrayList<>();
            for (int i = 0; i < 13; i++){
                CardNumber value = CardNumber.values()[i];
    
                for (int j = 0; j < 4; j++){
                    Card card = new Card(CardSuit.values()[j], value);
                    deck.add(card);
                }
            }
            Collections.shuffle(deck);
    
            return deck;

        }

        return deck;

       
    }

    public static void dealCard(ActualPlayer player){
        ArrayList<Card> deck = getDeck();
        int rand = (int)(Math.random() * 51);
        // System.out.println(rand);
        Card card = deck.get(rand);
        // System.out.println(card.getValue());
        player.getBoard().addCardToBoard(card);
       
    }
    
}
