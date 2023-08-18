package ca.sheridancollege.project;

public class ActualPlayer extends Player {
    private Board board = new Board();
    private Hand hand = new Hand();
    private boolean isRaider = false;

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
    
    public void setIsRaider(boolean control){
        this.isRaider = control;
    }
    public boolean getIsRaider(){
        return isRaider;
    }
    
}
