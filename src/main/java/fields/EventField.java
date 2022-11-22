package fields;

public class EventField extends Field
{
    private FieldEvent event;
    public FieldEvent getFieldEvent() { return this.event; }

    public EventField(String name, FieldEvent event){
        super(name);
        this.event = event;
    }
}



