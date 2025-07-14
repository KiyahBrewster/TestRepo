package model;

public class PerishableProduct extends Product {
    private String expiryDate;

    public PerishableProduct(String id, String name, int quantity, double price, String expiryDate) {
        super(id, name, quantity, price);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() { return expiryDate; }

    @Override
    public String toString() {
        return super.toString() + " | Expires: " + expiryDate;
    }
}