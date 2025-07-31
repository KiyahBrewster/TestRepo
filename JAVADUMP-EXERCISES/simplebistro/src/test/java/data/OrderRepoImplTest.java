package data;

import model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoImplTest {

    private OrderRepoImpl repo;

    @BeforeEach
    void setUp() {
        repo = new OrderRepoImpl();
    }

    @Test
    void testCreateOrder() {
        Order newOrder = new Order(99, 5, new BigDecimal("55.55"));
        repo.create(newOrder);

        // Should be able to find the order by ID
        Order found = repo.findById(99);
        assertNotNull(found);
        assertEquals(5, found.getCustomerId());
        assertEquals(new BigDecimal("55.55"), found.getTotal());
    }

    @Test
    void testUpdateOrder() {
        // Add an order, then update it
        Order order = new Order(100, 10, new BigDecimal("20.00"));
        repo.create(order);

        // Update total
        order.setTotal(new BigDecimal("99.99"));
        repo.update(order);

        // Should reflect update
        Order updated = repo.findById(100);
        assertNotNull(updated);
        assertEquals(new BigDecimal("99.99"), updated.getTotal());
    }

    @Test
    void testDeleteOrder() {
        // Add, then delete
        Order order = new Order(101, 8, new BigDecimal("18.18"));
        repo.create(order);

        repo.delete(101);
        // Try to find, should be null or throw an error depending on your implementation
        Order deleted = repo.findById(101);
        assertNull(deleted); // Or assertThrows, if your findById throws when not found
    }
}
