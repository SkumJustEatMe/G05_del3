package game;

public class main {
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.addPlayerToBoard(4);
        gui.displayDieRoll(1,2);
        gui.displayButton(true);
    }
}
