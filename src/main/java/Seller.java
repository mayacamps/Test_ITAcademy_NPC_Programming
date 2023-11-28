import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public abstract class Seller extends Npc{
    private List<Item> inventory;
    private final int MAXITEM;
    private final double TAX, WEAR;

    public Seller(String name, String type, String city, int maxItem, double tax, double wear) {
        super(name, type, city);
        MAXITEM = maxItem;
        TAX = tax;
        WEAR = wear;
        this.inventory = new ArrayList<Item>();
    }
    public List<Item> getInventory() {
        return inventory;
    }

    public int getPositionItem(String nameItem){
        return IntStream.range(0, getInventory().size())
                .filter(pos -> getInventory().get(pos).getName().equalsIgnoreCase(nameItem))
                .findAny().orElse(-1);
    }

    public void addItem(Item item) throws FullInventaryException {
        if (getInventory().size() >= MAXITEM){
            throw new FullInventaryException();
        }
        item.setWear(Math.floor((item.getWear() * (1 + WEAR)) * 100) / 100);
        item.setPrice(Math.floor((item.getPrice() * (1 + TAX)) * 100) / 100);
        getInventory().add(item);
        System.out.println("Item successfully sold to seller.\n");
    }

    public void deleteItem(Item item){
        getInventory().remove(item);
    }

    public String toString(){
        return "Seller: {" +
                "\nname: " + getName() +
                "\ntype: " + getType() +
                "\ncity: " + getCity() +
                "\ninventory: {\n" +
                getInventory() + "}\n}\n";
    }
}
