package controller;

import model.Item;
import org.example.data.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final ItemRepo itemRepo;

    @Autowired
    public MenuController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    @GetMapping("/items/{id}")
    public Item getItemById(@PathVariable int id) {
        return (Item) itemRepo.findById(id);
    }
}
