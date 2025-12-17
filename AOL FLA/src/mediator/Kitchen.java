package mediator;

public class Kitchen extends RestaurantComponent {
    public void prepareOrder(int orderId) {
        System.out.println("Kitchen: Preparing order #" + orderId);
        if (mediator != null) {
            mediator.notify(this, "orderReady");
        }
    }
}