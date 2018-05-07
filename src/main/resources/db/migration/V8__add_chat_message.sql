DROP TABLE IF EXISTS `chat_message`;

CREATE TABLE `chat_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `from_participant` bigint(20) DEFAULT NULL,
  `to_participant` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2o0cf0jreqqvwgv2v82thm6b7` (`from_participant`),
  KEY `FK5oa5ug7pb4wt9v2ml509yx6nc` (`to_participant`),
  CONSTRAINT `FK2o0cf0jreqqvwgv2v82thm6b7` FOREIGN KEY (`from_participant`) REFERENCES `chat_participant` (`id`),
  CONSTRAINT `FK5oa5ug7pb4wt9v2ml509yx6nc` FOREIGN KEY (`to_participant`) REFERENCES `chat_participant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8