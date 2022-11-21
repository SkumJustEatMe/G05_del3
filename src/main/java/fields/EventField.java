package fields;

public class EventField extends Field
{
    FieldEvent effect;

    public EventField(String name, FieldEvent effect){
        super(name);
        this.effect = effect;
    }
}



