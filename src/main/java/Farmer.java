public class Farmer extends Seller {
    private static final int MAXITEM = 5; ;
    private static final double TAX = 0.02, WEAR = 0.15;

    public Farmer(String name, String type, String city) {
        super(name, type, city, Farmer.MAXITEM, Farmer.TAX, Farmer.WEAR);
    }
}
