-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema consumers
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema consumers
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `consumers` DEFAULT CHARACTER SET utf8 ;
USE `consumers` ;

-- -----------------------------------------------------
-- Table `consumers`.`uf`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consumers`.`uf` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consumers`.`cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consumers`.`cidade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(100) NOT NULL,
  `id_uf` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_uf_cidade_fk_idx` (`id_uf` ASC),
  CONSTRAINT `id_uf_cidade_fk`
    FOREIGN KEY (`id_uf`)
    REFERENCES `consumers`.`uf` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consumers`.`profissao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consumers`.`profissao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(100) NOT NULL,
  `salario` DECIMAL(15,2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consumers`.`consumer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consumers`.`consumer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `sobrenome` VARCHAR(100) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `data_insercao` DATETIME NOT NULL,
  `data_atualizacao` DATETIME NOT NULL,
  `cpf` BIGINT(11) NOT NULL,
  `sexo` INT NULL,
  `id_uf` INT NULL,
  `id_cidade` INT NULL,
  `id_profissao` INT NULL,
  PRIMARY KEY (`id`, `cpf`),
  INDEX `id_uf_consumer_idx` (`id_uf` ASC),
  INDEX `id_cidade_consumer_fk_idx` (`id_cidade` ASC),
  INDEX `id_profissao_consumer_fk_idx` (`id_profissao` ASC),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC),
  CONSTRAINT `id_uf_consumer_fk`
    FOREIGN KEY (`id_uf`)
    REFERENCES `consumers`.`uf` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_cidade_consumer_fk`
    FOREIGN KEY (`id_cidade`)
    REFERENCES `consumers`.`cidade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_profissao_consumer_fk`
    FOREIGN KEY (`id_profissao`)
    REFERENCES `consumers`.`profissao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consumers`.`grupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consumers`.`grupo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `consumers`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consumers`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `sobrenome` VARCHAR(100) NOT NULL,
  `login` VARCHAR(50) NOT NULL,
  `senha` VARCHAR(100) NOT NULL,
  `id_grupo` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_grupo_usuario_fk_idx` (`id_grupo` ASC),
  CONSTRAINT `id_grupo_usuario_fk`
    FOREIGN KEY (`id_grupo`)
    REFERENCES `consumers`.`grupo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
