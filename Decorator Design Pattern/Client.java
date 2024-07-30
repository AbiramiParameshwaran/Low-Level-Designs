public class Client {
    public static void main(String[] args) {
        Cake cake = new SprinklesDecorator(
                        new FrostingDecorator(
                        new PlainCake()
                    )
                    );
        String description = cake.getDescription();
        int price = cake.price();
        System.out.println("Description = "+ description);
        System.out.println("Price = "+ price);
    }
}
