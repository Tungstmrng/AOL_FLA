package proxy;

public class RestaurantMenu implements MenuService {
    public void displayMenu() {
        System.out.println("\n=== REGULAR MENU ===");
        System.out.println("PIZZAS:");
        System.out.println("- Margherita Pizza: Rp.45.000");
        System.out.println("- Pepperoni Pizza: Rp.50.000");
        System.out.println("- Vegetarian Pizza: Rp.40.000");
        System.out.println("\nBURGERS:");
        System.out.println("- Classic Burger: Rp.25.000");
        System.out.println("- Cheese Burger: Rp.35.000");
        System.out.println("- Deluxe Burger: Rp.50.000");
        System.out.println("\nSALADS:");
        System.out.println("- Caesar Salad: Rp.35.000");
        System.out.println("- Greek Salad: Rp.35.000");
        System.out.println("- Garden Salad: Rp.35.000");
        System.out.println("\nDRINKS:");
        System.out.println("- Cola: Rp.10.000");
        System.out.println("- Juice: Rp.8.000");
        System.out.println("- Water: Rp.5.000");
        System.out.println("- Coffee: Rp.12.000");
    }
    
    public void displaySpecialMenu() {
        System.out.println("\n=== VIP MENU ===");
        System.out.println("- Wagyu Steak: Rp.300.000");
        System.out.println("- Lobster Thermidor: Rp.350.000");
        System.out.println("- Truffle Pasta: Rp.120.000");
        System.out.println("- Vintage Wine Selection: Rp.500.000");
    }
}
