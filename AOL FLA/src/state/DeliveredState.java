package state;

public class DeliveredState implements OrderState {
    public void next(Order order) {
        System.out.println("Order has been delivered and completed.");
    }
    
    public void prev(Order order) {
        order.setState(new ReadyState());
    }
    
    public String getStatus() {
        return "Delivered";
    }
}