import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {
    static Scanner en = new Scanner(System.in);
    public static void showItemsSeller(){
        //case 1- Consult a seller's items.
        String message = "Seller does not exist.\n";
        showAllSellersName();
        System.out.println("Choose one seller: ");

        String sellerName = en.nextLine();
        int posSeller = Init.getPositionSeller(sellerName);

        if (posSeller != -1){
            message = Init.getSellers().get(posSeller).getInventory().toString();
        }
        System.out.println(message);
    }

    public static void showAllSellersName(){
        System.out.println("Sellers in game: ");
        for (Seller seller : Init.getSellers()){
            System.out.println(seller.getName());
        }
    }

    public static void showSellersInCity(String cityName){
        //case 2 - Consult the sellers in a city
        List<Seller> sellersInCity = getSellersInCity(cityName);
        if (sellersInCity.isEmpty()){
            System.out.println("There are no sellers in this city.\n");
        } else{
            sellersInCity.forEach(System.out::println);
        }
    }

    public static List<Seller> getSellersInCity(String cityName){
        return Init.getSellers().stream().filter(s -> s.getCity().equalsIgnoreCase(cityName)).collect(Collectors.toList());
    }


    public static void showCheapestItemCity(){
        //case 3- Show the cheapest items from all the sellers in a city
        showAllCities();
        System.out.println("\nChoose one city: ");
        String cityName = en.nextLine();

        List<Seller> sellersInCity = getSellersInCity(cityName);
        if (sellersInCity.isEmpty()){
            System.out.println("There are no sellers in this city.\n");
        } else{
            List<Item> allItemsCity = sellersInCity.stream().flatMap(seller -> seller.getInventory().stream()).sorted(Comparator.comparing(Item::getPrice)).toList();
            if (allItemsCity.isEmpty()){
                System.out.println("The sellers in this city have no objects to sell.\n");
            } else {
                allItemsCity.stream().limit(1).forEach(System.out::println);
            }
        }
    }

    public static void showTypeItemOrderedPrice(){
        // case 4- Show all items of a certain type ordered by price (asc)
        showAllTypeItems();
        System.out.println("\nChoose one type of object: ");
        String objType = en.nextLine();
        List<Item> itemsType = Init.getSellers().stream().flatMap(seller -> seller.getInventory().stream()).filter(item -> item.getType().equalsIgnoreCase(objType)).toList();
        if (itemsType.isEmpty()){
            System.out.println("No seller has this type of item.\n");
        }else {
            itemsType.stream().sorted(Comparator.comparing(Item::getPrice)).toList().forEach(System.out::println);
        }
    }

    private static void showAllCities(){
        System.out.println("Cities with sellers: ");
        Init.getSellers().stream().map(Seller::getCity).distinct().toList().forEach(System.out::println);
    }

    private static void showAllTypeItems(){
        System.out.println("Types of items available: ");
        Init.getSellers().stream().flatMap(seller -> seller.getInventory().stream()).map(Item::getType).distinct().toList().forEach(System.out::println);
    }

    public static void saveJson(){
        try (BufferedWriter myWriter = Files.newBufferedWriter(Paths.get("src/main/java/sellersInfo.json"))){
            Init.getSellers().forEach(seller -> {
                try {
                    myWriter.write(seller.toString());
                } catch (IOException e) {
                    throw new RuntimeException("Error writing sellers info.\n");
                }
            });
            myWriter.close();
            System.out.println("Successfully wrote to the file.\n");
        } catch (IOException e) {
            System.err.println("An error occurred while creating or writing to the file.\n");
        }
    }
}
