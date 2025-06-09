import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get order total
        float orderTotal = 0;
        while (orderTotal <= 0) {
            System.out.print("Enter your order total (must be > 0): ");
            orderTotal = Float.parseFloat(scanner.nextLine());
        }

        // Check if customer is tax exempt
        boolean isTaxExempt = false;
        String taxInput = "";
        while (!taxInput.equals("yes") && !taxInput.equals("no")) {
            System.out.print("Are you tax exempt? (yes/no): ");
            taxInput = scanner.nextLine().toLowerCase();
        }
        isTaxExempt = taxInput.equals("yes");

        // Get shipping method
        String shippingMethod = "";
        while (!shippingMethod.equals("standard") &&
                !shippingMethod.equals("2-day") &&
                !shippingMethod.equals("overnight")) {
            System.out.print("Enter shipping method (standard, 2-day, overnight): ");
            shippingMethod = scanner.nextLine().toLowerCase();
        }

        // Promo code
        System.out.print("Enter a promo code (or press Enter to skip): ");
        String promoCode = scanner.nextLine();

        // Calculate tax
        float tax = isTaxExempt ? 0 : orderTotal * 0.07f;

        // Discount logic
        float discount = 0;
        if (orderTotal > 500) {
            discount = orderTotal * 0.10f;
        } else if (orderTotal > 100) {
            discount = orderTotal * 0.05f;
        }

        // Shipping cost using switch
        float shippingCost = 0;
        switch (shippingMethod) {
            case "standard":
                if (promoCode.equalsIgnoreCase("FREE")) {
                    shippingCost = 0;
                } else {
                    shippingCost = 2;
                }
                break;
            case "2-day":
                shippingCost = 5;
                break;
            case "overnight":
                shippingCost = 10;
                break;
            default:
                System.out.println("Invalid shipping method. Defaulting to standard.");
                shippingCost = 2;
        }

        // Calculate final total
        float finalTotal = orderTotal - discount + tax + shippingCost;

        // Output summary
        System.out.println("\n====== Order Summary ======");
        System.out.printf("Subtotal:       $%.2f\n", orderTotal);
        System.out.printf("Discount:      -$%.2f\n", discount);
        System.out.printf("Tax:            $%.2f\n", tax);
        System.out.printf("Shipping:       $%.2f\n", shippingCost);
        System.out.printf("Total:          $%.2f\n", finalTotal);

        scanner.close();
    }
}