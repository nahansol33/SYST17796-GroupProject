package ca.sheridancollege.project;

import java.util.ArrayList;

public class Board {
    private ArrayList<Card> board = new ArrayList<>();

    public void addCardToBoard(Card card){
        board.add(card);
        
    }

    public int calc(){
        int totalValue = 0;
        for (int i = 0; i < board.size(); i++){
            totalValue += board.get(i).getValue().getCardValue();
        }
        return totalValue;
    }
}
