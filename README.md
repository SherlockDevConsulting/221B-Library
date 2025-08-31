# 221B Library - Backend

Backend Kotlin + Spring Boot for 221B Library.

## Quick start

Prerequisites: Docker and Docker Compose, JDK 21 (for local runs), Maven 3.9+

- Local run (dev):
  - mvnw.cmd spring-boot:run
  - Open Swagger UI: http://localhost:8080/swagger-ui
  - Health: http://localhost:8080/api/health

- Docker:
  - docker compose up --build
  - App: http://localhost:8080/swagger-ui
  - Postgres exposed on 5432 (user: library, password: library, db: library)

## Architecture (Clean Architecture)
- domain: enterprise rules (pure Kotlin)
- application: use cases (depends on domain only)
- interfaces: controllers and DTOs (Web/API)
- infrastructure: technical adapters (DB, external APIs)

## Tech stack
- Kotlin 2.2.10, Spring Boot 3.5.5, Java 24
- PostgreSQL 16, Flyway
- springdoc-openapi for Swagger UI
- Tests: JUnit Jupiter 5.13.4, MockMvc, MockK 1.14.5

## Scripts
- Build: mvnw.cmd -q -DskipTests package
- Test: mvnw.cmd test
- Coverage report: target/site/jacoco/index.html

## License
MIT