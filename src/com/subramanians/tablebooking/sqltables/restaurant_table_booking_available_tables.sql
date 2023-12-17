-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: restaurant_table_booking
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `available_tables`
--

DROP TABLE IF EXISTS `available_tables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `available_tables` (
  `Date` date NOT NULL,
  `restaurantName` varchar(155) NOT NULL,
  `availableTable` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `available_tables`
--

LOCK TABLES `available_tables` WRITE;
/*!40000 ALTER TABLE `available_tables` DISABLE KEYS */;
INSERT INTO `available_tables` VALUES ('2023-12-16','Green Land Restaurant','30'),('2023-12-17','Green Land Restaurant','28'),('2023-12-18','Green Land Restaurant','28'),('2023-12-19','Green Land Restaurant','30'),('2023-12-20','Green Land Restaurant','30'),('2023-12-16','Hari Bhavanam','20'),('2023-12-17','Hari Bhavanam','19'),('2023-12-18','Hari Bhavanam','20'),('2023-12-19','Hari Bhavanam','20'),('2023-12-20','Hari Bhavanam','20'),('2023-12-20','SS Hydrebad Briyani','50'),('2023-12-19','SS Hydrebad Briyani','49'),('2023-12-18','SS Hydrebad Briyani','50'),('2023-12-17','SS Hydrebad Briyani','50'),('2023-12-16','SS Hydrebad Briyani','50');
/*!40000 ALTER TABLE `available_tables` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-18  0:22:39
