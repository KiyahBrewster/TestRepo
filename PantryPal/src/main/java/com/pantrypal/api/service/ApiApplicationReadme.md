# ApiApplication

**Location:** `com.pantrypal.api.ApiApplication`  
**Purpose:** Entry point for the PantryPal backend. Boots the Spring context and launches the embedded web server.

---

## Definition

```java
@SpringBootApplication
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
