PROJECT JOURNAL: Shopping Cart

1. Planning:
- Analyzed functional requirements: menu structure, item adding/removal, cart clearing.
- Identified business logic areas and created design with separation of concerns.

2. Design:
- Split code into packages: model, service, util, and interfaces.
- Used HashMap in CartService to manage cart contents (ensures fast lookup and quantity tracking).
- Interface ICartService created to enforce contract.

3. Development:
- Wrote Item class (POJO).
- Implemented CartService with add, remove, clear, total logic.
- Created CheckoutService to handle total and cart reset.
- Wrote InputHelper and Formatter in util for clean console interactions.

4. Testing:
- Wrote unit tests using JUnit 5.
- Tested add, remove (partial and full), clear, and total price.
- All tests pass successfully.

5. Refactoring:
- Ensured DRY principle.
- Isolated each feature in its method.
- Checked for code smells like duplicate logic and long methods.