package decorator;

public abstract class OrderItemDecorator implements OrderItem {
    protected OrderItem orderItem;
    
    public OrderItemDecorator(OrderItem orderItem) {
        this.orderItem = orderItem;
    }
}