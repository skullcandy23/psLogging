-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.11-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para logging
CREATE DATABASE IF NOT EXISTS `logging` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci */;
USE `logging`;

-- Volcando estructura para tabla logging.logs
CREATE TABLE IF NOT EXISTS `logs` (
  `id` int(11) NOT NULL,
  `host` varchar(45) DEFAULT NULL,
  `source` varchar(45) DEFAULT NULL,
  `event_name` varchar(45) DEFAULT NULL,
  `severity` enum('DEBUG','INFO','WARN','ERROR') DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `transaction_id` varchar(45) DEFAULT NULL,
  `source_system` varchar(45) DEFAULT NULL,
  `target_system` varchar(45) DEFAULT NULL,
  `metas` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla logging.logs: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `logs` DISABLE KEYS */;
INSERT INTO `logs` (`id`, `host`, `source`, `event_name`, `severity`, `time`, `transaction_id`, `source_system`, `target_system`, `metas`) VALUES
	(1, 'host', 'app name', 'Health Check', 'info', '2020-10-01 10:00:00', 'ff55a400-cd3a-11a8-9a22-06be2c1ae4a4', 'John', 'DCR', 'status : p(\'healthCheck.message\')');
/*!40000 ALTER TABLE `logs` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
