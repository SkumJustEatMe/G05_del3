package chancecards;

import fields.GameBoard;
import fields.PropertyField;
import game.Player;

public class GiveCardCard extends ChanceCard {
    String text;
    String name;

    public GiveCardCard(String text, String name){
        this.text = text;
        this.name = name;
    }
    public void execute(Player p, GameBoard board) {
        GiveCardCard giveCardCard = new GiveCardCard(text,name);
        if (p.getName() == true){ //skal tjekke om spilleren er med i spillet
            //dertil skal navne ændres i GUI og gamecontroller til SKIBET, HUNDEN, KATTEN, BILEN hvis det kan lade sig gøre
            if (p.getName() == name) { //tjekker om det er nuværende spillers navn der er på kortet
                giveCardCard.buyNextFieldCardActivated();
            } else {
                Gamelogic.giveCardto(name); // giver kort videre til spiller hvis navn er på kortet
                Gamelogic.curPlayer.takeNewChanceCard(); // nuværeende spiller trækker nyt kort
            }
        } else {
            Gamelogic.curPlayer.takeNewChanceCard();
        }
    }
    public String printText(){
        return this.text;
    }
    private void buyNextFieldCardActivated(Player p, GameBoard gameBoard){
        int spot = p.getPosition();
        boolean j = true;
            for (int i = 0; i < 24; i++) {
            spot += 1;
            if (spot == 23) {
                spot = 1;
            }
                if(gameBoard.getFieldList()[spot] instanceof PropertyField field){
                if (!field.hasOwner()) {
                p.setPosition(spot);
                field.setOwner(p);
                p.changeBalance(-field.getValue());
                j = false;
                break;
            }
        }
            if(j = true){
            for (i = 0; i < 24; i++) {
                spot +=1;
                if (spot == 23) {
                    spot = 1;
                }
                if(gameBoard.getFieldList()[spot] instanceof PropertyField field){
                if (field.hasOwner()) {
                    p.setPosition(spot);
                    p.changeBalance(-field.getValue());
                    field.getOwner().changeBalance(field.getValue());
                    field.setOwner(p);
                    break;
                }
            }
        }
}
}