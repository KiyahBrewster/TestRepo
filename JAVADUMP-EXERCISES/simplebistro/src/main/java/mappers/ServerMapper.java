package mappers;

import model.Server;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServerMapper implements RowMapper<Server> {

    @Override
    public Server mapRow(ResultSet rs, int rowNum) throws SQLException {
        Server server = new Server();
        server.setServerId(rs.getInt("server_id"));
        server.setName(rs.getString("name"));
        return server;
    }
}
