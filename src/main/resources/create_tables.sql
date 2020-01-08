/*
 * Copyright (c) 2020. Marc Kandel
 */

--
--
USE `checklists`;
CREATE TABLE IF NOT EXISTS `checklists`.`users` (
  `id` VARCHAR(36) NOT NULL,
  `username` VARCHAR(25) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `fname` VARCHAR(25) NOT NULL,
  `lname` VARCHAR(25) NOT NULL,
  `email` VARCHAR(55) NOT NULL,
  `type` INT NOT NULL DEFAULT 'USER',
  `active` TINYINT(4) NOT NULL DEFAULT '1',
  `last_update` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
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
