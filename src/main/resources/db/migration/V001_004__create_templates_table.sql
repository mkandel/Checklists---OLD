--
-- Copyright (c) 2018. Marc Kandel
--

DROP TABLE IF EXISTS `checklists`.`ChecklistTemplates`;
CREATE TABLE `checklists`.`ChecklistTemplates` (
  `id` VARCHAR(36) NOT NULL DEFAULT 'uuid()',
  `title` VARCHAR(55) NOT NULL,
  `createdBy` VARCHAR(36) NOT NULL,
  `updatedBy` VARCHAR(36) NOT NULL,
  `ownedBy` VARCHAR(36) NOT NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC)
--   CONSTRAINT FK_ChecklistTemplatesCreateUser_Users FOREIGN KEY (createdBy) REFERENCES Users (id),
--   CONSTRAINT FK_ChecklistsTemplatesUpdateUser_Users FOREIGN KEY (updatedBy) REFERENCES Users (id),
--   CONSTRAINT FK_ChecklistsTemplatesOwnedBy_Users FOREIGN KEY (ownedBy) REFERENCES Users (id)
 )
ENGINE = InnoDB
