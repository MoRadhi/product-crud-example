# Product CRUD Example

A lightweight, modern RESTful API built with **Spring Boot 3.x** and **Java 21** for managing a persistent product inventory catalog. This project demonstrates classic production-tier full-stack architecture conventions, separating web routing layers from transactional business logic, domain specifications, and automated database schema instantiation.

---

## 🛠️ Tech Stack & Prerequisites

- **Runtime Environment:** Java JDK 21
- **Framework:** Spring Boot 3.x (Web, Spring Data JPA Starters)
- **Object-Relational Mapping (ORM):** Hibernate
- **Database Engine:** PostgreSQL (Instance database named `product_db`)
- **Build Tool & Lifecycle Management:** Apache Maven (via Maven Wrapper `./mvnw`)
- **Boilerplate Optimization:** Project Lombok (Requires Lombok plugin enabled in your IDE)

---

## 🏗️ Architecture Design

The application implements a multi-tiered Layered Architecture with complete Separation of Concerns (SoC). Incoming requests pass sequentially through validation, service transaction boundaries, and repository persistence abstractions:

```text
 Client (Postman/ThunderClient)
             │
       [HTTP Request]
             ▼
      ProductController         (REST Routing & HTTP Status Mapping)
             │
             ▼
       ProductService           (Business Rule Verification Interface)
             │
             ▼
     ProductServiceImpl         (Transactional Implementations)
             │
             ▼
      ProductRepository         (Spring Data JPA / Hibernate Core)
             │
         [SQL Query]
             ▼
        PostgreSQL              (Persistent Engine: 'product_db')

```

---

## 📂 Project Structure Reference

```
PRODUCT-CRUD-EXAMPLE (Root Repository Workspace)
└── product-crud-assignment
    ├── .mvn/
    ├── src
    │   ├── main
    │   │   ├── java
    │   │   │   └── com
    │   │   │       └── example
    │   │   │           └── product_crud_assignment
    │   │   │               ├── controller
    │   │   │               │   └── ProductController.java
    │   │   │               ├── repository
    │   │   │               │   └── ProductRepository.java
    │   │   │               ├── service
    │   │   │               │   ├── ProductService.java
    │   │   │               │   └── ProductServiceImpl.java
    │   │   │               ├── Product.java
    │   │   │               ├── ProductDataLoader.java
    │   │   │               └── ProductCrudAssignmentApplication.java
    │   │   └── resources
    │   │       └── application.properties
    │   └── test/
    ├── mvnw
    ├── mvnw.cmd
    └── pom.xml
```

## 🚀 Installation & Build Lifecycle

Follow these steps to clean, compile, and execute the binaries locally.

1. Database Provisioning
   Ensure you have a PostgreSQL database server running locally on port 5432. Create an empty database container named product_db via your preferred administration terminal or DBeaver:
   `CREATE DATABASE product_db;`

2. Verify Database Connection Context
   Open src/main/resources/application.properties and verify your access credentials match your local PostgreSQL configuration environment:

   ```
   spring.datasource.url=jdbc:postgresql://localhost:5432/product_db
   spring.datasource.username=postgres
   spring.datasource.password=YOUR_POSTGRES_PASSWORD
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Navigate to the Project Folder
   Ensure your shell path is situated within the specific directory containing the pom.xml configuration framework:
   `cd product-crud-assignment`

4. Clean and Package Compilation
   Execute a clean compilation cycle using the local Maven Wrapper utility. This wipes previous target layers, validates dependency graphs, compiles production-ready classes, and packages output bundles:
   `./mvnw clean package`

5. Initialize Runtime Server
   Boot up the integrated embedded Tomcat application server (configured to bind to communication channel port 8080 by default):
   `./mvnw spring-boot:run`

---

## 🛰️ API Endpoint Contract Specifications

All request bodies and responses communicate over content type payload header specifications matching application/json.

| HTTP Method | Route Endpoint   | Description                                                 | Request Body Payload Requirement                           | Expected Success Status |
| :---------- | :--------------- | :---------------------------------------------------------- | :--------------------------------------------------------- | :---------------------- |
| **GET**     | `/products`      | Fetches complete array list of all current records          | None                                                       | `200 OK`                |
| **GET**     | `/products/{id}` | Fetches a target product matching index primary keys        | None                                                       | `200 OK`                |
| **POST**    | `/products`      | Persists a new item to relational inventory tables          | JSON representation containing metadata fields (omit `id`) | `201 Created`           |
| **PUT**     | `/products/{id}` | Updates details of an item matching target ID variables     | Full updated JSON representation payload details           | `200 OK`                |
| **DELETE**  | `/products/{id}` | Erases specified inventory record matching target parameter | None                                                       | `204 No Content`        |

---

### JSON Payload Template Model Example (POST / PUT)

```
{
  "name": "Gaming Laptop",
  "description": "High performance RTX 4070 laptop",
  "price": 1299.99,
  "quantity": 15
}
```
