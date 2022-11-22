package game;

public class Player {
    private int balance;
    public int getBalance() { return this.balance; }

    /**
     * Adds amount to player balance
     * @param balanceChange
     * Amount to be added
     */
    public void changeBalance(int balanceChange) {
        balance += balanceChange;

        if (balance < 0) {
            balance = 0;
        }
    }
    private int position;
    public int getPosition() { return this.position; }
    public void setPosition(int newPosition){ this.position = newPosition; }

}
