public class DiceCup {
    private Die die1;
    private Die die2;
    private int total;

    public DiceCup(){
        die1 = new Die();
        die2 = new Die();
        total = die1.getFaceValue()+die2.getFaceValue();
    }

    public int rollDice(){
        die1.roll();
        die2.roll();
        total = die1.getFaceValue()+die2.getFaceValue();
        return total;
    }

    public int getTotal(){
        return total;
    }
}