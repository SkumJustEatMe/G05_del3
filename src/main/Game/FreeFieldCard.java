package Game;
public class FreeFieldCard extends ChanceCard{
    String text;
    int value;

    public FreeFieldCard(String text, int value){
        this.text = text;
        this.value = value;
    }
    public void execute(Player p){
        int spot;
        p.curSqr = spot;
        if (p.curSqr = value){
            p.curSqr +=  1;
        }else{
            p.curSqr = value;
        }
        if(spot > p.curSqr){
            p.changeBalance(200);
        }
    }
    public String printText(){
        return this.text;
    }
}
