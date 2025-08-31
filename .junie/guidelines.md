# Project Guidelines

These guidelines define how Junie should work on this repository.

## Project structure
- Maven project (pom.xml)
- Kotlin + Spring Boot 3
- Clean Architecture layout under src/main/kotlin/com/library221b:
  - domain
  - application
  - interfaces (web controllers, DTOs)
  - infrastructure
- Config in src/main/resources (application.yml, db/migration for Flyway)
- Tests in src/test/kotlin

## Build and test
- Use Maven Wrapper:
  - Build: mvnw.cmd -q -DskipTests package
  - Run tests: mvnw.cmd test
  - Run app locally: mvnw.cmd spring-boot:run
- Coverage: JaCoCo report at target/site/jacoco/index.html
- A minimal test must pass before submitting changes.

## Docker
- Build and run stack: docker compose up --build
- Services: postgres (db) and app (backend)
- App listens on 8080; Swagger UI at /swagger-ui

## Quality and style
- Kotlin 2.2 language level, JVM target 24
- Prefer pure domain logic without Spring dependencies in domain layer
- Add unit tests for new controllers/use cases; keep tests deterministic (JUnit Jupiter 5.13.4; MockK 1.14.5)
- Use meaningful package names and KDoc on public APIs

## Submissions
- Update README.md if commands or architecture change
- Update these guidelines when you add tools, quality gates, or CI pipelines
