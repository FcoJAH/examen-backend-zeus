CREATE DEFINER=`root`@`localhost` PROCEDURE `ZEUS_INSERT_EMPLOYEE`(
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
END