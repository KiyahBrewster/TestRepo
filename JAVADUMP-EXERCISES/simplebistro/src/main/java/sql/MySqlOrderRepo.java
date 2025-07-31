package sql;

import data.OrderRepo;
import mappers.OrderMapper;
import model.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySqlOrderRepo implements OrderRepo {

    private final JdbcTemplate jdbc;

    public MySqlOrderRepo(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Order findById(int id) {
        final String sql = "SELECT * FROM `order` WHERE order_id = ?;";
        return jdbc.queryForObject(sql, new OrderMapper(), id);
    }

    @Override
    public List<Order> findAll() {
        final String sql = "SELECT * FROM `order`;";
        return jdbc.query(sql, new OrderMapper());
    }

    public int create(Order order) {
        final String sql = "INSERT INTO `order` (customer_id, total) VALUES (?, ?);";
        return jdbc.update(sql, order.getCustomerId(), order.getTotal());
    }

    public int update(Order order) {
        final String sql = "UPDATE `order` SET customer_id = ?, total = ? WHERE order_id = ?;";
        return jdbc.update(sql, order.getCustomerId(), order.getTotal(), order.getOrderId());
    }

    public int delete(int id) {
        final String sql = "DELETE FROM `order` WHERE order_id = ?;";
        return jdbc.update(sql, id);
    }
}
