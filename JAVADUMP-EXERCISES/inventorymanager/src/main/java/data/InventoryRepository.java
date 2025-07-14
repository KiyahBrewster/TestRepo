package data;

import model.Product;
import java.io.*;
import java.util.*;

public class InventoryRepository {
    private static final String FILE_NAME = "inventory.csv";

    public void save(List<Product> products) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Product p : products) {
                String line = p instanceof model.PerishableProduct pp ?
                        String.format("%s,%s,%d,%.2f,%s", p.getId(), p.getName(), p.getQuantity(), p.getPrice(), pp.getExpiryDate()) :
                        String.format("%s,%s,%d,%.2f", p.getId(), p.getName(), p.getQuantity(), p.getPrice());
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> load() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    products.add(new model.PerishableProduct(parts[0], parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3]), parts[4]));
                } else {
                    products.add(new Product(parts[0], parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
