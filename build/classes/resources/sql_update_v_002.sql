-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 03-Fev-2018 às 14:23
-- Versão do servidor: 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

ALTER TABLE fisioterapia DROP COLUMN hora;
ALTER TABLE fisioterapia DROP COLUMN data_primeira_fisioterapia;
ALTER TABLE fisioterapia DROP FOREIGN KEY fisioterapia_ibfk_2;
ALTER TABLE fisioterapia DROP COLUMN id_fisioterapeuta_fisioterapia;


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `clinica_life`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `agenda`
--

CREATE TABLE IF NOT EXISTS `agenda` (
  `id_agenda` int(11) NOT NULL AUTO_INCREMENT,
  `id_fisioterapia_agenda` int(11) NOT NULL,
  `id_fisioterapeuta_agenda` int(11) NOT NULL,
  `observacao` text COLLATE utf8_unicode_ci,
  `data_agendamento` datetime NOT NULL,
  PRIMARY KEY (`id_agenda`),
  KEY `paciente_id` (`id_fisioterapia_agenda`,`id_fisioterapeuta_agenda`),
  KEY `id_fisioterapeuta_agenda` (`id_fisioterapeuta_agenda`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=38;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `agenda`
--
ALTER TABLE `agenda`
  ADD CONSTRAINT `fk_agenda_fisioterapia` FOREIGN KEY (`id_fisioterapia_agenda`) REFERENCES `fisioterapia` (`id_fisioterapia`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_agenda_fisioterapeuta` FOREIGN KEY (`id_fisioterapeuta_agenda`) REFERENCES `fisioterapeuta` (`id_fisioterapeuta`) ON DELETE NO ACTION ON UPDATE CASCADE;

-- --------------------------------------------------------

--
-- Estrutura da tabela `horario`
--

CREATE TABLE IF NOT EXISTS `horario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hora` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=22 ;

--
-- Extraindo dados da tabela `horario`
--

INSERT INTO `horario` (`id`, `hora`) VALUES
(1, '07:30:00'),
(2, '08:00:00'),
(3, '08:30:00'),
(4, '09:00:00'),
(5, '09:30:00'),
(6, '10:00:00'),
(7, '10:30:00'),
(8, '11:00:00'),
(9, '13:30:00'),
(10, '14:00:00'),
(11, '14:30:00'),
(12, '15:00:00'),
(13, '15:30:00'),
(14, '16:00:00'),
(15, '16:30:00'),
(16, '17:00:00'),
(17, '17:30:00'),
(18, '18:00:00'),
(19, '18:30:00'),
(20, '19:00:00');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;