package sql;

import data.ServerRepo;
import mappers.ServerMapper;
import model.Server;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySqlServerRepo implements ServerRepo {

    private final JdbcTemplate jdbc;

    public MySqlServerRepo(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Server findById(int id) {
        final String sql = "SELECT * FROM server WHERE server_id = ?;";
        return jdbc.queryForObject(sql, new ServerMapper(), id);
    }

    @Override
    public List<Server> findAll() {
        final String sql = "SELECT * FROM server;";
        return jdbc.query(sql, new ServerMapper());
    }

    // Optional: Create, update, delete methods
    public int create(Server server) {
        final String sql = "INSERT INTO server (name) VALUES (?);";
        return jdbc.update(sql, server.getName());
    }

    public int update(Server server) {
        final String sql = "UPDATE server SET name = ? WHERE server_id = ?;";
        return jdbc.update(sql, server.getName(), server.getServerId());
    }

    public int delete(int id) {
        final String sql = "DELETE FROM server WHERE server_id = ?;";
        return jdbc.update(sql, id);
    }
}
