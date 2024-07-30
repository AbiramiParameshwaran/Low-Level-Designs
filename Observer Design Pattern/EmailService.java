public class EmailService implements Subscriber{
    Order order;
    EmailService() {
        order = Order.getInstance();
        order.registerSubscriber(this);
    }

    @Override
    public void notifySubscriber() {
        System.out.println("Email service notified");
    }
}
