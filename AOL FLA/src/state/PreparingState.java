package state;

public class PreparingState implements OrderState {
    public void next(Order order) {
        order.setState(new ReadyState());
    }
    
    public void prev(Order order) {
        order.setState(new NewState());
    }
    
    public String getStatus() {
        return "Preparing";
    }
}