package factory;

public class Drink implements MenuItem {
    private String type;
    
    public Drink(String type) {
        this.type = type;
    }
    
    public String getDescription() {
        return type;
    }
    
    public double getCost() {
        switch(type.toLowerCase()) {
            case "cola": return 10.000;
            case "juice": return 8.000;
            case "water": return 5.000;
            case "coffee": return 12.000;
            default: return 5.000;
        }
    }
    
    public String getCategory() {
        return "Beverage";
    }
}