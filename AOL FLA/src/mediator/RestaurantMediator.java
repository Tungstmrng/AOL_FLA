package mediator;

public interface RestaurantMediator {
    void notify(RestaurantComponent sender, String event);
}