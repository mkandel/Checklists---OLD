--
-- Copyright (c) 2018. Marc Kandel
--

CREATE TABLE IF NOT EXISTS `checklists`.`Users` (
  `id` VARCHAR(36) NOT NULL DEFAULT 'uuid()',
  `username` VARCHAR(25) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `fName` VARCHAR(25) NOT NULL,
  `lName` VARCHAR(25) NOT NULL,
  `email` VARCHAR(55) NOT NULL,
  `type` VARCHAR(10) NOT NULL DEFAULT 'USER',
  `active` TINYINT(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC)
 )
ENGINE = InnoDB

CREATE
DEFINER=`root`@`localhost`
TRIGGER `checklists`.`Users_BEFORE_INSERT`
BEFORE INSERT ON `checklists`.`Users`
FOR EACH ROW
BEGIN
  IF new.id IS NULL THEN
    SET new.id = uuid();
  END IF;
END
