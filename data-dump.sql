-- MariaDB dump 10.19-11.1.2-MariaDB, for debian-linux-gnu (aarch64)
--
-- Host: localhost    Database: product-manager
-- ------------------------------------------------------
-- Server version	11.1.2-MariaDB-1:11.1.2+maria~ubu2204

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `active` tinyint(4) NOT NULL DEFAULT 0,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES
(0,1,'Electronics'),
(0,2,'Clothing'),
(0,3,'Books'),
(0,4,'Home & Garden'),
(0,5,'Sports & Outdoors');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `active` tinyint(4) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` float NOT NULL,
  `stock` int(11) NOT NULL,
  `sku` varchar(100) DEFAULT NULL,
  `name` varchar(500) DEFAULT NULL,
  `image` varchar(1000) DEFAULT NULL,
  `description` mediumtext DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES
(1,1,1,799.99,100,'PHN-12345','Phone','https://images.t3n.de/news/wp-content/uploads/2022/11/getimgai-ki-bilder.jpg?class=hero-small','High-end smartphone with great camera'),
(1,2,2,29.99,150,'SRT-12345','Shirt','https://images.t3n.de/news/wp-content/uploads/2022/11/getimgai-ki-bilder.jpg?class=hero-small','Cotton shirt, red color'),
(1,3,3,14.99,80,'BOK-12345','Novel','https://images.t3n.de/news/wp-content/uploads/2022/11/getimgai-ki-bilder.jpg?class=hero-small','Best-selling novel by famous author'),
(1,4,4,499.99,20,'SFA-12345','Sofa','https://images.t3n.de/news/wp-content/uploads/2022/11/getimgai-ki-bilder.jpg?class=hero-small','Comfortable 3-seater sofa'),
(1,5,5,19.99,200,'BAL-12345','Football','https://images.t3n.de/news/wp-content/uploads/2022/11/getimgai-ki-bilder.jpg?class=hero-small','Standard size football for professional matches');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `active` tinyint(4) DEFAULT NULL,
  `channel_id` int(11) NOT NULL,
  `is_admin` bit(1) DEFAULT NULL,
  `product_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(256) DEFAULT NULL,
  `name` varchar(500) DEFAULT NULL,
  `image` varchar(1000) DEFAULT NULL,
  `description` mediumtext DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES
(0,0,'',0,1,'$2a$10$FwBPMLvpHkCEo6wyL64e0eupHsRZRsjzhBS46JOOKEV5ZIWJ0oyl2','admin',NULL,NULL),
(0,0,'\0',0,2,'$2a$10$WOL4xBS.VoycXqNXgjEl.eDHVenKJxaCU6yxlitrFv2tnV8O/YzCS','test1',NULL,NULL),
(0,0,'\0',0,3,'$2a$10$HMpE4tPWEv.yhJHEovfE8OU8qUUbu9w8Ui3DbHtYDR3WacfAILqc6','test2',NULL,NULL),
(0,0,'\0',0,4,'$2a$10$UJFY67wi0OpL2I0EAlIDsujS0RDT8HaIzogNmHCnXv1Qu0./OMVjm','test3',NULL,NULL),
(0,0,'\0',0,5,'$2a$10$DBoANkmAmRyqyEtiRnCYOO.YQL8E93/wVD/FwInK7ISuCjVZbSXtq','test4',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-30 14:42:23
