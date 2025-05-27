CREATE DEFINER=`root`@`localhost` PROCEDURE `ZEUS_GET_EMPLOYEE_PAYMENT`(
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
END