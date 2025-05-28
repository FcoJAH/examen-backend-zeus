# Examen Práctico - Java Backend (Zeus CH)

Este proyecto consiste en el desarrollo de una API RESTful para gestión de empleados y horas trabajadas, utilizando Java con Spring Boot, arquitectura hexagonal, MySQL y procedimientos almacenados exclusivamente para el acceso a datos.

---

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.x
- Maven
- MySQL
- Arquitectura Hexagonal (Clean Architecture)
- OpenAPI (Swagger UI)
- Docker (opcional)

---

## Estructura del proyecto
src/
└── main/
└── java/com/examen/zeuz/
├── domain/ # Modelos y puertos (interfaces)
├── application/ # Casos de uso (servicios)
└── infrastructure/ # Controladores REST y Repositorios
resources/
├── application.properties
├── schema.sql # Estructura y datos almacenados
└── procedures.sql # Catálogos de procedimientos

---

## Requisitos previos

- Java 17+
- Maven 3.8+
- MySQL 8.x
- (Opcional) Docker y Docker Compose

---

## Instrucciones de ejecución

### 1. Clonar repositorio

``bash
git clone https://github.com/tu-usuario/zeus-backend-exam.git
cd zeus-backend-exam

### 2. Crear la base de datos
Puedes ejecutar directamente desde tu cliente SQL los siguientes scripts:

-- schema.sql (estructura + datos)
-- procedure.sql (catálogos de procedures)

USE zeus_examen;
SOURCE schema.sql;
SOURCE procedures.sql;

O si están en src/main/resources, 
Spring Boot los ejecutará automáticamente 
si activas spring.sql.init.mode=always.

### 3. Configura la conexión a MySQL
En src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/zeus_examen
spring.datasource.username=root
spring.datasource.password=TU_PASSWORD

spring.sql.init.mode=always
spring.sql.init.schema-locations=classpath:schema.sql
spring.sql.init.data-locations=classpath:data.sql

### 4. Ejecutar la aplicación
mvn spring-boot:run
La API estará disponible en: http://localhost:8080

### Documentación API (Swagger)
Disponible en:
http://localhost:8080/swagger-ui.html

### Endpoints disponibles
## 1. Registrar empleado

POST /empleados
{
    "name": "Juan",
    "lastName": "Pérez",
    "birthdate": "1983-01-01",
    "genderId": 1,
    "jobId": 1
}

## 2. Registrar horas trabajadas

POST /horas-trabajadas
{
    "employeeId": 1,
    "workedHours": 10,
    "workedDate": "2019-01-01"
}

## 3. Consultar empleados por puesto

POST /empleados/por-puesto
{
    "jobId": 1
}

## 4. Total de horas trabajadas por rango

POST /worked-hours/summary
{
    "employeeId": 1,
    "startDate": "2019-01-01",
    "endDate": "2019-06-30"
}

## 5. Total pagado por rango

POST /payments/summary
{
    "employeeId": 1,
    "startDate": "2019-01-01",
    "endDate": "2019-06-30"
}

### Autor
Desarrollado por: Francisco Javier Alcala Herrera
Examen técnico.
Contacto: alcalaherrerafcoj@gmail.com
