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
-- Export de la structure de la table jpubdd. map
CREATE TABLE IF NOT EXISTS `map` (
  `idMap` int(11) NOT NULL AUTO_INCREMENT,
  `nameMap` varchar(56) NOT NULL,
  `widthMap` int(11) NOT NULL,
  `heightMap` int(11) NOT NULL,
  PRIMARY KEY (`idMap`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Les données exportées n'étaient pas sélectionnées.
-- Export de la structure de la table jpubdd. sprite
CREATE TABLE IF NOT EXISTS `sprite` (
  `idSprite` int(11) NOT NULL AUTO_INCREMENT,
  `charSprite` char(8) NOT NULL,
  PRIMARY KEY (`idSprite`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Les données exportées n'étaient pas sélectionnées.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
