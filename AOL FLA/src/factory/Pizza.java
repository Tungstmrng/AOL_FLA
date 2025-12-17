package factory;

public class Pizza implements MenuItem {
    private String type;
    
    public Pizza(String type) {
        this.type = type;
    }
    
    public String getDescription() {
        return type + " Pizza";
    }
    
    public double getCost() {
        switch(type.toLowerCase()) {
            case "margherita": return 45.000;
            case "pepperoni": return 50.000;
            case "vegetarian": return 40.000;
            default: return 45.000;
        }
    }
    
    public String getCategory() {
        return "Main Course";
    }
}