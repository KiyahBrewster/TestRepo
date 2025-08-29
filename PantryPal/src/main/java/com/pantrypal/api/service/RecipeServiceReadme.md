# RecipeService

**Location:** `com.pantrypal.api.service.RecipeService`  
**Purpose:** Provides recipe-related business logic. Acts as a middle layer between
controllers (`RecipeController`) and persistence (`RecipeRepository`).

---

## Responsibilities
- Fetch all recipes
- Support pagination for listing recipes
- Search recipes by ingredient names (case-insensitive, ANY-match)
- Provide both paged and non-paged search variants

---

## Dependencies
- `RecipeRepository` (Spring Data JPA)
- `org.springframework.data.domain.Page`, `Pageable`

---

## Methods

### `List<Recipe> all()`
- Returns all recipes.
- Used by: `GET /api/recipes`

---

### `Page<Recipe> paged(Pageable pageable)`
- Returns a pageable list of recipes.
- Used by: `GET /api/recipes/paged`

---

### `Page<Recipe> searchByAnyIngredientPaged(List<String> ingredientNames, Pageable pageable)`
- Case-insensitive search for recipes containing **any** of the given ingredients.
- Cleans and normalizes the ingredient list:
    - Filters out `null` and empty strings.
    - Trims whitespace.
    - Converts to lowercase.
- Returns empty `PageImpl` if no valid search terms are provided.
- Used by: `POST /api/search`

---

### `List<Recipe> searchByAnyIngredient(List<String> ingredientNames)`
- Non-paged version of the search.
- Mostly used in unit tests or background processing.

---

## Implementation Notes
- Annotated with `@Service`, `@RequiredArgsConstructor`, and `@Transactional(readOnly = true)`.
- Uses constructor injection (`final RecipeRepository recipeRepository`).
- Protects controller logic by returning empty collections/pages instead of `null`.

---

## Example Usage

```java
// Fetch all
List<Recipe> allRecipes = recipeService.all();

// Paged list
Page<Recipe> paged = recipeService.paged(PageRequest.of(0, 10));

// Search by ingredients (paged)
Page<Recipe> eggRice = recipeService.searchByAnyIngredientPaged(
    List.of("egg", "rice"),
    PageRequest.of(0, 5)
);

// Non-paged search
List<Recipe> eggOnly = recipeService.searchByAnyIngredient(List.of("egg"));
