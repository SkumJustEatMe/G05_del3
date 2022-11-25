package chancecards;

import fields.GameBoard;
import fields.PropertyField;
import game.Player;

import java.awt.*;
import game.Player;

public class FreeFieldCard extends ChanceCard {
    String text;
    Color color, color2;
    private Player p;

    public FreeFieldCard(String text, Color color, Color color2){
        this.text = text;
        this.color = color;
        this.color2 = color2;
    }
    public void execute(Player p, GameBoard board) {
        for (int i = p.getPosition(); i != 24; i++) {
            if (board.getFieldList()[i] instanceof PropertyField field) {
                if (field.getColor() == color || field.getColor() == color2) {
                    p.setPosition(i);
                    if (!field.hasOwner()) {
                        field.setOwner(p);
                        break;
                    } else {
                        p.changeBalance(-field.getValue());
                        field.getOwner().changeBalance(field.getValue());
                        break;
                    }
                }
            }
            if (i == 23) {
                i = 0;
                p.changeBalance(2);
            }
        }
    }
    public String printText(){
        return this.text;
    }
}
