package fields;

import java.awt.*;

public class GameBoard {

    private Field[] FieldList = {
            new Field("Start"),
            new PropertyField("Burgerbaren", 1, Color.gray),
            new PropertyField("Pizzahuset", 1, Color.gray),
            new EventField("Chance", FieldEvent.Chance),
            new PropertyField("Godtebutikken", 1, Color.cyan),
            new PropertyField("Iskiosken", 1, Color.cyan),
            new Field("Fængsel"),
            new PropertyField("Museet", 2, Color.pink),
            new PropertyField("Biblioteket", 2, Color.pink),
            new EventField("Chance", FieldEvent.Chance),
            new PropertyField("Skaterparken", 2, Color.orange),
            new PropertyField("Swimmingpoolen", 2, Color.orange),
            new Field("Gratis parkering"),
            new PropertyField("Spillehallen", 3, Color.red),
            new PropertyField("Biografen", 3, Color.red),
            new EventField("Chance", FieldEvent.Chance),
            new PropertyField("Legetøjsbutikken", 3, Color.yellow),
            new PropertyField("Dyrehandlen", 3, Color.yellow),
            new EventField("Gå i fængsel", FieldEvent.GoToJail),
            new PropertyField("Bowlinghallen", 4, Color.green),
            new PropertyField("Zoo", 4, Color.green),
            new EventField("Chance", FieldEvent.Chance),
            new PropertyField("Vandlandet", 5, Color.blue),
            new PropertyField("Strandpromenaden", 5, Color.blue)
    };

    public int getIndexOfGoToJail() {
        int index = 0;
        for (Field field : FieldList)
        {
            if (field instanceof EventField eventField && eventField.getFieldEvent() == FieldEvent.GoToJail) {
                break;
            }
            index++;
        }
        return index;
    }
    public Field[] getFieldList() { return this.FieldList; }

    public GameBoard()
    {
    }
}