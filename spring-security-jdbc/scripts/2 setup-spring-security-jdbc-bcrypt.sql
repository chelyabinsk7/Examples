DROP DATABASE  IF EXISTS `spring_security_demo_bcrypt`;

CREATE DATABASE  IF NOT EXISTS `spring_security_demo_bcrypt`;
USE `spring_security_demo_bcrypt`;


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Generation: https://www.bcryptcalculator.com/
-- Default passwords: test123

INSERT INTO `users` 
VALUES 
('john','{bcrypt}$2a$10$cR0w4kfAXeHlohIYf0DwduKoxY1y/rqhxn8JiugsFv1QHZTLbLBwy',1),
('mary','{bcrypt}$2a$10$QcX2jbuZ5QFVA9/tm26yJeHv3eQledClOvTyr0S9hwyt6JU5VNMdi',1),
('susan','{bcrypt}$2a$10$pVXnCcUp/ALGabCBZxiWBusE3qBIvUbiP/yoNmh3IRupbMPNe8q0G',1);


DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `authorities` 
VALUES 
('John','ROLE_EMPLOYEE'),
('Mary','ROLE_EMPLOYEE'),
('Mary','ROLE_MANAGER'),
('Ivan','ROLE_EMPLOYEE'),
('Ivan','ROLE_ADMIN');