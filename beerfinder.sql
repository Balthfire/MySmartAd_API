-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 07 Novembre 2016 à 10:26
-- Version du serveur :  5.7.9
-- Version de PHP :  5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `beerfinder`
--

-- --------------------------------------------------------

--
-- Structure de la table `bar`
--

DROP TABLE IF EXISTS `bar`;
CREATE TABLE IF NOT EXISTS `bar` (
  `idbar` varchar(50) NOT NULL DEFAULT 'barid',
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `terrasse` tinyint(1) DEFAULT NULL,
  `open_hours` varchar(25) DEFAULT NULL,
  `happy_hours` varchar(25) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `baisseprixhh` int(11) DEFAULT NULL,
  PRIMARY KEY (`idbar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `bar`
--

INSERT INTO `bar` (`idbar`, `name`, `address`, `terrasse`, `open_hours`, `happy_hours`, `longitude`, `latitude`, `baisseprixhh`) VALUES
('Bar1', 'BarTest', 'lskdhg', 1, '15-20', '18-19', 64, 4213, 1),
('Bar2', 'chips', 'sfsgshsgdh2', 0, '15-23', '18-19', 1, 1, 5),
('ChIJ2QG4nQjr9EcRFlfUcPU8GRw', 'Yes', '12 Quai Saint Vincent, Lyon', 0, 'happy_hours', 'open_hours', 4.8192957, 45.7677407, NULL),
('ChIJ34vY6nrr9EcREpwCn2O-nEE', 'City Loisirs', '65 Espace Bourbonnais, Lyon', 0, 'happy_hours', 'open_hours', 4.7975774, 45.7735448, NULL),
('ChIJ3eFVJHTr9EcRVY7ScLQyfuA', 'La Divina', '21 Rue de la Fraternelle, Lyon', 0, 'happy_hours', 'open_hours', 4.8039075, 45.7682274, NULL),
('ChIJ7YT1OQXr9EcRwf8naoZZTik', 'Bistrot du Boulevard', '57 Boulevard de la Croix-Rousse, Lyon', 0, 'happy_hours', 'open_hours', 4.8219346, 45.7733938, NULL),
('ChIJbyVXrW7r9EcRGsKIsKBx-kU', 'Le Bouchon de Vaise', '34 Rue de la Claire, Lyon', 0, 'happy_hours', 'open_hours', 4.804786, 45.779502, NULL),
('ChIJC6Y76Xrr9EcRDfLrkBG0wZI', 'Sound Factory', '65 Rue du Bourbonnais, Lyon', 0, 'happy_hours', 'open_hours', 4.7971697, 45.77353249999999, NULL),
('ChIJFwEyx2_r9EcRocRPTQ2W1tE', 'L''Atelier', '62 Rue Marietton, Lyon', 0, 'happy_hours', 'open_hours', 4.8013709, 45.7759761, NULL),
('ChIJfxf4iXLr9EcRdNhfex_44tQ', 'Au Gré des Jours', '1 Rue du Chapeau Rouge, Lyon', 0, 'happy_hours', 'open_hours', 4.8070797, 45.7738142, NULL),
('ChIJfZs-1Avr9EcROSLKR8cN24U', 'Little Jam', '11 Quai de Pierre-Scize, Lyon', 0, 'happy_hours', 'open_hours', 4.813751000000001, 45.767309, NULL),
('ChIJG4sJ9Qzr9EcRI7oeUix9VNQ', 'La Playa', '32 Quai Arloing, Lyon', 0, 'happy_hours', 'open_hours', 4.811846399999999, 45.77091959999999, NULL),
('ChIJG5A71Avr9EcRXfy0-uW5SBM', 'Sarl Argos', '12 Quai de Pierre-Scize, Lyon', 0, 'happy_hours', 'open_hours', 4.8135749, 45.767394, NULL),
('ChIJI8m063rr9EcRvlmi01gEO2g', 'The Sound Factory', '73 Rue du Bourbonnais, Lyon', 0, 'happy_hours', 'open_hours', 4.796938300000001, 45.77288599999999, NULL),
('ChIJj-DNdXLr9EcRDRBrRB9a3cY', 'Le Bistrot de Vaise', '13 Rue des Tanneurs, Lyon', 0, 'happy_hours', 'open_hours', 4.80622, 45.774494, NULL),
('ChIJKWsnpG7r9EcRn6fXmFEaaSk', 'Phénix Bar', '39 Rue Roger Salengro, Lyon 9e arrondissement', 0, 'happy_hours', 'open_hours', 4.8048351, 45.7786045, NULL),
('ChIJLehZXQjr9EcRFrdpFNAD_k8', 'Interface', '35 Quai de Pierre-Scize, Lyon', 0, 'happy_hours', 'open_hours', 4.817737999999999, 45.766361, NULL),
('ChIJSylK_Hbr9EcRiMEZFW2YSCo', 'Nakamal', '36 Avenue Joannes Masset, Lyon', 0, 'happy_hours', 'open_hours', 4.800866099999999, 45.7680728, NULL),
('ChIJszxvgHLr9EcRJfZoquashEU', 'L''assiette Du Marché', '21 Grande Rue de Vaise, Lyon', 0, 'happy_hours', 'open_hours', 4.8072495, 45.7744803, NULL),
('ChIJuexaZQjr9EcRnagEVgH8HoE', 'l''adresse', '41 Quai de Pierre-Scize, Lyon', 0, 'happy_hours', 'open_hours', 4.8183998, 45.7663073, NULL),
('ChIJw6uh13Pr9EcR4LVXM2noWH8', 'O Jardin', '56 Rue Saint-Pierre de Vaise, Lyon', 0, 'happy_hours', 'open_hours', 4.804075999999999, 45.7718203, NULL),
('ChIJ_aKGx3Pr9EcRw71QPa5Dkuk', 'Caffe e Cuccine', '26 Rue du Sergent Michel Berthet, Lyon', 0, 'happy_hours', 'open_hours', 4.8053031, 45.77144089999999, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `beer`
--

DROP TABLE IF EXISTS `beer`;
CREATE TABLE IF NOT EXISTS `beer` (
  `idbeer` varchar(50) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `idbeertype` int(11) DEFAULT NULL,
  `idorigin` int(11) DEFAULT NULL,
  PRIMARY KEY (`idbeer`),
  KEY `FK_beer_idbeertype` (`idbeertype`),
  KEY `FK_beer_idorigin` (`idorigin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `beer`
--

INSERT INTO `beer` (`idbeer`, `name`, `price`, `description`, `idbeertype`, `idorigin`) VALUES
('beer1', 'Labierenumber1', 5, 'deliciousbeer', 1, 1),
('beer2', 'Labierenumber2', 5.5, 'Delicious beer from another ocuntry', 1, 2),
('beer3', 'Chouffe', 5.5, 'La choufffe', 4, 1),
('beer4', 'Leffe ambrée', 6.5, 'leffe', 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `origin`
--

DROP TABLE IF EXISTS `origin`;
CREATE TABLE IF NOT EXISTS `origin` (
  `idorigin` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idorigin`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `origin`
--

INSERT INTO `origin` (`idorigin`, `name`) VALUES
(1, 'France'),
(2, 'Belgique');

-- --------------------------------------------------------

--
-- Structure de la table `serve`
--

DROP TABLE IF EXISTS `serve`;
CREATE TABLE IF NOT EXISTS `serve` (
  `idbeer` varchar(50) NOT NULL,
  `idbar` varchar(50) NOT NULL,
  PRIMARY KEY (`idbeer`,`idbar`),
  KEY `FK_serve_idbar` (`idbar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `serve`
--

INSERT INTO `serve` (`idbeer`, `idbar`) VALUES
('beer1', 'Bar1'),
('beer4', 'Bar1'),
('beer1', 'Bar2'),
('beer2', 'Bar2'),
('beer4', 'Bar2');

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

DROP TABLE IF EXISTS `type`;
CREATE TABLE IF NOT EXISTS `type` (
  `idbeertype` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idbeertype`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `type`
--

INSERT INTO `type` (`idbeertype`, `name`) VALUES
(1, 'Blonde'),
(2, 'Ambrée'),
(3, 'Blanche'),
(4, 'IPA');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `beer`
--
ALTER TABLE `beer`
  ADD CONSTRAINT `FK_beer_idbeertype` FOREIGN KEY (`idbeertype`) REFERENCES `type` (`idbeertype`),
  ADD CONSTRAINT `FK_beer_idorigin` FOREIGN KEY (`idorigin`) REFERENCES `origin` (`idorigin`);

--
-- Contraintes pour la table `serve`
--
ALTER TABLE `serve`
  ADD CONSTRAINT `FK_serve_idbar` FOREIGN KEY (`idbar`) REFERENCES `bar` (`idbar`),
  ADD CONSTRAINT `FK_serve_idbeer` FOREIGN KEY (`idbeer`) REFERENCES `beer` (`idbeer`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
