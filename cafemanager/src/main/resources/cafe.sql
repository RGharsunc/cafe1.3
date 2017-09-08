/*
SQLyog Ultimate v11.5 (32 bit)
MySQL - 5.7.18-log : Database - cafe_manger
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cafe_manger` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cafe_manger`;

/*Table structure for table `ctable` */

DROP TABLE IF EXISTS `ctable`;

CREATE TABLE `ctable` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `reserv_id` int(10) unsigned DEFAULT NULL,
  `user_id` int(10) unsigned DEFAULT NULL,
  `statuss` enum('FREE','RESERVED') NOT NULL DEFAULT 'FREE',
  PRIMARY KEY (`id`),
  KEY `reserv_id` (`reserv_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `ctable_ibfk_1` FOREIGN KEY (`reserv_id`) REFERENCES `reserv` (`id`),
  CONSTRAINT `ctable_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `ctable` */

insert  into `ctable`(`id`,`name`,`reserv_id`,`user_id`,`statuss`) values (12,'First',NULL,9,'FREE'),(13,'Second',NULL,9,'FREE'),(14,'Therd',NULL,10,'FREE'),(15,'Fourth',NULL,9,'FREE'),(16,'Fifth',NULL,9,'FREE');

/*Table structure for table `o_product` */

DROP TABLE IF EXISTS `o_product`;

CREATE TABLE `o_product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `amount` int(10) unsigned DEFAULT NULL,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `amount` (`amount`),
  CONSTRAINT `o_product_ibfk_1` FOREIGN KEY (`id`) REFERENCES `product_order` (`oproduct_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `o_product` */

/*Table structure for table `orderedproduct_reserv` */

DROP TABLE IF EXISTS `orderedproduct_reserv`;

CREATE TABLE `orderedproduct_reserv` (
  `reserv_id` int(10) unsigned NOT NULL,
  `oproduct_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`reserv_id`,`oproduct_id`),
  KEY `oproduct_id` (`oproduct_id`),
  CONSTRAINT `orderedproduct_reserv_ibfk_1` FOREIGN KEY (`oproduct_id`) REFERENCES `o_product` (`id`),
  CONSTRAINT `orderedproduct_reserv_ibfk_2` FOREIGN KEY (`reserv_id`) REFERENCES `reserv` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orderedproduct_reserv` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`name`) values (1,'coca');

/*Table structure for table `product_order` */

DROP TABLE IF EXISTS `product_order`;

CREATE TABLE `product_order` (
  `oproduct_id` int(10) unsigned NOT NULL,
  `product_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`oproduct_id`,`product_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `product_order_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product_order` */

/*Table structure for table `reserv` */

DROP TABLE IF EXISTS `reserv`;

CREATE TABLE `reserv` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `statuss` enum('OPEN','CLOSED') NOT NULL DEFAULT 'CLOSED',
  `reserv_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reserv` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `password` text NOT NULL,
  `role` enum('MANAGER','WAITER') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`role`) values (9,'a','$2a$10$ajZFXAiFrPFK0HCIMvNnkOfQ6RTjW9mCLAHmwUlNg1FYuSr33aEim','WAITER'),(10,'s','$2a$10$M0zLHFLpuZL/76o9W/b70uqvrzG9z8cv/TfropTsMDnjGMChUgAyO','WAITER'),(11,'d','$2a$10$9kzDE3rGborMj8HFOyJsmOTacx3O/UnKnetapJ.VSTmiAM.WTr/lG','WAITER'),(12,'f','$2a$10$WiFToG4Ss6YMnMXwvCkj1.r3QphG5rC3QX26UKIZLh90PWNLld55a','WAITER'),(13,'q','$2a$10$32jw2DvUIGnUW5MdQI.iyeF06kfFPzAga.guuaNmVVY0umTuyMYA2','MANAGER');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
