# Repository Implementation Unit Tests

This directory contains **unit tests** for the repository implementation classes (`*RepoImpl`) in the application. These tests are designed to validate the behavior of the in-memory (dummy) repository implementations.

---

## Structure

- Each test class corresponds to a repository implementation:
    - `OrderRepoImplTest.java`
    - `PaymentTypeRepoImplTest.java`
    - `ServerRepoImplTest.java`
    - `TaxRepoImplTest.java`

---

## Purpose

- **Verify** that each repository implementation returns expected dummy data.
- **Ensure** `findById(int id)` returns a valid object with the expected ID.
- **Ensure** `findAll()` returns a non-empty list of sample data.
- **Provide** regression coverage if the implementation changes.

---

## Example Test Cases

Each test class typically covers:

- **`findById` Test:**  
  Checks that an object with the requested ID is returned and is not null.

- **`findAll` Test:**  
  Checks that a list of objects is returned and is not empty.

---

## Example Usage

```java
@Test
void testFindById() {
    OrderRepoImpl repo = new OrderRepoImpl();
    Order order = repo.findById(1);
    assertNotNull(order);
    assertEquals(1, order.getOrderId());
}

@Test
void testFindAll() {
    OrderRepoImpl repo = new OrderRepoImpl();
    List<Order> orders = repo.findAll();
    assertNotNull(orders);
    assertFalse(orders.isEmpty());
}
