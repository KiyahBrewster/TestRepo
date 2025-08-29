**Purpose**: A compact, API-safe projection of Recipe entities for responses. Prevents exposing JPA internals and avoids over-posting.

Uses a Java record for immutable, concise DTOs.

from(Recipe) is a single source of truth for mapping.

Works seamlessly with Jackson for JSON serialization (no extra annotations required).

id — DB identifier

name — recipe title

instructions — long-form steps (may be null)

imageUrl — optional image URL shown on the frontend

prepMinutes / cookMinutes — optional time fields (non-negative when present)

ingredientsText — optional display string (e.g., “egg, rice, green onion”)


Mapping in controllers/services:
List<RecipeDto> list = recipes.stream().map(RecipeDto::from).toList();
***Extending safely***

Add new fields to the DTO and to from(Recipe)—clients get richer responses without breaking older code.

Keep DTOs read-only. For create/update, define dedicated request DTOs with bean validation (e.g., RecipeCreateDto).