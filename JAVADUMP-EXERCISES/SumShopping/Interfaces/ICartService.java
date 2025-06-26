package Interfaces;

import model.Item;
import java.util.Map;

public interface ICartService {
    void addItem(String name, double price, int quantity);
    boolean removeItem(String name, int quantity);
    Map<String, Item> getCartContents();
    double getTotalPrice();
    void clearCart();
}
