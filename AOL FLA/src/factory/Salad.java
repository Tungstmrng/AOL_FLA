package factory;

public class Salad implements MenuItem {
    private String type;
    
    public Salad(String type) {
        this.type = type;
    }
    
    public String getDescription() {
        return type + " Salad";
    }
    
    public double getCost() {
        switch(type.toLowerCase()) {
            case "caesar": return 35.000;
            case "greek": return 35.000;
            case "garden": return 35.000;
            default: return 35.000;
        }
    }
    
    public String getCategory() {
        return "Appetizer";
    }
}