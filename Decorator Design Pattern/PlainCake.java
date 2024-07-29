public class PlainCake implements Cake{
    @Override
    public String getDescription() {
        return "Plain Cake Ready";
    }

    @Override
    public int price() {
        return 100;
    }
}
