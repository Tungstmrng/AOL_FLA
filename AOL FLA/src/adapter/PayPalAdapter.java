package adapter;

public class PayPalAdapter implements PaymentProcessor {
    private PayPalAPI paypal = new PayPalAPI();
    
    public boolean pay(double amount) {
        return paypal.send(amount);
    }
    
    public String getPaymentMethod() {
        return "PayPal";
    }
}