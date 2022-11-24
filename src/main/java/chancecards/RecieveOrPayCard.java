package chancecards;

import chancecards.ChanceCard;
import game.Player;

public class RecieveOrPayCard extends ChanceCard {
    protected String text;
    protected int amount;
    RecieveOrPayCard(String text, int amount){
        this.text = text;
        this.amount = amount;
    }


    public void execute(Player p){
       p.changeBalance(amount);
    }
    public String printText(){
        return this.text;
    }
}
