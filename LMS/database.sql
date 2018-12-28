CREATE TABLE `lms`.`borrower` (
  `idborrower` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL,
  `phone` VARCHAR(45) NULL,
  PRIMARY KEY (`idborrower`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE `lms`.`book` (
  `idbook` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `subject` VARCHAR(45) NOT NULL,
  `author` VARCHAR(45) NOT NULL,
  `quantitySum` INT NOT NULL,
  `quantityBorrowed` INT NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`idbook`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


CREATE TABLE `lms`.`loan` (
  `idloan` INT NOT NULL AUTO_INCREMENT,
  `idborrower` INT NOT NULL,
  `idbook` INT NOT NULL,
  `idissuer` INT NOT NULL,
  `idreceiver` INT NOT NULL,
  `issueddate` DATE NULL,
  `returneddate` DATE NULL,
  `finepaid` DOUBLE NULL,
  PRIMARY KEY (`idloan`),
  FOREIGN KEY (`idborrower`) REFERENCES `lms`.`borrower`(`idborrower`),
  FOREIGN KEY (`idbook`) REFERENCES `lms`.`book`(`idbook`),
  FOREIGN KEY (`idissuer`) REFERENCES `lms`.`staff`(`idstaff`),
  FOREIGN KEY (`idreceiver`) REFERENCES `lms`.`staff`(`idstaff`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE `lms`.`holdrequest` (
  `idholdrequest` INT NOT NULL AUTO_INCREMENT,
  `idborrower` INT NOT NULL,
  `idbook` INT NOT NULL,
  `requestdate` DATE NULL,  
  PRIMARY KEY (`idholdrequest`),
  FOREIGN KEY (`idborrower`) REFERENCES `lms`.`borrower`(`idborrower`),
  FOREIGN KEY (`idbook`) REFERENCES `lms`.`book`(`idbook`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

