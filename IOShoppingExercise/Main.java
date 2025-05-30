import java.util.Scanner;
import java.text.DecimalFormat;

class OrderForm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat moneyFormat = new DecimalFormat("$0.00");

        System.out.println("Welcome to the order form!");

        // 1. Ask for user's name
        System.out.print("What is your name?  >> ");
        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "! Let's get started with your order.");

        // 2. Get product details
        System.out.print("What product would you like to purchase?  >> ");
        String product = scanner.nextLine();

        System.out.print("How many would you like?  >> ");
        int quantity = scanner.nextInt();

        System.out.print("What is the unit price?  >> ");
        double unitPrice = scanner.nextDouble();

        // 3. Calculate totals
        double subtotal = quantity * unitPrice;
        double tax = subtotal * 0.07;
        double grandTotal = subtotal + tax;

        // 4. Print receipt
        System.out.println("\nOrder Summary");
        System.out.println("-------------------------------");
        System.out.println("Item:\t\tQuantity:\tUnit Price:");
        System.out.println(product + "\t\t" + quantity + "\t\t" + moneyFormat.format(unitPrice));
        System.out.println("-------------------------------");
        System.out.println("Subtotal:\t" + moneyFormat.format(subtotal));
        System.out.println("Tax (7%):\t" + moneyFormat.format(tax));
        System.out.println("Grand Total:\t" + moneyFormat.format(grandTotal));
        System.out.println("-------------------------------");
        System.out.println("Thank you for your order, " + name + "!");

        scanner.close();
    }
}