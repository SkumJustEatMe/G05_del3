package Game;

import java.awt.*;

public class GameBoard {

    private Field[] FieldList = {
            new Field("Start"),
            new PropertyField("Burgerbaren", 1, Color.),
            new PropertyField("Pizzahuset", 1, "brun"),
            new EffectField("Chance", FieldEffect.Chance),
            new PropertyField("Godtebutikken", 1, "lyseblå"),
            new PropertyField("Iskiosken", 1, "lyseblå"),
            new Field("Fængsel")
            new PropertyField("Museet", 2, "pink"),
            new PropertyField("Biblioteket", 2, "pink"),
            new EffectField("Chance", FieldEffect.Chance),
            new PropertyField("Skaterparken", 2, "orange"),
            new PropertyField("Swimmingpoolen", 2, "orange"),
            new Field("Gratis parkering"),
            new PropertyField("Spillehallen", 3, "rød"),
            new PropertyField("Biografen", 3, "rød"),
            new EffectField("Chance", FieldEffect.Chance),
            new PropertyField("Legetøjsbutikken", 3, "gul"),
            new PropertyField("Dyrehandlen", 3, "gul"),
            new EffectField("Gå i fængsel", FieldEffect.GoToJail),
            new PropertyField("Bowlinghallen", 4, "grøn"),
            new PropertyField("Zoo", 4, "grøn"),


    };


    public GameBoard()
    {
    }