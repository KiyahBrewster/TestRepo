# Data Seed (`data.sql`)

**Purpose:** Provides initial seed data for the PantryPal backend. Populates the `ingredient`, `recipe`, and `recipe_ingredient` tables with default values so the application and tests have sample data to work with.

Includes initial inserts, join-table links (recipe_ingredient), and backfilled fields (prep_minutes, cook_minutes, ingredients_text, image_url).

**Notes**

Recipe images are loaded via Unsplash URLs for demo purposes.

ingredients_text provides a denormalized, human-readable version of ingredients to simplify display and search.

All test cases (IngredientRepositoryTest, RecipeRepositoryTest, RecipeServiceTest, RecipeControllerTest) depend on these seeds (e.g., presence of "egg" and "Egg Fried Rice").

Adjust IDs or add new records with caution — they are hard-coded into the test expectations.