package service;

import model.Item;
import Interfaces.ICartService;

import java.util.HashMap;
import java.util.Map;

public class CartService implements ICartService {
    private Map<String, Item> cart = new HashMap<>();

    @Override
    public void addItem(String name, double price, int quantity) {
        if (cart.containsKey(name)) {
            Item item = cart.get(name);
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            cart.put(name, new Item(name, price, quantity));
        }
    }

    @Override
    public boolean removeItem(String name, int quantity) {
        if (!cart.containsKey(name)) return false;
        Item item = cart.get(name);
        if (quantity >= item.getQuantity()) {
            cart.remove(name);
        } else {
            item.setQuantity(item.getQuantity() - quantity);
        }
        return true;
    }

    @Override
    public Map<String, Item> getCartContents() {
        return new HashMap<>(cart);
    }

    @Override
    public double getTotalPrice() {
        double total = 0;
        for (Item item : cart.values()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    @Override
    public void clearCart() {
        cart.clear();
    }
}
