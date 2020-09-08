CREATE DATABASE  IF NOT EXISTS `web_customer_tracker`;
USE `web_customer_tracker`;

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

LOCK TABLES `customer` WRITE;

INSERT INTO `customer` VALUES 
	(1,'David','Trezeguet','david@yahoo.com'),
	(2,'Pavel','Nedwed','pawa@gmail.com'),
	(3,'Diana','Princess','king@yandex.ru'),
	(4,'Mary','Bartoli','mary@mail.ru'),
	(5,'Tom','Cruize','tommy@list.com');

UNLOCK TABLES;
