package service;

import data.InventoryRepository;
import model.Product;

import java.util.*;

public class InventoryService {
    private final List<Product> products = new ArrayList<>();
    private final InventoryRepository repo = new InventoryRepository();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added.");
    }

    public short viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            products.forEach(System.out::println);
        }
        return 0;
    }

    public List<Product> getProducts() {
        return products;
    }


    public void searchProduct(String query) {
        products.stream()
                .filter(p -> p.getId().equalsIgnoreCase(query) || p.getName().equalsIgnoreCase(query))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Product not found."));
    }

    public void updateProduct(String id, Integer newQty, Double newPrice) {
        for (Product p : products) {
            if (p.getId().equalsIgnoreCase(id)) {
                if (newQty != null) p.setQuantity(newQty);
                if (newPrice != null) p.setPrice(newPrice);
                System.out.println("Product updated.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void deleteProduct(String id) {
        products.removeIf(p -> p.getId().equalsIgnoreCase(id));
        System.out.println("Product deleted (if found).");
    }

    public void saveToFile() {
        repo.save(products);
        System.out.println("Inventory saved to file.");
    }

    public void loadFromFile() {
        products.clear();
        products.addAll(repo.load());
        System.out.println("Inventory loaded from file.");
    }
}