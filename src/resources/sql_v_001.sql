-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 03-Fev-2018 às 14:09
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=12 ;

--
-- Extraindo dados da tabela `avaliacao`
--

INSERT INTO `avaliacao` (`id_avaliacao`, `diag_cli`, `diag_fis`, `data_avaliacao`, `medico`, `id_fisioterapeuta_avaliacao`, `id_paciente_avaliacao`) VALUES
(1, 'Entorse de Tornozelo', 'Paciente relata que em junho fez uma entorse de tornozelo esquerdo ficou 30 dias com a bota. Ao exame:edema em maleolo lateral,dor a palpação e diminuição de Adm. Conduta:analgesia com gelo,alongamentos e exercicios ativos. Andressa', '2017-08-05', '', 1, 2),
(2, 'Distensão em panturrilha esquerda  ', 'Paciente relata que começou com quadro de dor intensa em panturrilha esquerda após atividade fisica de alta intensidade. Ao exame:dor a palpação ,tensão muscular. Conduta:analgesia ,alongamentos e exercicios ativos. ', '2017-08-09', '', 1, 3),
(3, 'lombalgia', 'HMA: dor em coluna lombar com irradiação para MMII, fraz treino funcional \ne corrida aos finais de semana . Não foi ao medico, sem exames, toma \nDorflex quando dor forte. Apresenta fraqueza muscular , encurtamento\nmuscular.', '2017-07-31', '', 2, 6),
(4, 'cervicalgia', 'HMA: Dor em coluna cervical ha meses, devido ha outras comorbidades\nfaz tratamento de HEMOTERAPIA 1 vez por semana. Sem exames, \nsem medicação. Veio para Acupuntura.', '2017-08-25', '', 2, 5),
(5, 'entorse de tornozelo D', 'HMA: entorse de tornozelo D durante treino , apresenta edema , \ndor ao caminhar , fraqueza muscular. Cond, analgesia, exercicios. ', '2017-08-18', '', 2, 4),
(6, 'Entorse de tornozelo D', 'HMP: entorse de tornozelo em Junho/2016 , fez tratamento.\nHMA: entorse de repetição ha 1 mes, não foi ao medico , tomou medicação,\nesta fazendo gelo. Apresenta leve edema, hematoma em região lateral. \nrelata dor ao caminhar, apreseta fraqueza muscular. Cond. Us,tens com gelo,\nalongamento, exercicios ativos.Gloria.( 01/09/17 - 16/10/17) 10 sessões.', '2017-09-01', '', 2, 7),
(7, 'Desgaste patelar e encurtamento de cadeia posterior', 'Paciente relata que iniciou com quadro de dor infra patelar ao praticar atividade\nfisica de alto impacto como terinamento funcional e corrida.Esta medicada \nAo exame dor infra patelar ate terço medio da tibia,encurtamento importante \nde cadeia posterior. Conduta:analgesia, alongamentos', '2017-09-06', '', 1, 10),
(8, 'Tendinite bilateral de ombros  ', 'Paciente relata tendinopatia ha cerca de 2 anos ,chega ao atendimento com dor intensa em trapezio e romboide. Conduta:analgesia com calor e terapia manual . ', '2017-11-22', '', 1, 12),
(9, 'Distensão gastrocnemio', 'HMA: lesão em panturrilha durante treino funcional /corrida. \ntomando medicação . não foi ao medico. Apresenta dor a palpação,\nencurtamento muscular. Cond. analgesia, exercicios. Gloria', '2017-11-06', '', 2, 11),
(10, 'Desvio postural', '', '2017-09-30', '', 1, 13),
(11, 'protusão discal ', 'HMA: dor em coluna lombar , faz treino funcional . sem exames , \nsem medicação. dor em algumas atividades. Cond. analgesia, exercicios.', '2017-11-29', '', 2, 14);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=17 ;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id_endereco`, `CEP`, `rua`, `bairro`, `cidade`, `estado`, `numero`) VALUES
(1, '83314010', 'Joaquim Simões', 'Jardim Tropical', 'Piraquara', 'PR', 120),
(2, '', 'Rua Iguat u', 'Jardim Tropical ', 'Piraquara ', 'PR', 6),
(3, '', 'Tv:Francisco venancio da silva', 'jardim tropical ', 'Piraquara ', 'PR', 153),
(4, '', 'Rua Uruguaiana ', 'Jardim Tropical', 'Piraquara ', 'PR', 307),
(5, '83304561', 'av. Nilza gelinsk de faria', 'planta deodoro', 'piraquara', 'pr', 736),
(6, '', 'R. Zaleia ', 'jardim Carla', 'Pinhais', 'PR', 275),
(7, '', 'Alto paraiba', 'Jardim tropical', 'Piraquara', 'pr', 75),
(8, '', 'Uruguaiana', '', 'Piraquara', 'PR', 307),
(9, '83222310', 'Rio Javali ', 'Weissopolis', 'Pinhais', 'pr', 440),
(12, '', 'Jose de Alencar ', 'Vargem Grande', 'Pinhais', 'PR', 218),
(13, '', 'Rua Gulherme ceolin ', 'vargem grande', 'pinhais', 'pr', 347),
(14, '83300000', 'Travessa Francisco Venancio da Silva', 'Jardim Tropical ', 'Piraquara ', 'pr', 153),
(15, '', 'Arnaldo andrade ', 'Maria Antonoeta', 'Pinhais', 'pr', 250),
(16, '', 'avenida irai ', 'Weissopolis', 'Pinhais ', 'Pr', 1299);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `fisioterapeuta`
--

INSERT INTO `fisioterapeuta` (`id_fisioterapeuta`, `fone`, `celular`, `banco`, `agencia`, `digito`, `conta_corrente`, `id_endereco_fisioterapeuta`) VALUES
(1, '4136693523', '4196142906', 'BRADESCO ', '', '', '', 14),
(2, '', '4187000933', '', '', '', '', NULL);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=12 ;

--
-- Extraindo dados da tabela `fisioterapia`
--

INSERT INTO `fisioterapia` (`id_fisioterapia`, `qntd`, `data_primeira_fisioterapia`, `hora`, `valor`, `id_paciente_fisioterapia`, `id_fisioterapeuta_fisioterapia`) VALUES
(1, 1, '2017-08-18', '19:00:00', 30.00, 4, 2),
(2, 10, '2017-09-08', '18:30:00', 250.00, 10, 2),
(3, 13, '2017-08-04', '09:00:00', 520.00, 2, 1),
(4, 10, '2017-11-06', '19:30:00', 250.00, 11, 2),
(5, 1, '2017-08-25', '17:00:00', 50.00, 5, 2),
(6, 6, '2017-07-31', '17:00:00', 275.00, 6, 2),
(7, 4, '2017-11-08', '17:30:00', 110.00, 6, 1),
(8, 5, '2017-08-09', '19:00:00', 150.00, 3, 1),
(9, 10, '2017-09-01', '19:00:00', 250.00, 7, 1),
(10, 20, '2017-09-30', '19:00:00', 500.00, 13, 2),
(11, 5, '2017-11-29', '18:00:00', 130.00, 14, 2);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=17 ;

--
-- Extraindo dados da tabela `paciente`
--

INSERT INTO `paciente` (`id_paciente`, `nome_paciente`, `RG`, `CPF`, `fone_paciente`, `celular_paciente`, `fone_contato_paciente`, `sexo`, `estado_civil`, `data_nasc`, `peso`, `observacao`, `id_endereco_paciente`) VALUES
(1, 'Lais Frigério da Silva', '10435859', '09973396910', '4136533773', '41996182728', '', 'F', 'Solteiro(a)', '1995-10-30', '52.00', '', 1),
(2, 'Magdhel Gonçalves Belga Pedroso', '00000000000000', '00000000000', '4184466853', '', '', 'F', 'Casado(a)', '1980-10-20', '0.00', '', 2),
(3, 'Giovani Lemos da Silva ', '70146495', '03026586960', '4135570244', '', '', 'M', 'Casado(a)', '1977-09-01', '0.00', '', 4),
(4, 'Bruna de Lima Pinho', '133920820', '10741376989', '', '41995928758', '', 'F', 'Solteiro(a)', '1997-04-07', '0.00', '', 6),
(5, 'Eliane Brime Pinheiro', '210382', '35483512987', '', '41995494777', '', 'F', 'Casado(a)', '1956-03-22', '0.00', '', 7),
(6, 'Eliane talita Pinheiro', '93180585', '04788615916', '', '41999299591', '', 'F', 'Casado(a)', '1986-09-24', '0.00', '', 8),
(7, 'Natalia Moraes', '141537164', '06628510999', '', '41997514428', '', 'F', 'Solteiro(a)', '2000-10-23', '0.00', '', 9),
(10, 'Francielle Cristina Koppen da Silva Bobko ', '85139304', '08054571941', '', '', '', 'F', 'Casado(a)', '1983-05-01', '0.00', '', 12),
(11, 'Erli Ferreira de Oliveira', '41334428', '56174284972', '', '', '', 'M', 'Solteiro(a)', '1964-08-11', '0.00', '', NULL),
(12, 'Camila Fernandes ', '97537372', '06654116933', '4130334093', '', '', 'f', 'Casado(a)', '1987-05-15', '0.00', '', 13),
(13, 'Gabriel Santos Leite da Silva', '147839766', '12768872997', '', '', '', 'M', 'Solteiro(a)', '2007-10-04', '0.00', 'paciente de 10 anos', NULL),
(14, 'Edmar Manoel Lucas', '73304105', '02119549931', '', '41999327739', '', 'M', 'Solteiro(a)', '1977-05-13', '0.00', '', 15),
(15, 'Aguida Ferreira de Freitas', '38597655', '38890119934', '', '41996407319', '4136694446', '', 'Solteiro(a)', '2017-04-09', '0.00', '', NULL),
(16, 'Claudiane Gelinski ', '60799113', '02770247905', '4130333156', '', '', 'f', 'Casado(a)', '1974-05-22', '0.00', '', 16);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nome_usuario`, `login`, `senha`, `tipo_usuario`, `id_fisioterapeuta_usuario`) VALUES
(1, 'Andressa Rossa', 'admin', '21232f297a57a5a743894a0e4a801fc3', 1, NULL),
(2, 'Andressa Das Graças Rossa', 'admin', 'af1b377496ace6fa1a29770c3d43ca5d', 2, 1),
(3, 'Gloria Rafaela dos Santos Carvalho', 'admin', '49bc8098c8b1984a3ffcdccf236bbd54', 2, 2),
(4, 'Gloria carvalho', 'admin', '32ce473c4b643c7af477693d99ed0a47', 1, NULL);

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
