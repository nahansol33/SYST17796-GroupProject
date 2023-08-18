/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author Hansol Na, Adegoke Akanbi, Bilson Sunny, Dev Dahiya
 * @author Last modified on June 15 2023
 */
public class Card {

    private CardSuit suit;
    private CardNumber value;

    public Card(CardSuit suit, CardNumber value){
        this.suit = suit;
        this.value = value;
    }

    public CardSuit getSuit(){
        return suit;
    }
    public CardNumber getValue(){
        return value;
    }


    //default modifier for child classes

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    



}
