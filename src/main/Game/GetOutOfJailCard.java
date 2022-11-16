package Game;
public class GetOutOfJailCard extends ChanceCard{
    String text;

    public GetOutOfJailCard(String text){
        this.text = text;
    }
    public void execute(Player p){
        p.getOutOfJailCards += 1;
    }
    public String printText(){
        return this.text;
    }
}
