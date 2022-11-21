package game;

import fields.GameBoard;

import java.util.ArrayList;

public class GameController
{
    private Die die;
    private int currentDiceRoll = 0;
    private GameBoard gameBoard = new GameBoard();
    private ArrayList<Player> players;
    private int indexOfCurrentPlayer;
    private GUI gui;

    public GameController()
    {
        this.die = new Die();
        this.gameBoard = new GameBoard();
        this.players = new ArrayList<Player>();
        this.addPlayers(4);
        this.currentPlayer = this.players.get(0);
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
        // initialize gui if needed
    }

    private void startGameLoop()
    {
        while(true)
        {
            rollDice();
            // move player
            evaluateField();
            // execute field effect
            // update player properties
            setNextPlayer();
        }
    }


    private void rollDice()
    {
        this.currentDiceRoll = this.die.roll() + this.die.roll();
    }


    private void setNextPlayer()
    {
        if (this.indexOfCurrentPlayer + 1 < this.players.size()) {
            this.indexOfCurrentPlayer++;
        }
        else {
            this.indexOfCurrentPlayer = 0;
        }
    }

    private void evaluateField()
    {

    }
}