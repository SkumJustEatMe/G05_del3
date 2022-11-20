package Game;

public class Field
{
    private final String name;
    public String getName() { return this.name; }
    private final String description;
    public String getDescription() { return this.description; }

    public Field(String name, String description)
    {
        this.name = name;
        this.description = description;
    }
}
