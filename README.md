# Product CRUD Example

A lightweight, modern RESTful API built with **Spring Boot 3.x** and **Java 21** for managing an in-memory product inventory catalog. This project serves as a foundational baseline application demonstrating essential CRUD (Create, Read, Update, Delete) architecture patterns, REST mapping conventions, and structured JSON data serialization via Jackson and Lombok.

---

## 🛠️ Tech Stack & Prerequisites

- **Runtime Environment:** Java JDK 21
- **Framework:** Spring Boot 3.5.14 (Web Starter)
- **Build Tool & Lifecycle Management:** Apache Maven (via Maven Wrapper `./mvnw`)
- **Boilerplate Optimization:** Project Lombok (Requires Lombok plugin enabled in your IDE)
- **Data Layer:** Non-persistent context (`ArrayList` In-Memory Storage)

---

## 🏗️ Architecture Design

The system leverages a clear Separation of Concerns (SoC) pattern mapping HTTP transport layers cleanly down to object instances:

```text
 Client (Postman/ThunderClient) ──[HTTP Request]──>  ProductController
                                                    │
                                        (In-Memory List Operations)
                                                    ▼
                                             Product Model
```

---

## 📂 Project Structure Reference

```
PRODUCT-CRUD-EXAMPLE (Root Repository Workspace)
├── product-crud-assignment
│   ├── .mvn/
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── example
│   │   │   │           └── product_crud_assignment
│   │   │   │               ├── Product.java
│   │   │   │               ├── ProductController.java
│   │   │   │               └── ProductCrudAssignmentApplication.java
│   │   │   └── resources
│   │   │       └── application.properties
│   │   └── test/
│   ├── mvnw
│   ├── mvnw.cmd
│   └── pom.xml
└── README.md
```

## 🚀 Installation & Build Lifecycle

Follow these steps to clean, compile, and execute the binaries locally.

1. Navigate to the Project Folder
   Ensure your shell path is situated within the specific directory containing the pom.xml configuration framework:
   `cd product-crud-assignment`

2. Clean and Package Compilation
   Execute a clean compilation cycle using the local Maven Wrapper utility. This wipes previous target layers, validates dependency graphs, compiles production-ready classes, and packages output bundles:
   `./mvnw clean package`

3. Initialize Runtime Server
   Boot up the integrated embedded Tomcat application server (configured to bind to communication channel port 8080 by default):
   `./mvnw spring-boot:run`
