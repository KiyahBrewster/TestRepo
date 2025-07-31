package data;

import model.Order;
import java.util.List;
public interface OrderRepo {
    Order findById(int id);
    List<Order> findAll();
}