-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.27-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for station
CREATE DATABASE IF NOT EXISTS `station` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `station`;


-- Dumping structure for table station.bus
CREATE TABLE IF NOT EXISTS `bus` (
  `BusId` int(11) NOT NULL AUTO_INCREMENT,
  `GovId` varchar(10) NOT NULL,
  `Capacity` int(11) NOT NULL,
  `Title` varchar(15) NOT NULL,
  `Description` varchar(500) NOT NULL,
  PRIMARY KEY (`BusId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table station.bus: ~3 rows (approximately)
DELETE FROM `bus`;
/*!40000 ALTER TABLE `bus` DISABLE KEYS */;
INSERT INTO `bus` (`BusId`, `GovId`, `Capacity`, `Title`, `Description`) VALUES
	(1, '123', 100, '123', '123'),
	(2, 'qwe', 50, 'olo', 'asd'),
	(4, '234', 50, 'olo', 'ololo');
/*!40000 ALTER TABLE `bus` ENABLE KEYS */;


-- Dumping structure for table station.destination
CREATE TABLE IF NOT EXISTS `destination` (
  `DestinationId` int(11) NOT NULL AUTO_INCREMENT,
  `Price` bigint(20) NOT NULL DEFAULT '0',
  `Departure` varchar(50) NOT NULL,
  `Arrive` varchar(50) NOT NULL,
  `Distance` double NOT NULL,
  PRIMARY KEY (`DestinationId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table station.destination: ~1 rows (approximately)
DELETE FROM `destination`;
/*!40000 ALTER TABLE `destination` DISABLE KEYS */;
INSERT INTO `destination` (`DestinationId`, `Price`, `Departure`, `Arrive`, `Distance`) VALUES
	(1, 50, 'qwe', 'asd', 30);
/*!40000 ALTER TABLE `destination` ENABLE KEYS */;


-- Dumping structure for table station.purchase
CREATE TABLE IF NOT EXISTS `purchase` (
  `PurhaseId` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) NOT NULL,
  `RouteId` int(11) NOT NULL,
  `DatePurchased` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`PurhaseId`),
  KEY `FK_purchase_user` (`UserId`),
  KEY `FK_purchase_route` (`RouteId`),
  CONSTRAINT `FK_purchase_route` FOREIGN KEY (`RouteId`) REFERENCES `route` (`RouteId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_purchase_user` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table station.purchase: ~3 rows (approximately)
DELETE FROM `purchase`;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` (`PurhaseId`, `UserId`, `RouteId`, `DatePurchased`) VALUES
	(4, 1, 2, '2015-10-19 14:42:58'),
	(5, 2, 2, '2015-10-19 14:43:01'),
	(6, 3, 2, '2015-10-19 14:43:08');
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;


-- Dumping structure for table station.route
CREATE TABLE IF NOT EXISTS `route` (
  `RouteId` int(11) NOT NULL AUTO_INCREMENT,
  `BusId` int(11) NOT NULL,
  `DestinationId` int(11) NOT NULL,
  `DateStart` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DateEnd` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`RouteId`),
  KEY `FK_route_bus` (`BusId`),
  KEY `FK_route_destination` (`DestinationId`),
  CONSTRAINT `FK_route_bus` FOREIGN KEY (`BusId`) REFERENCES `bus` (`BusId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_route_destination` FOREIGN KEY (`DestinationId`) REFERENCES `destination` (`DestinationId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table station.route: ~2 rows (approximately)
DELETE FROM `route`;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` (`RouteId`, `BusId`, `DestinationId`, `DateStart`, `DateEnd`) VALUES
	(2, 1, 1, '2015-10-19 14:42:41', '2015-10-19 14:42:50'),
	(4, 1, 1, '2015-10-19 15:55:05', '2015-10-22 14:11:21');
/*!40000 ALTER TABLE `route` ENABLE KEYS */;


-- Dumping structure for table station.user
CREATE TABLE IF NOT EXISTS `user` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `Login` varchar(30) NOT NULL,
  `Password` varchar(128) NOT NULL,
  `Rights` varchar(10) NOT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table station.user: ~4 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`UserId`, `Login`, `Password`, `Rights`) VALUES
	(1, 'admin', '123456', 'ROLE_ADMIN'),
	(2, '234', '234', 'ROLE_USER'),
	(3, '345', '345', 'ROLE_USER'),
	(4, 'user', '12dea96fec20593566ab75692c9949596833adc9', 'ROLE_USER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Dumping structure for view station.vbus
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `vbus` (
	`BusId` INT(11) NOT NULL,
	`GovId` VARCHAR(10) NOT NULL COLLATE 'utf8_general_ci',
	`Capacity` INT(11) NOT NULL,
	`Title` VARCHAR(15) NOT NULL COLLATE 'utf8_general_ci',
	`Description` VARCHAR(500) NOT NULL COLLATE 'utf8_general_ci',
	`RouteAmount` BIGINT(21) NULL
) ENGINE=MyISAM;


-- Dumping structure for view station.vroute
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `vroute` (
	`DateStart` TIMESTAMP NOT NULL,
	`DateEnd` TIMESTAMP NOT NULL,
	`BusId` INT(11) NOT NULL,
	`RouteId` INT(11) NOT NULL,
	`DestinationId` INT(11) NOT NULL,
	`left` BIGINT(22) NULL
) ENGINE=MyISAM;


-- Dumping structure for view station.vbus
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `vbus`;
CREATE ALGORITHM=TEMPTABLE DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vbus` AS select `b`.`BusId` AS `BusId`,`b`.`GovId` AS `GovId`,`b`.`Capacity` AS `Capacity`,`b`.`Title` AS `Title`,`b`.`Description` AS `Description`,(select count(`r`.`RouteId`) from `route` `r` where (`r`.`BusId` = `b`.`BusId`)) AS `RouteAmount` from `bus` `b`;


-- Dumping structure for view station.vroute
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `vroute`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vroute` AS select `r`.`DateStart` AS `DateStart`,`r`.`DateEnd` AS `DateEnd`,`r`.`BusId` AS `BusId`,`r`.`RouteId` AS `RouteId`,`r`.`DestinationId` AS `DestinationId`,(`b`.`Capacity` - (select count(`p`.`PurhaseId`) from `purchase` `p` where (`p`.`RouteId` = `r`.`RouteId`))) AS `left` from (`route` `r` join `bus` `b` on((`r`.`BusId` = `b`.`BusId`)));
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
