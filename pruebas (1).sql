-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-07-2020 a las 03:46:28
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `bd_acueductos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `backupservicios`
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
-- Estructura de tabla para la tabla `cambiousuario`
--

CREATE TABLE IF NOT EXISTS `cambiousuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `documento` int(11) NOT NULL,
  `inmueble` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `cambiousuario`
--

INSERT INTO `cambiousuario` (`id`, `documento`, `inmueble`, `fecha`) VALUES
(1, 1110, 1, '2020-07-29 03:03:02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `documento` varchar(20) NOT NULL,
  `tipo_documento` varchar(5) NOT NULL,
  `genero` varchar(1) NOT NULL,
  `telefono` bigint(20) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`documento`),
  UNIQUE KEY `id_cliente` (`id_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=201 ;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `documento`, `tipo_documento`, `genero`, `telefono`, `Nombre`) VALUES
(200, '1102', 'CC', 'M', 233333, 'oscar'),
(199, '1110', 'CC', 'F', 1111111, 'PAOAL');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `deudor`
--

CREATE TABLE IF NOT EXISTS `deudor` (
  `iddeuda` int(11) NOT NULL AUTO_INCREMENT,
  `interes_mora` float DEFAULT NULL,
  `codigo_factura` int(11) DEFAULT NULL,
  `fecha_pago` date NOT NULL,
  `estado` varchar(3) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  PRIMARY KEY (`iddeuda`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Volcado de datos para la tabla `deudor`
--

INSERT INTO `deudor` (`iddeuda`, `interes_mora`, `codigo_factura`, `fecha_pago`, `estado`, `tipo`) VALUES
(8, 1, 150, '2020-08-10', 'IN', 'cierre'),
(9, 1, 151, '2020-09-10', 'IN', 'cierre'),
(10, 1, 151, '2020-09-10', 'IN', 'financia'),
(11, 1, 152, '2020-10-10', 'AC', 'cierre'),
(12, 1, 154, '2020-11-10', 'AC', 'cierre'),
(13, 1, 155, '2020-12-10', 'AC', 'cierre'),
(14, 1, 156, '2020-01-10', 'AC', 'cierre'),
(15, 1, 157, '2020-01-10', 'AC', 'cierre'),
(16, 1, 158, '2020-02-10', 'AC', 'cierre'),
(17, 1, 159, '2020-02-10', 'AC', 'cierre');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=160 ;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`codigo_factura`, `periodo_facturacion_inicial`, `periodo_facturacion_final`, `fecha_de_pago`, `fecha_suspencion`, `codigo_inmueble`, `acueducto`, `alcantarillado`, `reconexion`, `codigo_recone`, `iva_acueducto`, `Iva_alcantarillado`, `deuda_factura`, `total_a_pagar`, `otros_conceptos`, `codigo_financiacion`, `codigo_financiacion_deuda`, `nota`, `estado`) VALUES
(150, '2020-07-01', '2020-07-31', '2020-08-10', '2020-08-17', 1, 60000, 20000, 0, 0, 0, 0, 0, 80000, 0, 0, 0, 'Con el no pago de dos facturas se suspenderá el servicio y se le cobrara el valor de la reconexión en el mes siguiente, si esta factura no es cancelada en las fechas indicadas, la junta tomara las medidas del caso y se incluirá el valor en el siguiente facturación. Esta factura no será valida sin el sello de cancelado o reporte de pago. En caso de no recibirse o extraviarse la factura solicite un duplicado ya que lo anterior no lo exime ', 'Activo'),
(151, '2020-08-01', '2020-08-31', '2020-09-10', '2020-09-17', 1, 60000, 20000, 0, 0, 0, 0, 80000, 160000, 0, 0, 0, 'Con el no pago de dos facturas se suspenderá el servicio y se le cobrara el valor de la reconexión en el mes siguiente, si esta factura no es cancelada en las fechas indicadas, la junta tomara las medidas del caso y se incluirá el valor en el siguiente facturación. Esta factura no será valida sin el sello de cancelado o reporte de pago. En caso de no recibirse o extraviarse la factura solicite un duplicado ya que lo anterior no lo exime ', 'Activo'),
(152, '2020-09-01', '2020-09-30', '2020-10-10', '2020-10-17', 1, 60000, 20000, 0, 0, 0, 0, 0, 160000, 0, 0, 1, 'Con el no pago de dos facturas se suspenderá el servicio y se le cobrara el valor de la reconexión en el mes siguiente, si esta factura no es cancelada en las fechas indicadas, la junta tomara las medidas del caso y se incluirá el valor en el siguiente facturación. Esta factura no será valida sin el sello de cancelado o reporte de pago. En caso de no recibirse o extraviarse la factura solicite un duplicado ya que lo anterior no lo exime ', 'Activo'),
(154, '2020-10-01', '2020-10-31', '2020-11-10', '2020-11-17', 1, 60000, 20000, 0, 0, 0, 0, 160000, 323000, 2, 0, 1, 'Con el no pago de dos facturas se suspenderá el servicio y se le cobrara el valor de la reconexión en el mes siguiente, si esta factura no es cancelada en las fechas indicadas, la junta tomara las medidas del caso y se incluirá el valor en el siguiente facturación. Esta factura no será valida sin el sello de cancelado o reporte de pago. En caso de no recibirse o extraviarse la factura solicite un duplicado ya que lo anterior no lo exime ', 'Activo'),
(155, '2020-11-01', '2020-11-30', '2020-12-10', '2020-12-17', 1, 60000, 20000, 0, 0, 0, 0, 323000, 403000, 0, 0, 0, 'Con el no pago de dos facturas se suspenderá el servicio y se le cobrara el valor de la reconexión en el mes siguiente, si esta factura no es cancelada en las fechas indicadas, la junta tomara las medidas del caso y se incluirá el valor en el siguiente facturación. Esta factura no será valida sin el sello de cancelado o reporte de pago. En caso de no recibirse o extraviarse la factura solicite un duplicado ya que lo anterior no lo exime ', 'Activo'),
(156, '2020-12-01', '2020-12-31', '2020-01-10', '2020-01-17', 1, 60000, 20000, 0, 0, 0, 0, 403000, 483000, 0, 0, 0, 'Con el no pago de dos facturas se suspenderá el servicio y se le cobrara el valor de la reconexión en el mes siguiente, si esta factura no es cancelada en las fechas indicadas, la junta tomara las medidas del caso y se incluirá el valor en el siguiente facturación. Esta factura no será valida sin el sello de cancelado o reporte de pago. En caso de no recibirse o extraviarse la factura solicite un duplicado ya que lo anterior no lo exime ', 'Activo'),
(157, '2020-12-01', '2020-12-31', '2020-01-10', '2020-01-17', 2, 60000, 20000, 0, 0, 0, 0, 0, 90000, 0, 2, 0, 'Con el no pago de dos facturas se suspenderá el servicio y se le cobrara el valor de la reconexión en el mes siguiente, si esta factura no es cancelada en las fechas indicadas, la junta tomara las medidas del caso y se incluirá el valor en el siguiente facturación. Esta factura no será valida sin el sello de cancelado o reporte de pago. En caso de no recibirse o extraviarse la factura solicite un duplicado ya que lo anterior no lo exime ', 'Activo'),
(158, '2020-01-01', '2020-01-31', '2020-02-10', '2020-02-17', 1, 60000, 20000, 0, 0, 0, 0, 483000, 563000, 0, 0, 0, 'Con el no pago de dos facturas se suspenderá el servicio y se le cobrara el valor de la reconexión en el mes siguiente, si esta factura no es cancelada en las fechas indicadas, la junta tomara las medidas del caso y se incluirá el valor en el siguiente facturación. Esta factura no será valida sin el sello de cancelado o reporte de pago. En caso de no recibirse o extraviarse la factura solicite un duplicado ya que lo anterior no lo exime ', 'Activo'),
(159, '2020-01-01', '2020-01-31', '2020-02-10', '2020-02-17', 2, 60000, 20000, 0, 0, 0, 0, 90000, 180000, 0, 2, 0, 'Con el no pago de dos facturas se suspenderá el servicio y se le cobrara el valor de la reconexión en el mes siguiente, si esta factura no es cancelada en las fechas indicadas, la junta tomara las medidas del caso y se incluirá el valor en el siguiente facturación. Esta factura no será valida sin el sello de cancelado o reporte de pago. En caso de no recibirse o extraviarse la factura solicite un duplicado ya que lo anterior no lo exime ', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fechas_facturacion`
--

CREATE TABLE IF NOT EXISTS `fechas_facturacion` (
  `cierre` int(2) NOT NULL,
  `reconexion` int(11) NOT NULL,
  `factura` int(2) NOT NULL,
  `copia` int(2) NOT NULL,
  `inicio` int(2) NOT NULL,
  `fin` int(2) NOT NULL,
  `ruta_back` longtext COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`cierre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `fechas_facturacion`
--

INSERT INTO `fechas_facturacion` (`cierre`, `reconexion`, `factura`, `copia`, `inicio`, `fin`, `ruta_back`) VALUES
(25, 20, 10, 0, 1, 30, 'C:\\\\wamp\\\\bin\\\\mysql\\\\mysql5.6.17\\\\bin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `financiacion`
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `financiacion`
--

INSERT INTO `financiacion` (`codigo_financiacion`, `documento`, `inmueble`, `numero_cuotas`, `cuotas_pagas`, `iva`, `valor_total`, `tipo`, `abono`, `fecha`, `estado`) VALUES
(1, '1110', 1, 2, 2, '5', 160000, 'Deuda', 0, '2020-07-30 02:41:39', 'IN'),
(2, '1102', 2, 4, 3, '44', 40000, 'Instalacion', 10000, '2020-07-30 02:53:44', 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inmueble`
--

CREATE TABLE IF NOT EXISTS `inmueble` (
  `codigo_inmueble` int(11) NOT NULL,
  `Direccion` varchar(80) NOT NULL,
  `telefono` bigint(11) NOT NULL,
  `alcantarillado` int(3) NOT NULL,
  `Acueduto` int(3) NOT NULL,
  `documento` varchar(20) NOT NULL,
  `estado` varchar(3) NOT NULL DEFAULT 'AC',
  `observacion` varchar(200) NOT NULL DEFAULT 'NA',
  PRIMARY KEY (`codigo_inmueble`),
  KEY `documento` (`documento`),
  KEY `alcantarillado` (`alcantarillado`),
  KEY `Acueduto` (`Acueduto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `inmueble`
--

INSERT INTO `inmueble` (`codigo_inmueble`, `Direccion`, `telefono`, `alcantarillado`, `Acueduto`, `documento`, `estado`, `observacion`) VALUES
(1, 'carrera 20', 22222, 25, 23, '1110', 'AC', 'NA'),
(2, 'carrera 20', 44444, 25, 23, '1102', 'AC', 'NA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `logacceso`
--

CREATE TABLE IF NOT EXISTS `logacceso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `otrosconceptos`
--

CREATE TABLE IF NOT EXISTS `otrosconceptos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inmueble` int(11) NOT NULL,
  `cocepto` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `valor` int(6) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `estado` varchar(2) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `otrosconceptos`
--

INSERT INTO `otrosconceptos` (`id`, `inmueble`, `cocepto`, `valor`, `fecha`, `estado`) VALUES
(1, 182, 'cambio de mangera ', 100000, '2016-02-22 22:09:23', 'IN'),
(2, 1, 'tubo', 3000, '2020-07-30 02:50:57', 'IN');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago_factura`
--

CREATE TABLE IF NOT EXISTS `pago_factura` (
  `codigo_factura` int(11) NOT NULL,
  `fecha_pago_pago` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `codigo_pago_factura` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`codigo_pago_factura`),
  UNIQUE KEY `codigo_factura_2` (`codigo_factura`),
  UNIQUE KEY `codigo_factura_3` (`codigo_factura`),
  KEY `codigo_factura` (`codigo_factura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago_financiacion`
--

CREATE TABLE IF NOT EXISTS `pago_financiacion` (
  `codigo_pago_financiacion` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_financiacion` int(11) NOT NULL,
  `fecha_pago` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tipopago` varchar(20) NOT NULL,
  `valor` float NOT NULL,
  PRIMARY KEY (`codigo_pago_financiacion`),
  KEY `codigo_financiacion` (`codigo_financiacion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `pago_financiacion`
--

INSERT INTO `pago_financiacion` (`codigo_pago_financiacion`, `codigo_financiacion`, `fecha_pago`, `tipopago`, `valor`) VALUES
(1, 1, '2020-07-30 02:26:29', 'Factura', 80000),
(2, 1, '2020-07-30 02:28:56', 'Factura', 80000),
(3, 2, '2020-07-30 02:33:21', 'Financiacion', 200000),
(4, 1, '2020-07-30 02:49:06', 'Factura', 80000),
(5, 1, '2020-07-30 02:50:57', 'Factura', 80000),
(6, 2, '2020-07-30 02:55:11', 'Factura', 10000),
(7, 2, '2020-07-30 02:56:36', 'Financiacion', 10000),
(8, 2, '2020-07-30 03:03:54', 'Factura', 10000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reconexion`
--

CREATE TABLE IF NOT EXISTS `reconexion` (
  `codigo_reconeccion` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_factura` int(11) NOT NULL,
  `fecha_reconeccion` date DEFAULT NULL,
  `Estado` varchar(3) NOT NULL,
  `EstadoPago` varchar(2) NOT NULL DEFAULT 'NO',
  `Estadoservis` varchar(3) NOT NULL DEFAULT '1',
  `valor` int(11) NOT NULL,
  PRIMARY KEY (`codigo_reconeccion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE IF NOT EXISTS `servicio` (
  `idservicio` int(3) NOT NULL AUTO_INCREMENT,
  `CodServicio` int(2) NOT NULL,
  `nombre` varchar(80) COLLATE utf8_spanish_ci NOT NULL,
  `valor` int(11) DEFAULT NULL,
  PRIMARY KEY (`idservicio`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=45 ;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`idservicio`, `CodServicio`, `nombre`, `valor`) VALUES
(5, 5, 'Iva Deudores', 0),
(23, 2, 'Acueducto estrato 4', 60000),
(24, 3, 'Iva Acueducto estrato 4', 0),
(25, 1, 'Alcantarillado estrato 4', 20000),
(26, 3, 'Iva Alcantarillado estrato 4', 0),
(27, 4, 'Reconexion Acueducto estrato 4', 30000),
(44, 5, 'Iva Financiacion', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `idetificacion` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `estado` varchar(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`idusuario`),
  UNIQUE KEY `usuario` (`usuario`),
  UNIQUE KEY `idetificacion` (`idetificacion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idusuario`, `nombre`, `apellidos`, `idetificacion`, `usuario`, `contrasena`, `estado`) VALUES
(1, 'Administrador', 'Agua-Florida', 123, 'Admin', 'c893bad68927b457dbed39460e6afd62', 'A'),
(2, 'root', 'aaa', 1110, 'root', 'c893bad68927b457dbed39460e6afd62', 'A');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
