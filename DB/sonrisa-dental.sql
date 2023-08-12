-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: localhost    Database: sonrisa_dental
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `id` int NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  `staff_id` int DEFAULT NULL,
  `cost` int DEFAULT NULL,
  `status` enum('BOOKED','CANCELLED','IN_TREATMENT','LAB_WORK_ARRIVED','LAB_WORK_SENT','PAID','RESCHEDULED') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4apif2ewfyf14077ichee8g06` (`patient_id`),
  KEY `FK6j70i8k4wu1m1aahlty936m76` (`staff_id`),
  CONSTRAINT `FK4apif2ewfyf14077ichee8g06` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  CONSTRAINT `FK6j70i8k4wu1m1aahlty936m76` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (852,'2023-08-09','12:00','10:30','CROWN',104,3,250,'BOOKED'),(902,'2023-08-11','11:30','10:30','EMERGENCY',102,2,100,'BOOKED'),(952,'2023-08-14','12:00','11:30','CLEANING',102,2,80,'BOOKED'),(1002,'2023-08-14','14:00','13:30','CLEANING',102,2,80,'BOOKED'),(1052,'2023-08-15','14:00','13:30','EXAM',102,2,50,'CANCELLED'),(1202,'2023-08-07','11:30','10:30','EXTRACTION',302,2,150,'BOOKED'),(1203,'2023-08-17','12:00','11:00','EXTRACTION',302,2,150,'BOOKED'),(1204,'2023-08-17','15:30','14:30','EXTRACTION',302,2,150,'BOOKED'),(1205,'2023-08-21','12:00','11:00','EXTRACTION',302,2,150,'BOOKED'),(1206,'2023-08-22','12:00','11:30','CLEANING',302,2,80,'BOOKED'),(1207,'2023-08-07','17:00','15:00','CROWN',302,3,900,'BOOKED'),(1208,'2023-08-31','14:00','13:30','CLEANING',302,102,80,'BOOKED'),(1209,'2023-08-24','12:00','11:30','CLEANING',302,3,80,'BOOKED'),(1210,'2023-08-30','12:00','11:30','CLEANING',302,2,80,'BOOKED'),(1211,'2023-08-07','13:30','13:00','CLEANING',302,3,80,'BOOKED'),(1212,'2023-08-07','09:30','09:00','CLEANING',302,3,80,'BOOKED'),(1213,'2023-08-18','11:30','11:00','CLEANING',302,3,80,'BOOKED'),(1214,'2023-08-23','11:30','11:00','CLEANING',302,102,80,'BOOKED'),(1215,'2023-08-07','10:30','10:00','CLEANING',302,2,80,'BOOKED'),(1216,'2023-08-07','10:30','10:00','CLEANING',302,3,80,'BOOKED'),(1252,'2023-08-24','10:30','09:30','EMERGENCY',302,2,100,'BOOKED'),(1302,'2023-08-08','09:00','08:30','CLEANING',302,2,80,'BOOKED'),(1303,'2023-08-10','12:00','11:00','EXTRACTION',302,2,150,'BOOKED');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointment_seq`
--

DROP TABLE IF EXISTS `appointment_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment_seq`
--

LOCK TABLES `appointment_seq` WRITE;
/*!40000 ALTER TABLE `appointment_seq` DISABLE KEYS */;
INSERT INTO `appointment_seq` VALUES (1401);
/*!40000 ALTER TABLE `appointment_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extra_item`
--

DROP TABLE IF EXISTS `extra_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `extra_item` (
  `id` int NOT NULL,
  `cost` double NOT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `appointment_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc2974uj7jgopg922f0at3a1ms` (`appointment_id`),
  CONSTRAINT `FKc2974uj7jgopg922f0at3a1ms` FOREIGN KEY (`appointment_id`) REFERENCES `appointment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extra_item`
--

LOCK TABLES `extra_item` WRITE;
/*!40000 ALTER TABLE `extra_item` DISABLE KEYS */;
INSERT INTO `extra_item` VALUES (2,4.5,'Floss',NULL),(52,4.5,'Floss',NULL),(102,4.5,'Floss',852),(202,20,'Xray',NULL),(210,5.49,'Curaprox Adult',852),(213,5.49,'Curaprox Adult',852);
/*!40000 ALTER TABLE `extra_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extra_item_seq`
--

DROP TABLE IF EXISTS `extra_item_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `extra_item_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extra_item_seq`
--

LOCK TABLES `extra_item_seq` WRITE;
/*!40000 ALTER TABLE `extra_item_seq` DISABLE KEYS */;
INSERT INTO `extra_item_seq` VALUES (301);
/*!40000 ALTER TABLE `extra_item_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `insurance_number` varchar(255) DEFAULT NULL,
  `insurance_provider` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (102,'maria@gmail.com','R324664','VHI','083554264','15/05/171','Maria',' Acosta',NULL),(104,'conor@gmail.com','OP38383','PRSI','0834552287','08/04/1994','Conor','Maguire',NULL),(152,'nellmag@hotmail.com','3255463','Dental Care','0842355655','21/12/1965','Nell','Murphy',NULL),(202,'diego@hotmail.com','4313525','VHI','0834556697','03/09/2003','Diego','Acosta',NULL),(252,'mgsgd@hotmail.com','3255463','PRSI','0834556697','21/12/1965','Conor','Murphy','test1'),(302,'patient@gmail.com','4313525','PRSI','0834556697','08/04/1994','Conor','Maguire','patient'),(352,'luana@gmail.com',NULL,NULL,NULL,NULL,'Luana',NULL,'luanaceleste'),(353,'luana@gmail.com',NULL,NULL,NULL,NULL,'Luana',NULL,'password'),(354,'luana@gmail.com',NULL,NULL,NULL,NULL,'Luana',NULL,'password'),(355,'luana@gmail.com',NULL,NULL,NULL,NULL,'Luana',NULL,'password'),(356,'luana@gmail.com',NULL,NULL,NULL,NULL,'Luana',NULL,'password'),(402,'ciaran@gmail.com','2538953725B','VHI','086557392','16/08/1996','Ciaran','Maguire','password'),(403,'gustavo@gmail.com','53y3y','PRSI','43t34y','15/08/2000','Gustavo','Lopez','password'),(404,'irlandasan1923@gmail.com',NULL,NULL,NULL,NULL,'Sandra',NULL,'password'),(405,'julia@gmail.com',NULL,NULL,NULL,NULL,'Julia',NULL,'password');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_appointments`
--

DROP TABLE IF EXISTS `patient_appointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_appointments` (
  `patient_id` int NOT NULL,
  `appointments_id` int NOT NULL,
  UNIQUE KEY `UK_eliumj45n5s6lqd325u36mygc` (`appointments_id`),
  KEY `FK9t5466bjrp5l4ikqlwq7my18m` (`patient_id`),
  CONSTRAINT `FK9t5466bjrp5l4ikqlwq7my18m` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  CONSTRAINT `FKt56rrbfnr2fb40bsetck8yp24` FOREIGN KEY (`appointments_id`) REFERENCES `appointment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_appointments`
--

LOCK TABLES `patient_appointments` WRITE;
/*!40000 ALTER TABLE `patient_appointments` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient_appointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_seq`
--

DROP TABLE IF EXISTS `patient_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_seq`
--

LOCK TABLES `patient_seq` WRITE;
/*!40000 ALTER TABLE `patient_seq` DISABLE KEYS */;
INSERT INTO `patient_seq` VALUES (501);
/*!40000 ALTER TABLE `patient_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'practiceManager@sonrisadental.ie','Gustavo','Cova','0834556678','Manager','sonrisa123',NULL),(2,'sandra_lopez@gmail.com','Sandra',' López','0834556678','Dentist',NULL,'Graduated from Universidad Veracruzana, México in 2017. Dr. López specialises in Cosmetic Dentistry and Minimal Invasive Dentistry '),(3,'roxana_calin@gmail.com','Roxana','Calin','0833440096','Dentist','roxanacalin','Graduated from the University of Medicine and Pharmacy Craiova, Romania in 2014. Dr. Calin specialises in Prosthodontics '),(102,'walter_white@gmail.com','Walter','White','0834554628','Dentist',NULL,'Graduated from the University of Arizona, USA in 2006. Dr. White specialises in Oral Surgery and Sedation');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_seq`
--

DROP TABLE IF EXISTS `staff_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_seq`
--

LOCK TABLES `staff_seq` WRITE;
/*!40000 ALTER TABLE `staff_seq` DISABLE KEYS */;
INSERT INTO `staff_seq` VALUES (201);
/*!40000 ALTER TABLE `staff_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'san@gmail.com','sandra','san'),(3,'new@gmail.com','lalo','New'),(52,'lalo@gmail.com','Luis','Castillo');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--

DROP TABLE IF EXISTS `user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;
/*!40000 ALTER TABLE `user_seq` DISABLE KEYS */;
INSERT INTO `user_seq` VALUES (151);
/*!40000 ALTER TABLE `user_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-12 16:46:34
