package Game;

public class BirthdayCard extends ChanceCard{
    private String text;
    private String amount;

    public BirthdayCard(String text, int amount){
        this.text = text;
        this.amount = amount;
    }
    public void execute(Player p){
        amount = p.getNumberofPlayers();
        p.changeBalance(amount);
        p.otherPlayers.changeBalance(-1);
    }
}
