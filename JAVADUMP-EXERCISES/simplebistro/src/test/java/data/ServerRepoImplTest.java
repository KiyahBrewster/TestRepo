package data;

import model.Server;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServerRepoImplTest {

    private final ServerRepoImpl repo = new ServerRepoImpl();

    @Test
    void testFindById() {
        Server server = repo.findById(1);
        assertNotNull(server);
        assertEquals(1, server.getServerId());
        // Optionally check name if your dummy always returns a certain value
        // assertEquals("John Doe", server.getName());
    }

    @Test
    void testFindAll() {
        List<Server> servers = repo.findAll();
        assertNotNull(servers);
        assertFalse(servers.isEmpty());
        // Optionally, check expected values
        // assertEquals("Jane Doe", servers.get(0).getName());
    }
}
