package Game;

import gui_fields.*;

import java.awt.*;

public class GUI {
    private gui_main.GUI gui;
    private GUI_Field[] fields;
    private GUI_Player player1;
    private GUI_Player player2;
    private GUI_Player player3;
    private GUI_Player player4;
    private GUI_Car car1;
    private GUI_Car car2;
    private GUI_Car car3;
    private GUI_Car car4;
    public GUI(){
        this.fields = new GUI_Field[24];
        setBoardFields();
        this.gui = new gui_main.GUI(fields, Color.white);
        this.car1 = new GUI_Car();
        this.car1.setPrimaryColor(Color.YELLOW);
        this.car2 = new GUI_Car();
        this.car2.setPrimaryColor(Color.RED);
        this.car3 = new GUI_Car();
        this.car3.setPrimaryColor(Color.black);
        this.car4 = new GUI_Car();
        this.car4.setPrimaryColor(Color.blue);
        this.player1 = new GUI_Player("Player 1",1000, this.car1);
        this.player2 = new GUI_Player("Player 2",1000, this.car2);
        this.player3 = new GUI_Player("Player 3",1000, this.car3);
        this.player4 = new GUI_Player("Player 4",1000, this.car4);
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
    public void addPlayerToBoard(int antal) {
        switch (antal){
            case 1:
                gui.addPlayer(this.player1);
                player1.getCar().setPosition(fields[0]);
                break;
            case 2:
                gui.addPlayer(this.player1);
                gui.addPlayer(this.player2);
                player1.getCar().setPosition(fields[0]);
                player2.getCar().setPosition(fields[0]);
                break;
            case 3:
                gui.addPlayer(this.player1);
                gui.addPlayer(this.player2);
                gui.addPlayer(this.player3);
                player1.getCar().setPosition(fields[0]);
                player2.getCar().setPosition(fields[0]);
                player3.getCar().setPosition(fields[0]);
                break;
            case 4:
                gui.addPlayer(this.player1);
                gui.addPlayer(this.player2);
                gui.addPlayer(this.player3);
                gui.addPlayer(this.player4);
                player1.getCar().setPosition(fields[0]);
                player2.getCar().setPosition(fields[0]);
                player3.getCar().setPosition(fields[0]);
                player4.getCar().setPosition(fields[0]);
                break;
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
    public void displayButton(boolean owned){
        if (owned == false){
            String buyButton = gui.getUserButtonPressed("", "Roll Dice", "Buy land");
        }
        else {
            String buyButton = gui.getUserButtonPressed("", "Roll Dice");
        }
    }

}
