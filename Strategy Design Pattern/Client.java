public class Client {
    public static void main(String[] args) {
        ModeStrategy mode = ModeFactory.getModeObject("Car");
        mode.calcTimeBasedOnMode();
        mode = ModeFactory.getModeObject("Walk");
        mode.calcTimeBasedOnMode();
    }
}
