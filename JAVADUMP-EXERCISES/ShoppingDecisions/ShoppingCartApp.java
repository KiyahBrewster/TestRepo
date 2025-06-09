import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input order total as a string, then convert to float
        System.out.println("Enter order total: ");
        String orderTotalInput = scanner.nextLine();
        float orderTotal = Float.parseFloat(orderTotalInput);

        System.out.println("Are you tax exempt? (yes/no): ");
        String taxExemptInput = scanner.nextLine();
        boolean isTaxExempt = taxExemptInput.equals("yes");

        System.out.println("Enter shipping method (standard, 2-day, overnight): ");
        String shippingMethod = scanner.nextLine();

        System.out.println("Enter promo code (or leave blank): ");
        String promoCode = scanner.nextLine();

        // Calculate tax
        float tax = 0;
        if (!isTaxExempt) {
            tax = orderTotal * 0.07f;
        }

        // Calculate discount
        float discount = 0;
        if (orderTotal > 500) {
            discount = orderTotal * 0.10f;
        } else if (orderTotal > 100) {
            discount = orderTotal * 0.05f;
        }

        // Determine shipping cost
        float shippingCost = 0;
        if (shippingMethod.equals("standard")) {
            if (promoCode.equals("FREE")) {
                shippingCost = 0;
            } else {
                shippingCost = 2;
            }
        } else if (shippingMethod.equals("2-day")) {
            shippingCost = 5;
        } else if (shippingMethod.equals("overnight")) {
            shippingCost = 10;
        } else {
            System.out.println("Invalid shipping method. Using standard.");
            shippingCost = 2;
        }

        // Calculate final total
        float finalTotal = orderTotal - discount + tax + shippingCost;

        // Output summary
        System.out.println("\n==== Order Summary ====");
        System.out.println("Subtotal: $" + orderTotal);
        System.out.println("Discount: -$" + discount);
        System.out.println("Tax: $" + tax);
        System.out.println("Shipping: $" + shippingCost);
        System.out.println("Total: $" + finalTotal);
    }
}
