package chancecards;

import chancecards.ChanceCard;
import game.Player;

public class FreeFieldCard extends ChanceCard {
    String text, color, color2;

    public FreeFieldCard(String text, String color, String color2){
        this.text = text;
        this.color = color;
        this.color2 = color2;
    }
    public void execute(Player p, Board board){
        for(int i = p.curSqr; i!=25 ;i++) {
            if (i == 24) {
                i = 1;
                p.changeBalance(2);
            }
            if (board.number(i).color.Equals(color) || board.number(i).color.Equals(color2)) {
                p.curSqr = i;
                i = 25;
            }
        }
        if(p.curSqr.owner() = null){
            p.curSqr.owner() = p.curPlayer();
        }
        else{
            p.changeBalance(-p.curSqr.rent());
            p.curSqr.owner.changeBalance(+p.curSqr.rent());
        }
    }
    public String printText(){
        return this.text;
    }
}
