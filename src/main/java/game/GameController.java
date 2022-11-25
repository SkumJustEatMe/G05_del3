package game;

import chancecards.Deck;
import fields.*;

import java.util.ArrayList;

public class GameController
{
    private Die die;
    private int currentDieRoll = 0;
    private GameBoard gameBoard;
    private Deck deck;
    private ArrayList<Player> players;
    public ArrayList<Player> getPlayers() { return this.players; }
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
        this.gui = new GUI(this.gameBoard, this);
    }

    private void addPlayersAndSetPosition(int numberOfPlayers)
    {
        for (int i = 1; i <= numberOfPlayers; i++)
        {
            this.players.add(new Player(i, 20));
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
        this.gui.addPlayersToBoard(this.players.size());
        this.gui.addCarsToBoard();
    }

    private void startGameLoop()
    {
        while(!foundLoser())
        {
            getUserInputToBegin();
            rollDice();
            this.gui.displayDieRoll(this.currentDieRoll);
            movePlayer();
            this.gui.moveCarToField(indexOfCurrentPlayer);
            evaluateFieldAndExecute();
            this.gui.refreshOwnership();
            this.gui.displayPlayerBalance();
            setNextPlayer();
        }
        Player winner = getMostWealthy();
        this.gui.displayWinnerAndExit(winner);
    }


    private void rollDice()
    {
        this.currentDieRoll = this.die.roll();
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
            getCurrentPlayer().setPosition(currentPosition + this.currentDieRoll - this.gameBoard.getFieldList().length);
            getCurrentPlayer().changeBalance(2);
        }
        else
        {
            getCurrentPlayer().setPosition(currentPosition + this.currentDieRoll);
        }
    }

    private boolean hasReachedStartField()
    {
        return getCurrentPlayer().getPosition() + this.currentDieRoll >= this.gameBoard.getFieldList().length;
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
            if (getCurrentPlayer().getGetOutOfJailCards() > 0)
            {
                getCurrentPlayer().addGetOutOfJailCards(-1);
            }
            else {
                getCurrentPlayer().changeBalance(-2);
            }
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
        String result = (this.gui.displayPlayerSelectionButtons());
        return Integer.parseInt(String.valueOf(result.charAt(0)));
    }

    private void getUserInputToBegin() {
        if (this.gui.displayRollDiceButton(getCurrentPlayer().getName()).equals("Roll dice")) {
            return;
        }
    }

}