-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db_facturas_todo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_facturas_todo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_facturas_todo` DEFAULT CHARACTER SET utf8mb4 ;
USE `db_facturas_todo` ;

-- -----------------------------------------------------
-- Table `db_facturas_todo`.`proyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_facturas_todo`.`proyecto` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(600) NOT NULL,
  `nombre` VARCHAR(300) NOT NULL,
  `fecha_final` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `db_facturas_todo`.`tarea`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_facturas_todo`.`tarea` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(600) NOT NULL,
  `estado` BIT(1) NOT NULL,
  `fecha_final` DATETIME(6) NOT NULL,
  `nombre` VARCHAR(300) NOT NULL,
  `id_proyecto` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKigg2h8ndfrd99d72llwhrqw5p` (`id_proyecto` ASC) ,
  CONSTRAINT `FKigg2h8ndfrd99d72llwhrqw5p`
    FOREIGN KEY (`id_proyecto`)
    REFERENCES `db_facturas_todo`.`proyecto` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
