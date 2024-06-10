-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 10 juin 2024 à 20:44
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `examen`
--

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE `classe` (
  `idClasse` int(11) NOT NULL,
  `filiere` int(11) DEFAULT NULL,
  `niveau` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`idClasse`, `filiere`, `niveau`) VALUES
(1, 1, 0),
(2, 0, 2),
(3, 2, 2),
(4, 2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `matricule` int(11) NOT NULL,
  `nomComplet` varchar(50) DEFAULT NULL,
  `tuteur` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`matricule`, `nomComplet`, `tuteur`) VALUES
(1, 'Oumar SY', 'Amala'),
(852, 'poiuy oiu', 'mlkjh sdvb'),
(859, 'pourquoi ca', 'je ne sais pas'),
(85698541, 'oiuy oiuy', 'poiuy pokjhg');

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

CREATE TABLE `inscription` (
  `id` int(11) NOT NULL,
  `anneeScolaire` varchar(50) DEFAULT NULL,
  `matricule` int(11) DEFAULT NULL,
  `idClasse` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`id`, `anneeScolaire`, `matricule`, `idClasse`) VALUES
(1, '2024', 1, 2),
(2, '2025', 1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

CREATE TABLE `professeur` (
  `idProfesseur` int(11) NOT NULL,
  `nomComplet` varchar(50) DEFAULT NULL,
  `grade` varchar(25) DEFAULT NULL,
  `nci` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `professeur`
--

INSERT INTO `professeur` (`idProfesseur`, `nomComplet`, `grade`, `nci`) VALUES
(12, 'mlkjh mlkjh', '25', ''),
(13, 'poiu poiu', 'poiuy', '85296341'),
(14, 'birane baila wane', 'ing‚nieur', '789654123');

-- --------------------------------------------------------

--
-- Structure de la table `professeuretclasse`
--

CREATE TABLE `professeuretclasse` (
  `idProfesseurClasse` int(11) NOT NULL,
  `idProfesseur` int(11) DEFAULT NULL,
  `idClasse` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `professeuretclasse`
--

INSERT INTO `professeuretclasse` (`idProfesseurClasse`, `idProfesseur`, `idClasse`) VALUES
(4, 12, 1),
(5, 12, 2),
(6, 12, 2),
(7, 12, 2),
(8, 12, 1),
(9, 12, 2),
(10, 12, 3),
(11, 12, 4),
(12, 12, 2),
(13, 12, 2),
(14, 12, 4),
(15, 13, 1),
(16, 14, 2),
(17, 14, 4);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`idClasse`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`matricule`);

--
-- Index pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD PRIMARY KEY (`id`),
  ADD KEY `matricule` (`matricule`),
  ADD KEY `idClasse` (`idClasse`);

--
-- Index pour la table `professeur`
--
ALTER TABLE `professeur`
  ADD PRIMARY KEY (`idProfesseur`);

--
-- Index pour la table `professeuretclasse`
--
ALTER TABLE `professeuretclasse`
  ADD PRIMARY KEY (`idProfesseurClasse`),
  ADD KEY `idProfesseur` (`idProfesseur`),
  ADD KEY `idClasse` (`idClasse`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `classe`
--
ALTER TABLE `classe`
  MODIFY `idClasse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `matricule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=85698542;

--
-- AUTO_INCREMENT pour la table `inscription`
--
ALTER TABLE `inscription`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `professeur`
--
ALTER TABLE `professeur`
  MODIFY `idProfesseur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `professeuretclasse`
--
ALTER TABLE `professeuretclasse`
  MODIFY `idProfesseurClasse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `classe` (`idClasse`),
  ADD CONSTRAINT `idClasse` FOREIGN KEY (`idClasse`) REFERENCES `classe` (`idClasse`),
  ADD CONSTRAINT `inscription_ibfk_1` FOREIGN KEY (`matricule`) REFERENCES `etudiant` (`matricule`);

--
-- Contraintes pour la table `professeuretclasse`
--
ALTER TABLE `professeuretclasse`
  ADD CONSTRAINT `professeuretclasse_ibfk_1` FOREIGN KEY (`idProfesseur`) REFERENCES `professeur` (`idProfesseur`),
  ADD CONSTRAINT `professeuretclasse_ibfk_2` FOREIGN KEY (`idClasse`) REFERENCES `classe` (`idClasse`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
