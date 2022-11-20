package Game;
public class MoveCard extends ChanceCard{
    String text;
    int amount;
    MoveCard(String text, int value){
        this.text = text;
        this.amount = amount;
    }

    public void execute(Player p){
        int spot;
        spot = p.curSqr;
        p.curSqr() = p.curSqr() + p.move(amount);
        if(spot > p.curSqr){
            p.changeBalance(200);
        }
    }

    public String printText(){
        return this.text;
    }
}
