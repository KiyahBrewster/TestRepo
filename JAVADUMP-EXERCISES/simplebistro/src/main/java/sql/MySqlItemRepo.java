package sql;

import org.example.data.ItemRepo;
import mappers.ItemMapper;
import model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySqlItemRepo implements ItemRepo {

    private final JdbcTemplate jdbc;

    public MySqlItemRepo(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Item findById(int id) {
        final String sql = "SELECT * FROM item WHERE item_id = ?;";
        return (Item) jdbc.queryForObject(sql, new ItemMapper(), id);
    }

    @Override
    public List<Item> findAll() {
        final String sql = "SELECT * FROM item;";
        return jdbc.query(sql, new ItemMapper());
    }

    public int create(Item item) {
        final String sql = "INSERT INTO item (name, price) VALUES (?, ?);";
        return jdbc.update(sql, item.getName(), item.getPrice());
    }

    public int update(Item item) {
        final String sql = "UPDATE item SET name = ?, price = ? WHERE item_id = ?;";
        return jdbc.update(sql, item.getName(), item.getPrice(), item.getItemId());
    }

    public int delete(int id) {
        final String sql = "DELETE FROM item WHERE item_id = ?;";
        return jdbc.update(sql, id);
    }
}
