import java.util.Scanner;

public class ConsoleIOExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the order form!");

        System.out.print("What is your name?  \n>> ");
        String name = scanner.nextLine();

        System.out.println("\nHello, " + name + "! Let's get started with your order.");

        System.out.print("\nWhat product would you like to purchase?  \n>> ");
        String product = scanner.nextLine();

        System.out.print("\nHow many would you like?  \n>> ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.print("\nWhat is the unit price?  \n>> ");
        double unitPrice = Double.parseDouble(scanner.nextLine());

        // Calculations
        double subtotal = quantity * unitPrice;
        double tax = subtotal * 0.07;
        double grandTotal = subtotal + tax;

        // Output
        System.out.println("\nOrder Summary");
        System.out.println("-------------------------------");
        System.out.println("Item:            " + product);
        System.out.println("Quantity:        " + quantity);
        System.out.printf("Unit Price:      $%.2f\n", unitPrice);
        System.out.println("-------------------------------");
        System.out.printf("Subtotal:        $%.2f\n", subtotal);
        System.out.printf("Tax (7%%):        $%.2f\n", tax);
        System.out.printf("Grand Total:     $%.2f\n", grandTotal);
        System.out.println("-------------------------------");
        System.out.println("Thank you for your order, " + name + "!");
    }
}
