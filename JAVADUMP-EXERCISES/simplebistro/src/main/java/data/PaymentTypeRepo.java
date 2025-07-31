package data;

import model.PaymentType;
import java.util.List;

public interface PaymentTypeRepo {
    PaymentType findById(int id);
    List<PaymentType> findAll();
}
