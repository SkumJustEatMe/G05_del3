package game;

import fields.*;
import fields.GameBoard;
import gui_fields.*;

import java.awt.*;
import java.util.ArrayList;

public class GUI {
    private gui_main.GUI gui;
    private GameController gameController;
    private GameBoard gameBoard;
    private GUI_Field[] fields;
    private ArrayList<GUI_Player> gui_players;
    private Color[] playerColors = {
            Color.yellow,
            Color.red,
            Color.black,
            Color.blue
    };
    private ArrayList<GUI_Car> cars;
    public GUI(GameBoard gameBoard, GameController gameController){
        this.gameBoard = gameBoard;
        this.gameController = gameController;
        this.gui_players = new ArrayList<GUI_Player>();
        this.cars = new ArrayList<GUI_Car>();
        this.fields = new GUI_Field[gameBoard.getFieldList().length];
        populateFields();
        this.gui = new gui_main.GUI(fields, Color.white);
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
        gui_field.setTitle(field.getName());
        gui_field.setDescription(field.getName());
        gui_field.setSubText("");
        fields[fieldIndex] = gui_field;
    }
    public void createEmptyField(int fieldIndex)
    {
        GUI_Street gui_field = new GUI_Street();
        Field field = this.gameBoard.getFieldList()[fieldIndex];
        gui_field.setTitle(field.getName());
        gui_field.setDescription(field.getName());
        gui_field.setSubText("");
        fields[fieldIndex] = gui_field;
    }
    public void populateFields() {
        // should be generated automatically based on gameBoard
        createStartField(0);
        createPropertyField(1,"unowned", Color.magenta);
        createPropertyField(2,"unowned", Color.magenta);
        createChanceField(3);
        createPropertyField(4, "unowned", Color.cyan);
        createPropertyField(5, "unowned", Color.cyan);
        createEmptyField(6);
        createPropertyField(7, "unowned", Color.pink);
        createPropertyField(8, "unowned", Color.pink);
        createChanceField(9);
        createPropertyField(10, "unowned", Color.orange);
        createPropertyField(11, "unowned", Color.orange);
        createEmptyField(12);
        createPropertyField(13, "unowned", Color.red);
        createPropertyField(14, "unowned", Color.red);
        createChanceField(15);
        createPropertyField(16, "unowned", Color.yellow);
        createPropertyField(17, "unowned", Color.yellow);
        createJailField(18);
        createPropertyField(19, "unowned", Color.green);
        createPropertyField(20, "unowned", Color.green);
        createChanceField(21);
        createPropertyField(22, "unowned", Color.blue);
        createPropertyField(23, "unowned", Color.blue);
    }

    public void addCarsToBoard()
    {
        for (int i = 0; i < this.gui_players.size(); i++)
        {
            this.cars.add(new GUI_Car());
            this.cars.get(i).setPrimaryColor(this.playerColors[i]);
        }
    }

    public void addPlayersToBoard(int numberOfPlayers)
    {
        for (int i = 0; i < numberOfPlayers; i++)
        {
            this.gui_players.add(new GUI_Player( this.gameController.getPlayers().get(i).getName()));
            gui.addPlayer(this.gui_players.get(i));
            this.gui_players.get(i).getCar().setPosition(fields[0]);
            this.gui_players.get(i).setBalance(this.gameController.getPlayers().get(i).getBalance());
        }
    }

    public void displayDieRoll(int dieRoll) {
        gui.setDie(dieRoll);
    }

    public void moveCarToField(int indexOfCurrentPlayer){
            this.gui_players.get(indexOfCurrentPlayer).getCar().setPosition(fields[this.gameController.getPlayers().get(indexOfCurrentPlayer).getPosition()]);
    }

    public void displayPlayerBalance() {
        for (int i = 0; i < this.gameController.getPlayers().size(); i++)
        {
            this.gui_players.get(i).setBalance(this.gameController.getPlayers().get(i).getBalance());
        }
    }
    public String displayRollDiceButton(String playerName){
        return this.gui.getUserButtonPressed(playerName, "Roll dice");
    }

    public String displayPlayerSelectionButtons()
    {
        return this.gui.getUserButtonPressed("Select number of players:", "2 Players", "3 Players", "4 Players");
    }

    public void displayWinnerAndExit(Player player)
    {
        this.gui.getUserButtonPressed(String.format("Congratulations %1$s, you've won!", player.getName()), "Exit");
        System.exit(0);
    }
    public void refreshOwnership()
    {
        for (int i = 0; i < this.gameBoard.getFieldList().length; i++)
        {
            if (this.gui.getFields()[i] instanceof GUI_Street gui_field && this.gameBoard.getFieldList()[i] instanceof PropertyField field)
            {
                if (field.hasOwner())
                {
                    gui_field.setOwnerName(field.getOwner().getName());
                }
                else {
                    gui_field.setOwnerName("unowned");
                }
            }
        }
    }
}
