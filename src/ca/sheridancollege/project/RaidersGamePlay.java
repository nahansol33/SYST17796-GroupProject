package raiders;

import java.util.Scanner;

public class RaidersGamePlay {
    public static void main(String[] args) throws Exception {
        Deck deck = new Deck();
        System.out.println("Welcome to Our game: Raiders \n Enter player name: ");     
        Scanner input = new Scanner(System.in);
        Player player1 = new Raider(input.nextLine());
        System.out.println("Enter Player 2 NAme: ");
        Player player2 = new Raider(input.nextLine());   
        Game game = new Game(player1, player2);
        game.play();
    }
}
