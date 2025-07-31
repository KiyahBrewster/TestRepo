package mappers;

import model.Tax;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxMapper implements RowMapper<Tax> {
    @Override
    public Tax mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tax tax = new Tax();
        tax.setTaxId(rs.getInt("tax_id"));
        tax.setRate(rs.getBigDecimal("rate"));
        return tax;
    }
}
