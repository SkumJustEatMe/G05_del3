package Game;
public class RecieveOrPayCard extends ChanceCard{
    private String text;
    private int amount;
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
