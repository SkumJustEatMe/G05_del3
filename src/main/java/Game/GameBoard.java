package Game;

public class GameBoard {

    private Field[24];
    public static String getFieldName(int roll){
        String name = null;
        switch (roll) {

            case 1:
                name = "Start";
                break;
            case 2:
                name = "Corner Kitchen Burgerbar ";
                break;
            case 3:
                name = "Pizza House";
                break;
            case 4:
                name = "Chance card";
                break;
            case 5:
                name = "Candy store";
                break;
            case 6:
                name = "Icecream store";
                break;
            case 7:
                name = "Prison visit";
                break;
            case 8:
                name = "Museum";
                break;
            case 9:
                name = "Liberay";
                break;
            case 10:
                name = "Chance card";
                break;
            case 11:
                name = "Skating park";
                break;
            case 12:
                name = "Swimming pool";
                break;
            case 13:
                name = "Park";
                break;
            case 14:
                name = "Playing hall";
                break;
            case 15:
                name = "Cinema";
                break;
            case 16:
                name = "Chance card";
                break;
            case 17:
                name = "Toy store";
                break;
            case 18:
                name = "Pet store";
                break;
            case 19:
                name = "Go to jail";
                break;
            case 20:
                name = "Bowling allay";
                break;
            case 21:
                name = "Zoo";
                break;
            case 22:
                name = "Chance card";
                break;
            case 23:
                name = "Waterpark";
                break;
            case 24:
                name = "The beach promenade";
                break;
        }
        return name;



    }
    public static String getFieldDescription(int roll) {
        String descriptoion = null;
        switch (roll) {

            case 1:
                descriptoion = "Starting field";
                break;
            case 2:
                descriptoion = "Corner Kitchen Burgerbar ";
                break;
            case 3:
                descriptoion = "Pizza House";
                break;
            case 4:
                descriptoion = "Chance card";
                break;
            case 5:
                descriptoion = "Candy store";
                break;
            case 6:
                descriptoion = "Icecream store";
                break;
            case 7:
                descriptoion = "Prison visit";
                break;
            case 8:
                descriptoion = "Museum";
                break;
            case 9:
                descriptoion = "Liberay";
                break;
            case 10:
                descriptoion = "Chance card";
                break;
            case 11:
                descriptoion = "Skating park";
                break;
            case 12:
                descriptoion = "Swimming pool";
                break;
            case 13:
                descriptoion = "Free parking spot";
                break;
            case 14:
                descriptoion = "Playing hall";
                break;
            case 15:
                descriptoion = "Cinema";
                break;
            case 16:
                descriptoion = "Chance card";
                break;
            case 17:
                descriptoion = "Toy store";
                break;
            case 18:
                descriptoion = "Pet store";
                break;
            case 19:
                descriptoion = "Go to jail";
                break;
            case 20:
                descriptoion = "Bowling allay";
                break;
            case 21:
                descriptoion = "Zoo";
                break;
            case 22:
                descriptoion = "Chance card";
                break;
            case 23:
                descriptoion = "Waterpark";
                break;
            case 24:
                descriptoion = "The beach promenade";
                break;

        }
        return descriptoion;


    }

    public static int getRentPrice(int roll) {
        int rent = 0;
        switch (roll) {

            case 1:
                rent = 0 ;
                break;
            case 2:
                rent = 10 ;
                break;
            case 3:
                rent = 10 ;
                break;
            case 4:
                rent = 0 ;
                break;
            case 5:
                rent = 20 ;
                break;
            case 6:
                rent = 20 ;
                break;
            case 7:
                rent = 0 ;
                break;
            case 8:
                rent = 30;
                break;
            case 9:
                rent = 30;
                break;
            case 10:
                rent = 0 ;
                break;
            case 11:
                rent = 40;
                break;
            case 12:
                rent = 40;
                break;
            case 13:
                rent = 0;
                break;
            case 14:
                rent = 50;
                break;
            case 15:
                rent = 50;
                break;
            case 16:
                rent = 0;
                break;
            case 17:
                rent = 60;
                break;
            case 18:
                rent = 60;
                break;
            case 19:
                rent = 0;
                break;
            case 20:
                rent = 70;
                break;
            case 21:
                rent = 70;
                break;
            case 22:
                rent = 0;
                break;
            case 23:
                rent = 80;
                break;
            case 24:
                rent = 80;
                break;


        }
        return rent;







    }

    public static int getFieldPrice (int roll) {
        int price = 0;
        switch (roll) {

            case 1:
                price = 0;
                break;
            case 2:
                price = 50;
                break;
            case 3:
                price = 50;
                break;
            case 4:
                price = 0;
                break;
            case 5:
                price = 60;
                break;
            case 6:
                price = 60;
                break;
            case 7:
                price = 0;
                break;
            case 8:
                price = 70;
                break;
            case 9:
                price = 70;
                break;
            case 10:
                price = 0;
                break;
            case 11:
                price = 80;
                break;
            case 12:
                price = 80;
                break;
            case 13:
                price = 0;
                break;
            case 14:
                price = 90;
                break;
            case 15:
                price = 90;
                break;
            case 16:
                price = 0;
                break;
            case 17:
                price = 100;
                break;
            case 18:
                price = 100;
                break;
            case 19:
                price = 0;
                break;
            case 20:
                price = 110;
                break;
            case 21:
                price = 110;
                break;
            case 22:
                price = 0;
                break;
            case 23:
                price = 120;
                break;
            case 24:
                price = 120;
                break;



        }
        return price;

    }
}
