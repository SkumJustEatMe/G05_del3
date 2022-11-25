package chancecards;

import game.Player;

import java.util.ArrayList;

public class BirthdayCard extends ChanceCard {
    private String text;

    public BirthdayCard(String text){
        this.text = text;
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
