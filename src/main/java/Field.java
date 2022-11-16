public class Field {
    private String name;
    private String description;
    private int balanceChange;
    public Field(String fieldName, String fieldDescription, int fieldBalanceChange){
        name = fieldName;
        description = fieldDescription;
        balanceChange = fieldBalanceChange;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getBalanceChange(){
        return balanceChange;
    }
}
