-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 22/10/2024 às 18:53
-- Versão do servidor: 8.3.0
-- Versão do PHP: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `batalhanaval`
--
CREATE DATABASE IF NOT EXISTS `batalhanaval` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `batalhanaval`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `barco`
--

DROP TABLE IF EXISTS `barco`;
CREATE TABLE IF NOT EXISTS `barco` (
  `id_barco` tinyint NOT NULL AUTO_INCREMENT,
  `nome_barco` char(50) NOT NULL,
  `tamanho` tinyint NOT NULL,
  PRIMARY KEY (`id_barco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `jogada`
--

DROP TABLE IF EXISTS `jogada`;
CREATE TABLE IF NOT EXISTS `jogada` (
  `id_jogada` int NOT NULL AUTO_INCREMENT,
  `id_jogador` int NOT NULL,
  `posicao` tinyint NOT NULL,
  PRIMARY KEY (`id_jogada`),
  KEY `idx_jogador` (`id_jogador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `jogada_barco`
--

DROP TABLE IF EXISTS `jogada_barco`;
CREATE TABLE IF NOT EXISTS `jogada_barco` (
  `id_jogador` int NOT NULL,
  `id_barco` tinyint NOT NULL,
  `posicao` tinyint NOT NULL,
  `atingido` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_jogador`,`id_barco`,`posicao`),
  KEY `id_barco` (`id_barco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `jogador`
--

DROP TABLE IF EXISTS `jogador`;
CREATE TABLE IF NOT EXISTS `jogador` (
  `id_jogador` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `senha` varchar(50) NOT NULL,
  PRIMARY KEY (`id_jogador`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `jogador`
--

INSERT INTO `jogador` (`id_jogador`, `usuario`, `senha`) VALUES
(1, 'Gab', '1234'),
(2, 'Gabriel', '12345'),
(4, 'ggggg', '12345');

-- --------------------------------------------------------

--
-- Estrutura para tabela `partida`
--

DROP TABLE IF EXISTS `partida`;
CREATE TABLE IF NOT EXISTS `partida` (
  `id_partida` int NOT NULL AUTO_INCREMENT,
  `id_jogador1` int NOT NULL,
  `id_jogador2` int NOT NULL,
  `id_sala` tinyint NOT NULL,
  `pontos_jog1` tinyint NOT NULL,
  `pontos_jog2` tinyint NOT NULL,
  PRIMARY KEY (`id_partida`),
  KEY `idx_sala` (`id_sala`),
  KEY `idx_jogador` (`id_jogador2`,`id_jogador1`),
  KEY `id_jogador1` (`id_jogador1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `sala`
--

DROP TABLE IF EXISTS `sala`;
CREATE TABLE IF NOT EXISTS `sala` (
  `id_sala` tinyint NOT NULL AUTO_INCREMENT,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_sala`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `jogada`
--
ALTER TABLE `jogada`
  ADD CONSTRAINT `jogada_ibfk_1` FOREIGN KEY (`id_jogador`) REFERENCES `jogador` (`id_jogador`) ON UPDATE CASCADE;

--
-- Restrições para tabelas `jogada_barco`
--
ALTER TABLE `jogada_barco`
  ADD CONSTRAINT `jogada_barco_ibfk_1` FOREIGN KEY (`id_jogador`) REFERENCES `jogador` (`id_jogador`) ON UPDATE CASCADE,
  ADD CONSTRAINT `jogada_barco_ibfk_2` FOREIGN KEY (`id_barco`) REFERENCES `barco` (`id_barco`) ON UPDATE CASCADE;

--
-- Restrições para tabelas `partida`
--
ALTER TABLE `partida`
  ADD CONSTRAINT `partida_ibfk_1` FOREIGN KEY (`id_sala`) REFERENCES `sala` (`id_sala`) ON UPDATE CASCADE,
  ADD CONSTRAINT `partida_ibfk_2` FOREIGN KEY (`id_jogador1`) REFERENCES `jogador` (`id_jogador`) ON UPDATE CASCADE,
  ADD CONSTRAINT `partida_ibfk_3` FOREIGN KEY (`id_jogador2`) REFERENCES `jogador` (`id_jogador`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
