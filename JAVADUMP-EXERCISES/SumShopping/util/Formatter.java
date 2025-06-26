package util;

import model.Item;

import java.util.Map;

public class Formatter {
    public static void printCart(Map<String, Item> cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.printf("%-15s%-10s%-10s%n", "Item", "Price", "Qty");
        for (Item item : cart.values()) {
            System.out.printf("%-15s$%-9.2f%-10d%n",
                    item.getName(), item.getPrice(), item.getQuantity());
        }
    }
}
