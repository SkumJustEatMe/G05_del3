package game;

import fields.*;
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
        GUI_Start gui_field = new GUI_Start();
        Field field = this.gameBoard.getFieldList()[fieldIndex];
        gui_field.setTitle(field.getName());
        gui_field.setDescription(field.getName());
        gui_field.setSubText("");
        this.fields[fieldIndex] = gui_field;
    }
    public void createPropertyField(int fieldIndex, String owner, Color color){
        GUI_Street gui_field = new GUI_Street();
        PropertyField field = (PropertyField) this.gameBoard.getFieldList()[fieldIndex];
        gui_field.setTitle(field.getName());
        gui_field.setDescription(field.getName());
        gui_field.setSubText("Price: " + field.getValue());
        gui_field.setRent(Integer.toString(field.getValue()));
        gui_field.setRentLabel("Rent price: ");
        gui_field.setOwnerName(field.getOwner() == null ? "unowned" : field.getOwner().getName());
        gui_field.setBackGroundColor(color);
        this.fields[fieldIndex] = gui_field;

    }
    public void createChanceField(int fieldIndex){
        GUI_Chance gui_field = new GUI_Chance();
        EventField field = (EventField) this.gameBoard.getFieldList()[fieldIndex];
        gui_field.setDescription(field.getName());
        gui_field.setBackGroundColor(Color.green);
        this.fields[fieldIndex] = gui_field;
    }
    public void createJailField(int fieldIndex){
        GUI_Jail gui_field = new GUI_Jail();
        EventField field = (EventField) this.gameBoard.getFieldList()[fieldIndex];
        gui_field.setDescription(field.getName());
        gui_field.setSubText("");
        fields[fieldIndex] = gui_field;
    }
    public void createEmptyField(int fieldIndex)
    {
        GUI_Empty gui_field = new GUI_Empty();
        Field field = this.gameBoard.getFieldList()[fieldIndex];
        gui_field.setTitle(field.getName());
        gui_field.setSubText("");
        gui_field.setDescription(field.getName());
        fields[fieldIndex] = gui_field;
    }
    public void populateFields() {
        // should be generated automatically based on gameBoard
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

    public void moveCarToField(int indexOfCurrentPlayer){
            this.gui_players.get(indexOfCurrentPlayer).getCar().setPosition(fields[this.players.get(indexOfCurrentPlayer).getPosition()]);
    }

    public void displayPlayerBalance() {
        for (int i = 0; i < this.players.size(); i++)
        {
            this.gui_players.get(i).setBalance(this.players.get(i).getBalance());
        }
    }
    public String displayRollDiceButton(){
        return this.gui.getUserButtonPressed("", "Roll dice");
    }

    public String displayPlayerSelectionButtons()
    {
        return gui.getUserButtonPressed("Select number of players:", "1 Player", "2 Players", "3 Players", "4 Players");
    }
}
