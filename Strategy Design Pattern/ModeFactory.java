public class ModeFactory {
    public  static  ModeStrategy getModeObject(String mode) {
        if(mode.equals("Car")) {
            return new Car();
        } else {
            return new Walk();
        }
    }
}
