import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Init.init();
        loop();
    }

    private static void loop(){
        boolean exit = false;
        do {
            switch (menu()) {
                case 1 -> showItemsSeller();
                case 2 -> showSellersInCity();
                case 3 -> showCheapestItemCity();
                case 4 -> showTypeItemOrderedPrice();
                case 5 -> buyItemToSeller();
                case 6 -> sellItemToSeller();
                case 7 -> serializeSellersInfo();
                case 0 -> {
                    exit = true;
                    System.out.println("Bye!");}
                default -> System.err.println("Please introduce a valid option.\n");
            }

        } while (!exit);
    }
    private static int menu(){
        int menuOpt;
        System.out.println("Game management menu:\n" +
                "1- Consult a seller's items.\n" +
                "2- Consult the sellers in a city.\n" +
                "3- Show the cheapest items from all the sellers in a city\n" +
                "4- Show all items of a certain type ordered by price (asc).\n" +
                "5- Simulate the purchase of an item from an NPC.\n" +
                "6- Simulate the sale of an item to an NPC.*\n" +
                "7- Serialize the information of each NPC into a JSON file\n" +
                "0- Exit");
        menuOpt = Readers.readInt("\nChoose an option: ");
        return menuOpt;
    }

    private static void showItemsSeller(){
        Game.showItemsSeller();
    }
    private static void showSellersInCity(){
        String cityName = Readers.readString("Choose one city: ");
        Game.showSellersInCity(cityName);
    }
    private static void showCheapestItemCity(){
        Game.showCheapestItemCity();
    }
    private static void showTypeItemOrderedPrice(){
        Game.showTypeItemOrderedPrice();
    }
    private static void buyItemToSeller(){
        Player.buyItem();
    }
    private static void sellItemToSeller(){
        try {
            Player.sellItem();
        }catch (FullInventaryException e) {
            System.err.println(e.getMessage());
        }
    }
    private static void serializeSellersInfo(){
        try {
            Game.serializeJson(Init.getSellers(), "sellersInfo.json");
            System.out.println("Successfully wrote to the file.\n");
        } catch (IOException e) {
            System.err.println("An error occurred while creating or writing to the file.\n");
        }
    }

}
