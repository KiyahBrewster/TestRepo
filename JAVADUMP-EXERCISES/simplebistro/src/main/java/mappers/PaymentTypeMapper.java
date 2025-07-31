package mappers;

import model.PaymentType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentTypeMapper implements RowMapper<PaymentType> {
    @Override
    public PaymentType mapRow(ResultSet rs, int rowNum) throws SQLException {
        PaymentType pt = new PaymentType();
        pt.setPaymentTypeId(rs.getInt("payment_type_id"));
        pt.setTypeName(rs.getString("payment_type_name"));  // assuming you have setTypeName
        pt.setDescription(rs.getString("description"));      // if your table has this column
        return pt;
    }
}
