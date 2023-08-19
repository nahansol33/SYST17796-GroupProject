package ca.sheridancollege.project;

// * @author Hansol Na, Adegoke Akanbi, Bilson Sunny, Dev Dahiya
// * @author Last modified on Aug 18 2023

//This class is for creating Card instances that will be used in a composition relationship with the Deck class to create a dynamic Deck
public class Card {
    private CardSuit suit;
    private CardNumber number;

    public Card(CardSuit suit, CardNumber number){
        this.suit = suit;
        this.number = number;
    } 

    public int getValue(){
        switch (this.number){
            case ACE:
            return 11;

            case TWO:
            return 2;

            case THREE:
            return 3;

            case FOUR:
            return 4;

            case FIVE:
            return 5;

            case SIX:
            return 6;
            
            case SEVEN:
            return 7;

            case EIGHT:
            return 8;
            
            case NINE:
            return 9;

            case TEN:
            return 10;

            case JACK:
            return 10;

            case QUEEN:
            return 10;

            case KING:
            return 10;

        }
        return 1;
    }

    public CardSuit getSuit(){
        return suit;
    }

    public CardNumber getNumber(){
        return number;
    }

    @Override
    public String toString(){
        return "" + getSuit() + " " +getNumber();
    }
}
