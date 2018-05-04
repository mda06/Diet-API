DROP TABLE IF EXISTS `chat_participant`;

CREATE TABLE `chat_participant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `connection_date_time` datetime DEFAULT NULL,
  `session_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8