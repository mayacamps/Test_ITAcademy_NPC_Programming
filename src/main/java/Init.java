import java.util.ArrayList;
import java.util.List;

public class Init {
    /*
    Initializes in static block the inventories for all the npc in the game and also the player.
     */
    public static List<Seller> sellers = new ArrayList<Seller>();
    public static Player player = new Player("Mamen", "Madrid");

    public static void init(){
        Item item1 = new Item("apple", "food", 2.3, 100);
        Item item2 = new Item("sword", "weapon", 100, 100);
        Item item3 = new Item("knife", "weapon", 25, 50);
        Item item4 = new Item("wood", "materials", 30, 50);
        Item item5 = new Item("grenade", "weapon", 150, 100);
        Item item6 = new Item("pie", "food", 15, 100);
        Item item7 = new Item("metal", "materials", 2.3, 50);
        Item item8 = new Item("rock", "materials", 60, 100);
        Item item9 = new Item("banana", "food", 1.7, 50);
        Item item10 = new Item("bomb", "weapon", 250, 100);
        Item item11 = new Item("super bomb", "weapon", 250, 100);
        Item item12 = new Item("mega bomb", "weapon", 250, 100);

        Farmer farmer1 = new Farmer("Lucas", "farmer", "Barcelona");
        Thief thief1 = new Thief("Andrea", "thief", "Barcelona");
        Merchant merchant1 = new Merchant("Fran", "merchant", "Valencia");
        Farmer farmer2 = new Farmer("Juan", "farmer", "Madrid");

        farmer1.getInventory().add(item1);
        farmer1.getInventory().add(item2);
        farmer1.getInventory().add(item3);
        farmer1.getInventory().add(item4);

        thief1.getInventory().add(item5);
        thief1.getInventory().add(item6);

        merchant1.getInventory().add(item7);
        merchant1.getInventory().add(item8);
        merchant1.getInventory().add(item9);
        merchant1.getInventory().add(item10);

        sellers.add(farmer1);
        sellers.add(thief1);
        sellers.add(merchant1);
        sellers.add(farmer2);

        player.getPlayerInventory().add(item11);
        player.getPlayerInventory().add(item12);
        System.out.println("Initialized game data.\n_____________________________________________");
    }

    public static List<Seller> getSellers() {
        return sellers;
    }

    public static Player getPlayer(){return player;}

    public static int getPositionSeller(String nameSeller){
        int pos = 0;
        boolean found = false;
        while (pos < getSellers().size() && !found){
            if (getSellers().get(pos).getName().equalsIgnoreCase(nameSeller)){
                return pos;
            }
            pos++;
        }
        return -1;
    }
}
