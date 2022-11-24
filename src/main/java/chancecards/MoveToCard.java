package chancecards;

import chancecards.ChanceCard;
import game.Player;

public class MoveToCard extends ChanceCard {
    String text;
    int value;
    public MoveToCard(String text, int value){
        this.text = text;
        this.value = value;
    }

    public void execute(Player p){
        int spot;
        p.curSqr = spot;
        p.curSqr = p.setLoc(value);
        if(spot > p.curSqr){
            p.changeBalance(200);
        }
    }

    public String printText(){
        return this.text;
    }
}
