package ca.sheridancollege.project;

import java.util.ArrayList;

public class PlayerBoard {
    private ArrayList<Card> board;

    public PlayerBoard(){
        board = new ArrayList<>();
    }

    public void addCardToBoard(Card card){
        board.add(card);
    }

    public ArrayList<Card> getPlayerBoard(){
        return board;
    }

    public void displayBoard(){
        System.out.println(board);
    }
}
