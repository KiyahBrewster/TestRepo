import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Shipping addresses and sizes arrays
        String[] shippingAddresses = {"123 Main St", "456 Main St", "789 Main St"};
        String[] productSizes = {"small", "medium", "large"};

        // Display shipping addresses
        System.out.println("Choose a shipping address:");
        for (int i = 0; i < shippingAddresses.length; i++) {
            System.out.printf("%d. %s%n", i + 1, shippingAddresses[i]);
        }

        System.out.print("Shipping address? ");
        int addressChoice = Integer.parseInt(scanner.nextLine());

        // Get order quantity
        System.out.print("Order quantity? ");
        int quantity = Integer.parseInt(scanner.nextLine());

        // Display product sizes
        System.out.println("Choose a product size:");
        for (int i = 0; i < productSizes.length; i++) {
            System.out.printf("%d. %s%n", i + 1, productSizes[i]);
        }

        System.out.print("Size? ");
        int sizeChoice = Integer.parseInt(scanner.nextLine());

        // Promo code
        System.out.print("Promo code for free shipping? ");
        String promoCode = scanner.nextLine();

        // Summary
        System.out.println("\n=== Order Summary ===");
        System.out.println("Shipping to: " + shippingAddresses[addressChoice - 1]);
        System.out.println("Quantity: " + quantity);
        System.out.println("Size: " + productSizes[sizeChoice - 1]);
        System.out.println("Promo Code: " + (promoCode.isEmpty() ? "None" : promoCode));
    }
}
