package ca.sheridancollege.project;

public class ActualPlayer extends Player {
    private Board board = new Board();
    private Hand hand = new Hand();

    public ActualPlayer(String name){
        super(name);
        
    }

    @Override
    public void play(){

    }

    public Board getBoard(){
        return board;
    }
    public Hand getHand(){
        return hand;
    }
    // board.get(1);
    
}
