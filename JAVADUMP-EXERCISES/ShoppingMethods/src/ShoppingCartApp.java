import java.util.Scanner;

public class ShoppingCartApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] items = {"Apple", "Banana", "Orange", "Grapes", "Mango"};
        double[] prices = {0.99, 0.59, 0.79, 2.49, 1.99};

        System.out.println("Welcome to the Shopping Cart!");

        displayChoices(items);

        int choice = promptUserForInt(scanner, "Enter the number of the item you'd like to purchase (0-4): ");
        while (choice < 0 || choice >= items.length) {
            System.out.println("Invalid choice. Try again.");
            choice = promptUserForInt(scanner, "Enter the number of the item you'd like to purchase (0-4): ");
        }

        int quantity = promptUserForInt(scanner, "Enter the quantity: ");

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

    public static String promptUserForString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int promptUserForInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }
}