package adapter;

public interface PaymentProcessor {
    boolean pay(double amount);
    String getPaymentMethod();
}