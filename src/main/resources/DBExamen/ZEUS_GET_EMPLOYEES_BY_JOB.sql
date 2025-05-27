CREATE DEFINER=`root`@`localhost` PROCEDURE `ZEUS_GET_EMPLOYEES_BY_JOB`(IN p_job_id INT)
BEGIN
    SELECT e.id, e.name, e.last_name, e.birthdate,
           j.id AS job_id, j.name AS job_name, j.salary,
           g.id AS gender_id, g.name AS gender_name
    FROM employees e
    INNER JOIN jobs j ON e.job_id = j.id
    INNER JOIN genders g ON e.gender_id = g.id
    WHERE e.job_id = p_job_id;
END