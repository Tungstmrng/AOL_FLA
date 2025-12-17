package decorator;

public class ExtraLargeDecorator extends OrderItemDecorator {
    public ExtraLargeDecorator(OrderItem orderItem) {
        super(orderItem);
    }
    
    public String getDescription() {
        return orderItem.getDescription() + " (Extra Large)";
    }
    
    public double getCost() {
        return orderItem.getCost() * 1.5;
    }
}