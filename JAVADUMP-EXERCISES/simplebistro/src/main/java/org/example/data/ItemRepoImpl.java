package org.example.data;

import model.Item;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepoImpl implements ItemRepo {

    @Override
    public Item findById(int id) {
        // Dummy implementation
        return new Item(id, "Sample Item " + id, BigDecimal.valueOf(10.99));
    }

    @Override
    public List<Item> findAll() {
        // Dummy implementation
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Burger", BigDecimal.valueOf(5.99)));
        items.add(new Item(2, "Fries", BigDecimal.valueOf(2.99)));
        items.add(new Item(3, "Soda", BigDecimal.valueOf(1.50)));
        return items;
    }
}
