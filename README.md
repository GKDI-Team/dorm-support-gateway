# dorm-support-gateway

## О сервисе

Единая точка входа: направляет запросы к пользовательскому интерфейсу и серверным сервисам.

**Технологии:** Java, Spring Boot, Spring Cloud Gateway.

**Основные пути:** `/api/v1/auth/**`, `/api/v1/admin/**`, `/api/v1/issues/**`, `/api/v1/categories/**`, `/api/v1/notifications/**` и страницы пользовательского интерфейса.

## Запуск

Из папки `dorm-support-infrastructure`:

```bash
docker compose up --build gateway-service
```

Gateway доступен на http://localhost:8080. Compose также запустит зависимости. Весь проект можно поднять командой `make up` из папки инфраструктуры.

## Документация API

При запущенном сервисе Swagger UI доступен по адресу `/swagger-ui.html`, а описание публичного API Gateway — по адресу `/openapi.yaml`.
