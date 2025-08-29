package com.pantrypal.api.controller.dto;

import com.pantrypal.api.model.Recipe;

public record RecipeDto(
        Long id,
        String name,
        String instructions,
        String imageUrl,
        Integer prepMinutes,
        Integer cookMinutes,
        String ingredientsText
) {
    public static RecipeDto from(Recipe r) {
        return new RecipeDto(
                r.getId(),
                r.getName(),
                r.getInstructions(),
                r.getImageUrl(),
                r.getPrepMinutes(),
                r.getCookMinutes(),
                r.getIngredientsText()
        );
    }
}
