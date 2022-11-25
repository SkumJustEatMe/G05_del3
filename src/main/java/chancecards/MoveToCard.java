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
        spot = p.getPosition();
        p.setPosition(value);
        if(spot > p.getPosition()){
            p.changeBalance(2);
        }
    }

    public String printText(){
        return this.text;
    }
}
