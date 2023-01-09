-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 08 déc. 2022 à 16:43
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
-- Structure de la table `ecrit`
--

DROP TABLE IF EXISTS `ecrit`;
CREATE TABLE IF NOT EXISTS `ecrit` (
  `idAuteur` int(11) NOT NULL,
  `idOuvrage` int(11) NOT NULL,
  PRIMARY KEY (`idAuteur`,`idOuvrage`),
  KEY `ecrit_ouvrage_fk` (`idOuvrage`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ecrit`
--

INSERT INTO `ecrit` (`idAuteur`, `idOuvrage`) VALUES
(2402, 1),
(2, 53),
(12, 54),
(18, 55),
(20, 56),
(5, 57),
(8, 58),
(16, 59),
(6, 60),
(19, 61),
(13, 62),
(19, 63),
(14, 64),
(13, 65),
(5, 66),
(3, 67),
(11, 68),
(17, 69),
(15, 70),
(6, 71),
(7, 72),
(4, 73),
(9, 74),
(10, 75),
(3, 76),
(57, 77),
(62, 78),
(68, 82),
(72, 83),
(74, 84),
(81, 85),
(81, 86),
(83, 87),
(88, 88),
(89, 89),
(92, 90),
(92, 91),
(109, 92),
(2403, 93),
(2403, 94),
(6, 95),
(118, 109),
(119, 110),
(2403, 111),
(115, 112),
(124, 113),
(122, 114),
(2403, 115),
(6, 116),
(120, 117),
(126, 118),
(125, 119),
(130, 120),
(132, 121),
(136, 122),
(138, 123),
(138, 124),
(138, 125),
(138, 126),
(138, 127),
(138, 128),
(139, 129),
(141, 130),
(148, 131),
(151, 132),
(153, 133),
(157, 134),
(160, 135),
(161, 136),
(168, 137),
(169, 138),
(170, 139),
(172, 140),
(175, 141),
(617, 142),
(178, 143),
(178, 144),
(180, 145),
(165, 146),
(163, 147),
(183, 148),
(184, 149),
(189, 150),
(141, 151),
(192, 152),
(194, 153),
(198, 154),
(201, 155),
(205, 156),
(203, 157),
(45, 158),
(45, 159),
(45, 160),
(256, 161),
(260, 162),
(184, 163),
(184, 164),
(263, 165),
(57, 166),
(183, 167),
(183, 168),
(266, 169),
(267, 170),
(6, 171),
(6, 172),
(6, 173),
(6, 174),
(6, 175),
(6, 176),
(6, 177),
(6, 178),
(6, 179),
(6, 180),
(6, 181),
(6, 182),
(6, 183),
(6, 184),
(6, 185),
(189, 186),
(141, 187),
(268, 188),
(291, 189),
(269, 190),
(290, 191),
(269, 192),
(275, 193),
(285, 194),
(66, 195),
(282, 196),
(287, 197),
(276, 198),
(130, 199),
(390, 200),
(272, 201),
(278, 202),
(866, 203),
(283, 204),
(292, 205),
(292, 206),
(292, 207),
(284, 208),
(6, 209),
(293, 210),
(270, 211),
(270, 212),
(277, 213),
(294, 214),
(352, 215),
(279, 216),
(280, 217),
(289, 218),
(274, 219),
(286, 220),
(272, 221),
(273, 222),
(269, 223),
(161, 224),
(288, 225),
(14, 226),
(296, 227),
(215, 228),
(295, 229),
(297, 230),
(298, 231),
(299, 232),
(521, 233),
(304, 234),
(305, 235),
(305, 236),
(2403, 237),
(2403, 238),
(307, 239),
(306, 240),
(6, 241),
(370, 242),
(372, 243),
(372, 244),
(372, 245),
(373, 246),
(394, 247),
(14, 248),
(374, 249),
(375, 250),
(376, 251),
(377, 252),
(373, 254),
(373, 255),
(412, 256),
(413, 257),
(414, 258),
(415, 259),
(277, 260),
(416, 261),
(441, 262),
(418, 263),
(419, 264),
(456, 265),
(260, 266),
(468, 267),
(472, 268),
(475, 269),
(470, 270),
(467, 271),
(474, 272),
(463, 273),
(463, 274),
(464, 275),
(478, 276),
(478, 277),
(478, 278),
(6, 280),
(471, 281),
(464, 282),
(289, 283),
(466, 284),
(465, 285),
(1098, 285),
(473, 286),
(476, 287),
(486, 288),
(6, 290),
(502, 292),
(501, 294),
(76, 295),
(76, 296),
(504, 297),
(505, 298),
(2404, 299),
(507, 300),
(503, 301),
(514, 302),
(515, 303),
(516, 304),
(517, 305),
(521, 306),
(126, 311),
(521, 312),
(530, 313),
(14, 314),
(532, 315),
(277, 316),
(306, 317),
(537, 318),
(194, 319),
(543, 322),
(545, 323),
(367, 324),
(6, 325),
(550, 326),
(2405, 327),
(555, 328),
(555, 329),
(259, 330),
(562, 331),
(289, 332),
(7, 333),
(7, 334),
(7, 335),
(7, 336),
(7, 337),
(7, 338),
(7, 339),
(7, 340),
(565, 341),
(170, 342),
(130, 343),
(570, 344),
(130, 345),
(130, 346),
(130, 347),
(130, 348),
(130, 349),
(572, 350),
(645, 351),
(645, 352),
(574, 353),
(576, 354),
(141, 355),
(579, 356),
(286, 357),
(580, 358),
(581, 359),
(582, 360),
(583, 361),
(286, 362),
(584, 363),
(585, 364),
(586, 365),
(587, 366),
(599, 367),
(558, 368),
(306, 455),
(601, 456),
(537, 457),
(609, 458),
(467, 459),
(57, 460),
(178, 461),
(530, 462),
(530, 463),
(616, 464),
(617, 465),
(620, 466),
(308, 467),
(1369, 467),
(308, 468),
(1369, 468),
(624, 469),
(626, 470),
(499, 471),
(630, 472),
(277, 473),
(291, 474),
(635, 475),
(640, 476),
(558, 477),
(7, 478),
(57, 479),
(644, 480),
(645, 481),
(645, 482),
(130, 483),
(651, 484),
(653, 485),
(656, 486),
(188, 487),
(659, 488),
(664, 489),
(665, 490),
(306, 491),
(668, 492),
(1294, 492),
(175, 493),
(554, 494),
(670, 495),
(670, 496),
(306, 497),
(674, 498),
(675, 499),
(739, 499),
(679, 500),
(744, 501),
(683, 502),
(686, 503),
(687, 504),
(175, 505),
(306, 506),
(690, 507),
(203, 508),
(203, 509),
(702, 510),
(705, 511),
(704, 512),
(706, 513),
(687, 514),
(131, 515),
(617, 516),
(713, 517),
(714, 518),
(2406, 519),
(717, 520),
(719, 521),
(720, 522),
(746, 523),
(721, 524),
(723, 525),
(727, 526),
(730, 527),
(731, 528),
(7, 529),
(734, 530),
(734, 531),
(734, 532),
(734, 533),
(735, 534),
(747, 535),
(306, 536),
(756, 537),
(754, 538),
(750, 539),
(626, 540),
(626, 541),
(7, 542),
(687, 543),
(772, 544),
(499, 545),
(770, 547),
(175, 548),
(284, 549),
(57, 550),
(767, 551),
(57, 552),
(295, 553),
(765, 554),
(765, 555),
(765, 556),
(194, 558),
(14, 559),
(7, 560),
(762, 561),
(761, 562),
(740, 563),
(759, 564),
(645, 565),
(645, 566),
(774, 567),
(823, 568),
(746, 569),
(827, 570),
(829, 571),
(831, 572),
(833, 573),
(821, 574),
(823, 575),
(823, 576),
(823, 577),
(859, 578),
(835, 579),
(596, 580),
(838, 581),
(838, 582),
(306, 583),
(306, 584),
(306, 585),
(885, 586),
(740, 587),
(794, 588),
(840, 588),
(130, 589),
(804, 590),
(130, 591),
(116, 592),
(2, 593),
(115, 594),
(807, 595),
(805, 596),
(808, 597),
(45, 598),
(45, 599),
(130, 600),
(813, 601),
(296, 602),
(845, 603),
(296, 604),
(851, 605),
(852, 606),
(390, 607),
(390, 608),
(390, 609),
(854, 610),
(856, 611),
(857, 612),
(894, 613),
(895, 614),
(1033, 615),
(898, 616),
(899, 617),
(900, 618),
(119, 619),
(890, 620),
(734, 621),
(734, 622),
(734, 623),
(734, 624),
(866, 625),
(905, 626),
(19, 627),
(19, 628),
(886, 629),
(803, 630),
(885, 631),
(884, 632),
(305, 633),
(6, 634),
(6, 635),
(906, 636),
(874, 637),
(2030, 637),
(871, 638),
(870, 639),
(212, 640),
(975, 641),
(866, 642),
(57, 643),
(130, 644),
(130, 645),
(864, 646),
(951, 649),
(961, 660),
(983, 661),
(964, 662),
(975, 663),
(975, 664),
(975, 665),
(976, 666),
(976, 667),
(976, 668),
(976, 669),
(964, 670),
(297, 671),
(947, 672),
(617, 673),
(617, 674),
(617, 675),
(979, 676),
(804, 677),
(804, 678),
(804, 679),
(982, 680),
(927, 681),
(57, 682),
(57, 683),
(57, 684),
(57, 685),
(57, 686),
(57, 687),
(996, 688),
(997, 689),
(618, 690),
(927, 691),
(927, 692),
(929, 693),
(1000, 694),
(354, 695),
(1003, 696),
(1003, 697),
(214, 698),
(927, 699),
(932, 700),
(1005, 701),
(1005, 702),
(866, 703),
(804, 704),
(9, 705),
(1013, 706),
(875, 707),
(934, 708),
(158, 709),
(475, 710),
(7, 711),
(1019, 712),
(57, 713),
(463, 714),
(274, 715),
(945, 716),
(943, 717),
(940, 718),
(1029, 719),
(297, 720),
(320, 721),
(1288, 722),
(1033, 723),
(1033, 724),
(1034, 725),
(1035, 726),
(1289, 727),
(1038, 728),
(284, 729),
(1039, 730),
(1041, 731),
(6, 732),
(2407, 733),
(6, 734),
(272, 735),
(351, 736),
(1047, 737),
(1048, 738),
(1048, 739),
(1048, 740),
(1044, 741),
(2408, 742),
(2408, 743),
(2409, 744),
(203, 745),
(1065, 746),
(1067, 747),
(1070, 748),
(1327, 749),
(1327, 750),
(253, 751),
(1077, 752),
(1318, 753),
(893, 754),
(881, 755),
(879, 756),
(878, 757),
(885, 758),
(126, 759),
(126, 760),
(126, 761),
(1021, 762),
(1327, 763),
(1339, 764),
(305, 765),
(305, 766),
(1344, 767),
(126, 768),
(305, 769),
(1475, 866),
(1476, 867),
(1476, 868),
(1476, 869),
(1476, 870),
(717, 872),
(1471, 981),
(1682, 998),
(1473, 1000),
(1689, 1003),
(1693, 1008),
(1518, 1025),
(1738, 1035),
(740, 1036),
(1589, 1037),
(1589, 1038),
(3, 1039);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `ecrit`
--
ALTER TABLE `ecrit`
  ADD CONSTRAINT `ecrit_auteur-fk` FOREIGN KEY (`idAuteur`) REFERENCES `auteurs` (`idAuteur`),
  ADD CONSTRAINT `ecrit_ouvrage_fk` FOREIGN KEY (`idOuvrage`) REFERENCES `ouvrages` (`idOuvrage`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;