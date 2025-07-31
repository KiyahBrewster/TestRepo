package model;

import java.math.BigDecimal;

public class Payment {
    private int paymentId;
    private int orderId;
    private int paymentTypeId;
    private BigDecimal amount;

    public Payment() {
        // default constructor
    }

    public Payment(int paymentId, int orderId, int paymentTypeId, BigDecimal amount) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.paymentTypeId = paymentTypeId;
        this.amount = amount;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", orderId=" + orderId +
                ", paymentTypeId=" + paymentTypeId +
                ", amount=" + amount +
                '}';
    }
}
