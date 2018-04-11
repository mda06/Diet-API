 DROP TABLE IF EXISTS `meal_picture`;

 CREATE TABLE `meal_picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `patient_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PATIENT_ID_PICTURE` (`patient_id`),
  CONSTRAINT `FK_PATIENT_ID_PICTURE` FOREIGN KEY (`patient_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8