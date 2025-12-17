package adapter;

public class GopayAdapter implements PaymentProcessor {
    private GopayAPI gopay = new GopayAPI();
    
    public boolean pay(double amount) {
        return gopay.charge(amount);
    }
    
    public String getPaymentMethod() {
        return "Gopay";
    }
}
