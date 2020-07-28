-- phpMyAdmin SQL Dump ppp
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 26, 2014 at 06:02 AM
-- Server version: 5.5.24-log
-- PHP Version: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `agua_florida`
--

-- --------------------------------------------------------

--
-- Table structure for table `backupservicios`
--

CREATE TABLE IF NOT EXISTS `backupservicios` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valor` float NOT NULL,
  `id_servicios` int(11) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `cambiousuario`
--

CREATE TABLE IF NOT EXISTS `cambiousuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `documento` int(11) NOT NULL,
  `inmueble` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `documento` varchar(20) NOT NULL,
  `tipo_documento` varchar(5) NOT NULL,
  `genero` varchar(1) NOT NULL,
  `telefono` bigint(20) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`documento`, `tipo_documento`, `genero`, `telefono`, `Nombre`) VALUES
('222', 'CC', 'F', 6565665, 'paola'),
('33', 'CC', 'M', 2323232, 'OSCAR');

-- --------------------------------------------------------

--
-- Table structure for table `deudor`
--

CREATE TABLE IF NOT EXISTS `deudor` (
  `iddeuda` int(11) NOT NULL AUTO_INCREMENT,
  `interes_mora` float DEFAULT NULL,
  `codigo_factura` int(11) DEFAULT NULL,
  `fecha_pago` date NOT NULL,
  `estado` varchar(3) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  PRIMARY KEY (`iddeuda`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=41 ;

--
-- Dumping data for table `deudor`
--

INSERT INTO `deudor` (`iddeuda`, `interes_mora`, `codigo_factura`, `fecha_pago`, `estado`, `tipo`) VALUES
(36, 1, 78, '2014-09-15', 'IN', 'cierre'),
(37, 1, 79, '2014-09-15', 'AC', 'cierre'),
(38, 1, 80, '2014-10-15', 'IN', 'cierre'),
(39, 1, 81, '2014-10-15', 'AC', 'cierre'),
(40, 1, 83, '2014-11-15', 'AC', 'cierre');

-- --------------------------------------------------------

--
-- Table structure for table `factura`
--

CREATE TABLE IF NOT EXISTS `factura` (
  `codigo_factura` int(11) NOT NULL AUTO_INCREMENT,
  `periodo_facturacion_inicial` date NOT NULL,
  `periodo_facturacion_final` date NOT NULL,
  `fecha_de_pago` date NOT NULL,
  `fecha_suspencion` date NOT NULL,
  `codigo_inmueble` int(11) NOT NULL,
  `acueducto` int(5) NOT NULL,
  `alcantarillado` int(5) NOT NULL,
  `reconexion` int(5) DEFAULT NULL,
  `codigo_recone` int(11) DEFAULT NULL,
  `iva_acueducto` float NOT NULL,
  `Iva_alcantarillado` float NOT NULL,
  `deuda_factura` float NOT NULL,
  `total_a_pagar` float NOT NULL,
  `otros_conceptos` int(11) DEFAULT NULL,
  `codigo_financiacion` int(11) NOT NULL,
  `codigo_financiacion_deuda` int(11) NOT NULL,
  `nota` varchar(500) NOT NULL,
  `estado` varchar(10) NOT NULL DEFAULT 'Activo',
  PRIMARY KEY (`codigo_factura`),
  KEY `codigo_inmueble` (`codigo_inmueble`),
  KEY `codigo_financiacion` (`codigo_financiacion`),
  KEY `reconeccion` (`reconexion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=86 ;

--
-- Dumping data for table `factura`
--

INSERT INTO `factura` (`codigo_factura`, `periodo_facturacion_inicial`, `periodo_facturacion_final`, `fecha_de_pago`, `fecha_suspencion`, `codigo_inmueble`, `acueducto`, `alcantarillado`, `reconexion`, `codigo_recone`, `iva_acueducto`, `Iva_alcantarillado`, `deuda_factura`, `total_a_pagar`, `otros_conceptos`, `codigo_financiacion`, `codigo_financiacion_deuda`, `nota`, `estado`) VALUES
(78, '2014-09-01', '2014-09-08', '2014-09-15', '2014-09-22', 1, 8000, 2000, 0, 0, 0, 0, 0, 10000, 0, 0, 0, 'Con el no pago de dos facturas se suspenderá el servicio y se le cobrara el valor de la reconexión en el mes siguiente, si esta factura no es cancelada en las fechas indicadas, la junta tomara las medidas del caso y se incluirá el valor en el siguiente facturación. Esta factura no será valida sin el sello de cancelado o reporte de pago. En caso de no recibirse o extraviarse la factura solicite un duplicado ya que lo anterior no lo exime ', 'Activo'),
(79, '2014-09-01', '2014-09-08', '2014-09-15', '2014-09-22', 2, 8000, 2000, 0, 0, 0, 0, 0, 10000, 0, 0, 0, 'Con el no pago de dos facturas se suspenderá el servicio y se le cobrara el valor de la reconexión en el mes siguiente, si esta factura no es cancelada en las fechas indicadas, la junta tomara las medidas del caso y se incluirá el valor en el siguiente facturación. Esta factura no será valida sin el sello de cancelado o reporte de pago. En caso de no recibirse o extraviarse la factura solicite un duplicado ya que lo anterior no lo exime ', 'Activo'),
(80, '2014-10-01', '2014-10-08', '2014-10-15', '2014-10-22', 1, 8000, 2000, 0, 0, 0, 0, 10000, 20000, 0, 0, 0, 'Con el no pago de dos facturas se suspenderá el servicio y se le cobrara el valor de la reconexión en el mes siguiente, si esta factura no es cancelada en las fechas indicadas, la junta tomara las medidas del caso y se incluirá el valor en el siguiente facturación. Esta factura no será valida sin el sello de cancelado o reporte de pago. En caso de no recibirse o extraviarse la factura solicite un duplicado ya que lo anterior no lo exime ', 'Activo'),
(81, '2014-10-01', '2014-10-08', '2014-10-15', '2014-10-22', 2, 8000, 2000, 0, 0, 0, 0, 10000, 20000, 0, 0, 0, 'Con el no pago de dos facturas se suspenderá el servicio y se le cobrara el valor de la reconexión en el mes siguiente, si esta factura no es cancelada en las fechas indicadas, la junta tomara las medidas del caso y se incluirá el valor en el siguiente facturación. Esta factura no será valida sin el sello de cancelado o reporte de pago. En caso de no recibirse o extraviarse la factura solicite un duplicado ya que lo anterior no lo exime ', 'Activo'),
(82, '2014-11-01', '2014-11-08', '2014-11-15', '2014-11-22', 1, 0, 0, 0, 27, 0, 0, 20000, 20000, 0, 0, 0, 'Con el no pago de dos facturas se suspenderá el servicio y se le cobrara el valor de la reconexión en el mes siguiente, si esta factura no es cancelada en las fechas indicadas, la junta tomara las medidas del caso y se incluirá el valor en el siguiente facturación. Esta factura no será valida sin el sello de cancelado o reporte de pago. En caso de no recibirse o extraviarse la factura solicite un duplicado ya que lo anterior no lo exime ', 'Suspendido'),
(83, '2014-11-01', '2014-11-08', '2014-11-15', '2014-11-22', 2, 8000, 2000, 0, 28, 0, 0, 20000, 30000, 0, 0, 0, 'Con el no pago de dos facturas se suspenderá el servicio y se le cobrara el valor de la reconexión en el mes siguiente, si esta factura no es cancelada en las fechas indicadas, la junta tomara las medidas del caso y se incluirá el valor en el siguiente facturación. Esta factura no será valida sin el sello de cancelado o reporte de pago. En caso de no recibirse o extraviarse la factura solicite un duplicado ya que lo anterior no lo exime ', 'Activo'),
(84, '2014-12-01', '2014-12-08', '2014-12-15', '2014-12-22', 1, 8000, 2000, 0, 29, 0, 0, 0, 10000, 0, 0, 0, 'Con el no pago de dos facturas se suspenderá el servicio y se le cobrara el valor de la reconexión en el mes siguiente, si esta factura no es cancelada en las fechas indicadas, la junta tomara las medidas del caso y se incluirá el valor en el siguiente facturación. Esta factura no será valida sin el sello de cancelado o reporte de pago. En caso de no recibirse o extraviarse la factura solicite un duplicado ya que lo anterior no lo exime ', 'Activo'),
(85, '2014-12-01', '2014-12-08', '2014-12-15', '2014-12-22', 2, 8000, 2000, 0, 28, 0, 0, 30000, 40000, 0, 0, 0, 'Con el no pago de dos facturas se suspenderá el servicio y se le cobrara el valor de la reconexión en el mes siguiente, si esta factura no es cancelada en las fechas indicadas, la junta tomara las medidas del caso y se incluirá el valor en el siguiente facturación. Esta factura no será valida sin el sello de cancelado o reporte de pago. En caso de no recibirse o extraviarse la factura solicite un duplicado ya que lo anterior no lo exime ', 'Activo');

-- --------------------------------------------------------

--
-- Table structure for table `fechas_facturacion`
--

CREATE TABLE IF NOT EXISTS `fechas_facturacion` (
  `cierre` int(2) NOT NULL,
  `reconexion` int(11) NOT NULL,
  `factura` int(2) NOT NULL,
  `copia` int(2) NOT NULL,
  `inicio` int(2) NOT NULL,
  `fin` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `fechas_facturacion`
--

INSERT INTO `fechas_facturacion` (`cierre`, `reconexion`, `factura`, `copia`, `inicio`, `fin`) VALUES
(0, 2, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `financiacion`
--

CREATE TABLE IF NOT EXISTS `financiacion` (
  `codigo_financiacion` int(11) NOT NULL AUTO_INCREMENT,
  `documento` varchar(20) NOT NULL,
  `inmueble` int(11) NOT NULL,
  `numero_cuotas` int(11) NOT NULL,
  `cuotas_pagas` int(11) DEFAULT NULL,
  `iva` varchar(20) NOT NULL,
  `valor_total` float NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `abono` float NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `estado` varchar(2) NOT NULL,
  PRIMARY KEY (`codigo_financiacion`),
  KEY `documento` (`documento`),
  KEY `inmueble` (`inmueble`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `inmueble`
--

CREATE TABLE IF NOT EXISTS `inmueble` (
  `codigo_inmueble` int(11) NOT NULL,
  `Direccion` varchar(80) NOT NULL,
  `telefono` bigint(11) NOT NULL,
  `alcantarillado` int(3) NOT NULL,
  `Acueduto` int(3) NOT NULL,
  `documento` varchar(20) NOT NULL,
  `estado` varchar(3) NOT NULL DEFAULT 'AC',
  PRIMARY KEY (`codigo_inmueble`),
  KEY `documento` (`documento`),
  KEY `alcantarillado` (`alcantarillado`),
  KEY `Acueduto` (`Acueduto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inmueble`
--

INSERT INTO `inmueble` (`codigo_inmueble`, `Direccion`, `telefono`, `alcantarillado`, `Acueduto`, `documento`, `estado`) VALUES
(1, 'encanto', 2222222, 166, 164, '222', 'AC'),
(2, 'JARDIN', 23232323, 166, 164, '33', 'AC');

-- --------------------------------------------------------

--
-- Table structure for table `otrosconceptos`
--

CREATE TABLE IF NOT EXISTS `otrosconceptos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inmueble` int(11) NOT NULL,
  `cocepto` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `valor` int(6) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `estado` varchar(2) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `pago_factura`
--

CREATE TABLE IF NOT EXISTS `pago_factura` (
  `codigo_factura` int(11) NOT NULL,
  `fecha_pago_pago` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `codigo_pago_factura` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`codigo_pago_factura`),
  UNIQUE KEY `codigo_factura_2` (`codigo_factura`),
  UNIQUE KEY `codigo_factura_3` (`codigo_factura`),
  KEY `codigo_factura` (`codigo_factura`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Dumping data for table `pago_factura`
--

INSERT INTO `pago_factura` (`codigo_factura`, `fecha_pago_pago`, `codigo_pago_factura`) VALUES
(82, '2014-09-26 04:13:19', 21);

-- --------------------------------------------------------

--
-- Table structure for table `pago_financiacion`
--

CREATE TABLE IF NOT EXISTS `pago_financiacion` (
  `codigo_pago_financiacion` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_financiacion` int(11) NOT NULL,
  `fecha_pago` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tipopago` varchar(20) NOT NULL,
  `valor` float NOT NULL,
  PRIMARY KEY (`codigo_pago_financiacion`),
  KEY `codigo_financiacion` (`codigo_financiacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `reconexion`
--

CREATE TABLE IF NOT EXISTS `reconexion` (
  `codigo_reconeccion` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_factura` int(11) NOT NULL,
  `fecha_reconeccion` date DEFAULT NULL,
  `Estado` varchar(2) NOT NULL,
  `EstadoPago` varchar(2) NOT NULL DEFAULT 'NO',
  `Estadoservis` varchar(3) NOT NULL DEFAULT 'INI',
  `valor` int(11) NOT NULL,
  PRIMARY KEY (`codigo_reconeccion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=30 ;

--
-- Dumping data for table `reconexion`
--

INSERT INTO `reconexion` (`codigo_reconeccion`, `codigo_factura`, `fecha_reconeccion`, `Estado`, `EstadoPago`, `Estadoservis`, `valor`) VALUES
(27, 80, '2014-10-22', 'AC', 'SI', 'REC', 168),
(28, 81, '2014-10-22', 'IN', 'NO', 'INI', 168),
(29, 80, '2014-11-22', 'IN', 'NO', 'INI', 168);

-- --------------------------------------------------------

--
-- Table structure for table `servicio`
--

CREATE TABLE IF NOT EXISTS `servicio` (
  `idservicio` int(3) NOT NULL AUTO_INCREMENT,
  `CodServicio` int(2) NOT NULL,
  `nombre` varchar(80) COLLATE utf8_spanish_ci NOT NULL,
  `valor` int(11) DEFAULT NULL,
  PRIMARY KEY (`idservicio`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=169 ;

--
-- Dumping data for table `servicio`
--

INSERT INTO `servicio` (`idservicio`, `CodServicio`, `nombre`, `valor`) VALUES
(1, 3, 'Iva Deudores', 0),
(2, 5, 'financiacion', 0),
(164, 2, 'Acueducto Domiciliario', 8000),
(165, 3, 'Iva Acueducto Domiciliario', 0),
(166, 1, 'Alcantarillado Domiciliario', 2000),
(167, 3, 'Iva Alcantarillado Domiciliario', 0),
(168, 4, 'Reconexion Acueducto Domiciliario', 16000);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`codigo_inmueble`) REFERENCES `inmueble` (`codigo_inmueble`);

--
-- Constraints for table `financiacion`
--
ALTER TABLE `financiacion`
  ADD CONSTRAINT `financiacion_ibfk_1` FOREIGN KEY (`documento`) REFERENCES `cliente` (`documento`),
  ADD CONSTRAINT `financiacion_ibfk_2` FOREIGN KEY (`inmueble`) REFERENCES `inmueble` (`codigo_inmueble`);

--
-- Constraints for table `inmueble`
--
ALTER TABLE `inmueble`
  ADD CONSTRAINT `inmueble_ibfk_1` FOREIGN KEY (`documento`) REFERENCES `cliente` (`documento`),
  ADD CONSTRAINT `inmueble_ibfk_2` FOREIGN KEY (`alcantarillado`) REFERENCES `servicio` (`idservicio`),
  ADD CONSTRAINT `inmueble_ibfk_3` FOREIGN KEY (`Acueduto`) REFERENCES `servicio` (`idservicio`);

--
-- Constraints for table `pago_factura`
--
ALTER TABLE `pago_factura`
  ADD CONSTRAINT `pago_factura_ibfk_1` FOREIGN KEY (`codigo_factura`) REFERENCES `factura` (`codigo_factura`);

--
-- Constraints for table `pago_financiacion`
--
ALTER TABLE `pago_financiacion`
  ADD CONSTRAINT `pago_financiacion_ibfk_1` FOREIGN KEY (`codigo_financiacion`) REFERENCES `financiacion` (`codigo_financiacion`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
