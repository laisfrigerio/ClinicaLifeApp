-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 10-Fev-2018 às 17:49
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=39 ;

--
-- Extraindo dados da tabela `agenda`
--

INSERT INTO `agenda` (`id_agenda`, `id_fisioterapia_agenda`, `id_fisioterapeuta_agenda`, `observacao`, `data_agendamento`) VALUES
(30, 2, 3, 'testando paciente sem search de luana para margarete kkk ooooooooooi', '2018-01-30 08:00:00'),
(31, 4, 3, 'kkkkkk', '2018-01-30 10:30:00'),
(32, 3, 4, 'primeira sessao', '2018-01-31 07:30:00'),
(33, 3, 4, 'segunda sessao', '2018-01-31 08:00:00'),
(36, 2, 3, 'oi', '2018-01-30 08:30:00'),
(37, 4, 2, 'hsu shdsudhs sdhuashdhdsa dusdhusdhhd hwquhwuqh hwuwqhsq hsuwqhsuqwh\nhsu shdsudhs sdhuashdhdsa dusdhusdhhd hwquhwuqh hwuwqhsq hsuwqhsuqwh\nhsu shdsudhs sdhuashdhdsa dusdhusdhhd hwquhwuqh hwuwqhsq hsuwqhsuqwh\nhsu shdsudhs sdhuashdhdsa dusdhusdhhd hwquhwuqh hwuwqhsq hsuwqhsuqwh\nhsu shdsudhs sdhuashdhdsa dusdhusdhhd hwquhwuqh hwuwqhsq hsuwqhsuqwh\nhsu shdsudhs sdhuashdhdsa dusdhusdhhd hwquhwuqh hwuwqhsq hsuwqhsuqwh\nhsu shdsudhs sdhuashdhdsa dusdhusdhhd hwquhwuqh hwuwqhsq hsuwqhsuqwh\nhsu shdsudhs sdhuashdhdsa dusdhusdhhd hwquhwuqh hwuwqhsq hsuwqhsuqwhhsu shdsudhs sdhuashdhdsa dusdhusdhhd hwquhwuqh hwuwqhsq hsuwqhsuqwh\n', '2018-01-31 09:00:00'),
(38, 2, 3, 'hghgg hjhjjhh', '2018-02-04 07:30:00');

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

--
-- Extraindo dados da tabela `avaliacao`
--

INSERT INTO `avaliacao` (`id_avaliacao`, `diag_cli`, `diag_fis`, `data_avaliacao`, `medico`, `id_fisioterapeuta_avaliacao`, `id_paciente_avaliacao`) VALUES
(1, '', '', '2017-08-02', 'Paulo', 3, 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=23 ;

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
(22, '83314010', 'Joaquim Simões', 'Jardim Tropical', 'Piraquara', 'PR', 120);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `fisioterapeuta`
--

INSERT INTO `fisioterapeuta` (`id_fisioterapeuta`, `fone`, `celular`, `banco`, `agencia`, `digito`, `conta_corrente`, `id_endereco_fisioterapeuta`) VALUES
(2, '4133334444', '', 'Caixa', '', '', '', NULL),
(3, '4136533444', '41999999999', 'Banco do Brasil', '', '', '', NULL),
(4, '', '', '', '', '', '', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fisioterapia`
--

CREATE TABLE IF NOT EXISTS `fisioterapia` (
  `id_fisioterapia` int(11) NOT NULL AUTO_INCREMENT,
  `qntd` int(11) NOT NULL,
  `valor` double(10,2) NOT NULL,
  `id_paciente_fisioterapia` int(11) NOT NULL,
  PRIMARY KEY (`id_fisioterapia`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `fisioterapia`
--

INSERT INTO `fisioterapia` (`id_fisioterapia`, `qntd`, `valor`, `id_paciente_fisioterapia`) VALUES
(2, 12, 1200.00, 1),
(3, 2, 500.00, 10),
(4, 10, 500.00, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `horario`
--

CREATE TABLE IF NOT EXISTS `horario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hora` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=21 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=20 ;

--
-- Extraindo dados da tabela `paciente`
--

INSERT INTO `paciente` (`id_paciente`, `nome_paciente`, `RG`, `CPF`, `fone_paciente`, `celular_paciente`, `fone_contato_paciente`, `sexo`, `estado_civil`, `data_nasc`, `peso`, `observacao`, `id_endereco_paciente`) VALUES
(1, 'Margarete Frigério', '104358519', '09474289921', '4136533773', '', '', 'F', 'Casado(a)', '1967-05-13', '59.00', '', 7),
(3, 'João da Silva', '34562341', '25177676102', '', '', '', 'M', 'Solteiro(a)', '1985-05-21', '88.00', 'Bonito', 10),
(4, 'Marcos de Sousa', '2345678', '21423704380', '', '', '', 'M', 'Casado(a)', '1985-05-21', '80.00', NULL, NULL),
(6, 'Lucas Gabriel da Silva', '103456789', '09973396910', '4136677701', '', '', 'M', 'Casado(a)', '1996-02-04', '70.00', 'Alto, magro, estudante de análise e desenvolvimento de sistemas na UniCuritiba e trabalha atualmente na empres Orbenk como encarregado em um Armazém de Curitiba.', 9),
(10, 'Luana Frigério de Souza', '2345678901', '77614407512', '4133333333', '', '', 'F', 'Solteiro(a)', '1987-04-11', '53.00', '', 21),
(19, 'Luana kkkk', '104358519', '31253177627', '', '', '', '', 'Solteiro(a)', '1997-06-03', '0.00', '', NULL);

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
  UNIQUE KEY `login` (`login`),
  KEY `id_fisioterapeuta_usuario` (`id_fisioterapeuta_usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=44 ;

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
(8, 'Maria', 'maria', '4662f9c9c6c75b5497117ee21f27758e', 2, 3),
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
(43, 'Teste dois', 'teste', '9249b732803fce9372a4658446af5e71', 2, 4);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `agenda`
--
ALTER TABLE `agenda`
  ADD CONSTRAINT `agenda_ibfk_2` FOREIGN KEY (`id_fisioterapia_agenda`) REFERENCES `fisioterapia` (`id_fisioterapia`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `agenda_ibfk_3` FOREIGN KEY (`id_fisioterapeuta_agenda`) REFERENCES `fisioterapeuta` (`id_fisioterapeuta`) ON DELETE NO ACTION ON UPDATE CASCADE;

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
  ADD CONSTRAINT `fisioterapeuta_ibfk_1` FOREIGN KEY (`id_endereco_fisioterapeuta`) REFERENCES `endereco` (`id_endereco`);

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
