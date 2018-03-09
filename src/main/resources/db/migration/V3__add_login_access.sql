DROP TABLE IF EXISTS `login_access`;

CREATE TABLE `login_access` (
  `auth_id` varchar(255) NOT NULL,
  `expiration_time` datetime DEFAULT NULL,
  `is_blacklisted` bit(1) NOT NULL,
  `last_activity_time` datetime DEFAULT NULL,
  `log_out_time` datetime DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`auth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;