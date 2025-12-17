package decorator;

public class SpecialSauceDecorator extends OrderItemDecorator {
    public SpecialSauceDecorator(OrderItem orderItem) {
        super(orderItem);
    }
    
    public String getDescription() {
        return orderItem.getDescription() + ", Special Sauce";
    }
    
    public double getCost() {
        return orderItem.getCost() + 5.000;
    }
}