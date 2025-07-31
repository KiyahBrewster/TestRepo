package sql;

import data.TaxRepo;
import mappers.TaxMapper;
import model.Tax;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySqlTaxRepo implements TaxRepo {

    private final JdbcTemplate jdbc;

    public MySqlTaxRepo(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Tax findById(int id) {
        final String sql = "SELECT * FROM tax WHERE tax_id = ?;";
        return jdbc.queryForObject(sql, new TaxMapper(), id);
    }

    @Override
    public List<Tax> findAll() {
        final String sql = "SELECT * FROM tax";
        return jdbc.query(sql, new TaxMapper());
    }
}
