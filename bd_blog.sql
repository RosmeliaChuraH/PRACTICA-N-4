-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.27-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.7.0.6850
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para bd_blog
CREATE DATABASE IF NOT EXISTS `bd_blog` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `bd_blog`;

-- Volcando estructura para tabla bd_blog.posts
CREATE TABLE IF NOT EXISTS `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `contenido` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla bd_blog.posts: ~0 rows (aproximadamente)
INSERT INTO `posts` (`id`, `fecha`, `titulo`, `contenido`) VALUES
	(1, '2024-05-16', 'IntroducciÃ³n a Java', 'lenguaje popular para el desarrollo de software'),
	(2, '2024-05-13', 'JAVA EE PATRON DE DISEÃO DAO', 'Apoyan en la separacion de la logica de acceso a datos con la logica de negocio'),
	(3, '2024-05-03', 'Tecnicas para mejorar la concentracion', 'aumentar tu capacidad de concentracion y mejorar tu productividad en el trabajo o los estudios'),
	(4, '2024-05-01', 'Fabulas de Esopo', 'Cuento'),
	(5, '2024-05-08', 'Propuesta de Valor', 'libro');

-- Volcando estructura para tabla bd_blog.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla bd_blog.usuarios: ~0 rows (aproximadamente)
INSERT INTO `usuarios` (`id`, `usuario`, `password`) VALUES
	(1, 'Juan Lopez', '123juan'),
	(2, 'Rosmelia Chura', 'ross1406'),
	(4, 'Fanny Chura', 'Fanny505'),
	(5, 'Oliver Saravia', 'oli003');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
