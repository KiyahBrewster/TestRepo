package mappers;

import model.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper implements RowMapper<Item> {
    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();
        item.setItemId(rs.getInt("item_id"));
        item.setName(rs.getString("name"));
        item.setPrice(rs.getBigDecimal("price"));
        return item;
    }
}
