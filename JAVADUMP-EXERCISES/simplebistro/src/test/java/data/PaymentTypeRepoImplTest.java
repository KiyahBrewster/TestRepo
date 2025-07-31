package data;

import model.PaymentType;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTypeRepoImplTest {

    private final PaymentTypeRepoImpl repo = new PaymentTypeRepoImpl();

    @Test
    void testFindById() {
        PaymentType pt = repo.findById(1);
        assertNotNull(pt);
        assertEquals(1, pt.getPaymentTypeId());
    }

    @Test
    void testFindAll() {
        List<PaymentType> paymentTypes = repo.findAll();
        assertNotNull(paymentTypes);
        assertFalse(paymentTypes.isEmpty());
    }
}
