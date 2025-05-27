CREATE DEFINER=`root`@`localhost` PROCEDURE `ZEUS_EMPLOYEE_EXISTS`(
    IN p_employee_id INT,
    OUT p_exists BOOLEAN
)
BEGIN
    DECLARE total INT;
    SELECT COUNT(*) INTO total FROM employees WHERE id = p_employee_id;
    SET p_exists = total > 0;
END