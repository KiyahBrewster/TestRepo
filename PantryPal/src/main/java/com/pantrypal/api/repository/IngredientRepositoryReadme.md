# IngredientRepository

**Location:** `com.pantrypal.api.repository.IngredientRepository`  
**Purpose:** Data access layer for the `Ingredient` entity. Extends `JpaRepository` to provide CRUD operations and adds a case-insensitive search by name.

**Responsibilities**

Inherits full CRUD support (save, findById, deleteById, findAll, etc.) from JpaRepository<Ingredient, Long>.

Adds a custom finder:

Optional<Ingredient> findByNameIgnoreCase(String name)
→ Returns the first Ingredient with the given name, ignoring case.


**Why It Matters**

By extending JpaRepository, you get most DB access methods for free.

The method findByNameIgnoreCase uses Spring Data JPA’s derived query feature:

The method name translates directly into a JPQL query.

No need to write @Query manually for case-insensitive lookups.