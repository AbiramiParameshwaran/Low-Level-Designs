public class InventoryService implements Subscriber{
    Order order;
    InventoryService() {
        order = Order.getInstance();
        order.registerSubscriber(this);
    }
    @Override
    public void notifySubscriber() {
        System.out.println("Inventory Service notified");
    }
}
