package data;

import model.Order;

import java.math.BigDecimal;
import java.util.*;

public class OrderRepoImpl implements OrderRepo {
    private final Map<Integer, Order> orders = new HashMap<>();

    @Override
    public Order findById(int id) {
        return orders.get(id);
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orders.values());
    }

    // Add these methods:
    public void create(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public void update(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public void delete(int orderId) {
        orders.remove(orderId);
    }
}
