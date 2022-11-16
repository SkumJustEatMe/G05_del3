public class Player {
    private int balance;

    public Player(){
        balance = 0;
    }

    public int getBalance(){
        return balance;
    }

    public int changeBalance(int balanceChange){
        balance += balanceChange;
        return balance;
    }
}
