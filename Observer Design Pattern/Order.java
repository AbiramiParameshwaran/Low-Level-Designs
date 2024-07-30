import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Subscriber> subscribersList = new ArrayList<>();
    private static Order instance;
    public static Order getInstance() {
        if(instance == null) {
            instance =  new Order();
        }
        return instance;
    }

    void registerSubscriber(Subscriber subscriber) {
        subscribersList.add(subscriber);
    }

    void removeSubscriber(Subscriber subscriber) {
        subscribersList.remove(subscriber);
    }

    void notifySubscriber() {
        for(Subscriber subscriber: subscribersList) {
            subscriber.notifySubscriber();
        }
    }
}
