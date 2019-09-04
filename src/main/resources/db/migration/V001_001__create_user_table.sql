--
-- Copyright (c) 2018. Marc Kandel
--

DROP TABLE IF EXISTS `checklists`.`Users`;
CREATE TABLE `checklists`.`Users` (
  `id` VARCHAR(36) NOT NULL,
  `username` VARCHAR(25) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `fname` VARCHAR(25) NOT NULL,
  `lname` VARCHAR(25) NOT NULL,
  `email` VARCHAR(55) NOT NULL,
  `type` INT NOT NULL DEFAULT 3,
  `active` TINYINT(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC)
 )
ENGINE = InnoDB