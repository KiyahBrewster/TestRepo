package com.pantrypal.api.service;

import com.pantrypal.api.model.Recipe;
import com.pantrypal.api.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RecipeService {

    private final RecipeRepository recipeRepository;

    /** Return all recipes (used by GET /api/recipes). */
    public List<Recipe> all() {
        return recipeRepository.findAll();
    }

    /** Simple pagination over all recipes (used by GET /api/recipes/paged). */
    public Page<Recipe> paged(Pageable pageable) {
        return recipeRepository.findAll(pageable);
    }

    /** Search by ANY of the ingredient names, paged (used by POST /api/search). */
    public Page<Recipe> searchByAnyIngredientPaged(List<String> ingredientNames, Pageable pageable) {
        List<String> lowered = ingredientNames == null ? List.of() :
                ingredientNames.stream()
                        .filter(Objects::nonNull)
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .map(String::toLowerCase)
                        .toList();

        if (lowered.isEmpty()) {
            // keep the controller logic predictable; return an empty page with requested pageable
            return new PageImpl<>(List.of(), pageable, 0);
        }
        return recipeRepository.findByAnyIngredientNameIn(lowered, pageable);
    }

    /** Optional: non-paged variant (handy for unit tests). */
    public List<Recipe> searchByAnyIngredient(List<String> ingredientNames) {
        List<String> lowered = ingredientNames == null ? List.of() :
                ingredientNames.stream()
                        .filter(Objects::nonNull)
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .map(String::toLowerCase)
                        .toList();
        if (lowered.isEmpty()) return List.of();
        return recipeRepository.findByAnyIngredientNameIn(lowered);
    }
}
