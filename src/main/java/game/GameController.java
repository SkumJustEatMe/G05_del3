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
        this.indexOfCurrentPlayer = 0;
        this.gui = new GUI();
    }

    private void addPlayersAndSetPosition(int numberOfPlayers)
    {
        for (int i = 1; i <= numberOfPlayers; i++)
        {
            this.players.add(new Player());
        }
        for (Player i : this.players) {
            i.setPosition(0);
        }
    }

    public void run()
    {
        this.initialize();
        this.startGameLoop();
    }

    private void initialize()
    {
        this.addPlayersAndSetPosition(this.getNumberOfPlayers());
    }

    private void startGameLoop()
    {
        while(!foundLoser())
        {
            getUserInputToBegin();
            rollDice();
            movePlayer();
            evaluateFieldAndExecute();
            setNextPlayer();
        }
        Player winner = getMostWealthy();
        // display winner and quit
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
            executePropertyField(propertyField);
        }
        else if (field instanceof EventField eventField)
        {
            executeEventField(eventField);
        }
    }

    private void executePropertyField(PropertyField propertyField)
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

    private void executeEventField(EventField eventField)
    {
        if (eventField.getFieldEvent() == FieldEvent.Chance)
        {
            this.deck.getCard().execute(getCurrentPlayer());
        }
        else if (eventField.getFieldEvent() == FieldEvent.GoToJail)
        {
            getCurrentPlayer().setPosition(this.gameBoard.getIndexOfGoToJail());
        }
    }

    private boolean foundLoser()
    {
        for (Player player : this.players)
        {
            if (player.getBalance() == 0) {
                return true;
            }
        }
        return false;
    }

    private Player getMostWealthy()
    {
        // in case of a draw, winner is decided by turn order
        Player mostWealthy = this.players.get(0);
        for (int i = 1; i < this.players.size(); i++)
        {
            if (this.players.get(i).getBalance() > mostWealthy.getBalance())
            {
                mostWealthy = this.players.get(i);
            }
        }
        return mostWealthy;
    }
    private int getNumberOfPlayers() {
        return Integer.parseInt(this.gui.displayPlayerSelectionButtons());
    }

    private void getUserInputToBegin() {
        if (this.gui.displayRollDiceButton().equals("Roll dice")) {
            return;
        }
    }
}