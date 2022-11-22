package game;

import fields.*;

import java.util.ArrayList;

public class GameController
{
    private Die die;
    private int currentDiceRoll = 0;
    private GameBoard gameBoard;
    private ArrayList<Player> players;
    private int indexOfCurrentPlayer;
    private GUI gui;

    public GameController()
    {
        this.die = new Die();
        this.gameBoard = new GameBoard();
        this.players = new ArrayList<Player>();
        this.addPlayers(4);
        for (Player i : this.players) {
            i.setPosition(0);
        }
        this.indexOfCurrentPlayer = 0;
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
            movePlayer();
            evaluateFieldAndExecute();
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
    private void movePlayer()
    {
        int currentPosition = this.players.get(this.indexOfCurrentPlayer).getPosition();

        if (hasReachedStartField())
        {
            this.players.get(this.indexOfCurrentPlayer).setPosition(currentPosition + this.currentDiceRoll - this.gameBoard.getFieldList().length);
        }
        else
        {
            this.players.get(this.indexOfCurrentPlayer).setPosition(currentPosition + this.currentDiceRoll);
        }
    }

    private boolean hasReachedStartField()
    {
        return this.players.get(this.indexOfCurrentPlayer).getPosition() + this.currentDiceRoll >= this.gameBoard.getFieldList().length;
    }

    private void evaluateFieldAndExecute()
    {
        String fieldType = this.gameBoard.getFieldList()[this.players.get(indexOfCurrentPlayer).getPosition()].getClass().getTypeName();
        if (fieldType.equals("PropertyField"))
        {
            if ((PropertyField) this.gameBoard.getFieldList()[this.players.get(indexOfCurrentPlayer).getPosition()].)
        }
        else if (fieldType.equals("EventField"))
        {

        }
    }
}