package mappers;

import model.ItemCategory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemCategoryMapper implements RowMapper<ItemCategory> {
    @Override
    public ItemCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
        ItemCategory ic = new ItemCategory();
        ic.setItemCategoryId(rs.getInt("item_category_id"));
        ic.setName(rs.getString("name"));
        return ic;
    }
}