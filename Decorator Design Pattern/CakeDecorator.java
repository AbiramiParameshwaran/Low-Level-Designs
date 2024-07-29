abstract class CakeDecorator implements Cake{
    Cake cake;

    CakeDecorator(Cake cake) {
        this.cake = cake;
    }
    @Override
    public String getDescription() {
        return cake.getDescription();
    }

    @Override
    public int price() {
        return cake.price();
    }
}
