CREATE DEFINER=`root`@`localhost` PROCEDURE `ZEUS_TOTAL_HOURS_BY_DATE`(
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
END