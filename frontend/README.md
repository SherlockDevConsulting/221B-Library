# 221B Library - Frontend

TypeScript + Vue 3.5.20 app following a clean architecture layout.

## Structure (Clean Architecture)
- src/domain: Pure models and domain services (no framework dependencies)
- src/application: Use cases and application services orchestrating domain
- src/interfaces: Primary adapters (web UI components, view models)
- src/infrastructure: Secondary adapters (HTTP clients, persistence)

For now, we ship a minimal Health page under interfaces/web that calls the backend /api/health endpoint.

## Commands
- npm run dev: start Vite dev server (http://localhost:5173)
- npm run build: production build to dist/
- npm run preview: preview the production build
- npm run typecheck: TypeScript type checking

## Configuration
- VITE_API_BASE_URL: base URL of the backend (default http://localhost:8080). Used for the dev proxy.
