package org.example;

import service.CartService;
import service.CheckoutService;
import util.InputHelper;
import util.Formatter;

public class App {
    public static void main(String[] args) {
        CartService cart = new CartService();

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Display Cart");
            System.out.println("2. Remove an Item");
            System.out.println("3. Add an Item");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");

            int choice = InputHelper.promptInt("Choose an option: ");

            switch (choice) {
                case 1:
                    Formatter.printCart(cart.getCartContents());
                    break;
                case 2:
                    String removeName = InputHelper.prompt("Enter item name to remove: ");
                    int removeQty = InputHelper.promptInt("How many to remove? ");
                    if (!cart.removeItem(removeName, removeQty)) {
                        System.out.println("Item not found.");
                    }
                    break;
                case 3:
                    String name = InputHelper.prompt("Item name: ");
                    double price = InputHelper.promptDouble("Item price: ");
                    int qty = InputHelper.promptInt("Quantity: ");
                    cart.addItem(name, price, qty);
                    break;
                case 4:
                    Formatter.printCart(cart.getCartContents());
                    CheckoutService.completeCheckout(cart);
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
