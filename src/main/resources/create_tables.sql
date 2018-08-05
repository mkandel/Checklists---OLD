--
-- Copyright (c) 2018. Marc Kandel
--

CREATE TABLE IF NOT EXISTS `checklists`.`Users` (
  `id` VARCHAR(36) NOT NULL DEFAULT GENERATED ALWAYS AS (UUID()),
  `username` VARCHAR(25) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `fname` VARCHAR(25) NOT NULL,
  `lname` VARCHAR(25) NOT NULL,
  `email` VARCHAR(55) NOT NULL,
  `type` VARCHAR(10) NOT NULL DEFAULT 'USER',
  `active` TINYINT(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC)
 )
ENGINE = InnoDB

DELIMITER ;;
CREATE TRIGGER before_insert_users
BEFORE INSERT ON Users FOR EACH ROW
BEGIN
  IF new.uuid IS NULL THEN
    SET new.uuid = uuid();
  END IF;
END
;;
