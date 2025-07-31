# SQL Repository Implementations

This package (`sql`) contains MySQL-specific implementations of repository interfaces used throughout the SimpleBistro application.

Each class in this package implements a corresponding interface from the `data` package using Spring's `JdbcTemplate` to perform database operations against a MySQL database.

---

## Contents

- **MySqlItemRepo.java**  
  Handles CRUD operations for `Item` entities from the `item` table.

- **MySqlOrderRepo.java**  
  Manages operations for `Order` entities from the `order` table. Note: `order` is a reserved keyword in SQL and must be wrapped in backticks.

- **MySqlPaymentTypeRepo.java**  
  Handles operations for different types of payments (e.g., credit, cash) stored in the `paymenttype` table.

- **MySqlServerRepo.java**  
  Manages server/waitstaff data stored in the `server` table.

- **MySqlTaxRepo.java**  
  Retrieves and updates tax rate information from the `tax` table.

---

## Notes

- These classes are annotated with `@Repository` for Spring component scanning.
- All SQL queries are written as raw strings and use `?` placeholders to prevent SQL injection.
- Each class depends on its own `*Mapper` class from the `mappers` package to convert `ResultSet` rows into Java model objects.

---

## Dependencies

- Spring Framework (`JdbcTemplate`, `@Repository`)
- Your custom model classes (e.g., `Item`, `Order`, `Tax`, etc.)
- Corresponding interfaces in the `data` package

---

## Example Usage

```java
@Autowired
private ItemRepo itemRepo;

public List<Item> fetchItems() {
    return itemRepo.findAll();
}
