# MenuController

The `MenuController` class serves as the main entry point for handling user interactions and menu operations within the application. It acts as a bridge between the application's business logic and the user interface (CLI, REST API, etc.), delegating data access and processing tasks to the appropriate service or repository classes.

---

## Purpose

- Manages and routes incoming user requests related to menu actions (such as viewing menu items, placing orders, etc.).
- Coordinates with repository implementation classes to fetch, display, or update application data.
- Provides a clear separation between the application's user interface logic and its data management logic.

---

## Location

- `controller/MenuController.java`

---

## Key Responsibilities

- Displaying available menu options to users.
- Handling user inputs and delegating tasks to service or repository classes.
- Managing the flow of application features such as creating orders, listing items, viewing payment types, etc.

---

## Example Features

- **List Menu Items:** Displays all available menu items to the user.
- **Create Order:** Accepts user input to create a new order and persists it through the appropriate repository.
- **List Payment Types:** Shows available payment methods.
- **List Servers:** Displays all available servers/waitstaff.
- **List Taxes:** Provides information on current tax rates.

---

## Dependencies

The `MenuController` typically depends on the following repositories/services:
- `ItemRepo`
- `OrderRepo`
- `PaymentTypeRepo`
- `ServerRepo`
- `TaxRepo`

---

## Notes

- The `MenuController` is intended for user interaction and application flow management only. It should not contain business logic or direct data access code.
- All business/data operations should be delegated to service or repository classes.

