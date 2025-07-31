# RowMapper Implementations

This package (`mappers`) contains implementations of the `RowMapper<T>` interface from Spring JDBC. Each mapper class converts a row from a `ResultSet` into a corresponding Java model object from the `model` package.

These mappers are primarily used by the SQL repository classes in the `sql` package for transforming raw database query results into usable Java objects.

---

## Contents

- **ItemCategoryMapper.java**  
  Maps rows from the `itemcategory` table to `ItemCategory` objects.

- **ItemMapper.java**  
  Maps rows from the `item` table to `Item` objects.

- **OrderItemMapper.java**  
  Maps rows from the `order_item` table to `OrderItem` objects.

- **OrderMapper.java**  
  Maps rows from the `order` table to `Order` objects.

- **PaymentMapper.java**  
  Maps rows from the `payment` table to `Payment` objects.

- **PaymentTypeMapper.java**  
  Maps rows from the `paymenttype` table to `PaymentType` objects.

- **ServerMapper.java**  
  Maps rows from the `server` table to `Server` objects.

- **TaxMapper.java**  
  Maps rows from the `tax` table to `Tax` objects.

---

## How It Works

Each `*Mapper` implements:
```java
public class ExampleMapper implements RowMapper<Example> {
    @Override
    public Example mapRow(ResultSet rs, int rowNum) throws SQLException {
        Example example = new Example();
        example.setField(rs.getType("column_name"));
        return example;
    }
}
