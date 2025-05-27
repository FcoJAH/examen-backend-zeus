CREATE DEFINER=`root`@`localhost` PROCEDURE `ZEUS_JOB_EXISTS`(
    IN p_job_id INT,
    OUT p_exists BOOLEAN
)
BEGIN
    DECLARE total INT;
    SELECT COUNT(*) INTO total FROM jobs WHERE id = p_job_id;
    SET p_exists = total > 0;
END