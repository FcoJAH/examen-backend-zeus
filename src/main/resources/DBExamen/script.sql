-- Crear base de datos
CREATE DATABASE IF NOT EXISTS zeus_examen;
USE zeus_examen;

-- Catálogo de géneros
CREATE TABLE genders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

-- Catálogo de puestos
CREATE TABLE jobs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    salary DECIMAL(10,2) NOT NULL CHECK (salary > 0)
);

-- Tabla de empleados
CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    birthdate DATE NOT NULL,
    gender_id INT NOT NULL,
    job_id INT NOT NULL,
    UNIQUE(name, last_name), -- No se permite nombre + apellido repetido
    FOREIGN KEY (gender_id) REFERENCES genders(id),
    FOREIGN KEY (job_id) REFERENCES jobs(id)
);

-- Registro de horas trabajadas
CREATE TABLE worked_hours (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL,
    worked_date DATE NOT NULL,
    worked_hours INT NOT NULL CHECK (worked_hours > 0 AND worked_hours <= 20),
    UNIQUE(employee_id, worked_date), -- No duplicar registro por empleado en un mismo día
    FOREIGN KEY (employee_id) REFERENCES employees(id)
);
