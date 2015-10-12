import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jessicahuffstutler on 10/12/15.
 */
public class Inventory {
    static void printItems(ArrayList<Supply> items) {
        int itemNum = 1;
        for (Supply item : items) { //iterate over a list/collection; taking items(arraylist), starting from the first item in the list and going to the last and for each item it's calling it item.
            String quantityBox = "[ ]";
            int amount = item.quantity;
            if (amount != 0) {
                quantityBox = "[" + amount + "]";
            }
            System.out.println(itemNum + ". " + quantityBox + " " + item.name);
            itemNum++;
        }
    }

    public static void main(String[] args) {
        ArrayList<Supply> items = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printItems(items);

            System.out.println("Options:");
            System.out.println("[1] Create a new item");
            System.out.println("[2] Remove an item");
            System.out.println("[3] Update an item's quantity");

            String option = scanner.nextLine();
            int optionNum = Integer.valueOf(option);

            if (optionNum == 1) {
                System.out.println("Type an object and hit enter.");
                String item = scanner.nextLine();
                Supply thing = new Supply(item);
                items.add(thing);
            } else if (optionNum == 2) {
                System.out.println("Type the number of the item you would like to remove.");
                String item = scanner.nextLine();
                try {
                    int selectNum = Integer.valueOf(item);
                    Supply thing = items.get(selectNum - 1);
                    items.remove(thing);
                } catch (Exception e) {
                    System.out.println("An error occurred.");
                }
            } else if (optionNum == 3) {
                System.out.println("Type the number of the item you would like to update the quantity of.");
                String select = scanner.nextLine();
                try {
                    int selectNum = Integer.valueOf(select);
                    Supply item = items.get(selectNum - 1);
                    System.out.println("Please enter the quantity for " + item.name + ".");
                    String quantityString = scanner.nextLine();
                    int quantity = Integer.valueOf(quantityString);
                    item.quantity = quantity;
                    System.out.println("Quantity of " + item.name + " updated to " + quantity + ".");
                } catch (Exception e) {
                    System.out.println("An error occurred.");
                }
            } else {
                System.out.println("Invalid number.");
            }
        }
    }
}
