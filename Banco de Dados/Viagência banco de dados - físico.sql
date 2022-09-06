-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: viagencia
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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `CPF` varchar(255) NOT NULL,
  `Nome` varchar(255) DEFAULT NULL,
  `Endereco` varchar(255) DEFAULT NULL,
  `Telefone` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CPF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destino`
--

DROP TABLE IF EXISTS `destino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `destino` (
  `Id_Destino` int NOT NULL AUTO_INCREMENT,
  `Pais` varchar(255) DEFAULT NULL,
  `Estado` varchar(255) DEFAULT NULL,
  `Cidade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id_Destino`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destino`
--

LOCK TABLES `destino` WRITE;
/*!40000 ALTER TABLE `destino` DISABLE KEYS */;
/*!40000 ALTER TABLE `destino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel` (
  `Id_Hotel` int NOT NULL AUTO_INCREMENT,
  `Nome` varchar(255) DEFAULT NULL,
  `Endereco` varchar(255) DEFAULT NULL,
  `Qtd_De_Quartos` int DEFAULT NULL,
  `Telefone` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id_Hotel`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quartos`
--

DROP TABLE IF EXISTS `quartos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quartos` (
  `Num_Quarto` int NOT NULL AUTO_INCREMENT,
  `Ocupacao` tinyint(1) DEFAULT NULL,
  `fk_Hotel_Id_Hotel` int DEFAULT NULL,
  PRIMARY KEY (`Num_Quarto`),
  KEY `FK_Quartos_2` (`fk_Hotel_Id_Hotel`),
  CONSTRAINT `FK_Quartos_2` FOREIGN KEY (`fk_Hotel_Id_Hotel`) REFERENCES `hotel` (`Id_Hotel`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quartos`
--

LOCK TABLES `quartos` WRITE;
/*!40000 ALTER TABLE `quartos` DISABLE KEYS */;
/*!40000 ALTER TABLE `quartos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservahotel`
--

DROP TABLE IF EXISTS `reservahotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservahotel` (
  `Id_Reserva_Hotel` int NOT NULL AUTO_INCREMENT,
  `fk_Cliente_CPF` varchar(255) DEFAULT NULL,
  `fk_Hotel_Id_Hotel` int DEFAULT NULL,
  `Quarto` int DEFAULT NULL,
  PRIMARY KEY (`Id_Reserva_Hotel`),
  KEY `FK_ReservaHotel_2` (`fk_Hotel_Id_Hotel`),
  KEY `FK_ReservaHotel_3` (`fk_Cliente_CPF`),
  CONSTRAINT `FK_ReservaHotel_2` FOREIGN KEY (`fk_Hotel_Id_Hotel`) REFERENCES `hotel` (`Id_Hotel`) ON DELETE CASCADE,
  CONSTRAINT `FK_ReservaHotel_3` FOREIGN KEY (`fk_Cliente_CPF`) REFERENCES `cliente` (`CPF`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservahotel`
--

LOCK TABLES `reservahotel` WRITE;
/*!40000 ALTER TABLE `reservahotel` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservahotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservapacote`
--

DROP TABLE IF EXISTS `reservapacote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservapacote` (
  `Id_Reserva_Pacote` int NOT NULL AUTO_INCREMENT,
  `fk_Cliente_CPF` varchar(255) DEFAULT NULL,
  `fk_Destino_Id_Destino` int DEFAULT NULL,
  `fk_ReservaVoo_Id_Reserva_Voo` int DEFAULT NULL,
  `fk_ReservaHotel_Id_Reserva_Hotel` int DEFAULT NULL,
  `Valor` double DEFAULT NULL,
  PRIMARY KEY (`Id_Reserva_Pacote`),
  KEY `FK_ReservaPacote_2` (`fk_ReservaVoo_Id_Reserva_Voo`),
  KEY `FK_ReservaPacote_3` (`fk_Destino_Id_Destino`),
  KEY `FK_ReservaPacote_4` (`fk_ReservaHotel_Id_Reserva_Hotel`),
  KEY `FK_ReservaPacote_5` (`fk_Cliente_CPF`),
  CONSTRAINT `FK_ReservaPacote_2` FOREIGN KEY (`fk_ReservaVoo_Id_Reserva_Voo`) REFERENCES `reservavoo` (`Id_Reserva_Voo`) ON DELETE CASCADE,
  CONSTRAINT `FK_ReservaPacote_3` FOREIGN KEY (`fk_Destino_Id_Destino`) REFERENCES `destino` (`Id_Destino`) ON DELETE CASCADE,
  CONSTRAINT `FK_ReservaPacote_4` FOREIGN KEY (`fk_ReservaHotel_Id_Reserva_Hotel`) REFERENCES `reservahotel` (`Id_Reserva_Hotel`) ON DELETE CASCADE,
  CONSTRAINT `FK_ReservaPacote_5` FOREIGN KEY (`fk_Cliente_CPF`) REFERENCES `cliente` (`CPF`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservapacote`
--

LOCK TABLES `reservapacote` WRITE;
/*!40000 ALTER TABLE `reservapacote` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservapacote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservavoo`
--

DROP TABLE IF EXISTS `reservavoo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservavoo` (
  `Id_Reserva_Voo` int NOT NULL AUTO_INCREMENT,
  `fk_Cliente_CPF` varchar(255) DEFAULT NULL,
  `fk_Voo_Id_Voo` int DEFAULT NULL,
  PRIMARY KEY (`Id_Reserva_Voo`),
  KEY `FK_ReservaVoo_2` (`fk_Voo_Id_Voo`),
  KEY `FK_ReservaVoo_3` (`fk_Cliente_CPF`),
  CONSTRAINT `FK_ReservaVoo_2` FOREIGN KEY (`fk_Voo_Id_Voo`) REFERENCES `voo` (`Id_Voo`) ON DELETE CASCADE,
  CONSTRAINT `FK_ReservaVoo_3` FOREIGN KEY (`fk_Cliente_CPF`) REFERENCES `cliente` (`CPF`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservavoo`
--

LOCK TABLES `reservavoo` WRITE;
/*!40000 ALTER TABLE `reservavoo` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservavoo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voo`
--

DROP TABLE IF EXISTS `voo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voo` (
  `Id_Voo` int NOT NULL AUTO_INCREMENT,
  `Destino` varchar(255) DEFAULT NULL,
  `Data_Voo` date DEFAULT NULL,
  `Companhia` varchar(255) DEFAULT NULL,
  `Aeroporto` varchar(255) DEFAULT NULL,
  `Portao_De_Embarque` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id_Voo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voo`
--

LOCK TABLES `voo` WRITE;
/*!40000 ALTER TABLE `voo` DISABLE KEYS */;
/*!40000 ALTER TABLE `voo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'viagencia'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-06  1:40:29
