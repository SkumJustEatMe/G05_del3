package Game;

public class EffectField extends Field
{
    FieldEffect effect;

    public EffectField(String name, FieldEffect effect){
        super(name);
        this.effect = effect;
    }
}



