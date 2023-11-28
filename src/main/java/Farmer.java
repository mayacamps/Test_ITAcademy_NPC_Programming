public class Farmer extends Seller {
    private final static int MAXITEM = 5; ;
    private final static double TAX = 0.02, WEAR = 0.15;

    public Farmer(String name, String type, String city) {
        super(name, type, city, Farmer.MAXITEM, Farmer.TAX, Farmer.WEAR);
    }
}
