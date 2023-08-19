package ca.sheridancollege.project;

import java.util.Scanner;

public class Game {
    private int round;
    private Deck gamDeck;
    Player player1;
    Player player2;
    boolean gameOverStatus;

    public Game(Player p1, Player p2){
        player1 = p1;
        player2 = p2;
        gamDeck = new Deck();
        round = 1;
    }

    public void play(){
        initializePlayerBoards();
        initializePlayerHands();
        Player raider;
        Player non_raider;
        while (!gameOverStatus && round <=3){
            System.out.print("Showing " + player1 +"'s board: ");
            player1.getPlayerBoard().displayBoard();
            System.out.print("Showing " + player2 +"'s board: ");
            player2.getPlayerBoard().displayBoard();

            if (determineWinner(player1, player2, round) == null){
                if (determinRaider(player1, player2) == player1){
                    System.out.println(player1.getUserName() + " is the Raider.");
                    raider = player1;
                    non_raider = player2;
                    player1.setRaiderStatus(true);
                    player2.setRaiderStatus(false);
                }
                else {
                    System.out.println(player2.getUserName() + " is the Raider.");
                    raider = player2;
                    non_raider = player1;
                    player1.setRaiderStatus(false);
                    player2.setRaiderStatus(true);
                }
                System.out.println("Staring round: " + round);
                
                raiderTurn(raider, non_raider);
                non_raiderTurn(raider, non_raider);
    
                updateRound();
            }
            else {
                gameOverStatus = true;
            }
            
        }
    }

    public void initializePlayerBoards(){
        player1.getPlayerBoard().addCardToBoard(gamDeck.dealCard());
        player2.getPlayerBoard().addCardToBoard(gamDeck.dealCard());
    }

    public void initializePlayerHands(){
        for (int i =0; i < 2; i++){
            player1.getPlayerHand().addCardToHand(gamDeck.dealCard());
            player2.getPlayerHand().addCardToHand(gamDeck.dealCard());
        }
    }

    public void updateRound(){
        round+=1;
        player1.getPlayerHand().addCardToHand(gamDeck.dealCard());
        player2.getPlayerHand().addCardToHand(gamDeck.dealCard());
    }

    public int calculateScore(PlayerBoard p1Board){
        int score = 0;
        for (Card c: p1Board.getPlayerBoard()){
            score += c.getValue();
        } 
        return score
        ;
    }

    public void displayScore(Player p1, Player p2){
        System.out.println(p1 +"'s Score: " + calculateScore(p1.getPlayerBoard()) + "\n" + p2 +"'s Score: " + calculateScore(p2.getPlayerBoard()));
    }

    public Player determinRaider(Player p1, Player p2){
        return calculateScore(p1.getPlayerBoard()) > calculateScore(p2.getPlayerBoard()) ? p1 : p2;
    }

    public Player determineWinner(Player p1, Player p2, int round){
        if (round <=3){
            if (calculateScore(p1.getPlayerBoard()) == 34){
                gameOverStatus = true;
                System.out.println("Winner: " + p1);
                return p1;
            }
            else if(calculateScore(p2.getPlayerBoard()) == 34){
                gameOverStatus = true;
                System.out.println("Winner: " + p2);
                return p2;
            }
            else if(calculateScore(p1.getPlayerBoard()) > 34){
                gameOverStatus = true;
                System.out.println(p1 + " Busted. " + "Winner: " + p2);
                return p2;
            }
            else if(calculateScore(p2.getPlayerBoard()) > 34){
                gameOverStatus = true;
                System.out.println(p2 + " Busted. " +"Winner: " + p1);
                return p1;
            }
            else {
                gameOverStatus = false;
                return null;
            }
        }
        else {
            return calculateScore(p1.getPlayerBoard())>calculateScore(p2.getPlayerBoard())? p1 :p2;
        }
        
    }

    public void raiderTurn(Player raider, Player non_raider){
        displayScore(raider, non_raider);
        System.out.println(raider + " goes first.");
        System.out.print(raider + "'s Hand: ");
        System.out.println(raider.getPlayerHand().viewHand());
        System.out.println("Enter: \n1 to Attack \n2 to Play Card \n3 to Raid: ");
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();

        while (userInput != 1 && userInput != 2 && userInput != 3){
            System.out.println("Wrong input, try again: ");
            userInput = input.nextInt();
        }
        if (userInput == 1){
            raider.attack(non_raider.getPlayerBoard(), gamDeck.dealCard());
        }
        else if (userInput == 2){
            raider.playCard();
        }
        else if(userInput == 3){
            if (raider.isRaider){
                raider.raid(non_raider);
            }
        }
        if (determineWinner(raider, non_raider, round) instanceof Player){
            System.exit(0);
        }
    }
    public void non_raiderTurn(Player raider, Player non_raider){
        displayScore(raider, non_raider);
        System.out.println(non_raider + "'s turn.");
        System.out.print(non_raider + "'s Hand: ");
        System.out.println(non_raider.getPlayerHand().viewHand());
        System.out.println("Enter: \n1 to Attack \n2 to Play Card: ");
        // System.out.println(non_raider + "'s turn'. Enter: \n1 to Attack \n2 to Play Card: ");
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();

        while (userInput != 1 && userInput != 2){
            System.out.println("Wrong input, try again: ");
            userInput = input.nextInt();
        }
        System.out.print(non_raider + "'s Hand: ");
        System.out.println(non_raider.getPlayerHand().viewHand());
        if (userInput == 1){
            non_raider.attack(raider.getPlayerBoard(), gamDeck.dealCard());
        }
        else if (userInput == 2){
            non_raider.playCard();
        }
        if (determineWinner(raider, non_raider, round) instanceof Player){
            System.exit(0);
        }
    }
}
