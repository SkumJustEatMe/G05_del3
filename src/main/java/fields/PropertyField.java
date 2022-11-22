package fields;

import game.Player;

import java.awt.*;

public class PropertyField extends Field {

    private final int value;
    public int getValue() { return this.value;}

    private final Color color;
    public Color getColor() { return this.color;}

    private Player owner;
    public Player getOwner() { return this.owner;}
    public void setOwner(Player owner) {this.owner = owner;}

    public PropertyField(String name, int value, Color color)
    {
        super(name);
        this.value = value;
        this.color = color;
    }

    public boolean hasOwner() { return this.owner != null; }
}
