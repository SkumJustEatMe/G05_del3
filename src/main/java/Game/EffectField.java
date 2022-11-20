package Game;

public class EffectField extends Field
{
    FieldEffect effect;

    public EffectField(String name, String description, FieldEffect effect){
        super(name, description);
        this.effect = effect;
    }
}



