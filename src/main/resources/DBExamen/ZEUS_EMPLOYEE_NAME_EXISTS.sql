CREATE DEFINER=`root`@`localhost` PROCEDURE `ZEUS_EMPLOYEE_NAME_EXISTS`(
    IN p_name VARCHAR(100),
    IN p_last_name VARCHAR(100),
    OUT p_exists BOOLEAN
)
BEGIN
    DECLARE total INT;
    SELECT COUNT(*) INTO total FROM employees WHERE name = p_name AND last_name = p_last_name;
    SET p_exists = total > 0;
END