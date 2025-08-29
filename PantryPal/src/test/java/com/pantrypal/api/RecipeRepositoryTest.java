package com.pantrypal.api;

import com.pantrypal.api.model.Recipe;
import com.pantrypal.api.repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RecipeRepositoryTest {

    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    void findAll_hasSeedDataFromDataSql() {
        List<Recipe> all = recipeRepository.findAll();

        assertFalse(all.isEmpty(), "Expected recipes from data.sql");
        assertTrue(all.stream().anyMatch(r -> r.getName().equalsIgnoreCase("Egg Fried Rice")),
                "Should include 'Egg Fried Rice' from seed data");
    }
}
