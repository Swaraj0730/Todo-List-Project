# 📝 TodoManagement

A full-stack **Spring Boot** application for managing TODO tasks. This project demonstrates a complete implementation of a RESTful web application using modern Java and Spring technologies.

## 🚀 Tech Stack

- **Java 21**
- **Spring Boot 3.5.0**
- **Spring Data JPA**
- **Spring Web**
- **Spring Security**
- **ModelMapper**
- **H2 / MySQL Database**
- **Lombok**
- **Springdoc OpenAPI (Swagger)**
- **Maven**

## 🎯 Features

- ✅ Create, update, delete TODO tasks
- 🔒 Secure endpoints with Spring Security
- 📚 Auto-generated API documentation with Swagger UI
- 🧩 Clean separation of controller, service, and repository layers
- 🧪 Includes test dependencies for unit testing
- 💾 Switchable database support (H2 or MySQL)

## 📦 Getting Started

### Clone the Project

```bash
git clone https://github.com/your-username/todomanagement.git

Project Structure
------------------
src
├── main
│   ├── java
│   │   └── com.project.todomanagement
│   │       ├── controller
│   │       ├── service
│   │       ├── repository
│   │       └── model
│   └── resources
│       ├── application.properties
│       └── templates / static
└── test

H2 database default configuration
-----------------------------------
spring.datasource.url=jdbc:h2:mem:todo_db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true

Mysql configuration
--------------------
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update


