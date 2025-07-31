package data;

import model.Tax;
import java.util.List;

public interface TaxRepo {
    Tax findById(int id);
    List<Tax> findAll();
}
