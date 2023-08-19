package ca.sheridancollege.project;
// * @author Hansol Na, Adegoke Akanbi, Bilson Sunny, Dev Dahiya
// * @author Last modified on Aug 18 2023

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
