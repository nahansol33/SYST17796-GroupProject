package ca.sheridancollege.project;


import java.util.ArrayList;
// * @author Hansol Na, Adegoke Akanbi, Bilson Sunny, Dev Dahiya
// * @author Last modified on Aug 18 2023

//This class is for creating a Deck that is real-life like. It is dynamic meaning that everytime we deal a card from the deck, it is removed.
//This ensure sthat no same card is dealt twice.
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
