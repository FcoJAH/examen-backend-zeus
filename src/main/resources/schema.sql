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

-- -------------------------------
-- INSERTAR DATOS DE PRUEBA
-- -------------------------------

-- Géneros
INSERT INTO genders (name) VALUES
('Hombre'),
('Mujer'),
('No Binario'),
('Prefiere no decirlo');

-- Puestos
INSERT INTO jobs (name, salary) VALUES
('Gerente', 100.00),
('Analista', 80.00),
('Desarrollador Backend', 90.00),
('Desarrollador Frontend', 85.00),
('QA Tester', 75.00);

-- Empleados
INSERT INTO employees (name, last_name, birthdate, gender_id, job_id) VALUES
('Juan', 'Pérez', '1980-01-15', 1, 1),
('José', 'López', '1983-03-22', 1, 1),
('Ana', 'García', '1990-07-05', 2, 3),
('Luis', 'Martínez', '1988-11-12', 1, 2);

-- Horas trabajadas (opcional para pruebas)
INSERT INTO worked_hours (employee_id, worked_date, worked_hours) VALUES
(1, '2019-01-02', 8),
(1, '2019-01-03', 6),
(2, '2019-02-01', 7),
(2, '2019-02-02', 5),
(3, '2024-05-25', 8),
(4, '2024-05-25', 4);
