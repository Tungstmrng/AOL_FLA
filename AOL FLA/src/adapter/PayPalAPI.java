package adapter;

public class PayPalAPI {
    public boolean send(double amount) {
        System.out.println("PayPal payment processed: Rp." + String.format("%.3f", amount));
        return true;
    }
}
