DELIMITER |
CREATE
DEFINER=`root`@`localhost`
TRIGGER `checklists`.`Users_BEFORE_INSERT`
BEFORE INSERT ON `checklists`.`Users`
FOR EACH ROW
BEGIN
  IF new.id IS NULL THEN
    SET new.id = uuid();
  END IF;
END;
|

DELIMITER ;
