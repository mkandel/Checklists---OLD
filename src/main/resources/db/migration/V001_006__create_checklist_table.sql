--
-- Copyright (c) 2018. Marc Kandel
--

DROP TABLE IF EXISTS `checklists`.`Checklists`;
CREATE TABLE `checklists`.`Checklists` (
  `id` VARCHAR(36) NOT NULL DEFAULT 'uuid()',
  `name` VARCHAR(55) NOT NULL,
  `createdBy` VARCHAR(36) NOT NULL,
  `updatedBy` VARCHAR(36) NOT NULL,
  `ownedBy` VARCHAR(36) NOT NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `templateId` VARCHAR(36) NOT NULL,
  `active` TINYINT(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC)
  CONSTRAINT FK_Checklists_Users FOREIGN KEY (createdBy) REFERENCES Users (id)
  CONSTRAINT FK_Checklists_Users FOREIGN KEY (updatedBy) REFERENCES Users (id)
  CONSTRAINT FK_Checklists_Users FOREIGN KEY (ownedBy) REFERENCES Users (id)
 )
ENGINE = InnoDB
