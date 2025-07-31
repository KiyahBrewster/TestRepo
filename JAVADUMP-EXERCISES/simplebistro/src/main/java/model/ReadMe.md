# Model Classes

This directory contains the core data model classes for the application. These classes represent the main business entities and are used throughout the application for storing, transferring, and managing data.

---

## List of Model Classes

### 1. `Item`
- **Fields:**
    - `itemId` (`int`): Unique identifier for the item
    - `name` (`String`): Name of the item
    - `price` (`BigDecimal`): Price of the item
- **Purpose:**  
  Represents a menu item available for order (e.g., a food or drink).

---

### 2. `Order`
- **Fields:**
    - `orderId` (`int`): Unique identifier for the order
    - `customerId` (`int`): Identifier for the customer placing the order
    - `total` (`BigDecimal`): Total amount for the order
- **Purpose:**  
  Represents a customer's order, including the total price and customer reference.

---

### 3. `OrderItem`
- **Fields:**
    - `orderItemId` (`int`): Unique identifier for this order item
    - `orderId` (`int`): Associated order’s ID
    - `itemId` (`int`): Associated menu item’s ID
    - `quantity` (`int`): Quantity of the item in the order
- **Purpose:**  
  Represents a specific menu item within an order, including quantity.

---

### 4. `Payment`
- **Fields:**
    - `paymentId` (`int`): Unique identifier for the payment
    - `orderId` (`int`): Associated order’s ID
    - `paymentTypeId` (`int`): ID for the payment method (e.g., cash, card)
    - `amount` (`BigDecimal`): Amount paid
- **Purpose:**  
  Represents a payment transaction for an order.

---

### 5. `PaymentType`
- **Fields:**
    - `paymentTypeId` (`int`): Unique identifier for the payment type
    - `typeName` (`String`): Name/type of payment method (e.g., "Credit Card")
    - `description` (`String`): Additional description or notes
- **Purpose:**  
  Represents a method of payment available in the system.

---

### 6. `Server`
- **Fields:**
    - `serverId` (`int`): Unique identifier for the server (waitstaff)
    - `name` (`String`): Name of the server
- **Purpose:**  
  Represents a staff member who serves customers.

---

### 7. `Tax`
- **Fields:**
    - `taxId` (`int`): Unique identifier for the tax entry
    - `taxName` (`String`): Name of the tax (e.g., "Standard Tax")
    - `rate` (`BigDecimal`): Tax rate as a decimal (e.g., 0.10 for 10%)
- **Purpose:**  
  Represents tax information applied to orders.

---

## Notes

- All model classes provide both a default constructor and a full-arguments constructor for flexibility.
- Standard Java getter and setter methods are included for all fields.
- These classes are pure POJOs (Plain Old Java Objects) and do not contain any business logic.
- Used across repositories, services, and controllers for data manipulation and transfer.