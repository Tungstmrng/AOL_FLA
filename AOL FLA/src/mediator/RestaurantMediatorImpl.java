package mediator;

public class RestaurantMediatorImpl implements RestaurantMediator {
    private Kitchen kitchen;
    private Waiter waiter;
    private PaymentDesk paymentDesk;
    
    public RestaurantMediatorImpl(Kitchen kitchen, Waiter waiter, PaymentDesk paymentDesk) {
        this.kitchen = kitchen;
        this.waiter = waiter;
        this.paymentDesk = paymentDesk;
    }
    
    @Override
    public void notify(RestaurantComponent sender, RestaurantEvent event) {
        System.out.println("Mediator: " + event.getMessage());

        switch (event) {
            case ORDER_TAKEN:
                handleOrderTaken(sender);
                break;

            case ORDER_READY:
                handleOrderReady();
                break;

            case PAYMENT_COMPLETE:
                handlePaymentComplete();
                break;

            default:
                System.out.println("Mediator: Unknown event");
        }
    }

    private void handleOrderTaken(RestaurantComponent sender) {
        int orderId = extractOrderId(sender);
        System.out.println("Mediator: Sending order to kitchen");
        kitchen.prepareOrder(orderId);
    }

    private void handleOrderReady() {
        System.out.println("Mediator: Notifying waiter to serve order");
        waiter.serveOrder();
    }

    private void handlePaymentComplete() {
        System.out.println("Mediator: Payment completed, order finished");
    }
    private int extractOrderId(RestaurantComponent sender) {
        if (sender instanceof OrderComponent) {
            return ((OrderComponent) sender).getOrderId();
        }
        return 1;
    }
}