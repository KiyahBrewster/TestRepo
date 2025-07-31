package data;

import org.example.data.ItemRepoImpl;
import model.Item;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepoImplTest {

    private final ItemRepoImpl repo = new ItemRepoImpl();

    @Test
    void testFindById() {
        Item item = repo.findById(1);
        assertNotNull(item);
        assertEquals(1, item.getItemId());
    }

    @Test
    void testFindAll() {
        List<Item> items = repo.findAll();
        assertNotNull(items);
        assertFalse(items.isEmpty());
    }
}
