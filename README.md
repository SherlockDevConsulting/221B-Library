# 221B Library - Monorepo (Backend + Frontend)

This repository contains:
- Backend: Kotlin + Spring Boot (hexagonal/clean architecture)
- Frontend: TypeScript + Vue 3.5.20 (clean architecture layout)

## Quick start

Prerequisites: Docker and Docker Compose, JDK 21 (for local backend runs), Maven 3.9+, Node 20+ (for local frontend runs)

- Backend (local dev):
  - cd backend && mvnw.cmd spring-boot:run
  - Swagger UI: http://localhost:8080/swagger-ui
  - Health: http://localhost:8080/api/health

- Frontend (local dev):
  - cd frontend
  - npm install
  - npm run dev
  - Open http://localhost:5173 (the app proxies /api/* to http://localhost:8080 by default)

- Docker (full stack):
  - docker compose up --build
  - Backend: http://localhost:8080/swagger-ui
  - Frontend: http://localhost:5173
  - Postgres on 5432 (user: library, password: library, db: library)

## Architecture (Clean/Hexagonal)
- backend/src/main/kotlin/com/library221b
  - domain: business rules, use cases, ports (pure Kotlin)
  - interfaces: HTTP controllers and DTOs (primary adapters)
  - infrastructure: PostgreSQL and other technical adapters (secondary adapters)
  - application: orchestration layer (thin)
- frontend/src
  - domain: pure TS models/services
  - application: use cases orchestrating domain
  - interfaces: web UI (Vue components)
  - infrastructure: HTTP clients, storage, etc.

## Tech stack
- Backend: Kotlin 2.2.10, Spring Boot 3.5.5, Java 24, PostgreSQL 16, Flyway, Spring Data JPA, springdoc-openapi
- Frontend: Vue 3.5.20, Vite 5, TypeScript 5
- Tests: JUnit Jupiter 5.13.4, MockMvc, MockK 1.14.5

## Scripts
- Backend build: (cd backend && mvnw.cmd -q -DskipTests package)
- Backend tests: (cd backend && mvnw.cmd test)
- Coverage report: backend/target/site/jacoco/index.html
- Frontend dev: (cd frontend && npm run dev)
- Frontend build: (cd frontend && npm run build)
- Frontend preview: (cd frontend && npm run preview)

## License
MIT