SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `evaluacion` DEFAULT CHARACTER SET utf8 ;
USE `evaluacion` ;

-- -----------------------------------------------------
-- Table `evaluacion`.`rol`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `evaluacion`.`rol` (
  `idrol` INT(11) NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`idrol`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `evaluacion`.`menu`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `evaluacion`.`menu` (
  `idmenu` INT(11) NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`idmenu`) )
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `evaluacion`.`submenu`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `evaluacion`.`submenu` (
  `idsubmenu` INT(11) NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL ,
  `url` VARCHAR(100) NULL DEFAULT NULL ,
  `idmenu` INT(11) NOT NULL ,
  PRIMARY KEY (`idsubmenu`) ,
  INDEX `fk_submenu_menu1_idx` (`idmenu` ASC) ,
  CONSTRAINT `fk_submenu_menu1`
    FOREIGN KEY (`idmenu` )
    REFERENCES `evaluacion`.`menu` (`idmenu` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `evaluacion`.`acceso`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `evaluacion`.`acceso` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `idmenu` INT(11) NOT NULL ,
  `idsubmenu` INT(11) NOT NULL ,
  `idrol` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_menu_has_usuario_menu1_idx` (`idmenu` ASC) ,
  INDEX `fk_acceso_submenu1_idx` (`idsubmenu` ASC) ,
  INDEX `fk_acceso_rol1_idx` (`idrol` ASC) ,
  CONSTRAINT `fk_acceso_rol1`
    FOREIGN KEY (`idrol` )
    REFERENCES `evaluacion`.`rol` (`idrol` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_acceso_submenu1`
    FOREIGN KEY (`idsubmenu` )
    REFERENCES `evaluacion`.`submenu` (`idsubmenu` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_menu_has_usuario_menu1`
    FOREIGN KEY (`idmenu` )
    REFERENCES `evaluacion`.`menu` (`idmenu` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `evaluacion`.`pregunta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `evaluacion`.`pregunta` (
  `idpregunta` INT(11) NOT NULL ,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL ,
  `tipo` VARCHAR(25) NULL DEFAULT NULL ,
  `tema` VARCHAR(45) NULL DEFAULT NULL ,
  `respuesta` VARCHAR(250) NULL ,
  PRIMARY KEY (`idpregunta`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `evaluacion`.`alternativa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `evaluacion`.`alternativa` (
  `idalternativa` INT(11) NOT NULL ,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL ,
  `tema` LONGBLOB NULL DEFAULT NULL ,
  `idpregunta` INT(11) NOT NULL ,
  PRIMARY KEY (`idalternativa`) ,
  INDEX `fk_alternativa_pregunta1_idx` (`idpregunta` ASC) ,
  CONSTRAINT `fk_alternativa_pregunta1`
    FOREIGN KEY (`idpregunta` )
    REFERENCES `evaluacion`.`pregunta` (`idpregunta` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `evaluacion`.`usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `evaluacion`.`usuario` (
  `idusuario` INT(11) NOT NULL AUTO_INCREMENT ,
  `usuario` VARCHAR(45) NULL DEFAULT NULL ,
  `passsword` VARCHAR(45) NULL DEFAULT NULL ,
  `idrol` INT(11) NOT NULL ,
  PRIMARY KEY (`idusuario`) ,
  INDEX `fk_usuario_rol1_idx` (`idrol` ASC) ,
  CONSTRAINT `fk_usuario_rol1`
    FOREIGN KEY (`idrol` )
    REFERENCES `evaluacion`.`rol` (`idrol` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `evaluacion`.`alumno`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `evaluacion`.`alumno` (
  `idalumno` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NULL ,
  `apePaterno` VARCHAR(45) NULL ,
  `apeMaterno` VARCHAR(45) NULL ,
  `celular` VARCHAR(45) NULL ,
  `correo` VARCHAR(45) NULL ,
  `direccion` VARCHAR(45) NULL ,
  `sexo` VARCHAR(45) NULL ,
  `idusuario` INT(11) NOT NULL ,
  PRIMARY KEY (`idalumno`) ,
  INDEX `fk_alumno_usuario1_idx` (`idusuario` ASC) ,
  CONSTRAINT `fk_alumno_usuario1`
    FOREIGN KEY (`idusuario` )
    REFERENCES `evaluacion`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `evaluacion`.`curso`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `evaluacion`.`curso` (
  `idcurso` INT(11) NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NULL DEFAULT NULL ,
  `ciclo` VARCHAR(45) NULL DEFAULT NULL ,
  `idalumno` INT NOT NULL ,
  PRIMARY KEY (`idcurso`) ,
  INDEX `fk_curso_alumno1_idx` (`idalumno` ASC) ,
  CONSTRAINT `fk_curso_alumno1`
    FOREIGN KEY (`idalumno` )
    REFERENCES `evaluacion`.`alumno` (`idalumno` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `evaluacion`.`examen`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `evaluacion`.`examen` (
  `idexamen` INT(11) NOT NULL ,
  `nombre` VARCHAR(45) NULL DEFAULT NULL ,
  `estado` VARCHAR(45) NULL DEFAULT NULL ,
  `nivel` VARCHAR(45) NULL DEFAULT NULL ,
  `fecIni` DATETIME NULL ,
  `fecFin` DATETIME NULL ,
  `idcurso` INT(11) NOT NULL ,
  PRIMARY KEY (`idexamen`) ,
  INDEX `fk_examen_curso1_idx` (`idcurso` ASC) ,
  CONSTRAINT `fk_examen_curso1`
    FOREIGN KEY (`idcurso` )
    REFERENCES `evaluacion`.`curso` (`idcurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `evaluacion`.`examen_pregunta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `evaluacion`.`examen_pregunta` (
  `idexamen` INT(11) NOT NULL ,
  `idpregunta` INT(11) NOT NULL ,
  PRIMARY KEY (`idexamen`, `idpregunta`) ,
  INDEX `fk_examen_has_pregunta_pregunta1_idx` (`idpregunta` ASC) ,
  INDEX `fk_examen_has_pregunta_examen1_idx` (`idexamen` ASC) ,
  CONSTRAINT `fk_examen_has_pregunta_examen1`
    FOREIGN KEY (`idexamen` )
    REFERENCES `evaluacion`.`examen` (`idexamen` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_examen_has_pregunta_pregunta1`
    FOREIGN KEY (`idpregunta` )
    REFERENCES `evaluacion`.`pregunta` (`idpregunta` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `evaluacion`.`docente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `evaluacion`.`docente` (
  `iddocente` INT NOT NULL ,
  `nombre` VARCHAR(45) NULL ,
  `apePaterno` VARCHAR(45) NULL ,
  `apeMaterno` VARCHAR(45) NULL ,
  `celular` VARCHAR(45) NULL ,
  `correo` VARCHAR(45) NULL ,
  `direccion` VARCHAR(45) NULL ,
  `sexso` VARCHAR(45) NULL ,
  `idusuario` INT(11) NOT NULL ,
  PRIMARY KEY (`iddocente`) ,
  INDEX `fk_docente_usuario1_idx` (`idusuario` ASC) ,
  CONSTRAINT `fk_docente_usuario1`
    FOREIGN KEY (`idusuario` )
    REFERENCES `evaluacion`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `evaluacion`.`examen_alumno`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `evaluacion`.`examen_alumno` (
  `idexamen` INT(11) NOT NULL ,
  `idalumno` INT NOT NULL ,
  `nota` DOUBLE NULL ,
  `fecRend` VARCHAR(45) NULL ,
  PRIMARY KEY (`idexamen`, `idalumno`) ,
  INDEX `fk_examen_has_alumno_alumno1_idx` (`idalumno` ASC) ,
  INDEX `fk_examen_has_alumno_examen2_idx` (`idexamen` ASC) ,
  CONSTRAINT `fk_examen_has_alumno_examen2`
    FOREIGN KEY (`idexamen` )
    REFERENCES `evaluacion`.`examen` (`idexamen` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_examen_has_alumno_alumno1`
    FOREIGN KEY (`idalumno` )
    REFERENCES `evaluacion`.`alumno` (`idalumno` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `evaluacion` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
