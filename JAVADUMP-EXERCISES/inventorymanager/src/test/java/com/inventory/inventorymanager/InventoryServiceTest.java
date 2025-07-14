package com.inventory.inventorymanager;

import model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.InventoryService;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryServiceTest {
    private InventoryService service;

    @BeforeEach
    public void setup() {
        service = new InventoryService();
    }

    @Test
    public void testAddAndViewProducts() {
        Product p = new Product("P01", "Banana", 5, 0.99);
        service.addProduct(p);
        assertEquals(1, service.getProducts().size());

    }



}
