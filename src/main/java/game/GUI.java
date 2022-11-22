package game;

import fields.GameBoard;
import gui_fields.*;

import java.awt.*;
import java.util.ArrayList;

public class GUI {
    private gui_main.GUI gui;
    private GameBoard gameBoard;
    private ArrayList<Player> players;
    private GUI_Field[] fields;
    private ArrayList<GUI_Player> gui_players;
    private Color[] playerColors = {
            Color.yellow,
            Color.red,
            Color.black,
            Color.blue
    };
    private ArrayList<GUI_Car> cars;
    public GUI(GameBoard gameBoard, ArrayList<Player> players){
        this.gameBoard = gameBoard;
        this.players = players;
        this.fields = new GUI_Field[gameBoard.getFieldList().length];
        populateFields();
        this.gui = new gui_main.GUI(fields, Color.white);
        addPlayersToBoard(this.players.size());
        addCarsToBoard();
    }

    public void createStartField(int fieldIndex){
        GUI_Start field = new GUI_Start();
        field.setTitle(this.gameBoard.getFieldList()[fieldIndex].getName());
        field.setDescription(this.gameBoard.getFieldList()[fieldIndex].getName());
        field.setSubText("");
        fields[fieldIndex] = field;
    }
    public void createPropertyField(int fieldIndex, String owner, Color color){
        GUI_Street field = new GUI_Street();
        field.setTitle(Board.getFieldName(fieldIndex));
        field.setDescription(Board.getFieldDescription(fieldIndex));
        field.setSubText("Price: " + Board.getFieldPrice(fieldIndex));
        field.setRent(Integer.toString(Board.getRentPrice(fieldIndex)));
        field.setRentLabel("Rent price: ");
        field.setOwnerName(owner);
        field.setOwnableLabel("Owned by: ");
        field.setBackGroundColor(color);
        fields[fieldIndex] = field;

    }
    public void createChanceField(int fieldIndex){
        GUI_Chance field = new GUI_Chance();
        field.setDescription(Board.getFieldDescription(fieldIndex));
        field.setBackGroundColor(Color.green);
        fields[fieldIndex] = field;
    }
    public void createJailField(int fieldIndex){
        GUI_Jail field = new GUI_Jail();
        field.setSubText(Board.getFieldName(fieldIndex));
        field.setDescription(Board.getFieldDescription(fieldInex));
        fields[fieldIndex] = field;
    }
    public void createEmptyField(int fieldIndex)
    {
        GUI_Empty field = new GUI_Empty();
        field.setTitle(this.gameBoard.getFieldList()[fieldIndex].getName());
        field.setSubText(Board.getFieldName(fieldIndex));
        field.setDescription(Board.getFieldDescription(fieldIndex));
        fields[fieldIndex] = field;
    }
    public void populateFields() {

       createStartField(0);
       createPropertyField(1,"unowned", Color.darkGray);
       createPropertyField(2,"unowned", Color.darkGray);
       createChanceField(3);
       createPropertyField(4, "unowned", Color.cyan);
       createPropertyField(5, "unowned", Color.cyan);
       createStartField(6);
       createPropertyField(7, "unowned", Color.magenta);
       createPropertyField(8, "unowned", Color.magenta);
       createChanceField(9);
       createPropertyField(10, "unowned", Color.orange);
       createPropertyField(11, "unowned", Color.orange);
       createStartField(12);
       createPropertyField(13, "unowned", Color.red);
       createPropertyField(14, "unowned", Color.red);
       createChanceField(15);
       createPropertyField(16, "unowned", Color.yellow);
       createPropertyField(17, "unowned", Color.yellow);
       createJailField(18);
       createPropertyField(19, "unowned", Color.pink);
       createPropertyField(20, "unowned", Color.pink);
       createChanceField(21);
       createPropertyField(22, "unowned", Color.blue);
       createPropertyField(23, "unowned", Color.blue);
    }

    private void addCarsToBoard()
    {
        for (int i = 0; i < this.gui_players.size(); i++)
        {
            this.cars.add(new GUI_Car());
            this.cars.get(i).setPrimaryColor(this.playerColors[i]);
        }
    }

    private void addPlayersToBoard(int numberOfPlayers)
    {
        for (int i = 1; i <= numberOfPlayers; i++)
        {
            this.gui_players.add(new GUI_Player("Player " + i));
            gui.addPlayer(this.gui_players.get(i - 1));
            this.gui_players.get(i - 1).getCar().setPosition(fields[0]);
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
    public void displayPlayerBalance() {
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
