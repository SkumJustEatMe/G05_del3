package chancecards;

import chancecards.*;

import java.awt.*;
public class Deck {
    private ChanceCard[] cards = new ChanceCard[20];

    public ChanceCard getCard() {
        return this.cards[(int) (Math.random() * 16)];
    }

    public Deck() {
        this.cards[0] = new FreeFieldCard("Gratis Felt!\nRyk frem til et orange felt.\n" +
                "Hvis det er ledigt får du det GRATIS!\n" +
                "Ellers skal du BETALE leje til ejeren.", Color.orange, Color.orange);
        this.cards[1] = new FreeFieldCard("Gratis Felt!\nRyk frem til et orange eller grønt felt.\n" +
                "Hvis det er ledigt, får du det Gratis!\n" +
                "Ellers skal du BETALE leje til ejeren.", Color.orange, Color.green);
        this.cards[2] = new FreeFieldCard("Gratis Felt!\nRyk frem til et lyseblåt felt.\n" +
                "Hvis det er ledigt, får du det Gratis!\n" +
                "Ellers skal du BETALE leje til ejeren.", Color.cyan, Color.cyan);
        this.cards[3] = new FreeFieldCard("Gratis Felt!\nRyk frem til et pink eller mørkeblåt felt.\n" +
                "Hvis det er ledigt, får du det Gratis!\n" +
                "Ellers skal du BETALE leje til ejeren.", Color.pink, Color.blue);
        this.cards[4] = new FreeFieldCard("Gratis Felt!\nRyk frem til et rødt felt.\n" +
                "Hvis det er ledigt, får du det Gratis!\n" +
                "Ellers skal du BETALE leje til ejeren.", Color.red, Color.red);
        this.cards[5] = new FreeFieldCard("Gratis Felt!\nRyk frem til Skaterparken for at lave det perfekte grind!\n" +
                "Hvis ingen ejer den, får du den Gratis!\n" +
                "Ellers skal du BETALE leje til ejeren.", Color.orange, Color.orange);
        this.cards[6] = new FreeFieldCard("Gratis Felt!\nRyk frem til et lyseblåt eller rødt felt.\n" +
                "Hvis det er ledigt, får du det Gratis!\n" +
                "Ellers skal du BETALE leje til ejeren.", Color.cyan, Color.red);
        this.cards[7] = new FreeFieldCard("Gratis Felt!\nRyk frem til et lilla eller gult felt.\n" +
                "Hvis det er ledigt, får du det Gratis!\n" +
                "Ellers skal du BETALE leje til ejeren.", Color.magenta, Color.yellow);
        this.cards[8] = new MoveCard("Ryk 1 felt frem, eller tag et chancekort mere.", 1);
        this.cards[9] = new MoveCard("Ryk op til 5 felter frem.", 1);
        this.cards[10] = new MoveToCard("Ryk frem til Standpromenaden", 23);
        this.cards[11] = new MoveToCard("Ryk frem til START. Modtag M2", 0);
        this.cards[12] = new GetOutOfJailCard("Du løslades uden omkostninger. Behold dette kort, indtil du får brug for det.");
        this.cards[13] = new RecieveOrPayCard("Du har spist for meget slik. BETAL M2 til banken.", -2);
        this.cards[14] = new RecieveOrPayCard("Du har labet alle dine lektier! MODTAG M2 fra banken.", 2);
        this.cards[15] = new BirthdayCard("Det er din fødselsdag! Alle giver dig M1.\n TILLYKKE MED FØDSELSDAGEN!");

    }
}
