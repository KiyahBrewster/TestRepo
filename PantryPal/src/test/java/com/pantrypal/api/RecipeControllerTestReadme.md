**Purpose:** Integration tests for the `RecipeController` using Spring Boot’s test context and MockMvc. Verifies that endpoints return correct status codes, content types, and expected JSON structures.

**Responsibilities**

Ensures GET /api/recipes returns:

200 OK

JSON array of recipes

At least one recipe with a name field.

Ensures POST /api/search with "egg,rice" returns:

200 OK

JSON content containing a recipe named "Egg Fried Rice".

Ensures POST /api/search with an unknown ingredient ("unobtainium") returns:

200 OK

An empty array ($.length() == 0).


**Assertions & Expectations**
Test: getAllRecipes_returnsOkAndJsonArray

Status: 200

Content type: JSON

Asserts that the first element has a name field.

Test: search_eggRice_returnsEggFriedRice

Status: 200

Content type: JSON

JSONPath asserts that a recipe with "name" == "Egg Fried Rice" exists.

Test: search_unknown_returnsEmptyArray

Status: 200

JSONPath asserts that the array length is 0.