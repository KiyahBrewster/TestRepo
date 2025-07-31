package model;

import java.math.BigDecimal;

public class Order {
    private int orderId;
    private int customerId;
    private BigDecimal total;

    // Default constructor
    public Order() {}

    // All-args constructor
    public Order(int orderId, int customerId, BigDecimal total) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.total = total;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", total=" + total +
                '}';
    }
}
