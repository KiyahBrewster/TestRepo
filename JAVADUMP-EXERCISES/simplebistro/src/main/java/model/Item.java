package model;

import java.math.BigDecimal;

public class Item {
    private int itemId;
    private String name;
    private BigDecimal price;

    public Item() {
        // default constructor
    }

    public Item(int itemId, String name, BigDecimal price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
