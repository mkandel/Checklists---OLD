--/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
--/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
--/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
-- SET NAMES utf8mb4 ;
--/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
--/*!40103 SET TIME_ZONE='+00:00' */;
--/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
--/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
--/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
--/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
--
--DROP TABLE IF EXISTS `Users`;
--/*!40101 SET @saved_cs_client     = @@character_set_client */;
-- SET character_set_client = utf8mb4 ;
--CREATE TABLE `Users` (
--  `id` varchar(36) NOT NULL,
--  `username` varchar(25) NOT NULL,
--  `password` varchar(45) NOT NULL,
--  `fname` varchar(25) NOT NULL,
--  `lname` varchar(25) NOT NULL,
--  `email` varchar(55) NOT NULL,
--  `type` int(11) NOT NULL DEFAULT '3',
--  `active` tinyint(4) NOT NULL DEFAULT '1',
--  PRIMARY KEY (`id`),
--  UNIQUE KEY `id_UNIQUE` (`id`),
--  UNIQUE KEY `username_UNIQUE` (`username`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--/*!40101 SET character_set_client = @saved_cs_client */;
--
--LOCK TABLES `Users` WRITE;
--/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES
('087fb518-a89f-11e8-8361-0d28a1b08eb5','admin','admin','System','Administrator','another.email@here.com',0,1),
('2a86352d-2e36-4ffe-86c4-366f65477b4f','yoyoyo','yoyoyo','Jesse','Pinkman','yoyoyo@email.net',2,1),
('2cadf10e-a8ac-11e8-8361-0d28a1b08eb5','user1','password','User1','User','another.bad.email@nowhere.net',2,1),
('3e3bc760-8c27-47e1-bebf-a401daaf0332','dabossman','kaching','Gustavo','Fring','dabossman@email.net',0,1),
('5ee9579b-46cc-4d27-8b72-536e33a6c873','mrsmooth','mrsmooth','Sy','Tolliver','asdf123qwe__#@',2,1),
('ca4c9718-50f4-411d-a939-a1e0e8934a07','asskicker','cocksucka','Al','Swearengen','SOMERaNd0mstR1ng',1,1),
('e5548c3b-b549-49a4-bdfb-8361cc28cc40','heisenberg','sekrit','Walter','White','some.fake@email.net',0,1),
('e9e9452e-a89e-11e8-8361-0d28a1b08eb5','creator1','password','Creator1','Creator','no.email@here.com',1,1);
--/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
--UNLOCK TABLES;
----
---- WARNING: old server version. The following dump may be incomplete.
----
--DELIMITER ;;
--/*!50003 SET SESSION SQL_MODE="ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION" */;;
--/*!50003 CREATE */ /*!50017 DEFINER=`sa`@`%` */ /*!50003 TRIGGER `Users_BEFORE_INSERT` BEFORE INSERT ON `Users` FOR EACH ROW BEGIN
--  IF new.id IS NULL THEN
--    SET new.id = UUID();
--  END IF;
--END */;;
--DELIMITER ;
--/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
--
--/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
--/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
--/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
--/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
--/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
--/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
--/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
