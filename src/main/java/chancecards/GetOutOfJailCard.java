package chancecards;

import chancecards.ChanceCard;
import game.Player;

public class GetOutOfJailCard extends ChanceCard {
    String text;
    public GetOutOfJailCard(String text){
        this.text = text;
    }
    public void execute(Player p){
        p.setGetOutOfJailFreeCards(1);
    }
    public String printText(){
        return this.text;
    }
}
