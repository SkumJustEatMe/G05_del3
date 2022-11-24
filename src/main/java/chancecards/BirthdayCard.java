package chancecards;

import game.Player;

import java.util.ArrayList;

public class BirthdayCard extends ChanceCard {
    private String text;
    private int amount;

    public BirthdayCard(String text, int amount){
        this.text = text;
        this.amount = amount;
    }
    public void execute(ArrayList<Player> players, int playerIndex) {
        for (int i = 0; i < players.size(); i++) {
            if (i == playerIndex) {
                continue;
            }
            players.get(i).changeBalance(-1);
            players.get(playerIndex).changeBalance(1);
        }
    }
    public String printText(){
        return this.text;
    }
}
