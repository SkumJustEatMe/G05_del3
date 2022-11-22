package game;

import fields.GameBoard;
import gui_fields.*;

import java.awt.*;
import java.util.ArrayList;

public class GUI {
    private gui_main.GUI gui;
    private GUI_Field[] fields;
    private ArrayList<GUI_Player> players;
    private Color[] playerColors = {
            Color.yellow,
            Color.red,
            Color.black,
            Color.blue
    };
    private ArrayList<GUI_Car> cars;
    public GUI(int numberOfplayers, GameBoard gameBoard){
        this.fields = new GUI_Field[gameBoard.];
        setBoardFields();
        this.gui = new gui_main.GUI(fields, Color.white);
        addPlayersToBoard(numberOfplayers);
        addCarsToBoard();
    }

    public void emptyField(int fieldNumber){
        GUI_Start field = new GUI_Start();
        field.setTitle(Board.getFieldName(fieldNumber));
        field.setDescription(Board.getFieldDescription(fieldNumber));
        field.setSubText("");
        fields[fieldNumber - 1] = field;
    }
    public void ownableField(int fieldNumber, String owner, Color color){
        GUI_Street field = new GUI_Street();
        field.setTitle(Board.getFieldName(fieldNumber));
        field.setDescription(Board.getFieldDescription(fieldNumber));
        field.setSubText("Price: " + Board.getFieldPrice(fieldNumber));
        field.setRent(Integer.toString(Board.getRentPrice(fieldNumber)));
        field.setRentLabel("Rent price: ");
        field.setOwnerName(owner);
        field.setOwnableLabel("Owned by: ");
        field.setBackGroundColor(color);
        fields[fieldNumber - 1] = field;

    }
    public void chanceField(int fieldNumber){
        GUI_Chance field = new GUI_Chance();
        field.setDescription(Board.getFieldDescription(fieldNumber));
        field.setBackGroundColor(Color.green);
        fields[fieldNumber - 1] = field;
    }
    public void jailField(int fieldNumber){
        GUI_Jail field = new GUI_Jail();
        field.setSubText(Board.getFieldName(fieldNumber));
        field.setDescription(Board.getFieldDescription(fieldNumber));
        fields[fieldNumber - 1] = field;
    }
    public void setBoardFields() {

       emptyField(1);
       ownableField(2,"Test", Color.darkGray);
       ownableField(3,"Test", Color.darkGray);
       chanceField(4);
       ownableField(5, "Test", Color.cyan);
       ownableField(6, "Test", Color.cyan);
       jailField(7);
       ownableField(8, "Test", Color.magenta);
       ownableField(9, "Test", Color.magenta);
       chanceField(10);
       ownableField(11, "Test", Color.orange);
       ownableField(12, "Test", Color.orange);
       emptyField(13);
       ownableField(14, "Test", Color.red);
       ownableField(15, "Test", Color.red);
       chanceField(16);
       ownableField(17, "Test", Color.yellow);
       ownableField(18, "Test", Color.yellow);
       jailField(19);
       ownableField(20, "Test", Color.pink);
       ownableField(21, "Test", Color.pink);
       chanceField(22);
       ownableField(23, "Test", Color.blue);
       ownableField(24, "Test", Color.blue);



    }

    private void addCarsToBoard()
    {
        for (int i = 0; i < this.players.size(); i++)
        {
            this.cars.add(new GUI_Car());
            this.cars.get(i).setPrimaryColor(this.playerColors[i]);
        }
    }

    private void addPlayersToBoard(int numberOfPlayers)
    {
        for (int i = 1; i <= numberOfPlayers; i++)
        {
            this.players.add(new GUI_Player("Player " + i));
            gui.addPlayer(this.players.get(i - 1));
            this.players.get(i - 1).getCar().setPosition(fields[0]);
        }
    }

    public void displayDieRoll(int DieRoll1, int DieRoll2) {
        gui.setDice(DieRoll1, DieRoll2);
    }
    /* public void moveCarToField(Player currentPlayer){
        if(currentPlayer.getTurnOrderId() == 1) {
            player1.getCar().setPosition(fields[currentPlayer.getField]);
            }
        if(currentPlayer.getTurnOrderId() == 2) {
            player2.getCar().setPosition(fields[currentPlayer.getField]);
        }
        if(currentPlayer.getTurnOrderId() == 3) {
            player3.getCar().setPosition(fields[currentPlayer.getField]);
        }
        if(currentPlayer.getTurnOrderId() == 4) {
            player4.getCar().setPosition(fields[currentPlayer.getField]);
        }
    }
     */
    public void displayPlayerBalance(int balance1, int balance2, int balance3, int balance4) {
        this.player1.setBalance(balance1);
        this.player2.setBalance(balance2);
        this.player3.setBalance(balance3);
        this.player4.setBalance(balance4);
    }
    public String displayRollDiceButton(){
        return this.gui.getUserButtonPressed("", "Roll dice");
    }

    public String displayPlayerSelectionButtons()
    {
        return gui.getUserButtonPressed("Select number of players:", "1 Player", "2 Players", "3 Players", "4 Players");
    }
}
