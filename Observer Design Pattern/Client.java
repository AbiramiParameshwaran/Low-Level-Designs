public class Client {
    public static void main(String[] args) {
        Order order = Order.getInstance();
        EmailService emailService = new EmailService();
        InventoryService inventoryService = new InventoryService();
        order.notifySubscriber();
    }
}
