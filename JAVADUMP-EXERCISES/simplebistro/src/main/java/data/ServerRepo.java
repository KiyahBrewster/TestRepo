package data;

import model.Server;
import java.util.List;

public interface ServerRepo {
    Server findById(int id);
    List<Server> findAll();
}
