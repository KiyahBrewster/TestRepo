package model;

public class PaymentType {
    private int paymentTypeId;
    private String typeName;
    private String description;

    public PaymentType() {}

    public PaymentType(int paymentTypeId, String typeName, String description) {
        this.paymentTypeId = paymentTypeId;
        this.typeName = typeName;
        this.description = description;
    }

    public PaymentType(int id, String creditCard) {
    }

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
