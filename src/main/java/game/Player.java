package game;

public class Player {
        private int balance;

        private int turnOrderId;

        public Player() // Vores construktor
        {
            balance = 1000;
        }

        public int getTurnOrderId() {
            return turnOrderId;
        }

        public void setTurnOrderId(int numberInTurnOrder) {
            this.turnOrderId = numberInTurnOrder;
        }

        public int getBalance(){
            return(balance);
        }

        public void changeBalance(int balanceChange){
            balance += balanceChange;

            if(balance<0){
                balance = 0;
            }
        }
}
