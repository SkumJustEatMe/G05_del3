package game;

public class Player {
    private int balance;

    private String name;
    private int getOutOfJailCards = 0;
    public int getGetOutOfJailCards() { return this.getOutOfJailCards; }
    public void addGetOutOfJailCards(int value) { this.getOutOfJailCards += value; }

    public String getName() { return this.name; }
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

    public Player(int playerNumber, int startingBalance){
        this.name = "Player " + playerNumber;
        this.balance = startingBalance;
    }

}
