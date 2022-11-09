package Game;

public class Deck {
    private ChanceCard[] cards = new ChanceCard[20];

    public Deck(){
        this.cards[0] = new FreeFieldCard("Gratis Felt!\nRyk frem til et orange felt.\n"+
                "Hvis det er ledigt får du det GRATIS!\n"+
                "Ellers skal du BETALE leje til ejeren.", 16, 15, 1);
        this.cards[1] = new FreeFieldCard("Gratis Felt!\nRyk frem til et orange eller grønt felt.\n"+
                "Hvis det er ledigt, får du det Gratis!\n"+
                "Ellers skal du BETALE leje til ejeren.", 12, 2, 3);
        this.cards[2] = new FreeFieldCard("Gratis Felt!\nRyk frem til et lyseblåt felt.\n"+
                "Hvis det er ledigt, får du det Gratis!\n"+
                "Ellers skal du BETALE leje til ejeren.", 12, 2, 3);
        this.cards[3] = new FreeFieldCard("Gratis Felt!\nRyk frem til et pink eller mørkeblåt felt.\n"+
                "Hvis det er ledigt, får du det Gratis!\n"+
                "Ellers skal du BETALE leje til ejeren.", 12, 2, 3);
        this.cards[4] = new FreeFieldCard("Gratis Felt!\nRyk frem til et rødt felt.\n"+
                "Hvis det er ledigt, får du det Gratis!\n"+
                "Ellers skal du BETALE leje til ejeren.", 12, 2, 3);
        this.cards[5] = new FreeFieldCard("Gratis Felt!\nRyk frem til Skaterparken for at lave det perfekte grind!\n"+
                "Hvis ingen ejer den, får du den Gratis!\n"+
                "Ellers skal du BETALE leje til ejeren.", 12, 2, 3);
        this.cards[6] = new FreeFieldCard("Gratis Felt!\nRyk frem til et lyseblåt eller rødt felt.\n"+
                "Hvis det er ledigt, får du det Gratis!\n"+
                "Ellers skal du BETALE leje til ejeren.", 12, 2, 3);
        this.cards[7] = new FreeFieldCard("Gratis Felt!\nRyk frem til et brunt eller gult felt.\n"+
                "Hvis det er ledigt, får du det Gratis!\n"+
                "Ellers skal du BETALE leje til ejeren.", 12, 2, 3);
        this.cards[] = new GiveCardCard("Giv dette kort til BILEN, og tage et chancekort mere.\n"+
                "BIL: På din næste tur skal du drøne frem til hvilket som helst ledigt felt og købe det.\n"+
                "Hvis der ikke er nogen ledige felter, skal du købe et fra en anden spiller!", "BIL");
        this.cards[] = new GiveCardCard("Giv dette kort til SKIBET, og tage et chancekort mere.\n"+
                "BIL: På din næste tur skal du sejle frem til hvilket som helst ledigt felt og købe det.\n"+
                "Hvis der ikke er nogen ledige felter, skal du købe et fra en anden spiller!", "SKIB");
        this.cards[] = new GiveCardCard("Giv dette kort til HUNDEN, og tage et chancekort mere.\n"+
                "BIL: På din næste tur skal du hoppe hen på et hvilket som helst ledigt felt og købe det.\n"+
                "Hvis der ikke er nogen ledige felter, skal du købe et fra en anden spiller!", "HUND");
        this.cards[] = new GiveCardCard("Giv dette kort til KATTEN, og tage et chancekort mere.\n"+
                "BIL: På din næste tur skal du liste dig hen på et hvilket som helst ledigt felt og købe det.\n"+
                "Hvis der ikke er nogen ledige felter, skal du købe et fra en anden spiller!", "KAT");
        this.cards[] = new MoveCard("Ryk 1 felt frem, eller tag et chancekort mere.", 1 );
        this.cards[] = new MoveCard("Ryk op til 5 felter frem.", 1 );
        this.cards[] = new MoveToCard("Ryk frem til Standpromenaden", 23);
        this.cards[] = new MoveToCard("Ryk frem til START. Modtag M2",0);
        this.cards[] = new GetOutOfJailCard("Du løslades uden omkostninger. Behold dette kort, indtil du får brug for det.");
        this.cards[] = new RecieveOrPayCard("Du har spist for meget slik. BETAL M2 til banken.", -2);
        this.cards[] = new RecieveOrPayCard("Du har labet alle dine lektier! MODTAG M2 fra banken.", 2);
        this.cards[] = new BirthdayCard("Det er din fødselsdag! Alle giver dig M1.\n TILLYKKE MED FØDSELSDAGEN!", 1);
    }
}
