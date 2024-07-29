public class FrostingDecorator extends CakeDecorator{
    FrostingDecorator(Cake cake) {
        super(cake);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "...Frosting Decoration done";
    }

    @Override
    public int price() {
        return super.price() + 20;
    }
}
