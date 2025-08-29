**Purpose:** Verifies that the `RecipeRepository` loads seeded recipe data correctly from `data.sql`.


**Key Annotations**

@DataJpaTest

Loads only JPA components (entities, repositories, persistence config).

Uses an in-memory database (H2 by default) unless overridden.

Each test runs in a transactional context and rolls back afterward.

@Autowired

Injects the RecipeRepository for direct repository testing.

@Test

JUnit 5 annotation marking a method as a test.


**Responsibilities**

Ensures that recipeRepository.findAll() is not empty, confirming that data.sql was loaded into the test database.

Verifies that the seeded recipes include one named "Egg Fried Rice".

Confirms repository wiring and entity mapping between Recipe and the database.