package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Scanner;

public class Start extends Game {
    
    private Deck gameDeck;

    public Start(String name){
        super(name);
    }

    @Override
    public void play(){
        
    }

    
    public void declareWinner(ActualPlayer player1, ActualPlayer player2){
       System.out.println("Winner is " + determineRaider(player1, player2));
       
    }

    //method to calculate a player's score
    public int calculateScore(ActualPlayer player){
        return player.getBoard().calculateTotalBoardValue();
    }

    public ActualPlayer determineRaider(ActualPlayer player1, ActualPlayer player2){ 
        return calculateScore(player1) > calculateScore(player2) ? player1 : player2;
    }

    public ActualPlayer determineWinner(ActualPlayer player1, ActualPlayer player2){
        ActualPlayer winner = null;
        if (calculateScore(player1) > 34 ){ 
            winner = player2; 
        } else if (calculateScore(player2) > 34 ){
            winner = player1; 
        } else if(calculateScore(player1) == 34 ){ 
            winner = player1; 
        } else if (calculateScore(player2) == 34 ){
            winner = player2; 
        }
        
        return winner;
    }

    public static void main(String[] args){
        int round = 1;
        Start thisGame = new Start("Raiders");
        System.out.println("Welcome to " + thisGame.getName() + " game!!!");
        // System.out.print("\nPlease enter your username: ");
        // Scanner input = new Scanner(System.in);
        
        ActualPlayer player1 = new ActualPlayer("Adegoke");
        ActualPlayer player2 = new ActualPlayer("Computer");


        // add the players to the game.
        // NOTE i chose not to access the players through the getPlayers method
        // cuz that will occassion a lot of loops to get each player to apply game logic to them.
        // Maybe we should just delete that setter and getter methods in the Game class
        ArrayList<Player> players = new ArrayList<>();        
        players.add(player1);
        players.add(player2);

        thisGame.setPlayers(players);


        

        if (round == 1) {
            //deal two cards to each player in an alternate manner
           for (int i = 0; i < 2; i++){
                Deck.dealCard(player1.getBoard());
                Deck.dealCard(player2.getBoard());
           }

        //    check for raider if no player has won
           if (thisGame.determineWinner(player1, player2) == null){
                /*
                This is sort of object chaining. The determineRaider method 
                returns a player object. The raider attribute of that object is then turned on.                
                */
                thisGame.determineRaider(player1, player2).setIsRaider(true);

           }

           if (player1.getIsRaider()) {
                //then player1 plays his options here since he is the raider.
                //followed by player2's play options
           } else {
                //if not, then player2 is the raider and thus plays his options here
                //followed by player1's play options
           }

           round++;
        }
        
        while (round > 1 && round <= 3) {
            // deal one card to each player's board
            Deck.dealCard(player1.getHand());
            Deck.dealCard(player2.getHand());

            //check for raider if no player has won
           if (thisGame.determineWinner(player1, player2) == null){
                /*
                This is sort of object chaining. The determineRaider method 
                returns a player object. The raider attribute of that object is then turned on.                
                */
                thisGame.determineRaider(player1, player2).setIsRaider(true);

           }


            if (player1.getIsRaider()) {
                //then player1 plays his options here since he is the raider.
                //followed by player2's play options
           } else {
                //if not, then player2 is the raider and thus plays his options here
                //followed by player1's play options
           }

           //declare winner if there is one at the end of the rounde
            if (thisGame.determineWinner(player1, player2) != null) {
                thisGame.declareWinner(player1, player2);
                round = -1; //to end the game.

            }

            
           round++;
           

        }



    }
    
}
