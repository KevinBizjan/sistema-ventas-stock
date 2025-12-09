# Sistema de Ventas y Control de Stock

Sistema backend desarrollado en **Java + Spring Boot** que permite gestionar ventas, clientes, productos y control automático de stock.

## Tecnologías
- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Spring Security
- Lombok

## Funcionalidades
- Gestión de usuarios y roles (ADMIN, VENDEDOR)
- CRUD de clientes
- CRUD de categorías
- CRUD de productos
- Registro de ventas con:
  - Detalle de productos
  - Cálculo automático del total
  - Descuento automático de stock
- Reportes empresariales:
  - Ventas por día
  - Producto más vendido
  - Cliente con más compras
- API REST probada con Postman

## Endpoints principales
- `/api/clientes`
- `/api/categorias`
- `/api/productos`
- `/api/ventas`
- `/api/reportes/*`

##  Autor
Desarrollado por Kevin – Tecnicatura en Programación
