package state;

public class ReadyState implements OrderState {
    public void next(Order order) {
        order.setState(new DeliveredState());
    }
    
    public void prev(Order order) {
        order.setState(new PreparingState());
    }
    
    public String getStatus() {
        return "Ready";
    }
}