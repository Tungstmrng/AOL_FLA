package factory;

public class Burger implements MenuItem {
    private String type;
    
    public Burger(String type) {
        this.type = type;
    }
    
    public String getDescription() {
        return type + " Burger";
    }
    
    public double getCost() {
        switch(type.toLowerCase()) {
            case "classic": return 25.000;
            case "cheese": return 35.000;
            case "deluxe": return 50.000;
            default: return 25.000;
        }
    }
    
    public String getCategory() {
        return "Main Course";
    }
}