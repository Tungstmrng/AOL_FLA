package mediator;

public class PaymentDesk extends RestaurantComponent {
    public void processPayment() {
        System.out.println("Payment Desk: Processing payment");
        if (mediator != null) {
            mediator.notify(this, "paymentComplete");
        }
    }
}