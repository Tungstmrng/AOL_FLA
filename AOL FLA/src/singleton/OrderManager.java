package singleton;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private static OrderManager instance;
    private List<String> orders;
    private int orderCounter;

    private OrderManager() {
        orders = new ArrayList<>();
        orderCounter = 1;
    }

    public static synchronized OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public int placeOrder(String orderDetails) {
        int orderId = orderCounter++;
        orders.add("Order #" + orderId + ": " + orderDetails);
        System.out.println("Order placed - ID: " + orderId + ", Details: " + orderDetails);
        return orderId;
    }

    public List<String> getAllOrders() {
        return new ArrayList<>(orders);
    }
}