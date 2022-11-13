package Game;

import gui_fields.*;

import java.awt.*;

public class GUI {
    private gui_main.GUI gui;
    private GUI_Field[] fields;
    public GUI(){
        this.fields = new GUI_Field[24];
        SetFieldInformation();
        this.gui = new gui_main.GUI(fields, Color.WHITE);
    }

    public void emptyField(int fieldNumber){
        GUI_Start field = new GUI_Start();
        field.setTitle(Board.getFieldName(fieldNumber));
        field.setDescription(Board.getFieldDescription(fieldNumber));
        field.setSubText("");
        fields[fieldNumber - 1] = field;
    }
    public void ownableField(int fieldNumber, String owner){
        GUI_Street field = new GUI_Street();
        field.setTitle(Board.getFieldName(fieldNumber));
        field.setDescription(Board.getFieldDescription(fieldNumber));
        field.setSubText("Price: " + Board.getFieldPrice(fieldNumber));
        field.setRent(Integer.toString(Board.getRentPrice(fieldNumber)));
        field.setOwnerName(owner);
        field.setBackGroundColor(Color.DARK_GRAY);
        fields[fieldNumber - 1] = field;

    }
    public void chanceField(int fieldNumber){
        GUI_Chance field = new GUI_Chance();
        field.setDescription(Board.getFieldDescription(fieldNumber));
        fields[fieldNumber - 1] = field;
    }
    public void jailField(int fieldNumber){
        GUI_Jail field = new GUI_Jail();
        field.setSubText(Board.getFieldName(fieldNumber));
        field.setDescription(Board.getFieldDescription(fieldNumber));
        fields[fieldNumber - 1] = field;
    }
    public void SetFieldInformation() {

        emptyField(1);
       ownableField(2,"Test");
       ownableField(3,"Test");
       chanceField(4);
       ownableField(5, "Test");
       ownableField(6, "Test");
       jailField(7);
       ownableField(8, "Test");
       ownableField(9, "Test");
       chanceField(10);
       ownableField(11, "Test");
       ownableField(12, "Test");
       emptyField(13);
       ownableField(14, "Test");
       ownableField(15, "Test");
       chanceField(16);
       ownableField(17, "Test");
       ownableField(18, "Test");
       jailField(19);
       ownableField(20, "Test");
       ownableField(21, "Test");
       chanceField(22);
       ownableField(23, "Test");
       ownableField(24, "Test");



    }

}
