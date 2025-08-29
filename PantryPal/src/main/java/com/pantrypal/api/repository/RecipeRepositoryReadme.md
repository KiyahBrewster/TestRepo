# RecipeRepository

**Location:** `com.pantrypal.api.repository.RecipeRepository`  
**Purpose:** Data access layer for the `Recipe` entity. Extends `JpaRepository` to provide CRUD operations, plus custom ingredient-based search queries (paged and non-paged).

---

**Responsibilities**:

Inherits full CRUD methods from JpaRepository<Recipe, Long>.

Provides custom queries to search recipes by ingredient names:

Non-paged: List<Recipe> findByAnyIngredientNameIn(Collection<String> names)

Paged: Page<Recipe> findByAnyIngredientNameIn(Collection<String> names, Pageable pageable)

Both return recipes that contain any of the given ingredients (case-insensitive).


**Why Custom Queries?**

Spring Data JPA derived queries don’t work well for joining collection relationships like @ManyToMany.

Explicit JPQL queries ensure:

Proper join to the ingredients table.

distinct to avoid duplicate recipes when multiple ingredients match.

Case-insensitive matching with lower(i.name).