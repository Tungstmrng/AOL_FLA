package mediator;

public abstract class RestaurantComponent {

    protected RestaurantMediator mediator;

    public RestaurantComponent(RestaurantMediator mediator) {
        this.mediator = mediator;
    }
}