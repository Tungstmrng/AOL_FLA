package mediator;

public class Waiter extends RestaurantComponent {
    public void takeOrder() {
        System.out.println("Waiter: Taking order from customer");
        if (mediator != null) {
            mediator.notify(this, "orderTaken");
        }
    }
    
    public void serveOrder() {
        System.out.println("Waiter: Serving order to customer");
    }
}