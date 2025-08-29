**Responsibilities**:

Provide read endpoints for recipes (list & pagination).

Provide a paged search by ingredient terms (match ANY term).

Return API-safe payloads via RecipeDto.

**Dependencies**:

RecipeService must implement:

List<Recipe> all()

Page<Recipe> paged(Pageable pageable)

Page<Recipe> searchByAnyIngredientPaged(List<String> terms, Pageable pageable)