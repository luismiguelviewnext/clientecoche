CREATE TABLE `vehiculosdb`.`clientes` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `telefono` INT NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_cliente`));
