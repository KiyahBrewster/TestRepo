# Recipe Entity

**Location:** `com.pantrypal.api.model.Recipe`  
**Purpose:** Represents a recipe in the PantryPal system. Defines recipe metadata, instructions, ingredient relationships, and fields for search/display.



/** Surrogate key (auto-increment). */
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

/** Display name (required). */
@Column(nullable = false, length = 160)
private String name;

/** Long-form cooking steps. */
@Lob
@Column(columnDefinition = "TEXT")
private String instructions;

/** Optional image URL for the UI thumbnail/hero. */
@Column(name = "image_url", length = 512)
private String imageUrl;

/** Minutes required for prep tasks (optional). */
@Column(name = "prep_minutes")
private Integer prepMinutes;

/** Minutes required for cooking (optional). */
@Column(name = "cook_minutes")
private Integer cookMinutes;

/**
    * Denormalized, human-friendly ingredient list for fast display and
    * lightweight text search (e.g., "egg; rice; soy sauce; green onion").
      */
      @Column(name = "ingredients_text", columnDefinition = "TEXT")
      private String ingredientsText;

/**
    * Canonical ingredient references used for structured queries & joins.
    * LAZY keeps list endpoints snappy; load when you need the full graph.
      */
      @ManyToMany(fetch = FetchType.LAZY)
      @JoinTable(
      name = "recipe_ingredient",
      joinColumns = @JoinColumn(name = "recipe_id"),
      inverseJoinColumns = @JoinColumn(name = "ingredient_id")
      )
      private Set<Ingredient> ingredients = new HashSet<>();

/** Convenience (not persisted): total time = prep + cook. */
@Transient
public int getTotalMinutes() {
return (prepMinutes == null ? 0 : prepMinutes)
+ (cookMinutes == null ? 0 : cookMinutes);
}
}

# Recipe Model

Represents a user-facing recipe with display fields, timing, and a structured list of ingredients.

## Table Mapping

- **Table:** `recipe`
- **Indexes:**
    - `ix_recipe_name` on `name`
    - `ix_recipe_times` on `prep_minutes,cook_minutes`
- **PK:** `id` (BIGINT, auto-increment)
- **Columns:**
    - `id` – primary key
    - `name` – `VARCHAR(160)`, **NOT NULL**
    - `instructions` – `TEXT` (long content via `@Lob`)
    - `image_url` – `VARCHAR(512)`, optional
    - `prep_minutes` – INT, optional
    - `cook_minutes` – INT, optional
    - `ingredients_text` – `TEXT`, optional (denormalized list for display/search)

## Relationships

- **Many-to-Many** with `Ingredient` via join table `recipe_ingredient`:

```sql
CREATE TABLE recipe_ingredient (
  recipe_id BIGINT NOT NULL,
  ingredient_id BIGINT NOT NULL,
  PRIMARY KEY (recipe_id, ingredient_id),
  CONSTRAINT fk_ri_recipe     FOREIGN KEY (recipe_id)     REFERENCES recipe(id),
  CONSTRAINT fk_ri_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredient(id)
);
