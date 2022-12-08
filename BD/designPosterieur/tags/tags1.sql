-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 07 déc. 2022 à 21:29
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `fprojectcolmar`
--

-- --------------------------------------------------------

--
-- Structure de la table `tags`
--

DROP TABLE IF EXISTS `tags`;
CREATE TABLE IF NOT EXISTS `tags` (
  `idTag` int(11) NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  `nom` varchar(50) NOT NULL,
  PRIMARY KEY (`idTag`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tags`
--

INSERT INTO `tags` (`idTag`, `description`, `nom`) VALUES
(1, 'Motifs iconographiques proches', 'Generated1'),
(2, 'Motifs iconographiques proches', 'Generated2'),
(3, 'Motifs iconographiques proches', 'Generated3'),
(4, 'Reproduction quasi-identique. La pointe de la fleur, au centre du A, est plus anguleuse sur le n° 14408 que sur le n° 14491', 'Generated4'),
(5, 'Motifs iconographiques proches', 'Generated5'),
(6, 'Motifs iconographiques proches', 'Generated6'),
(7, 'Motifs iconographiques proches', 'Generated7'),
(8, 'Motifs iconographiques proches', 'Generated8'),
(9, 'Motifs iconographiques proches', 'Generated9'),
(10, 'Motifs iconographiques proches', 'Generated10'),
(11, 'Motifs iconographiques proches', 'Generated11'),
(12, 'Motifs iconographiques proches', 'Generated12'),
(13, 'Motifs iconographiques proches', 'Generated13'),
(14, 'Motifs iconographiques proches', 'Generated14'),
(15, 'Motifs iconographiques proches', 'Generated15'),
(16, 'Motifs iconographiques proches', 'Generated16'),
(17, 'Motifs iconographiques proches', 'Generated17'),
(18, 'Motifs iconographiques proches', 'Generated18'),
(19, 'Motifs iconographiques proches', 'Generated19'),
(20, 'Motifs iconographiques proches', 'Generated20'),
(21, 'Motifs iconographiques proches', 'Generated21'),
(22, 'Motifs iconographiques proches', 'Generated22'),
(23, 'Motifs iconographiques proches', 'Generated23'),
(24, 'Motifs iconographiques proches', 'Generated24'),
(25, 'Motifs iconographiques proches', 'Generated25'),
(26, 'Motifs iconographiques proches', 'Generated26'),
(27, 'Motifs iconographiques proches', 'Generated27'),
(29, 'La marque de Gromors copie celle de Rembolt', 'Generated29'),
(30, 'La marque de Gromors copie celle de Rembolt', 'Generated30'),
(31, 'Motifs iconographiques proches', 'Generated31'),
(32, 'Motifs iconographiques proches', 'Generated32'),
(33, 'Motifs iconographiques proches', 'Generated33'),
(34, 'Motifs iconographiques proches', 'Generated34'),
(35, 'Motifs iconographiques proches', 'Generated35'),
(36, 'Motifs iconographiques proches', 'Generated36'),
(37, 'Motifs iconographiques proches', 'Generated37'),
(38, 'Motifs iconographiques proches', 'Generated38'),
(39, 'Motifs iconographiques proches', 'Generated39'),
(40, 'Motifs iconographiques proches', 'Generated40'),
(41, 'Motifs iconographiques proches', 'Generated41'),
(42, 'Motifs iconographiques proches', 'Generated42'),
(43, 'Motifs iconographiques proches', 'Generated43'),
(44, 'Motifs iconographiques proches', 'Generated44'),
(45, 'Motifs iconographiques proches', 'Generated45'),
(46, 'Motifs iconographiques proches', 'Generated46'),
(47, 'Motifs iconographiques proches', 'Generated47'),
(48, 'Motifs iconographiques proches', 'Generated48'),
(49, 'Motifs iconographiques proches', 'Generated49'),
(50, 'Motifs iconographiques proches', 'Generated50'),
(51, 'Motifs iconographiques proches', 'Generated51'),
(52, 'Motifs iconographiques proches', 'Generated52'),
(53, 'Motifs iconographiques proches', 'Generated53'),
(54, 'Motifs iconographiques proches', 'Generated54'),
(55, 'Motifs iconographiques proches', 'Generated55'),
(56, 'motifs iconographiques proches', 'Generated56'),
(57, 'La marque de Galliot II du Pré semble s&apos;inspirer directement de celle de Francesco Marcolini', 'Generated57'),
(58, 'motifs iconographiques proches', 'Generated58'),
(59, 'motifs iconographiques proches', 'Generated59'),
(60, 'motifs iconographiques proches', 'Generated60'),
(61, 'motifs iconographiques proches', 'Generated61'),
(62, 'motifs iconographiques proches', 'Generated62'),
(63, 'motifs iconographiques proches', 'Generated63'),
(64, 'motifs iconographiques proches', 'Generated64'),
(65, 'motifs iconographiques proches', 'Generated65'),
(66, 'motifs iconographiques proches', 'Generated66'),
(67, 'motifs iconographiques proches', 'Generated67'),
(68, 'motifs iconographiques proches', 'Generated68'),
(69, 'motifs iconographiques proches', 'Generated69'),
(70, 'motifs iconographiques proches', 'Generated70'),
(71, 'Motif iconographique proche', 'Generated71'),
(72, 'motifs iconographiques proches', 'Generated72'),
(73, 'motifs iconographiques proches', 'Generated73'),
(74, 'motifs iconographiques proches', 'Generated74'),
(75, 'motifs iconographiques proches', 'Generated75'),
(76, 'motifs iconographiques proches', 'Generated76'),
(77, 'motifs iconographiques proches', 'Generated77'),
(78, 'motifs iconographiques proches', 'Generated78'),
(79, 'Motif iconographique proche', 'Generated79'),
(80, 'motifs iconographiques proches', 'Generated80'),
(81, 'Motif iconographique proche', 'Generated81'),
(82, 'Motif iconographique proche', 'Generated82'),
(83, 'Motif iconographique proche', 'Generated83'),
(84, 'Motif iconographique proche', 'Generated84'),
(85, 'Il s\'agit en fait du même pied d\'encadrement, sur lequel Guillaume de Bossozel a modifié les initiales', 'Generated85'),
(86, 'Motif iconographique proche : la lettrine de Robert Estienne (Batyr n° 9593) fut fréquemment copiée.', 'Generated86'),
(87, 'Motif iconographique proche', 'Generated87'),
(88, 'Motif iconographique proche', 'Generated88'),
(89, 'Motif iconographique proche', 'Generated89'),
(90, 'Motif iconographique proche', 'Generated90'),
(91, 'Motif iconographique proche', 'Generated91'),
(92, 'Motif iconographique proche', 'Generated92'),
(93, 'Motif iconographique proche', 'Generated93'),
(94, 'Motif iconographique proche', 'Generated94'),
(95, 'Motif iconographique proche', 'Generated95'),
(96, 'Motif iconographique proche', 'Generated96'),
(97, 'Motif iconographique proche', 'Generated97'),
(98, 'Motif iconographique proche', 'Generated98'),
(99, 'Motif iconographique proche', 'Generated99'),
(100, 'Motif iconographique proche', 'Generated100'),
(101, 'Motif iconographique proche', 'Generated101'),
(102, 'Motif iconographique proche', 'Generated102'),
(103, 'Motif iconographique proche', 'Generated103'),
(104, 'Motif iconographique proche', 'Generated104'),
(105, 'Motif iconographique proche', 'Generated105'),
(106, 'Motif iconographique proche', 'Generated106'),
(107, 'Motif iconographique proche', 'Generated107'),
(108, 'Motif iconographique proche', 'Generated108'),
(109, 'Motif iconographique proche', 'Generated109'),
(110, 'Motif iconographique proche', 'Generated110'),
(111, 'Motif iconographique proche', 'Generated111'),
(112, 'Motif iconographique proche', 'Generated112'),
(113, 'Motif iconographique proche', 'Generated113'),
(114, 'Motif iconographique proche', 'Generated114'),
(115, 'Motif iconographique proche', 'Generated115'),
(116, 'Motif iconographique proche', 'Generated116'),
(117, 'Motif iconographique proche', 'Generated117'),
(118, 'Motif iconographique proche', 'Generated118'),
(119, 'Motif iconographique proche', 'Generated119'),
(120, 'Motif iconographique proche', 'Generated120'),
(121, 'Composition identique', 'Generated121');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
