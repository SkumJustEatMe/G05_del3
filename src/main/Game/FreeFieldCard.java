package Game;
public class FreeFieldCard extends ChanceCard{
    String text;
    int value, value2;

    public FreeFieldCard(String text, int value, int value2){
        this.text = text;
        this.value = value;
        this.value2 = value2;
    }
    public void execute(Player p){
        int spot;
        spot = p.curSqr;
        //if (spot == value || spot == value2){
           // p.curSqr +=  1;
        //}else if(p.curSqr > value && p.curSqr < value2){
          //  p.curSqr = value2;
        //} else if(p.curSqr > value2 && p.curSqr < value){
        //p.curSqr = value;
        //}
        if(spot<value||spot>value2){
            p.curSqr = value;
        }else{
            p.curSqr = value2;
        }
        if(spot > p.curSqr()){
            p.changeBalance(2);
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
