package adapter;

public class GopayAPI {
    public boolean charge(double amount) {
        System.out.println("Gopay payment processed: Rp." + String.format("%.2f", amount));
        return true;
    }
}