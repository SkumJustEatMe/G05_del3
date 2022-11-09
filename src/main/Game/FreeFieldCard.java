package Game;
public class FreeFieldCard extends ChanceCard{
    String text;
    int value, value2, value3;

    public FreeFieldCard(String text, int value, int value2, int value3){
        this.text = text;
        this.value = value;
    }
    public void execute(Player p){
        int spot;
        p.curSqr = spot;

        if (p.curSqr == value || p.curSqr == value2||p.curSqr == value3){
            p.curSqr +=  1;
        }else if(p.curSqr > value && p.curSqr < value2){
            p.curSqr = value2;
        } else if(p.curSqr > value2 && p.curSqr < value3){
        p.curSqr = value3;
        } else {
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
