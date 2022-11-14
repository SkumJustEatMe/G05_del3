package Game;
public class GiveCardCard extends ChanceCard{
    String text;
    String name;

    public GiveCardCard(String text, String name){
        this.text = text;
        this.name = name;
    }
    public void execute(Player p, Board board) {
        int spot = p.curSqr;
        GiveCardCard giveCardCard = new GiveCardCard(text,name);
        if (Player.name == true){
            if (p.name == name) {
                giveCardCard.CardActivated();
            } else {
                Gamelogic.giveCardto(name);
                Gamelogic.curPlayer.takeNewChanceCard();
            }
        } else {
            Gamelogic.curPlayer.takeNewChanceCard();
        }
    }
    public String printText(){
        return this.text;
    }
    private void CardActivated(){
        if(
            for (int i = 0; i < 24; i++) {
            spot = +1;
            if (spot == 24) {
                spot = 0;
            }
            if (board.owned() == false) {
                p.curSqr = spot;
                p.curSqr.buyField;
                p.changeBalance(-p.curSqr.price);
            }
        }
        for (int i = 0; i < 24; i++) {
            spot = +1;
            if (spot == 24) {
                spot = 0;
            }
            if (board.owned().otherPlayer == true) {
                p.curSqr = spot;
                p.curSqr.buyField;
                p.changeBalance(-p.curSqr.price);
                p.curSqr.owner.changeBalance(+p.curSqr.rent());
                p.curSqr.newOwner(p);
            }
    }

}
}