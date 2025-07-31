# ItemRepoImpl

`ItemRepoImpl` is a simple in-memory implementation of the `ItemRepo` interface for the SimpleBistro application.  
It uses dummy data to simulate menu items for demonstration and testing purposes.

## Location

- **Package:** `org.example.data`
- **Class:** `ItemRepoImpl`

## Description

- Implements the `ItemRepo` interface.
- Provides methods to retrieve single items by ID and fetch all available items.
- Data is **hardcoded** and not persisted.

## Methods

- **`Item findById(int id)`**  
  Returns a sample `Item` object with the given ID.

- **`List<Item> findAll()`**  
  Returns a list of predefined `Item` objects representing menu items.

//////ITEM REPO

# ItemRepo Interface

The `ItemRepo` interface defines the contract for retrieving `Item` objects in the SimpleBistro application.

## Location

- **Package:** `org.example.data`
- **Interface:** `ItemRepo`

## Description

This interface provides abstract methods for:
- Fetching an `Item` by its unique ID
- Retrieving a list of all available items

## Methods

- **`Item findById(int id)`**
    - Returns an `Item` with the specified ID.
    - Parameters:
        - `id`: The unique identifier of the item.
    - Returns:
        - An `Item` object.

- **`List<Item> findAll()`**
    - Returns a list of all items.
    - Parameters:
        - None.
    - Returns:
        - A `List<Item>` containing all available items.

## Usage Example

```java
ItemRepo itemRepo = ...; // Typically injected by Spring

Item item = itemRepo.findById(1);
List<Item> allItems = itemRepo.findAll();

