import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = {"Apple", "Banana", "Orange", "Grapes", "Mango"};
        double[] prices = {0.99, 0.59, 0.79, 2.49, 1.99};

        System.out.println("Welcome to the Shopping Cart!");
        displayChoices(items);

        int choice = -1;
        while (true) {
            try {
                System.out.print("Enter the number of the item you'd like to purchase (0-" + (items.length - 1) + "): ");
                choice = Integer.parseInt(scanner.nextLine());

                if (choice < 0 || choice >= items.length) {
                    throw new IndexOutOfBoundsException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please enter a valid menu option.");
            }
        }

        int quantity = -1;
        while (true) {
            try {
                System.out.print("Enter the quantity: ");
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity < 1) {
                    System.out.println("Quantity must be at least 1.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        double total = prices[choice] * quantity;
        System.out.println("You selected: " + items[choice]);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Total: $%.2f%n", total);

        scanner.close();
    }

    public static void displayChoices(String[] choices) {
        System.out.println("Available Items:");
        for (int i = 0; i < choices.length; i++) {
            System.out.println(i + ": " + choices[i]);
        }
    }
}
