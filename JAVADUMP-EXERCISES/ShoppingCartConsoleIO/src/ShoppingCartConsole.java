import java.util.Scanner;

public class ShoppingCartConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the shopping cart app!");

        System.out.println("Are you tax-exempt? (y/n)");
        String taxExempt = scanner.nextLine();

        System.out.println("Shipping? (y/n)");
        String shipping = scanner.nextLine();

        System.out.println("Order quantity?");
        String quantity = scanner.nextLine();

        System.out.println("Promo code for free shipping?");
        String promoCode = scanner.nextLine();

        System.out.println("\nDetails:");
        System.out.println("Tax-exempt: " + taxExempt);
        System.out.println("Shipping: " + shipping);
        System.out.println("Order quantity: " + quantity);
        System.out.println("Promo code: " + promoCode);

        System.out.println("Bye");
    }
}
