USE zeus_examen;

-- ==========================================
-- PROCEDURE: Insertar empleado
-- ==========================================
DELIMITER //

CREATE PROCEDURE ZEUS_INSERT_EMPLOYEE(
    IN p_name VARCHAR(100),
    IN p_last_name VARCHAR(100),
    IN p_birthdate DATE,
    IN p_gender_id INT,
    IN p_job_id INT,
    OUT p_id INT
)
BEGIN
    INSERT INTO employees (name, last_name, birthdate, gender_id, job_id)
    VALUES (p_name, p_last_name, p_birthdate, p_gender_id, p_job_id);
    SET p_id = LAST_INSERT_ID();
END //

-- ==========================================
-- PROCEDURE: Insertar horas trabajadas
-- ==========================================
CREATE PROCEDURE ZEUS_INSERT_WORKED_HOURS(
    IN p_employee_id INT,
    IN p_worked_hours INT,
    IN p_worked_date DATE,
    OUT p_id INT
)
BEGIN
    INSERT INTO worked_hours (employee_id, worked_hours, worked_date)
    VALUES (p_employee_id, p_worked_hours, p_worked_date);
    SET p_id = LAST_INSERT_ID();
END //

-- ==========================================
-- PROCEDURE: Verificar existencia de empleado
-- ==========================================
CREATE PROCEDURE ZEUS_EMPLOYEE_EXISTS(
    IN p_employee_id INT,
    OUT p_exists BOOLEAN
)
BEGIN
    DECLARE total INT;
    SELECT COUNT(*) INTO total FROM employees WHERE id = p_employee_id;
    SET p_exists = total > 0;
END //

-- ==========================================
-- PROCEDURE: Verificar existencia de género
-- ==========================================
CREATE PROCEDURE ZEUS_GENDER_EXISTS(
    IN p_gender_id INT,
    OUT p_exists BOOLEAN
)
BEGIN
    DECLARE total INT;
    SELECT COUNT(*) INTO total FROM genders WHERE id = p_gender_id;
    SET p_exists = total > 0;
END //

-- ==========================================
-- PROCEDURE: Verificar existencia de puesto
-- ==========================================
CREATE PROCEDURE ZEUS_JOB_EXISTS(
    IN p_job_id INT,
    OUT p_exists BOOLEAN
)
BEGIN
    DECLARE total INT;
    SELECT COUNT(*) INTO total FROM jobs WHERE id = p_job_id;
    SET p_exists = total > 0;
END //

-- ==========================================
-- PROCEDURE: Verificar si nombre + apellido existen
-- ==========================================
CREATE PROCEDURE ZEUS_EMPLOYEE_NAME_EXISTS(
    IN p_name VARCHAR(100),
    IN p_last_name VARCHAR(100),
    OUT p_exists BOOLEAN
)
BEGIN
    DECLARE total INT;
    SELECT COUNT(*) INTO total FROM employees WHERE name = p_name AND last_name = p_last_name;
    SET p_exists = total > 0;
END //

-- ==========================================
-- PROCEDURE: Verificar si ya hay registro de horas por fecha
-- ==========================================
CREATE PROCEDURE ZEUS_WORKED_DATE_EXISTS(
    IN p_employee_id INT,
    IN p_worked_date DATE,
    OUT p_exists BOOLEAN
)
BEGIN
    DECLARE total INT;
    SELECT COUNT(*) INTO total
    FROM worked_hours
    WHERE employee_id = p_employee_id AND worked_date = p_worked_date;
    SET p_exists = total > 0;
END //

-- ==========================================
-- PROCEDURE: Consultar empleados por puesto
-- ==========================================
CREATE PROCEDURE ZEUS_GET_EMPLOYEES_BY_JOB(IN p_job_id INT)
BEGIN
    SELECT e.id, e.name, e.last_name, e.birthdate,
           j.id AS job_id, j.name AS job_name, j.salary,
           g.id AS gender_id, g.name AS gender_name
    FROM employees e
    INNER JOIN jobs j ON e.job_id = j.id
    INNER JOIN genders g ON e.gender_id = g.id
    WHERE e.job_id = p_job_id;
END //

-- ==========================================
-- PROCEDURE: Obtener total de horas trabajadas por empleado en rango
-- ==========================================
CREATE PROCEDURE ZEUS_TOTAL_HOURS_BY_DATE(
    IN p_employee_id INT,
    IN p_start_date DATE,
    IN p_end_date DATE,
    OUT p_total_hours INT
)
BEGIN
    SELECT SUM(worked_hours)
    INTO p_total_hours
    FROM worked_hours
    WHERE employee_id = p_employee_id
      AND worked_date BETWEEN p_start_date AND p_end_date;
END //

-- ==========================================
-- PROCEDURE: Calcular pago total a empleado en un rango
-- ==========================================
CREATE PROCEDURE ZEUS_GET_EMPLOYEE_PAYMENT(
    IN p_employee_id INT,
    IN p_start_date DATE,
    IN p_end_date DATE,
    OUT p_payment INT
)
BEGIN
    SELECT SUM(w.worked_hours * j.salary)
    INTO p_payment
    FROM worked_hours w
    JOIN employees e ON w.employee_id = e.id
    JOIN jobs j ON e.job_id = j.id
    WHERE w.employee_id = p_employee_id
      AND w.worked_date BETWEEN p_start_date AND p_end_date;
END //

DELIMITER ;
