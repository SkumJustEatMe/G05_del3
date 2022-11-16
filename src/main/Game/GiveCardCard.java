package Game;
public class GiveCardCard extends ChanceCard{
    String text;
    String name;

    public GiveCardCard(String text, String name){
        this.text = text;
        this.name = name;
    }
    public void execute(Player p, Board board) {
        GiveCardCard giveCardCard = new GiveCardCard(text,name);
        if (Player.name == true){
            if (p.name == name) {
                giveCardCard.buyNextFieldCardActivated();
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
    private void buyNextFieldCardActivated(){
        int spot = p.curSqr;
        boolean j = true;
            for (int i = 0; i < 24; i++) {
            spot = +1;
            if (spot == 24) {
                spot = 1;
            }
            if (board.number(spot).owned() == false) {
                p.curSqr = spot;
                p.curSqr.buyField;
                p.changeBalance(-p.curSqr.price);
                i = 24;
                j = false;
            }
        }
            if(j = true){
            for (int i = 0; i < 24; i++) {
                spot = +1;
                if (spot == 24) {
                    spot = 1;
                }
                if (board.number(spot).owned().otherPlayer == true) {
                    p.curSqr = spot;
                    p.curSqr.buyField;
                    p.changeBalance(-p.curSqr.price);
                    p.curSqr.owner.changeBalance(+p.curSqr.price));
                    p.curSqr.newOwner(p);
                    i = 24;
                }
            }
        }
}
}