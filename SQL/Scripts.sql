CREATE TABLE `demo`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `nick` VARCHAR(45) NULL,
  `fee` DECIMAL(10,2) NULL,
  `grade` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO `demo`.`student` (`name`, `nick`, `fee`, `grade`) VALUES ('Victor', 'Rep', '323.34', 'A');
INSERT INTO `demo`.`student` (`name`, `nick`, `fee`, `grade`) VALUES ('Augustine', 'Sweetie', '256.78', 'A');
INSERT INTO `demo`.`student` (`name`, `nick`, `fee`, `grade`) VALUES ('Micheal', 'Curious', '123.45', 'A');
INSERT INTO `demo`.`student` (`name`, `nick`, `fee`, `grade`) VALUES ('Jasper', 'Laughing Star', '789.56', 'A');
