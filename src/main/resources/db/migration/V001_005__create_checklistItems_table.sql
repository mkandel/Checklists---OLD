--
-- Copyright (c) 2018. Marc Kandel
--

DROP TABLE IF EXISTS `checklists`.`ChecklistItems`;
CREATE TABLE `checklists`.`ChecklistItems` (
  `id` VARCHAR(36) NOT NULL DEFAULT 'uuid()',
  `parentChecklistId` VARCHAR(36) NOT NULL,
  `itemText` VARCHAR(55) NOT NULL,
  `completed` TINYINT(4) NOT NULL DEFAULT '0',
  `createdBy` VARCHAR(36) NOT NULL,
  `updatedBy` VARCHAR(36) NOT NULL,
  `ownedBy` VARCHAR(36) NOT NULL,
  `createDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT FK_ChecklistItems_Checklists FOREIGN KEY (parentChecklistId) REFERENCES Checklists (id)
 )
ENGINE = InnoDB
