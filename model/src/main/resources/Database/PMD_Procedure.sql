-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           5.7.24 - MySQL Community Server (GPL)
-- SE du serveur:                Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Export de la structure de la base pour jpubdd
CREATE DATABASE IF NOT EXISTS `jpubdd` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `jpubdd`;

-- Export de la structure de la procédure jpubdd. addNewMap
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `addNewMap`(userIdMap INT, userNameMap VARCHAR(50), userWidthMap INT, userHeightMap INT)
BEGIN
	INSERT INTO map (idMap, nameMap, widthMap, heightMap)
	VALUES (userIdMap, userNameMap, userWidthMap, userHeightMap);
END//
DELIMITER ;

-- Export de la structure de la procédure jpubdd. addNewObject
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `addNewObject`(userIdMap INT,userIdSprite  INT, userX INT, userY INT)
BEGIN
	INSERT INTO compose (compose.idSprite, compose.idMap , compose.x, compose.y)
	VALUES (userIdSprite, userIdMap, userX, userY);
END//
DELIMITER ;

-- Export de la structure de la table jpubdd. compose
CREATE TABLE IF NOT EXISTS `compose` (
  `idSprite` int(11) NOT NULL,
  `idMap` int(11) NOT NULL,
  `x` int(11) NOT NULL,
  `y` int(11) NOT NULL,
  KEY `Compose_Map0_FK` (`idMap`),
  KEY `Foreign Key` (`idSprite`,`idMap`),
  CONSTRAINT `Compose_Map0_FK` FOREIGN KEY (`idMap`) REFERENCES `map` (`idMap`),
  CONSTRAINT `Compose_Sprite_FK` FOREIGN KEY (`idSprite`) REFERENCES `sprite` (`idSprite`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Les données exportées n'étaient pas sélectionnées.
-- Export de la structure de la procédure jpubdd. getDimension
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `getDimension`(userIDMap INT)
BEGIN
	SELECT map.heightMap,map.widthMap
	FROM map
	WHERE map.idMap = userIDMAP;
END//
DELIMITER ;

-- Export de la structure de la procédure jpubdd. getLastID
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `getLastID`()
BEGIN
	SELECT MAX(map.idMap)
	FROM map;
END//
DELIMITER ;

-- Export de la structure de la procédure jpubdd. getMap
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `getMap`(userIDMap INT)
BEGIN
	SELECT compose.x,compose.y, sprite.charSprite
	FROM compose
	LEFT JOIN sprite ON compose.idSprite = sprite.idSprite
	WHERE compose.idMap = userIDMAP;
END//
DELIMITER ;

-- Export de la structure de la table jpubdd. map
CREATE TABLE IF NOT EXISTS `map` (
  `idMap` int(11) NOT NULL AUTO_INCREMENT,
  `nameMap` varchar(56) NOT NULL,
  `widthMap` int(11) NOT NULL,
  `heightMap` int(11) NOT NULL,
  PRIMARY KEY (`idMap`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Les données exportées n'étaient pas sélectionnées.
-- Export de la structure de la table jpubdd. sprite
CREATE TABLE IF NOT EXISTS `sprite` (
  `idSprite` int(11) NOT NULL AUTO_INCREMENT,
  `charSprite` char(8) NOT NULL,
  PRIMARY KEY (`idSprite`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Les données exportées n'étaient pas sélectionnées.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
