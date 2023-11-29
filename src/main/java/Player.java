import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name, currCity;
    private List<Item> playerItems;

    public Player(String name, String currCity) {
        this.name = name;
        this.currCity = currCity;
        this.playerItems = new ArrayList<Item>();
    }

    public String getName() {
        return name;
    }

    public String getCurrCity() {
        return currCity;
    }

    public void setCurrCity(String currCity) {
        this.currCity = currCity;
    }

    public List<Item> getPlayerInventory() {
        return playerItems;
    }
    private void addItem(Item item){getPlayerInventory().add(item);}
    private void deleteItem(Item item){getPlayerInventory().remove(item);}
    
    private static void optionChangeCity(){
        System.out.println("You are currently in: " + Init.getPlayer().getCurrCity());
        boolean changeCity = Readers.readYesNo("Do you want to switch cities?");

        if (changeCity){
            String newCurrCity = Readers.readString("Which city do you want to move to?");
            Init.getPlayer().setCurrCity(newCurrCity);
        }
    }

    public static void buyItem(){
        // case 5- Simulate purchase of item from seller
        Player player = Init.getPlayer();
        optionChangeCity();

        System.out.println("Showing sellers in this city:");
        Init.getSellers().stream().filter(seller -> seller.getCity().equalsIgnoreCase(Init.getPlayer().getCurrCity())).forEach(seller -> System.out.println(seller.getName()));
        String sellerName = Readers.readString("\nEnter the name of the seller you want to buy an item from: ");

        int sellerPos = Init.getPositionSeller(sellerName);

        if (sellerPos != -1){
            Seller seller = Init.getSellers().get(sellerPos);
            List<Item> sellerItems = seller.getInventory();

            if (!sellerItems.isEmpty()){
                System.out.println("\nSeller items: ");
                sellerItems.forEach(System.out::println);
                System.out.println("X (exit)");
                String itemName = Readers.readString("\nWhich item do you want to buy? ");

                if (!itemName.equalsIgnoreCase("X") && !sellerName.equalsIgnoreCase("exit")){
                    int itemPos = seller.getPositionItem(itemName);
                    if(itemPos != -1){
                        Item item = sellerItems.get(itemPos);
                        player.addItem(item);
                        seller.deleteItem(item);
                        System.out.println("Item successfully bought from seller.\n");
                    } else {System.out.println("\nSeller does not have this item.\n");}
                }
            } else {System.out.println("\nSeller has no items.\n");}
        } else {System.out.println("\nSeller doesn't exist.\n");}
        System.out.println("See you again in the shop!\n");
    }

    public static void sellItem() throws FullInventaryException {
        // case 6- Simulate the sale of item to seller
        Player player = Init.getPlayer();
        List<Item> playerItems = player.getPlayerInventory();

        if (!(playerItems.isEmpty())) {
            optionChangeCity();

            if (!(Game.getSellersInCity(Init.getPlayer().getCurrCity())).isEmpty()){
                System.out.println("This is your inventory: " + playerItems);
                String itemName = Readers.readString("Which item do you want to sell?");
                int itemPos = getPositionItem(itemName);

                if (itemPos != -1) {
                    Item item = playerItems.get(itemPos);
                    System.out.println("Showing sellers in this city: ");
                    Init.getSellers().stream().filter(seller -> seller.getCity().equalsIgnoreCase(Init.getPlayer().getCurrCity())).forEach(seller -> System.out.println(seller.getName()));
                    System.out.println("X (exit)");
                    String sellerName = Readers.readString("Choose which seller you want to sell an item to.");

                    if (!sellerName.equalsIgnoreCase("X") && !sellerName.equalsIgnoreCase("exit")){
                        int sellerPos = Init.getPositionSeller(sellerName);

                        if (sellerPos != -1) {
                            Seller seller = Init.getSellers().get(sellerPos);
                            player.deleteItem(item);
                            seller.addItem(item);
                        } else {System.out.println("Seller doesn't exist in this city.\n");}
                    }
                } else{System.out.println("Player doesn't have this item.\n");}
            } else { System.out.println("There are no sellers in this city.\n");}
        } else { System.out.println("Player has no items in inventory.\n");}
        System.out.println("See you again in the shop!\n");
    }

    private static int getPositionItem(String nameItem){
        int pos = 0;
        List<Item> playerItems = Init.getPlayer().getPlayerInventory();
        while (pos < playerItems.size()){
            if (playerItems.get(pos).getName().equalsIgnoreCase(nameItem)){
                return pos;
            }
            pos++;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Player: {" +
                "\nname: " + getName() +
                "\ncurrent city: " + getCurrCity() + "\n" +
                "\ninventory: {" + getPlayerInventory() + "}\n}\n";
    }

}
