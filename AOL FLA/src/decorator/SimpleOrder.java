package decorator;

public class SimpleOrder implements OrderItem {
    private String description;
    private double cost;

    public SimpleOrder(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
