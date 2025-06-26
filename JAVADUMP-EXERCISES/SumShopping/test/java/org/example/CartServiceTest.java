package org.example;

import model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.CartService;

import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class CartServiceTest {
    private CartService cart;

    @BeforeEach
    public void setup() {
        cart = new CartService();
    }

    @Test
    public void testAddNewItem() {
        cart.addItem("Apple", 1.00, 3);
        Map<String, Item> items = cart.getCartContents();
        assertTrue(items.containsKey("Apple"));
        assertEquals(3, items.get("Apple").getQuantity());
    }

    @Test
    public void testRemoveItemPartialQuantity() {
        cart.addItem("Banana", 0.5, 5);
        cart.removeItem("Banana", 2);
        assertEquals(3, cart.getCartContents().get("Banana").getQuantity());
    }

    @Test
    public void testRemoveItemAllQuantity() {
        cart.addItem("Orange", 0.75, 2);
        cart.removeItem("Orange", 2);
        assertFalse(cart.getCartContents().containsKey("Orange"));
    }

    @Test
    public void testTotalPrice() {
        cart.addItem("Apple", 1.00, 2);
        cart.addItem("Orange", 2.00, 1);
        assertEquals(4.00, cart.getTotalPrice(), 0.001);
    }

    @Test
    public void testClearCart() {
        cart.addItem("Apple", 1.00, 1);
        cart.clearCart();
        assertTrue(cart.getCartContents().isEmpty());
    }
}
