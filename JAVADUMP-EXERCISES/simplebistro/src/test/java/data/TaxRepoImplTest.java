package data;

import model.Tax;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaxRepoImplTest {

    private final TaxRepoImpl repo = new TaxRepoImpl();

    @Test
    void testFindById() {
        Tax tax = repo.findById(1);
        assertNotNull(tax);
        assertEquals(1, tax.getTaxId());
        assertEquals(BigDecimal.valueOf(0.08), tax.getRate());
    }

    @Test
    void testFindAll() {
        List<Tax> taxes = repo.findAll();
        assertNotNull(taxes);
        assertFalse(taxes.isEmpty());
        assertTrue(taxes.size() >= 1); // Adjust depending on your dummy data
    }
}
