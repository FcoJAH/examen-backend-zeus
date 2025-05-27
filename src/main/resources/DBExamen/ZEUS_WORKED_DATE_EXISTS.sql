CREATE DEFINER=`root`@`localhost` PROCEDURE `ZEUS_WORKED_DATE_EXISTS`(
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
END