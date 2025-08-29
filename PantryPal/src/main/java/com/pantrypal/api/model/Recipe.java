package com.pantrypal.api.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Lob
    private String instructions;

    @Column(name = "image_url")
    private String imageUrl;

    // NEW: prep & cook times
    @Column(name = "prep_minutes")
    private Integer prepMinutes;

    @Column(name = "cook_minutes")
    private Integer cookMinutes;

    // NEW: denormalized text string of ingredients
    @Column(name = "ingredients_text", columnDefinition = "TEXT")
    private String ingredientsText;

    @ManyToMany
    @JoinTable(
            name = "recipe_ingredient",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<Ingredient> ingredients = new HashSet<>();
}
