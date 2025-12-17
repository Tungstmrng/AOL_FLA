package factory;

public class MenuItemFactory {
    public static MenuItem createMenuItem(String category, String type) {
        switch (category.toLowerCase()) {
            case "pizza": 
                return new Pizza(type);
            case "burger": 
                return new Burger(type);
            case "salad": 
                return new Salad(type);
            case "drink":
                return new Drink(type);
            default: 
                throw new IllegalArgumentException("Unknown category: " + category);
        }
    }
}