
CREATE DATABASE IF NOT EXISTS `Projet`;

USE `Projet`;

DELIMITER $$

DROP PROCEDURE IF EXISTS `LevelSelect`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `LevelSelect` (IN `niveau` INT(8))  BEGIN
SELECT* FROM map WHERE map.ID = niveau;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `map`
--

DROP TABLE IF EXISTS `map`;
CREATE TABLE IF NOT EXISTS `map` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Level` longtext COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `map`
--

INSERT INTO `map` (`ID`, `Level`) VALUES
(1, 'WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW\nWPDDDDDDDDDDDDDDDDDDDDDDDDDDDW\nWDDDDDDDDDDDDDDDDDDDDDDDDDDDDW\nWDDDDDDDDDDDDDDDDSDSDSDSDDDDDW\nWDDDDDDDDDDDDDDDDDDDDDDDDDDDDW\nWDDDDDDDDDDDDDDDDDDDDDDDDDDDDW\nWDDDD D D D DDDDDDDDDDDDDDDDDW\nWDDDD D D D DDDDDDDDDDDDDDDDDW\nWDDDD D D D DDDDDDDDDDDDDDDDDW\nWDDDDEDEDEDEDDDDDDDDDDDDDDDDDW\nWDDDD D D D DDDDDDDDDDDDDDDDDW\nWDDDD D D D DDDDDDDDDDDDDDDDDW\nWDDDD D D D DDDDDDDDDDDDDDDDDW\nWDDDDDDDDDDDDDDDDDDDDDDDDDDDDW\nWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW\n');


INSERT INTO `map`(`ID`, `Level`) VALUES 
(2,'WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW\nWPDDDDDDDSD DODDDDSDODDSDDDDDW\nWDDDDDDDDDDDDDDDDSSSDDDDDDDDDW\nWDDDDDDDDDDDDDDDDDDDDDDDDDDDDW\nWWWWWWWWWWWWWWWWWWWWWWWSDSDDDW\nWD DDDDDDSOSDDDDDDDDDDDSDDSDDW\nWDODDSDDDDSDDDDDDDDDDDDSDSSDDW\nWDDSDDDDDDDDDDDDDDSDDDDDDDDSDW\nWDDDDSSDDDDDDSDDDDDSDDDDDDSDOW\nWDSDDSOWWWWWWWWWWWWWWWWWWWWWWW\nWDDDDSDDDDDDDDDDDDDDDDDDDSDDDW\nWDDDDDSDDDDDDSDDDDDDDDDDDSOSDW\nWSSSDDDDDSDDSDDDDDDDDDDDDSSDDW\nWDODSDDDSDDDDDODDDDDDSDDDDDDTW\nWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW\n');
COMMIT;