import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jessicahuffstutler on 10/12/15.
 */
public class Inventory {
    static void printItems(ArrayList<Supply> items) { //ArrayList is named items
        int itemNum = 1;
        for (Supply item : items) { //iterate over a list/collection; taking items(arraylist), starting from the first item in the list and going to the last and for each item it's calling it item.
            String quantityBox = "[ ]";
            int amount = item.quantity; //accessing the quantity field from the Supply class
            if (amount != 0) {
                quantityBox = "[" + amount + "]";
            }
            System.out.println(String.format("%d. %s %s %s", itemNum, quantityBox, item.name, item.category));
            itemNum++; //shorthand for itemNum = itemNum + 1;
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
                String supplyName = scanner.nextLine();
                System.out.println(String.format("Please enter a category for %s.", supplyName));
                String categoryTyped = scanner.nextLine();
                categoryTyped = categoryTyped.toLowerCase();
                Supply supplyWithCategory = null; //supplyCategory is a Supply but hasn't been created yet.
                try {
                    supplyWithCategory = createSupply(categoryTyped); //supplyWithCategory is created/assigned based on what createSupply returns.
                } catch (Exception e) {
                    System.out.println("Invalid category entered.");
                }
                supplyWithCategory.name = supplyName; //saving supplyName into the name field on the object (supplyWithCategory)
                System.out.println(String.format("Please enter the quantity for %s.", supplyName));
                String quantity = scanner.nextLine();
                try {
                    int quantityNum = Integer.valueOf(quantity);
                    supplyWithCategory.quantity = quantityNum;
                    items.add(supplyWithCategory);
                    System.out.println(String.format("%s added! Quantity of %s updated to %d.", supplyName, supplyName, quantityNum));
                } catch (Exception e) {
                    System.out.println("An error occurred.");
                }
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
                    System.out.println(String.format("Please enter the quantity for %s.", item.name));
                    String quantityString = scanner.nextLine();
                    int quantity = Integer.valueOf(quantityString);
                    item.quantity = quantity;
                    System.out.println(String.format("Quantity of %s updated to %d.", item.name, quantity));
                } catch (Exception e) {
                    System.out.println("An error occurred.");
                }
            } else {
                System.out.println("Invalid number.");
            }
        }
    }

    static Supply createSupply(String category) throws Exception {
        if (category.equals("dairy")) {
            return new Dairy(); //constructor, it's going to create a new dairy object
        } else if (category.equals("meat")) {
            return new Meat();
        } else if (category.equals("cans")) {
            return new Cans();
        } else if (category.equals("bakery")) {
            return new Bakery();
        }else if (category.equals("alcohol")) {
            return new Alcohol();
        } else {
            throw new Exception("Invalid category.");
        }
    }
} //still need to list the items with their quantity and category.
