package com.inventory.inventorymanager;

import model.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    @Test
    public void testProductGettersAndSetters() {
        Product p = new Product("1", "Apple", 10, 1.99);
        assertEquals("1", p.getId());
        assertEquals("Apple", p.getName());
        assertEquals(10, p.getQuantity());
        assertEquals(1.99, p.getPrice(), 0.01);

        p.setQuantity(20);
        p.setPrice(2.99);
        assertEquals(20, p.getQuantity());
        assertEquals(2.99, p.getPrice(), 0.01);
    }
}