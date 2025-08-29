package com.pantrypal.api;

import com.pantrypal.api.model.Recipe;
import com.pantrypal.api.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipeServiceTest {

    @Autowired
    RecipeService recipeService;

    @Test
    void searchByAnyIngredient_findsEggFriedRice() {
        List<Recipe> results = recipeService.searchByAnyIngredient(List.of("egg", "rice"));
        assertFalse(results.isEmpty());
        assertTrue(results.stream().anyMatch(r -> r.getName().equalsIgnoreCase("Egg Fried Rice")));
    }

    @Test
    void searchByAnyIngredient_unknownReturnsEmpty() {
        List<Recipe> results = recipeService.searchByAnyIngredient(List.of("unobtainium"));
        assertTrue(results.isEmpty());
    }
}
