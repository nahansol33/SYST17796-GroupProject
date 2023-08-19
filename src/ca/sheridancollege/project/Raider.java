package ca.sheridancollege.project;

import java.util.Scanner;

public class Raider extends Player{

    public Raider(String name) {
        super(name);
    }

    public void setRaiderStatus(boolean isRaider){
        this.isRaider = isRaider;
    }
    
    @Override
    public void raid(Player non_raider){
        if (isRaider){
            PlayerBoard bTemp = this.playerBoard;
            this.playerBoard = non_raider.getPlayerBoard();
            non_raider.setPlayerBoard(bTemp);
            System.out.println("Swapped boards with opponent. Do you wish to play card to your Board? y or n: ");
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            if (userInput.equals("y")||userInput.equals("Y")){
                playCard();
            }
            else {
                System.out.println("Okay, finished turn");
            }
        }
        else {
            System.out.println("You are not the Raider. Only the raider may Raid!");
        }
    }
}
