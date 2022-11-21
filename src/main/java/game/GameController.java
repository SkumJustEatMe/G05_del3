package game;

import java.util.ArrayList;

public class GameController
{
    private Die die;
    private int currentDiceRoll = 0;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private GUI gui;

    public GameController(Die die)
    {
        this.die = die;
        this.players = new ArrayList<Player>();
        this.addPlayers(4);
        this.gui = new GUI();
    }

    private void addPlayers(int numberOfPlayers)
    {
        for (int i = 1; i <= numberOfPlayers; i++)
        {
            this.players.add(new Player());
        }
    }

    public void run()
    {
        this.initiatlize();
        this.startGameLoop();
    }

    private void initiatlize()
    {
        // initialize beginning game state

    }

    private void startGameLoop()
    {
        while(true)
        {
            // player rolls dice
            // move player
            // evaluate field
            // execute field effect
            // update player properties
            //
        }
    }

    private void rollDice()
    {
        this.currentDiceRoll = this.die1.roll() + this.die2.roll();
    }
}