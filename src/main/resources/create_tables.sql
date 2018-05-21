--
-- Copyright (c) 2018. Marc Kandel
--

CREATE TABLE `Users` (
  `id` varchar(36) NOT NULL DEFAULT 'uuid()',
  `username` varchar(25) NOT NULL,
  `password` varchar(45) NOT NULL,
  `fName` varchar(25) NOT NULL,
  `lName` varchar(25) NOT NULL,
  `email` varchar(55) NOT NULL,
  `type` varchar(10) NOT NULL DEFAULT 'USER',
  `active` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci