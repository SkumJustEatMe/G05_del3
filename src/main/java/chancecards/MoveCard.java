package chancecards;

import chancecards.ChanceCard;
import fields.GameBoard;
import game.Player;

public class MoveCard extends ChanceCard {
    String text;
    int amount;
    MoveCard(String text, int amount){
        this.text = text;
        this.amount = amount;
    }

    public void execute(Player p, GameBoard gameBoard){
        if(p.getPosition() + amount > gameBoard.getFieldList().length){
            p.setPosition(p.getPosition() + amount - 24);
            p.changeBalance(200);
        } else {
            p.setPosition(p.getPosition()+amount);
        }
    }

    public String printText(){
        return this.text;
    }
}
