package data;

import model.Tax;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaxRepoImpl implements TaxRepo {
    @Override
    public Tax findById(int id) {
        return new Tax(id, "Standard Tax", BigDecimal.valueOf(0.10));
    }

    @Override
    public List<Tax> findAll() {
        List<Tax> taxes = new ArrayList<>();
        taxes.add(new Tax(1, "Standard Tax", BigDecimal.valueOf(0.10)));
        taxes.add(new Tax(2, "Reduced Tax", BigDecimal.valueOf(0.05)));
        return taxes;
    }
}
