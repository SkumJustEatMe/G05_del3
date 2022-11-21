package game;

public class Player {
    private int balance;
    public int getBalance() { return(balance); }
    private int position;
    public int getPosition() { return this.position; }
    public void setPosition(int newPosition){ this.position = newPosition; }

    public void changeBalance(int balanceChange) {
        balance += balanceChange;

        if (balance < 0) {
            balance = 0;
        }
    }
}
