import fields.PropertyField;
import game.GameController;
import game.Player;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    @Test
    void executePropertyField_changeBalanceForBothPlayers() {
        GameController gameController = new GameController();
        PropertyField propertyField = new PropertyField("Tårnet", 2, Color.blue);
        Player player1 = new Player(1, 20);
        Player player2 = new Player(2, 20);
        propertyField.setOwner(player1);
        gameController.executePropertyField(propertyField, player2);
        assertEquals(18, player2.getBalance());
        assertEquals(22, player1.getBalance());
    }

    @Test
    void executePropertyField_buyPropertyIfNoOwner() {
        GameController gameController = new GameController();
        PropertyField propertyField = new PropertyField("Tårnet", 2, Color.blue);
        Player player1 = new Player(1, 20);
        gameController.executePropertyField(propertyField, player1);
        assertTrue(propertyField.getOwner().getName().equals("Player 1"));
    }

    @Test
    void startGameLoop_GameStopsIfLoserIsFound(){
        GameController gameController = new GameController();
        Player player1 = new Player(1, -1);
        Player player2 = new Player(2, 20);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        assertTrue(gameController.foundLoser(players));
    }
}