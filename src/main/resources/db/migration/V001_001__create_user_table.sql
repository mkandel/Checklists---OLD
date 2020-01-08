/*
 * Copyright (c) 2020. Marc Kandel
 */

--
--

DROP TABLE IF EXISTS `checklists`.`Users`;
CREATE TABLE `checklists`.`Users` (
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
