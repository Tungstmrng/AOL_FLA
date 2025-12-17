package proxy;

public class MenuProxy implements MenuService {
    private RestaurantMenu menu;
    private boolean isVIP;
    
    public MenuProxy(boolean isVIP) {
        this.menu = new RestaurantMenu();
        this.isVIP = isVIP;
    }
    
    public void displayMenu() {
        menu.displayMenu();
    }
    
    public void displaySpecialMenu() {
        if (isVIP) {
            menu.displaySpecialMenu();
        } else {
            System.out.println("\n=== VIP MENU ===");
            System.out.println("Access denied. VIP membership required.");
        }
    }
}
