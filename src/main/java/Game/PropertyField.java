package Game;

public class PropertyField extends Field {

    private final int price;
    public int getPrice() {return this.price;}

    private final int rent;
    public int getRent() {return this.rent;}

    private final String color;
    public String getColor() {return this.color;}

    private Player owner;
    public Player getOwner() {return this.owner;}
    public void setOwner(Player owner) {this.owner = owner;}

    PropertyField(String name, String description, int price, int rent, String color)
    {
        super(name, description);
        this.price = price;
        this.rent = rent;
        this.color = color;
    }

    public boolean isOwned() {return this.owner != null; }
}
