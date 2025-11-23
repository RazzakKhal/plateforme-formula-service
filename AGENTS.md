# Repository Guidelines

## Project Structure & Module Organization
Formula service Spring Boot module under `src/main/java/com/bookNDrive/formula_service`. We follow a hexagonal layout split into `application`, `configuration`, `domain`, `infrastructure`, and `shared` packages. Tests mirror this structure under `src/test/java`, with fixtures in `src/test/resources`.

### Current Package Layout
- `application`: use-case contracts and orchestration logic (e.g. `service/ManageFormulaService`, `service/port/FormulaCrudUseCase`).
- `configuration`: Spring wiring such as security config, JWT helpers, and explicit bean definitions (e.g. the `FormulaCrudUseCase` bean).
- `domain`: pure core model with aggregates (`models`), domain exceptions, and ports (`ports/out`).
- `infrastructure/inbound/web`: REST adapter containing controllers, transport DTOs, MapStruct mappers, and exception handling.
- `infrastructure/outbound/persistence/jpa`: JPA entity, MapStruct mapper, Spring Data repository interface, and adapter implementing the domain port.
- `shared`: reserved for cross-cutting utilities and constants (currently empty).

Configuration files sit in `src/main/resources` with environment overrides in `application.yaml`; seed data lives in `data.sql`.

## Build, Test & Local Development
Use the Maven wrapper from the repository root. `./mvnw clean install` runs compilation, unit tests, Jacoco, and prepares the Docker image. `./mvnw spring-boot:run` starts the service with the local profile. `./mvnw compile jib:build -Djib.to.image=<registry>/plateforme-autoecole-formula-service:tag` publishes the container image; the CI workflow injects the target tag automatically.

## Coding Style & Naming Conventions
Target Java 17 and prefer Lombok annotations to keep entities concise. Follow package-by-feature structure and keep class names aligned to their roles (`*Controller`, `*UseCase`, `*RepositoryAdapter`). Indent with four spaces, keep line length under 120 characters, favor constructor injection, and use MapStruct for DTO/domain conversion. Rely on IDE auto-formatting or project-level code style files; do not hand-edit generated Lombok methods.

## Testing Guidelines
Write JUnit 5 tests next to the code they cover using `*Tests` suffixes. Seed data goes into `src/test/resources` or dedicated factory helpers. Use the embedded H2 database for repository tests; the provided `application-test.yml` configures it. After changes, run `./mvnw test` and review `target/site/jacoco/index.html`. Aim for meaningful coverage of application services and adapters.

## Commit & Pull Request Guidelines
Keep commits small and focused, using Conventional Commit headers such as `feat:`, `fix:`, or `chore:`. Reference Jira or GitHub issues in the body when relevant. Pull requests must describe the change, highlight configuration impacts, link tracking tickets, and attach screenshots or API payload samples for API surface changes. Confirm CI passes before requesting review.

## Configuration & Security Notes
External secrets (database, JWT) belong in environment variables or Spring Cloud Config; do not commit them to `application.yaml`. Update `application.yaml` only with safe defaults and document required overrides in the PR. Review dependency changes carefully because this service participates in Eureka discovery and the AMQP bus; coordinate rollout with the platform team.
