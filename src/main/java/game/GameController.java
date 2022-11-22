package game;

import chancecards.*;
import fields.*;

import java.util.ArrayList;

public class GameController
{
    private Die die;
    private int currentDiceRoll = 0;
    private GameBoard gameBoard;
    private Deck deck;
    private ArrayList<Player> players;
    private Player getCurrentPlayer() { return this.players.get(indexOfCurrentPlayer); }
    private int indexOfCurrentPlayer;
    private GUI gui;

    public GameController()
    {
        this.die = new Die();
        this.gameBoard = new GameBoard();
        this.deck = new Deck();
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
        int currentPosition = getCurrentPlayer().getPosition();

        if (hasReachedStartField())
        {
            getCurrentPlayer().setPosition(currentPosition + this.currentDiceRoll - this.gameBoard.getFieldList().length);
        }
        else
        {
            getCurrentPlayer().setPosition(currentPosition + this.currentDiceRoll);
        }
    }

    private boolean hasReachedStartField()
    {
        return getCurrentPlayer().getPosition() + this.currentDiceRoll >= this.gameBoard.getFieldList().length;
    }

    private void evaluateFieldAndExecute()
    {
        Field field = this.gameBoard.getFieldList()[getCurrentPlayer().getPosition()];
        if (field instanceof PropertyField propertyField)
        {
            getCurrentPlayer().changeBalance(-propertyField.getValue());

            if (propertyField.hasOwner())
            {
                propertyField.getOwner().changeBalance(propertyField.getValue());
            }
            else
            {
                propertyField.setOwner(getCurrentPlayer());
            }
        }
        else if (field instanceof EventField eventField)
        {
            if (eventField.getFieldEvent() == FieldEvent.Chance)
            {
                // draw a card
            }
            else if (eventField.getFieldEvent() == FieldEvent.GoToJail)
            {
                getCurrentPlayer().setPosition(this.gameBoard.getIndexOfGoToJail());
            }
        }
    }
}