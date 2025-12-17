package state;

public class NewState implements OrderState {
    public void next(Order order) {
        order.setState(new PreparingState());
    }
    
    public void prev(Order order) {
        System.out.println("Order is already in New state.");
    }
    
    public String getStatus() {
        return "New";
    }
}