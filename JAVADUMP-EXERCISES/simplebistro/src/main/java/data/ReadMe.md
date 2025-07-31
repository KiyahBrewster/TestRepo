# Repository Interfaces in `data`

This directory contains interface definitions for accessing core data entities in the SimpleBistro application. These interfaces define the contract for fetching, managing, and updating key business objects.

## Interfaces

### 1. `OrderRepo`
Defines methods for interacting with **Order** data, such as finding, saving, or deleting orders.

### 2. `PaymentTypeRepo`
Provides an abstraction for accessing and managing **PaymentType** entities, e.g., retrieving available payment methods.

### 3. `ServerRepo`
Specifies the contract for handling **Server** (staff/waiter) data, such as listing servers or retrieving details for a specific server.

### 4. `TaxRepo`
Handles operations related to **Tax** data, including retrieving applicable tax rates or details for calculations.

## Common Usage

These interfaces are typically implemented by repository classes (e.g., `OrderRepoImpl`) that provide the actual logic for data retrieval and manipulation, either through in-memory lists, databases, or external APIs.

Implementations are usually managed by Spring and injected as dependencies where needed.

# Implementation Classes for Repositories

This directory contains concrete implementations of the repository interfaces for the application. These classes provide dummy (in-memory) data for testing and development purposes.

---

## `OrderRepoImpl`

- **Location:** `data/OrderRepoImpl.java`
- **Implements:** `OrderRepo`
- **Purpose:** Provides mock order data. Returns example `Order` objects for testing purposes.
- **Key Methods:**
    - `Order findById(int id)`: Returns a sample `Order` object with the given ID.
    - `List<Order> findAll()`: Returns a list of sample `Order` objects.

---

## `PaymentTypeRepoImpl`

- **Location:** `data/PaymentTypeRepoImpl.java`
- **Implements:** `PaymentTypeRepo`
- **Purpose:** Supplies mock payment types (e.g., "Credit Card", "Cash") for development and demonstration.
- **Key Methods:**
    - `PaymentType findById(int id)`: Returns a sample `PaymentType` object by ID.
    - `List<PaymentType> findAll()`: Returns a list of sample payment types.

---

## `ServerRepoImpl`

- **Location:** `data/ServerRepoImpl.java`
- **Implements:** `ServerRepo`
- **Purpose:** Provides mock server (waitstaff) data for the application.
- **Key Methods:**
    - `Server findById(int id)`: Returns a sample `Server` object by ID.
    - `List<Server> findAll()`: Returns a list of sample servers.

---

## `TaxRepoImpl`

- **Location:** `data/TaxRepoImpl.java`
- **Implements:** `TaxRepo`
- **Purpose:** Supplies mock tax rates for development and demonstration.
- **Key Methods:**
    - `Tax findById(int id)`: Returns a sample `Tax` object by ID.
    - `List<Tax> findAll()`: Returns a list of sample tax rates.

---

> **Note:**  
> These implementations are for testing only. For real data, see the corresponding SQL-backed repository implementations (e.g., `MySqlOrderRepo`, `MySqlTaxRepo`, etc.).

