package decorator;

import factory.MenuItem;

public class BaseMenuItem implements OrderItem {
    private MenuItem menuItem;
    
    public BaseMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
    
    public String getDescription() {
        return menuItem.getDescription();
    }
    
    public double getCost() {
        return menuItem.getCost();
    }
}