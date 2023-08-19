package raiders;

import java.util.ArrayList;

public class PlayerHand {
    private ArrayList<Card> cardsInHand = new ArrayList<>();

    public void addCardToHand(Card card){
        cardsInHand.add(card);
    }

    public Card playCardFromHand(int userChoice){
        Card chosenCard = cardsInHand.get(userChoice);
        cardsInHand.remove(chosenCard);
        return chosenCard;
    }

    public String viewHand(){
        String msg = "Your Cards in Hand: \n";
        String cardsPrinted = "";
        int i = 0;
        for (Card c:cardsInHand){
            cardsPrinted += c.toString() + " index = " + i + "\n";
            i++;
        }
        return msg + cardsPrinted;
    }
}
