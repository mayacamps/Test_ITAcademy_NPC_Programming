public class Item {
    private String name, type;
    private double price, wear;

    public Item(String name, String type, double price, double wear) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.wear = wear;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public double getWear() {
        return wear;
    }

    public void setWear(double wear) {
        this.wear = wear;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "Item: {" +
                "\n\tname: " + getName() +
                "\n\ttype: " + getType() +
                "\n\tprice: " + getPrice() +
                "\n\t% wear: " + getWear() +
                "}\n";
    }
}
