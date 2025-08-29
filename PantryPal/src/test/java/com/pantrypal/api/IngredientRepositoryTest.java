package com.pantrypal.api;

import com.pantrypal.api.model.Ingredient;
import com.pantrypal.api.repository.IngredientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IngredientRepositoryTest {

    @Autowired
    IngredientRepository ingredientRepository;

    @Test
    void findAll_includesCommonIngredientEgg() {
        List<Ingredient> all = ingredientRepository.findAll();
        assertFalse(all.isEmpty(), "Expected ingredients from data.sql");
        assertTrue(all.stream().anyMatch(i -> i.getName().equalsIgnoreCase("egg")),
                "Seed should include 'egg'");
    }
}
