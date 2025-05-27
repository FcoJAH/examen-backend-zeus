CREATE DEFINER=`root`@`localhost` PROCEDURE `ZEUS_INSERT_WORKED_HOURS`(
    IN p_employee_id INT,
    IN p_worked_hours INT,
    IN p_worked_date DATE,
    OUT p_id INT
)
BEGIN
    INSERT INTO worked_hours (employee_id, worked_hours, worked_date)
    VALUES (p_employee_id, p_worked_hours, p_worked_date);

    SET p_id = LAST_INSERT_ID();
END