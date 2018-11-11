-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 05-Ago-2017 às 20:55
-- Versão do servidor: 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `clinica_life`
--
CREATE DATABASE IF NOT EXISTS `clinica_life` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `clinica_life`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `avaliacao`
--

CREATE TABLE IF NOT EXISTS `avaliacao` (
  `id_avaliacao` int(11) NOT NULL AUTO_INCREMENT,
  `diag_cli` longtext COLLATE utf8_unicode_ci,
  `diag_fis` longtext COLLATE utf8_unicode_ci,
  `data_avaliacao` date NOT NULL,
  `medico` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_fisioterapeuta_avaliacao` int(11) NOT NULL,
  `id_paciente_avaliacao` int(11) NOT NULL,
  PRIMARY KEY (`id_avaliacao`),
  KEY `id_avaliacao` (`id_avaliacao`),
  KEY `id_fisioterapeuta_avaliacao` (`id_fisioterapeuta_avaliacao`),
  KEY `id_cliente_avaliacao` (`id_paciente_avaliacao`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE IF NOT EXISTS `endereco` (
  `id_endereco` int(11) NOT NULL AUTO_INCREMENT,
  `CEP` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rua` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bairro` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cidade` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `estado` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_endereco`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=18 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `fisioterapeuta`
--

CREATE TABLE IF NOT EXISTS `fisioterapeuta` (
  `id_fisioterapeuta` int(11) NOT NULL AUTO_INCREMENT,
  `fone` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `celular` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `banco` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `agencia` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `digito` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `conta_corrente` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_endereco_fisioterapeuta` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_fisioterapeuta`),
  KEY `id_endereco_fisioterapeuta` (`id_endereco_fisioterapeuta`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `fisioterapia`
--

CREATE TABLE IF NOT EXISTS `fisioterapia` (
  `id_fisioterapia` int(11) NOT NULL AUTO_INCREMENT,
  `qntd` int(11) NOT NULL,
  `data_primeira_fisioterapia` date NOT NULL,
  `hora` time NOT NULL,
  `valor` double(10,2) NOT NULL,
  `id_paciente_fisioterapia` int(11) NOT NULL,
  `id_fisioterapeuta_fisioterapia` int(11) NOT NULL,
  PRIMARY KEY (`id_fisioterapia`),
  KEY `id_fisioterapeuta_fisioterapia` (`id_fisioterapeuta_fisioterapia`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `paciente`
--

CREATE TABLE IF NOT EXISTS `paciente` (
  `id_paciente` int(11) NOT NULL AUTO_INCREMENT,
  `nome_paciente` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `RG` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `CPF` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `fone_paciente` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `celular_paciente` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fone_contato_paciente` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sexo` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `estado_civil` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `data_nasc` date NOT NULL,
  `peso` decimal(5,2) DEFAULT NULL,
  `observacao` longtext COLLATE utf8_unicode_ci,
  `id_endereco_paciente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_paciente`),
  UNIQUE KEY `CPF` (`CPF`),
  KEY `id_endereco_cliente` (`id_endereco_paciente`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome_usuario` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `login` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `senha` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `tipo_usuario` int(11) NOT NULL,
  `id_fisioterapeuta_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `id_fisioterapeuta_usuario` (`id_fisioterapeuta_usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=43 ;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `avaliacao`
--
ALTER TABLE `avaliacao`
  ADD CONSTRAINT `avaliacao_ibfk_1` FOREIGN KEY (`id_fisioterapeuta_avaliacao`) REFERENCES `fisioterapeuta` (`id_fisioterapeuta`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `avaliacao_ibfk_2` FOREIGN KEY (`id_paciente_avaliacao`) REFERENCES `paciente` (`id_paciente`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Limitadores para a tabela `fisioterapeuta`
--
ALTER TABLE `fisioterapeuta`
  ADD CONSTRAINT `fisioterapeuta_ibfk_1` FOREIGN KEY (`id_endereco_fisioterapeuta`) REFERENCES `endereco` (`id_endereco`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `fisioterapia`
--
ALTER TABLE `fisioterapia`
  ADD CONSTRAINT `fisioterapia_ibfk_2` FOREIGN KEY (`id_fisioterapeuta_fisioterapia`) REFERENCES `fisioterapeuta` (`id_fisioterapeuta`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Limitadores para a tabela `paciente`
--
ALTER TABLE `paciente`
  ADD CONSTRAINT `paciente_ibfk_1` FOREIGN KEY (`id_endereco_paciente`) REFERENCES `endereco` (`id_endereco`);

--
-- Limitadores para a tabela `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_fisioterapeuta_usuario`) REFERENCES `fisioterapeuta` (`id_fisioterapeuta`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
