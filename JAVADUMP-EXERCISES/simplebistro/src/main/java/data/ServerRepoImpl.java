package data;

import model.Server;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ServerRepoImpl implements ServerRepo {
    @Override
    public Server findById(int id) {
        // Dummy implementation
        return new Server(id, "Server " + id); // Update constructor as needed
    }

    @Override
    public List<Server> findAll() {
        // Dummy implementation
        List<Server> servers = new ArrayList<>();
        servers.add(new Server(1, "Alice"));
        servers.add(new Server(2, "Bob"));
        return servers;
    }
}
