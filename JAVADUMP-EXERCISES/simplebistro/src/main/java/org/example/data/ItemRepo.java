package org.example.data;

import model.Item;

import java.util.List;

public interface ItemRepo {
    Item findById(int id);
    List<Item> findAll();
}
