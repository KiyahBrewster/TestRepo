package data;

import model.PaymentType;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentTypeRepoImpl implements PaymentTypeRepo {

    @Override
    public PaymentType findById(int id) {
        // Dummy implementation: returns a PaymentType with given id
        return new PaymentType(id, "Credit Card"); // Adjust as needed for your constructor
    }

    @Override
    public List<PaymentType> findAll() {
        // Dummy implementation: returns a list of sample PaymentTypes
        List<PaymentType> paymentTypes = new ArrayList<>();
        paymentTypes.add(new PaymentType(1, "Credit Card"));
        paymentTypes.add(new PaymentType(2, "Cash"));
        return paymentTypes;
    }
}
