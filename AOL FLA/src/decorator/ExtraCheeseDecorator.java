package decorator;

public class ExtraCheeseDecorator extends OrderItemDecorator {
    public ExtraCheeseDecorator(OrderItem orderItem) {
        super(orderItem);
    }
    
    public String getDescription() {
        return orderItem.getDescription() + ", Extra Cheese";
    }
    
    public double getCost() {
        return orderItem.getCost() + 5.000;
    }
}