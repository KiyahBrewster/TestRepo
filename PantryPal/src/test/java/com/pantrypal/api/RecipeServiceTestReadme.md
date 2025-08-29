**Purpose:** Integration tests for the `RecipeService`. Validates service logic for ingredient-based search, ensuring expected results with seeded data.


**Key Annotations**

@SpringBootTest

Loads the full Spring application context.

Tests RecipeService in a realistic environment with repositories, entities, and the database.

@Autowired

Injects the RecipeService into the test class.

@Test

Marks test methods for JUnit 5.


**Responsibilities**

Validates that RecipeService.searchByAnyIngredient(...):

Returns seeded recipes when valid ingredients are provided.

Returns "Egg Fried Rice" when searching for "egg" or "rice".

Returns an empty list when no matching ingredient exists ("unobtainium").