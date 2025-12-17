package state;

public class Order {
    private OrderState state;
    private int orderId;
    
    public Order(int orderId) {
        this.orderId = orderId;
        this.state = new NewState();
    }
    
    public void setState(OrderState state) {
        this.state = state;
    }
    
    public void next() {
        state.next(this);
    }
    
    public void prev() {
        state.prev(this);
    }
    
    public String getStatus() {
        return "Order #" + orderId + " - Status: " + state.getStatus();
    }
}