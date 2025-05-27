CREATE DEFINER=`root`@`localhost` PROCEDURE `ZEUS_GENDER_EXISTS`(
    IN p_gender_id INT,
    OUT p_exists BOOLEAN
)
BEGIN
    DECLARE total INT;
    SELECT COUNT(*) INTO total FROM genders WHERE id = p_gender_id;
    SET p_exists = total > 0;
END