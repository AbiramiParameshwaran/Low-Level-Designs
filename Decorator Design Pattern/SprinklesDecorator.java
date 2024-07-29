public class SprinklesDecorator extends CakeDecorator{
    SprinklesDecorator(Cake cake) {
        super(cake);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "...Sprinkles decoration added";
    }

    @Override
    public int price() {
        return super.price() + 30;
    }
}
