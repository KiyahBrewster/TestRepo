package sql;

import data.PaymentTypeRepo;
import mappers.PaymentTypeMapper;
import model.PaymentType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySqlPaymentTypeRepo implements PaymentTypeRepo {

    private final JdbcTemplate jdbc;

    public MySqlPaymentTypeRepo(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public PaymentType findById(int id) {
        final String sql = "SELECT * FROM paymenttype WHERE payment_type_id = ?;";
        return jdbc.queryForObject(sql, new PaymentTypeMapper(), id);
    }

    @Override
    public List<PaymentType> findAll() {
        final String sql = "SELECT * FROM paymenttype;";
        return jdbc.query(sql, new PaymentTypeMapper());
    }

    public int create(PaymentType pt) {
        final String sql = "INSERT INTO paymenttype (payment_type_name) VALUES (?);";
        return jdbc.update(sql, pt.getTypeName());
    }

    public int update(PaymentType pt) {
        final String sql = "UPDATE paymenttype SET payment_type_name = ? WHERE payment_type_id = ?;";
        return jdbc.update(sql, pt.getTypeName(), pt.getPaymentTypeId());
    }

    public int delete(int id) {
        final String sql = "DELETE FROM paymenttype WHERE payment_type_id = ?;";
        return jdbc.update(sql, id);
    }
}
