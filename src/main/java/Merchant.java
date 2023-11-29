public class Merchant extends Seller{
    private static final int MAXITEM = 7; ;
    private static final double TAX = 0.04, WEAR = 0;

    public Merchant(String name, String type, String city) {
        super(name, type, city, Merchant.MAXITEM, Merchant.TAX, Merchant.WEAR);
    }
}
