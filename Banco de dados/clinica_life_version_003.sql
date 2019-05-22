-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 12-Nov-2018 às 00:04
-- Versão do servidor: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clinica_life`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `CREATE_AVALICAO_IN_CONSULTAS` ()  BEGIN
DECLARE total INT DEFAULT 0;
DECLARE i INT DEFAULT 0;
DECLARE lastID INT DEFAULT 0;
DECLARE paciente_id INT DEFAULT 0;
DECLARE profissional_id INT DEFAULT 0;
DECLARE data_agenda DATE DEFAULT NOW();
DECLARE observacao TEXT DEFAULT "";
SELECT COUNT(*) FROM avaliacao INTO total;
SET i=0;
WHILE i<total DO

	  SELECT id_paciente_avaliacao, id_fisioterapeuta_avaliacao, data_avaliacao, CONCAT(diag_cli, "\n\n", diag_fis) as obs
	  INTO paciente_id, profissional_id, data_agenda, observacao
	  FROM avaliacao LIMIT i,1;

	  INSERT INTO consulta(qntd,valor, paciente_id, procedimento_id) VALUES(1,0.00, paciente_id, 2);
	  SET lastID = LAST_INSERT_ID();

	  INSERT INTO agenda (consulta_id, profissional_id, data_agendamento, observacao) VALUES(lastID, profissional_id, CONCAT(data_agenda, " 07:30:00"), observacao);
	  SET i = i + 1;
	END WHILE;
	End$$

	DELIMITER ;

	-- --------------------------------------------------------

	--
	-- Estrutura da tabela `agenda`
	--

	CREATE TABLE `agenda` (
		  `id_agenda` int(11) NOT NULL,
		  `consulta_id` int(11) DEFAULT NULL,
		  `profissional_id` int(11) DEFAULT NULL,
		  `observacao` text COLLATE utf8_unicode_ci,
		  `data_agendamento` datetime NOT NULL
		) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

		--
		-- Extraindo dados da tabela `agenda`
		--

		INSERT INTO `agenda` (`id_agenda`, `consulta_id`, `profissional_id`, `observacao`, `data_agendamento`) VALUES
		(30, 2, 3, 'testando paciente sem search de luana para margarete kkk ooooooooooi', '2018-01-30 08:00:00'),
		(31, 4, 3, 'kkkkkk', '2018-01-30 10:30:00'),
		(32, 3, 4, 'primeira sessao', '2018-01-31 07:30:00'),
		(33, 3, 4, 'segunda sessao', '2018-01-31 08:00:00'),
		(36, 2, 3, 'oi', '2018-01-30 08:30:00'),
		(37, 4, 2, 'hsu shdsudhs sdhuashdhdsa dusdhusdhhd hwquhwuqh hwuwqhsq hsuwqhsuqwh\nhsu shdsudhs sdhuashdhdsa dusdhusdhhd hwquhwuqh hwuwqhsq hsuwqhsuqwh\nhsu shdsudhs sdhuashdhdsa dusdhusdhhd hwquhwuqh hwuwqhsq hsuwqhsuqwh\nhsu shdsudhs sdhuashdhdsa dusdhusdhhd hwquhwuqh hwuwqhsq hsuwqhsuqwh\nhsu shdsudhs sdhuashdhdsa dusdhusdhhd hwquhwuqh hwuwqhsq hsuwqhsuqwh\nhsu shdsudhs sdhuashdhdsa dusdhusdhhd hwquhwuqh hwuwqhsq hsuwqhsuqwh\nhsu shdsudhs sdhuashdhdsa dusdhusdhhd hwquhwuqh hwuwqhsq hsuwqhsuqwh\nhsu shdsudhs sdhuashdhdsa dusdhusdhhd hwquhwuqh hwuwqhsq hsuwqhsuqwhhsu shdsudhs sdhuashdhdsa dusdhusdhhd hwquhwuqh hwuwqhsq hsuwqhsuqwh\n', '2018-01-31 09:00:00'),
		(38, 2, 3, 'hghgg hjhjjhh', '2018-02-04 07:30:00'),
		(39, 4, 3, 'test november', '2018-11-01 07:30:00'),
		(40, 2, 2, 'kkk', '2018-11-01 07:30:00'),
		(41, 2, 4, 'teste hahah', '2018-11-02 11:00:00'),
		(42, 7, 4, 'Avaliação', '2018-11-04 07:30:00'),
		(43, 9, 2, 'kkk hahahah	kk', '2018-11-04 08:00:00'),
		(44, 5, 2, 'amanhã', '2018-11-05 14:00:00'),
		(45, 11, 3, '1 primeira sessao', '2018-11-04 09:30:00'),
		(46, 12, 3, '', '2017-08-09 00:00:00'),
		(47, 13, 2, 'hahahahah			asasabshabsah absahsb', '2018-11-17 00:00:00'),
		(48, 14, 4, 'hahsassabshabsahb', '2018-11-17 00:00:00'),
		(49, 15, 3, '', '2017-08-02 07:00:00'),
		(50, 16, 2, 'hahahahah			asasabshabsah absahsb', '2018-11-10 07:00:00'),
		(51, 17, 4, 'hahsassabshabsahb', '2018-11-10 07:00:00'),
		(52, 18, 3, '', '2017-08-02 07:00:00'),
		(53, 19, 2, 'hahahah.\nHAHAHA.\nLALALALasasabshabsah absahsb,\nHAHAHA\nLAIS!', '2018-11-10 07:00:00'),
		(54, 20, 4, 'hahsassabshabsahb', '2018-11-10 07:00:00'),
		(55, 21, 3, '\n', '2017-08-02 07:00:00'),
		(56, 22, 2, 'hahahah.\nHAHAHA.\nLALALAL.\nasasabshabsah absahsb,\nHAHAHA.\nLAIS!', '2018-11-10 07:00:00'),
		(57, 23, 4, 'hahsas\nsabshabsahb', '2018-11-10 07:00:00'),
		(58, 24, 3, '\n\n', '2017-08-02 07:00:00'),
		(59, 25, 2, 'hahahah.\nHAHAHA.\nLALALAL.\n\nasasabshabsah absahsb,\nHAHAHA.\nLAIS!', '2018-11-10 07:00:00'),
		(60, 26, 4, 'hahsas\n\nsabshabsahb', '2018-11-10 07:00:00'),
		(61, 27, 3, '\n\n', '2017-08-02 07:30:00'),
		(62, 28, 2, 'hahahah.\nHAHAHA.\nLALALAL.\n\nasasabshabsah absahsb,\nHAHAHA.\nLAIS!', '2018-11-10 07:30:00'),
		(63, 29, 4, 'hahsas\n\nsabshabsahb', '2018-11-10 07:30:00'),
		(64, 11, 3, 'teste', '2018-11-05 09:00:00'),
		(66, 11, 2, 'teste 2', '2018-11-05 08:00:00'),
		(67, 30, 3, 'kakakak', '2018-11-06 09:30:00'),
		(68, 30, 3, 'kakakak', '2018-11-07 09:30:00'),
		(69, 30, 3, 'kakakak', '2018-11-08 09:30:00'),
		(70, 30, 3, 'kakakak', '2018-11-09 09:30:00'),
		(71, 31, 2, 'vai replicar mensalmente', '2018-11-05 10:00:00'),
		(72, 31, 2, 'vai replicar mensalmente', '2018-12-05 10:00:00'),
		(73, 31, 2, 'vai replicar mensalmente', '2019-01-05 10:00:00'),
		(74, 31, 2, 'vai replicar mensalmente', '2019-02-05 10:00:00'),
		(75, 31, 2, 'vai replicar mensalmente', '2019-03-05 10:00:00'),
		(76, 32, 4, 'n vou repetir', '2018-11-05 09:30:00'),
		(77, 34, 2, '1 sem repetir', '2018-11-05 09:30:00'),
		(78, 34, 3, '2 sem repetir', '2018-11-05 09:30:00'),
		(79, 34, 4, '3 sem repetir', '2018-11-05 09:30:00'),
		(80, 34, 3, '4 sem repetir', '2018-11-05 09:30:00'),
		(83, 34, 3, 'repetir', '2018-11-04 09:30:00'),
		(84, 34, 3, 'repetir', '2018-11-11 09:30:00'),
		(85, 34, 3, 'repetir', '2018-11-18 09:30:00'),
		(86, 34, 3, 'repetir', '2018-11-25 09:30:00'),
		(87, 34, 3, 'repetir', '2018-12-02 09:30:00'),
		(88, 34, 3, 'repetir', '2018-12-09 09:30:00'),
		(89, 34, 3, 'repetir', '2018-12-16 09:30:00'),
		(90, 34, 3, 'repetir', '2018-12-23 09:30:00'),
		(91, 34, 3, 'repetir', '2018-12-30 09:30:00'),
		(92, 34, 3, 'repetir', '2019-01-06 09:30:00'),
		(93, 34, 3, 'repetir', '2019-01-13 09:30:00'),
		(94, 34, 3, 'repetir', '2019-01-20 09:30:00'),
		(95, 34, 3, 'repetir', '2019-01-27 09:30:00'),
		(96, 34, 3, 'repetir', '2019-02-03 09:30:00'),
		(97, 34, 3, 'repetir', '2019-02-10 09:30:00'),
		(98, 34, 3, 'repetir', '2019-02-17 09:30:00'),
		(99, 34, 3, 'repetir', '2019-02-24 09:30:00'),
		(100, 34, 3, 'repetir', '2019-03-03 09:30:00'),
		(101, 34, 3, 'repetir', '2019-03-10 09:30:00'),
		(102, 35, 3, 'sem repetir', '2018-11-05 10:30:00'),
		(103, 35, 3, 'repetir 3 vezes', '2018-11-05 10:30:00'),
		(104, 35, 3, 'repetir 3 vezes', '2018-11-06 10:30:00'),
		(105, 35, 3, 'repetir 3 vezes', '2018-11-07 10:30:00'),
		(106, 36, 3, 'repetir 2 vezes - anualmente', '2018-11-08 10:00:00'),
		(107, 36, 3, 'repetir 2 vezes - anualmente', '2019-11-08 10:00:00'),
		(108, 37, 3, '2 vezes - 1 hj e outra daqui 15 dias', '2018-11-05 11:00:00'),
		(109, 37, 3, '2 vezes - 1 hj e outra daqui 15 dias', '2018-11-17 11:00:00'),
		(110, 38, 4, 'repetir 3 vezes a cada 14 dias', '2018-11-05 13:30:00'),
		(111, 38, 4, 'repetir 3 vezes a cada 14 dias', '2018-11-19 13:30:00'),
		(112, 38, 4, 'repetir 3 vezes a cada 14 dias', '2018-12-03 13:30:00'),
		(113, 40, 5, '5 cinco vez por semana', '2018-11-09 09:00:00'),
		(114, 40, 5, '5 cinco vez por semana', '2018-11-16 09:00:00'),
		(115, 40, 5, '5 cinco vez por semana', '2018-11-23 09:00:00'),
		(116, 40, 5, '5 cinco vez por semana', '2018-11-30 09:00:00'),
		(117, 40, 5, '5 cinco vez por semana', '2018-12-07 09:00:00'),
		(118, 39, 2, '11 vezes', '2018-11-09 08:30:00'),
		(119, 39, 2, '11 vezes', '2018-11-10 08:30:00'),
		(120, 39, 2, '11 vezes', '2018-11-11 08:30:00'),
		(121, 39, 2, '11 vezes', '2018-11-12 08:30:00'),
		(122, 39, 2, '11 vezes', '2018-11-13 08:30:00'),
		(123, 39, 2, '11 vezes', '2018-11-14 08:30:00'),
		(124, 39, 2, '11 vezes', '2018-11-15 08:30:00'),
		(125, 39, 2, '11 vezes', '2018-11-16 08:30:00'),
		(126, 39, 2, '11 vezes', '2018-11-17 08:30:00'),
		(127, 39, 2, '11 vezes', '2018-11-18 08:30:00'),
		(128, 39, 2, '11 vezes', '2018-11-19 08:30:00'),
		(129, 41, 2, '3 vezes a cada 15 dias', '2018-11-10 10:00:00'),
		(130, 41, 2, '3 vezes a cada 15 dias', '2018-11-24 10:00:00'),
		(131, 42, 4, '3 vez - 1 por mês', '2018-11-10 14:00:00'),
		(132, 42, 4, '3 vez - 1 por mês', '2018-12-10 14:00:00'),
		(133, 42, 4, '3 vez - 1 por mês', '2019-01-10 14:00:00'),
		(134, 43, 3, '2 vezes - 1 por ano', '2018-11-09 10:00:00'),
		(135, 43, 3, '2 vezes - 1 por ano', '2019-11-09 10:00:00'),
		(136, 44, 3, 'N pode repetir 5 vez, e sim 4. \n\n4 S E M A N A S ', '2018-11-10 18:00:00'),
		(137, 44, 3, 'N pode repetir 5 vez, e sim 4. \n\n4 S E M A N A S ', '2018-11-17 18:00:00'),
		(138, 44, 3, 'N pode repetir 5 vez, e sim 4. \n\n4 S E M A N A S ', '2018-11-24 18:00:00'),
		(139, 44, 3, 'N pode repetir 5 vez, e sim 4. \n\n4 S E M A N A S ', '2018-12-01 18:00:00'),
		(141, 45, 3, '3 dias - n pode repetir no domingo', '2018-11-10 10:30:00'),
		(142, 45, 3, '3 dias - n pode repetir no domingo', '2018-11-12 10:30:00'),
		(143, 45, 3, '3 dias - n pode repetir no domingo', '2018-11-13 10:30:00'),
		(144, 46, 5, 'n repetir no sabado', '2018-11-10 09:00:00'),
		(145, 46, 5, 'n repetir no sabado', '2018-11-12 09:00:00'),
		(146, 46, 5, 'n repetir no sabado', '2018-11-13 09:00:00'),
		(147, 46, 5, 'n repetir no sabado', '2018-11-14 09:00:00'),
		(148, 46, 5, 'n repetir no sabado', '2018-11-15 09:00:00'),
		(149, 46, 5, 'n repetir no sabado', '2018-11-16 09:00:00'),
		(150, 46, 5, 'n repetir no sabado', '2018-11-19 09:00:00'),
		(151, 46, 5, 'n repetir no sabado', '2018-11-20 09:00:00'),
		(152, 46, 5, 'n repetir no sabado', '2018-11-21 09:00:00'),
		(153, 47, 2, 'tem que repetir no sabado', '2018-11-12 14:30:00'),
		(154, 47, 2, 'tem que repetir no sabado', '2018-11-13 14:30:00'),
		(155, 47, 2, 'tem que repetir no sabado', '2018-11-14 14:30:00'),
		(156, 47, 2, 'tem que repetir no sabado', '2018-11-15 14:30:00'),
		(157, 47, 2, 'tem que repetir no sabado', '2018-11-16 14:30:00'),
		(158, 47, 2, 'tem que repetir no sabado', '2018-11-17 14:30:00'),
		(159, 47, 2, 'tem que repetir no sabado', '2018-11-19 14:30:00'),
		(160, 47, 2, 'tem que repetir no sabado', '2018-11-20 14:30:00'),
		(161, 47, 2, 'tem que repetir no sabado', '2018-11-21 14:30:00'),
		(162, 48, 4, 'n pode recorrer no sabado', '2018-11-11 11:00:00'),
		(163, 48, 4, 'n pode recorrer no sabado', '2018-11-12 11:00:00'),
		(164, 48, 4, 'n pode recorrer no sabado', '2018-11-13 11:00:00'),
		(165, 48, 4, 'n pode recorrer no sabado', '2018-11-14 11:00:00'),
		(166, 48, 4, 'n pode recorrer no sabado', '2018-11-15 11:00:00'),
		(167, 48, 4, 'n pode recorrer no sabado', '2018-11-16 11:00:00'),
		(168, 48, 4, 'n pode recorrer no sabado', '2018-11-19 11:00:00'),
		(169, 48, 4, 'n pode recorrer no sabado', '2018-11-20 11:00:00'),
		(170, 48, 4, 'n pode recorrer no sabado', '2018-11-21 11:00:00'),
		(171, 49, 4, 'kkk', '2018-11-23 10:30:00'),
		(172, 49, 4, 'kkk', '2018-11-24 10:30:00'),
		(173, 49, 3, '1 agendamento', '2018-11-26 10:30:00');

		-- --------------------------------------------------------

		--
		-- Estrutura da tabela `avaliacao`
		--

		CREATE TABLE `avaliacao` (
			  `id_avaliacao` int(11) NOT NULL,
			  `diag_cli` longtext COLLATE utf8_unicode_ci,
			  `diag_fis` longtext COLLATE utf8_unicode_ci,
			  `data_avaliacao` date NOT NULL,
			  `medico` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
			  `id_fisioterapeuta_avaliacao` int(11) NOT NULL,
			  `id_paciente_avaliacao` int(11) NOT NULL
			) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

			--
			-- Extraindo dados da tabela `avaliacao`
			--

			INSERT INTO `avaliacao` (`id_avaliacao`, `diag_cli`, `diag_fis`, `data_avaliacao`, `medico`, `id_fisioterapeuta_avaliacao`, `id_paciente_avaliacao`) VALUES
			(1, '', '', '2017-08-02', 'Paulo', 3, 1),
			(2, 'hahahah.\nHAHAHA.\nLALALAL.', 'asasabshabsah absahsb,\nHAHAHA.\nLAIS!', '2018-11-10', 'Lais', 2, 4),
			(3, 'hahsas', 'sabshabsahb', '2018-11-10', 'lais', 4, 10);

			-- --------------------------------------------------------

			--
			-- Estrutura da tabela `consulta`
			--

			CREATE TABLE `consulta` (
				  `id` int(11) NOT NULL,
				  `qntd` int(11) NOT NULL,
				  `valor` double(10,2) NOT NULL,
				  `paciente_id` int(11) NOT NULL,
				  `procedimento_id` int(11) DEFAULT NULL
				) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

				--
				-- Extraindo dados da tabela `consulta`
				--

				INSERT INTO `consulta` (`id`, `qntd`, `valor`, `paciente_id`, `procedimento_id`) VALUES
				(2, 12, 1200.00, 1, 6),
				(3, 2, 500.00, 10, 6),
				(4, 10, 500.00, 19, 6),
				(5, 1, 59.90, 4, 2),
				(6, 2, 59.90, 6, 10),
				(7, 1, 0.00, 20, 12),
				(9, 1, 0.00, 1, 12),
				(10, 1, 0.00, 20, 12),
				(11, 3, 149.97, 6, 4),
				(12, 1, 0.00, 1, 7),
				(13, 1, 0.00, 4, 12),
				(14, 1, 0.00, 10, 12),
				(15, 1, 0.00, 1, 12),
				(16, 1, 0.00, 4, 12),
				(17, 1, 0.00, 10, 12),
				(18, 1, 0.00, 1, 12),
				(19, 1, 0.00, 4, 12),
				(20, 1, 0.00, 10, 12),
				(21, 1, 0.00, 1, 12),
				(22, 1, 0.00, 4, 12),
				(23, 1, 0.00, 10, 12),
				(24, 1, 0.00, 1, 12),
				(25, 1, 0.00, 4, 12),
				(26, 1, 0.00, 10, 12),
				(27, 1, 0.00, 1, 12),
				(28, 1, 0.00, 4, 12),
				(29, 1, 0.00, 10, 12),
				(30, 5, 99.95, 23, 5),
				(31, 5, 149.90, 21, 7),
				(32, 10, 1000.00, 22, 6),
				(33, 2, 49.90, 24, 1),
				(34, 20, 1000.00, 23, 6),
				(35, 4, 49.90, 4, 3),
				(36, 2, 99.99, 3, 8),
				(37, 2, 90.90, 1, 8),
				(38, 3, 149.90, 21, 2),
				(39, 11, 1200.00, 19, 6),
				(40, 5, 199.90, 6, 4),
				(41, 2, 39.90, 3, 1),
				(42, 3, 69.90, 10, 3),
				(43, 2, 99.90, 4, 5),
				(44, 5, 249.90, 20, 8),
				(45, 3, 99.90, 24, 5),
				(46, 10, 1999.90, 23, 6),
				(47, 10, 2299.90, 22, 8),
				(48, 10, 190.00, 21, 2),
				(49, 3, 149.90, 1, 3);

				-- --------------------------------------------------------

				--
				-- Estrutura da tabela `endereco`
				--

				CREATE TABLE `endereco` (
					  `id_endereco` int(11) NOT NULL,
					  `CEP` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
					  `rua` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
					  `bairro` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
					  `cidade` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
					  `estado` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
					  `numero` int(11) DEFAULT NULL
					) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

					--
					-- Extraindo dados da tabela `endereco`
					--

					INSERT INTO `endereco` (`id_endereco`, `CEP`, `rua`, `bairro`, `cidade`, `estado`, `numero`) VALUES
					(7, '83314010', 'Joaquim Simões', 'Jardim Tropical', 'Piraquara', 'PR', 120),
					(9, '83314060', 'Terezina', 'Jardim Tropical', 'Piraquara', 'PR', 234),
					(10, '83314080', 'Iguatu', 'Jardim Tropical', 'Piraquara', 'PR', 25),
					(16, '83314020', 'Carlos Chagas', 'Jardim Tropical', 'Piraquara', 'PR', 123),
					(17, '83314010', 'Joaquim Simões', 'Jardim Tropical', 'Piraquara', 'PR', 120),
					(18, '83314010', 'Joaquim Simões', 'Jardim Tropical', 'Piraquara', 'PR', 1244),
					(19, '83314010', 'Joaquim Simões', 'Jardim Tropical', 'Piraquara', 'PR', 4445),
					(20, '83314010', 'Joaquim Simões', 'Jardim Tropical', 'Piraquara', 'PR', 4445),
					(21, '83314000', 'Governador Valadares', 'Jardim Tropical', 'Piraquara', 'PR', 12),
					(22, '83314010', 'Joaquim Simões', 'Jardim Tropical', 'Piraquara', 'PR', 120),
					(24, '83314060', 'Terezina', 'Jardim Tropical', 'Piraquara', 'PR', 444),
					(25, '83314010', 'Joaquim Simões', 'Jardim Tropical', 'Piraquara', 'PR', 120),
					(26, '83314010', 'Joaquim Simões', 'Jardim Tropical', 'Piraquara', 'PR', 120),
					(28, '83314010', 'Joaquim Simões', 'Jardim Tropical', 'Piraquara', 'PR', 120);

					-- --------------------------------------------------------

					--
					-- Estrutura da tabela `especialidade`
					--

					CREATE TABLE `especialidade` (
						  `id` int(11) NOT NULL,
						  `nome` varchar(255) COLLATE utf8_unicode_ci NOT NULL
						) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

						--
						-- Extraindo dados da tabela `especialidade`
						--

						INSERT INTO `especialidade` (`id`, `nome`) VALUES
						(1, 'Fisioterapeuta'),
						(2, 'Nutricionista'),
						(3, 'Esteticista '),
						(15, 'Urologista'),
						(16, 'Mastologista');

						-- --------------------------------------------------------

						--
						-- Estrutura da tabela `horario`
						--

						CREATE TABLE `horario` (
							  `id` int(11) NOT NULL,
							  `hora` time NOT NULL
							) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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

							-- --------------------------------------------------------

							--
							-- Estrutura da tabela `paciente`
							--

							CREATE TABLE `paciente` (
								  `id_paciente` int(11) NOT NULL,
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
								  `id_endereco_paciente` int(11) DEFAULT NULL
								) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

								--
								-- Extraindo dados da tabela `paciente`
								--

								INSERT INTO `paciente` (`id_paciente`, `nome_paciente`, `RG`, `CPF`, `fone_paciente`, `celular_paciente`, `fone_contato_paciente`, `sexo`, `estado_civil`, `data_nasc`, `peso`, `observacao`, `id_endereco_paciente`) VALUES
								(1, 'Margarete Frigério', '104358519', '09474289921', '4136533773', '', '', 'F', 'Casado(a)', '1967-05-13', '59.00', '', 7),
								(3, 'João da Silva', '34562341', '25177676102', '', '', '', 'M', 'Solteiro(a)', '1985-05-21', '88.00', 'Bonito', 10),
								(4, 'Marcos de Sousa', '2345678', '21423704380', '', '', '', 'M', 'Casado(a)', '1985-05-21', '80.00', NULL, NULL),
								(6, 'Lucas Gabriel da Silva', '103456789', '09973396910', '4136677701', '', '', 'M', 'Casado(a)', '1996-02-04', '70.00', 'Alto, magro, estudante de análise e desenvolvimento de sistemas na UniCuritiba e trabalha atualmente na empres Orbenk como encarregado em um Armazém de Curitiba.', 9),
								(10, 'Luana Frigério de Souza', '2345678901', '77614407512', '4133333333', '', '', 'F', 'Solteiro(a)', '1987-04-11', '53.00', '', 21),
								(19, 'Luana kkkk', '104358519', '31253177627', '', '', '', '', 'Solteiro(a)', '1997-06-03', '0.00', '', NULL),
								(20, 'Teste 1 Paciente com avaliação', '104358519', '86536909054', '', '', '', 'F', 'Casado(a)', '1967-05-13', '0.00', '', NULL),
								(21, 'Paciente 1', '104358519', '78373255087', '4136533773', '', '', '', 'Solteiro(a)', '1967-07-11', '0.00', '', NULL),
								(22, 'Paciente 2', '104358519', '06999407029', '', '', '4199650548', '', 'Solteiro(a)', '1985-05-21', '56.00', 'Paciente 2', NULL),
								(23, 'Paciente 4', '104358519', '38935993042', '4136533773', '', '', 'M', 'Casado(a)', '1987-02-02', '90.00', 'PACIENTE 4', 24),
								(24, 'Paciente 5', '104358519', '06612159030', '', '', '', '', 'Solteiro(a)', '1990-10-31', '0.00', '', NULL);

								-- --------------------------------------------------------

								--
								-- Estrutura da tabela `procedimento`
								--

								CREATE TABLE `procedimento` (
									  `id` int(11) NOT NULL,
									  `nome` varchar(255) COLLATE utf8_unicode_ci NOT NULL
									) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

									--
									-- Extraindo dados da tabela `procedimento`
									--

									INSERT INTO `procedimento` (`id`, `nome`) VALUES
									(1, 'Acupuntura'),
									(2, 'Drenagem Linfática'),
									(3, 'Auriculoterapia'),
									(4, 'Ventosaterapia'),
									(5, 'Isostreching (Postural)'),
									(6, 'Fisioterapia Convencional'),
									(7, 'Kinesiotape (Bandagem Funcional)'),
									(8, 'Terapias de Reabilitação vestibular'),
									(9, 'Massagem Relaxante ou Modeladora'),
									(10, 'hsausauh ashauhsahsuh'),
									(12, 'Avaliação');

									-- --------------------------------------------------------

									--
									-- Estrutura da tabela `profissional`
									--

									CREATE TABLE `profissional` (
										  `id` int(11) NOT NULL,
										  `fone` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
										  `celular` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
										  `banco` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
										  `agencia` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
										  `digito` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
										  `conta_corrente` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
										  `endereco_id` int(11) DEFAULT NULL,
										  `especialidade_id` int(11) DEFAULT NULL
										) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

										--
										-- Extraindo dados da tabela `profissional`
										--

										INSERT INTO `profissional` (`id`, `fone`, `celular`, `banco`, `agencia`, `digito`, `conta_corrente`, `endereco_id`, `especialidade_id`) VALUES
										(2, '4133334444', '', 'Caixa', '', '', '', 28, 1),
										(3, '4136533444', '41999999999', 'Banco do Brasil', '', '', '0192929', 26, 3),
										(4, '', '', 'aah', 'hahah', 'h', 'haha', 25, 3),
										(5, '', '', '', '', '', '', NULL, 15);

										-- --------------------------------------------------------

										--
										-- Estrutura da tabela `usuario`
										--

										CREATE TABLE `usuario` (
											  `id_usuario` int(11) NOT NULL,
											  `nome_usuario` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
											  `login` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
											  `senha` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
											  `tipo_usuario` int(11) NOT NULL,
											  `id_fisioterapeuta_usuario` int(11) DEFAULT NULL
											) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

											--
											-- Extraindo dados da tabela `usuario`
											--

											INSERT INTO `usuario` (`id_usuario`, `nome_usuario`, `login`, `senha`, `tipo_usuario`, `id_fisioterapeuta_usuario`) VALUES
											(1, 'Lais', 'lais', '7c1ca643780d76f6d2a4d1a7cc3f2c3', 1, NULL),
											(2, 'Andressa Rossa', 'andressa', '29a5641eaa0c01abe5749608c8232806', 1, NULL),
											(3, 'Lucas Gabriel', 'lucas', 'dc53fc4f621c80bdc2fa0329a6123708', 1, NULL),
											(4, 'Lua da Silva', 'lua', 'f8dbbbdb3b80b4f170a8272978f579eb', 1, NULL),
											(6, 'Joana Maria', 'joana', '4c1e9507eab22f29e79a70fa6e974dfd', 2, 2),
											(7, 'Mateus da Silva', 'mateus', 'd41d8cd98f00b204e9800998ecf8427e', 1, NULL),
											(8, 'Maria ', 'teste12', '4662f9c9c6c75b5497117ee21f27758e', 2, 3),
											(9, 'Joãozinho', 'joao', 'd41d8cd98f00b204e9800998ecf8427e', 1, NULL),
											(10, 'Amanda', 'amanda', 'd41d8cd98f00b204e9800998ecf8427e', 1, NULL),
											(11, 'Joel', 'joel', 'c000ccf225950aac2a082a59ac5e57ff', 1, NULL),
											(13, 'Luana', 'luana', 'e1d9614bc81cfc05391171cede492e79', 1, NULL),
											(14, 'Pedro', 'pedro', 'c6cc8094c2dc07b700ffcc36d64e2138', 1, NULL),
											(15, 'Luiz', 'luiz', '77949c9f02621a4c85964be115a9dcc9', 1, NULL),
											(16, 'fabio', 'fabio', 'a53bd0415947807bcb95ceec535820ee', 1, NULL),
											(17, 'Luna', 'luna', 'ba8a48b0e34226a2992d871c65600a7c', 1, NULL),
											(18, 'Luma', 'luma', '7123372f52ef8a8be62f2cd3c7db812b', 1, NULL),
											(19, 'José', 'jose', '662eaa47199461d01a623884080934ab', 1, NULL),
											(20, 'Fabiano', 'fabiano', 'cc2777e6c894d15db039e928bc590131', 1, NULL),
											(21, 'Fabiana', 'fabiana', 'b64153305da0e0b8997ae9cb999ad7af', 1, NULL),
											(22, 'Mariana', 'mariana', 'e60408e9a55027070e3caf0550d2b4df', 1, NULL),
											(23, 'Marcia', 'marcia', '94b4832293a575584ca078d82a9c023a', 1, NULL),
											(24, 'Paulo', 'paulo', 'dd41cb18c930753cbecf993f828603dc', 1, NULL),
											(25, 'Gustavo', 'gustavo', '4c96f8324e3ba54a99e78249b95daa30', 1, NULL),
											(26, 'Marina', 'marina', 'ce5225d01c39d2567bc229501d9e610d', 1, NULL),
											(27, 'Anitta', 'anitta', '120057f336c9ca134404b9348d9c5b3d', 1, NULL),
											(28, 'Tata', 'tata', '49d02d55ad10973b7b9d0dc9eba7fdf0', 1, NULL),
											(29, 'Zaza', 'zaza', '8ba97607a1485ccdbe19745ed80cd52d', 1, NULL),
											(30, 'Magali', 'magali', '2a4ac4d8e4ebdf7e367d88157afe9746', 1, NULL),
											(31, 'Marga', 'marga', '8e8402a76367b3404bbac7f235d451c7', 1, NULL),
											(32, 'Zilda', 'zilda', 'cef1e4687f61ff3a09d8338574ab0f9c', 1, NULL),
											(33, 'Dita', 'dita', 'e6b047aa9378bce37a5260a949d1ea3e', 1, NULL),
											(34, 'Raul', 'raul', 'bc7a844476607e1a59d8eb1b1f311830', 1, NULL),
											(36, 'Katia', 'katia', 'cbe7ae50f7d9b54efdb2aed41dea171', 1, NULL),
											(37, 'Karen', 'karen', 'ba952731f97fb058035aa399b1cb3d5c', 1, NULL),
											(38, 'Carlos', 'carlos', 'dc599a9972fde3045dab59dbd1ae170b', 1, NULL),
											(39, 'Wesley', 'wesley', 'a09f91f8be77e65b371a64bf1d8305c9', 1, NULL),
											(40, 'Marilia', 'marilia', 'c4349152f739c809ab12116967962590', 1, NULL),
											(41, 'Lulu', 'lulu', '654e4dc5b90b7478671fe6448cab3f32', 1, NULL),
											(42, 'Pedrinho', 'pedrinho', '1ca918f9eda86850db0980ecd806690a', 1, NULL),
											(43, 'Teste dois', 'teste', '9249b732803fce9372a4658446af5e71', 2, 4),
											(44, 'malu', 'teste33', 'd41d8cd98f00b204e9800998ecf8427e', 1, NULL),
											(45, 'teste2', 'teste2', '38851536d87701d2191990e24a7f8d4e', 1, NULL),
											(46, 'Teste 3', 'teste13', '507eb04c9c427e9f961e47a7204fac41', 2, 5),
											(47, 'testando', 'testando', 'caa9c8f8620cbb30679026bb6427e11f', 1, NULL),
											(48, 'hahahaha', 'hahahaha', '4f0b36a34946153c358f8b243428a1eb', 1, NULL);

											--
											-- Indexes for dumped tables
											--

											--
											-- Indexes for table `agenda`
											--
											ALTER TABLE `agenda`
											  ADD PRIMARY KEY (`id_agenda`),
											  ADD KEY `paciente_id` (`consulta_id`,`profissional_id`),
											  ADD KEY `id_fisioterapeuta_agenda` (`profissional_id`);

											--
											-- Indexes for table `avaliacao`
											--
											ALTER TABLE `avaliacao`
											  ADD PRIMARY KEY (`id_avaliacao`),
											  ADD KEY `id_avaliacao` (`id_avaliacao`),
											  ADD KEY `id_fisioterapeuta_avaliacao` (`id_fisioterapeuta_avaliacao`),
											  ADD KEY `id_cliente_avaliacao` (`id_paciente_avaliacao`);

											--
											-- Indexes for table `consulta`
											--
											ALTER TABLE `consulta`
											  ADD PRIMARY KEY (`id`),
											  ADD KEY `fk_consulta_paciente_id` (`paciente_id`),
											  ADD KEY `fk_consulta_procedimento_id` (`procedimento_id`);

											--
											-- Indexes for table `endereco`
											--
											ALTER TABLE `endereco`
											  ADD PRIMARY KEY (`id_endereco`);

											--
											-- Indexes for table `paciente`
											--
											ALTER TABLE `paciente`
											  ADD PRIMARY KEY (`id_paciente`),
											  ADD UNIQUE KEY `CPF` (`CPF`),
											  ADD KEY `id_endereco_cliente` (`id_endereco_paciente`);

											--
											-- Indexes for table `procedimento`
											--
											ALTER TABLE `procedimento`
											  ADD PRIMARY KEY (`id`);

											--
											-- Indexes for table `profissional`
											--
											ALTER TABLE `profissional`
											  ADD PRIMARY KEY (`id`),
											  ADD KEY `id_endereco_fisioterapeuta` (`endereco_id`),
											  ADD KEY `fk_tipo_profissional_id` (`especialidade_id`);

											--
											-- Indexes for table `usuario`
											--
											ALTER TABLE `usuario`
											  ADD PRIMARY KEY (`id_usuario`),
											  ADD UNIQUE KEY `login` (`login`),
											  ADD KEY `id_fisioterapeuta_usuario` (`id_fisioterapeuta_usuario`);

                     --
											-- Indexes for table `especialidade`
											--
                      ALTER TABLE `especialidade`
											  ADD PRIMARY KEY (`id`);

                     --
											-- Indexes for table `horario`
											--
                      ALTER TABLE `horario`
											  ADD PRIMARY KEY (`id`);

											--
											-- AUTO_INCREMENT for dumped tables
											--

											--
											-- AUTO_INCREMENT for table `agenda`
											--
											ALTER TABLE `agenda`
											  MODIFY `id_agenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=174;

											--
											-- AUTO_INCREMENT for table `avaliacao`
											--
											ALTER TABLE `avaliacao`
											  MODIFY `id_avaliacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

											--
											-- AUTO_INCREMENT for table `consulta`
											--
											ALTER TABLE `consulta`
											  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

											--
											-- AUTO_INCREMENT for table `endereco`
											--
											ALTER TABLE `endereco`
											  MODIFY `id_endereco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

											--
											-- AUTO_INCREMENT for table `especialidade`
											--
											ALTER TABLE `especialidade`
											  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

											--
											-- AUTO_INCREMENT for table `horario`
											--
											ALTER TABLE `horario`
											  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

											--
											-- AUTO_INCREMENT for table `paciente`
											--
											ALTER TABLE `paciente`
											  MODIFY `id_paciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

											--
											-- AUTO_INCREMENT for table `procedimento`
											--
											ALTER TABLE `procedimento`
											  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

											--
											-- AUTO_INCREMENT for table `profissional`
											--
											ALTER TABLE `profissional`
											  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

											--
											-- AUTO_INCREMENT for table `usuario`
											--
											ALTER TABLE `usuario`
											  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

											--
											-- Constraints for dumped tables
											--

											--
											-- Limitadores para a tabela `agenda`
											--
											ALTER TABLE `agenda`
											  ADD CONSTRAINT `fk_agenda_consulta_id` FOREIGN KEY (`consulta_id`) REFERENCES `consulta` (`id`),
											  ADD CONSTRAINT `fk_agenda_profissional_id` FOREIGN KEY (`profissional_id`) REFERENCES `profissional` (`id`);

											--
											-- Limitadores para a tabela `avaliacao`
											--
											ALTER TABLE `avaliacao`
											  ADD CONSTRAINT `avaliacao_ibfk_1` FOREIGN KEY (`id_fisioterapeuta_avaliacao`) REFERENCES `profissional` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
											  ADD CONSTRAINT `avaliacao_ibfk_2` FOREIGN KEY (`id_paciente_avaliacao`) REFERENCES `paciente` (`id_paciente`) ON DELETE NO ACTION ON UPDATE CASCADE;

											--
											-- Limitadores para a tabela `consulta`
											--
											ALTER TABLE `consulta`
											  ADD CONSTRAINT `fk_consulta_paciente_id` FOREIGN KEY (`paciente_id`) REFERENCES `paciente` (`id_paciente`),
											  ADD CONSTRAINT `fk_consulta_procedimento_id` FOREIGN KEY (`procedimento_id`) REFERENCES `procedimento` (`id`);

											--
											-- Limitadores para a tabela `paciente`
											--
											ALTER TABLE `paciente`
											  ADD CONSTRAINT `paciente_ibfk_1` FOREIGN KEY (`id_endereco_paciente`) REFERENCES `endereco` (`id_endereco`);

											--
											-- Limitadores para a tabela `profissional`
											--
											ALTER TABLE `profissional`
											  ADD CONSTRAINT `fk_endereco_id` FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`id_endereco`),
											  ADD CONSTRAINT `fk_tipo_profissional_id` FOREIGN KEY (`especialidade_id`) REFERENCES `especialidade` (`id`);

											--
											-- Limitadores para a tabela `usuario`
											--
											ALTER TABLE `usuario`
											  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_fisioterapeuta_usuario`) REFERENCES `profissional` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
											COMMIT;

											/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
											/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
											/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
