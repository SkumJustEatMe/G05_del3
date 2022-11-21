package fields;

public class BuyableField extends Field {
    int buyingPrice;
    String colour;
     public BuyableField(int buyingPrice, String colour){
         this.buyingPrice = buyingPrice;
         this.colour = colour;
     }
}
