package Game;
public class GiveCardCard extends ChanceCard{
    String text;
    String name;

    public GiveCardCard(String text, String name){
        this.text = text;
        this.name = name;
    }
    public void execute(Player p){
        if(p.name == name){
            p.
        }
    }
    public String printText(){
        return this.text;
    }

}