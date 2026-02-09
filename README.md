# 🚀 Task Manager REST API

**Spring Boot · Java · JPA · REST · Testing**

## 📌 Project Overview

This project is a **RESTful Task / Account Management API** built with **Spring Boot**.
It demonstrates solid **back-end fundamentals**, clean architecture, and best practices used in real-world Java applications.

The main goal of this project is to showcase my ability to:

* Design REST APIs
* Apply layered architecture
* Handle validation and exceptions
* Write meaningful unit & controller tests
* Build production-ready Spring Boot applications

---

## 🎯 Key Features

* CRUD operations (Create, Read, Update, Delete)
* RESTful API design
* DTO-based request & response handling
* Validation using Jakarta Validation
* Global exception handling
* In-memory & database-ready architecture
* Controller-level testing with MockMvc

---

## 🛠️ Tech Stack

* **Java 21**
* **Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **H2 Database (Development / Testing)**
* **MySQL (Production-ready)**
* **JUnit 5**
* **Mockito**
* **MockMvc**
* **Maven**

---

## 🧱 Project Architecture

The project follows a **Layered Architecture**:

```
Controller → Service → Repository → Database
```

### Package Structure

```
com.example.taskmanager
│
├── controller      // REST Controllers (API Layer)
├── service         // Business Logic
├── repository      // Data Access Layer (JPA)
├── model           // JPA Entities
├── dto             // Request / Response DTOs
├── exception       // Custom Exceptions
├── handler         // Global Exception Handler
```

### Why this architecture?

* Clear separation of concerns
* Easy to test and maintain
* Scalable for future features
* Industry-standard structure

---

## 🔄 DTO Design

### Request DTO

* Used to receive input from clients
* Validated using annotations
* Prevents exposing internal entities

```java
@NotBlank
private String ownerName;

@NotNull
@Min(0)
private Double balance;
```

### Response DTO

* Used to control API output
* Decouples API response from entity structure
* Allows safe evolution of the domain model

---

## ⚠️ Global Exception Handling

All exceptions are handled centrally using `@RestControllerAdvice`.

Handled cases include:

* Resource not found (404)
* Validation errors (400)
* Generic server errors (500)

Example response:

```json
{
  "status": 404,
  "message": "Account not found",
  "timestamp": "2026-02-08T14:17:09"
}
```

---

## 🌐 REST API Endpoints

| Method | Endpoint         | Description             |
| ------ | ---------------- | ----------------------- |
| GET    | `/accounts`      | Get all accounts        |
| GET    | `/accounts/{id}` | Get account by ID       |
| POST   | `/accounts`      | Create new account      |
| PUT    | `/accounts/{id}` | Update existing account |
| DELETE | `/accounts/{id}` | Delete account          |

---

## 🧪 Testing Strategy

Controller-level tests are implemented using **MockMvc**.

What is tested:

* HTTP status codes
* Successful responses
* Validation errors
* Not-found scenarios (404)
* Create & delete operations

Example:

```java
mockMvc.perform(get("/accounts/99"))
       .andExpect(status().isNotFound());
```

Why this matters:

* Ensures API correctness
* Protects against regressions
* Reflects real-world testing practices

---

## 🗄️ Database Configuration

* **H2** is used for development and testing
* **MySQL** configuration is ready for production

The repository layer uses **Spring Data JPA**, allowing:

* Clean data access
* No boilerplate code
* Easy migration between databases

---

## 🚀 How to Run the Project

```bash
mvn clean install
mvn spring-boot:run
```

The API will be available at:

```
http://localhost:8080
```

---

## 🔮 Future Improvements

* Authentication & Authorization (Spring Security)
* Pagination & Sorting
* Swagger / OpenAPI documentation
* Docker support
* Integration tests
* CI/CD pipeline

---

## 👨‍💻 Author

**Ali Al-Jalo**

Java Back-End Developer

Focused on building clean, testable, and scalable Spring Boot applications.

---

## 💡 Why this project matters

This project is not just a CRUD demo.
It reflects **real back-end engineering practices**, clean design decisions, and testing strategies expected from a **Junior–Mid Java Developer**.
