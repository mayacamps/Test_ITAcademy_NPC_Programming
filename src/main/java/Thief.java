public class Thief extends Seller{
    private static final int MAXITEM = 3; ;
    private static final double TAX = 0, WEAR = 0.25;

    public Thief(String name, String type, String city) {
        super(name, type, city, Thief.MAXITEM, Thief.TAX, Thief.WEAR);
    }
}
