package raiders;

import java.util.Scanner;

public class Player {
    protected String userName;
    protected PlayerBoard playerBoard;
    protected boolean isRaider;
    protected PlayerHand hand;

    public Player(String name){
        userName = name;
        playerBoard = new PlayerBoard();
        hand = new PlayerHand();
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void attack(PlayerBoard opponentBoard, Card cardFromDeck){
        System.out.println("Adding a random card from Deck to opponent's Board");
        // System.out.println("Enter the card index of the Card from your Hand you wish to attack with: ");
        // Scanner input = new Scanner(System.in);
        // int userChoice = input.nextInt();
        // Card card = hand.playCardFromHand(userChoice);
        opponentBoard.addCardToBoard(cardFromDeck);
        System.out.println("Attacked the opponenet with " + cardFromDeck);
    }

    public void playCard(){
        System.out.println("Enter the card index of the Card from your Hand you wish to play to Your Board: ");
        // System.out.println(hand.viewHand());
        Scanner input = new Scanner(System.in);
        int userChoice = input.nextInt();
        Card card = hand.playCardFromHand(userChoice);
        playerBoard.addCardToBoard(card);
        System.out.println("Played card " + card + "to your board");
    }

    public void setRaiderStatus(boolean isRaider){
        this.isRaider = isRaider;
    }

    public boolean getRaiderStatus(){
        return isRaider;
    }

    public PlayerHand getPlayerHand(){
        return hand;
    }

    public PlayerBoard getPlayerBoard(){
        return playerBoard;
    }

    public void raid(Player non_raider){};

    public void setPlayerBoard(PlayerBoard board){
        playerBoard = board;
    }

    @Override
    public String toString(){
        return userName;
    }
}
