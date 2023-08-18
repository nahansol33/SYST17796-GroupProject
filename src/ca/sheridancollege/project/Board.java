package ca.sheridancollege.project;

import java.util.ArrayList;

public class Board {
    private ArrayList<Card> board = new ArrayList<>();

    public void addCardToBoard(Card card){
        board.add(card);
        
    }

    public CardNumber calc(){
       return board.get(0).getValue();
    }
}
