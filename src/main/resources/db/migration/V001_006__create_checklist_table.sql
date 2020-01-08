/*
 * Copyright (c) 2020. Marc Kandel
 */

--
--

DROP TABLE IF EXISTS `checklists`.`Checklists`;
CREATE TABLE `checklists`.`Checklists` (
  `id` VARCHAR(36) NOT NULL DEFAULT 'uuid()',
  -- Checklist title will come from the template
  `templateId` VARCHAR(36) NOT NULL,
  `active` TINYINT(4) NOT NULL DEFAULT '1',
  `createdBy` VARCHAR(36) NOT NULL,
  `updatedBy` VARCHAR(36) NOT NULL,
  `ownedBy` VARCHAR(36) NOT NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT FK_ChecklistCreateUser_Users FOREIGN KEY (createdBy) REFERENCES Users (id)
  CONSTRAINT FK_ChecklistsUpdateUser_Users FOREIGN KEY (updatedBy) REFERENCES Users (id)
  CONSTRAINT FK_ChecklistsOwnedBy_Users FOREIGN KEY (ownedBy) REFERENCES Users (id)
  CONSTRAINT FK_ChecklistsTemplateId_Templates FOREIGN KEY (templateId) REFERENCES ChecklistTemplates (id)
 )
ENGINE = InnoDB
