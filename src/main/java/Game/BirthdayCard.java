package Game;

public class BirthdayCard extends ChanceCard{
    private String text;
    private int amount;

    public BirthdayCard(String text, int amount){
        this.text = text;
        this.amount = amount;
    }
    public void execute(Player p){
        amount = p.getNumberofPlayers()-1;
        p.changeBalance(amount);
        p.otherPlayers.changeBalance(-1);
    }
    public String printText(){
        return this.text;
    }
}
