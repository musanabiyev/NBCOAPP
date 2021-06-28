

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer_data
-- ----------------------------
DROP TABLE IF EXISTS `customer_data`;
CREATE TABLE `customer_data`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `surname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `date_of_birth` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKj6oafnllvypsw37ftxfbabcox`(`user_id`) USING BTREE,
  CONSTRAINT `FKj6oafnllvypsw37ftxfbabcox` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of customer_data
-- ----------------------------
INSERT INTO `customer_data` VALUES (1, 'Baku', 'Musa', '+994550000000', 'Nabiyev', 1, NULL);
INSERT INTO `customer_data` VALUES (5, 'Baku', 'test', '+994501112222', 'testov', 6, '2021-06-27');

-- ----------------------------
-- Table structure for group_role
-- ----------------------------
DROP TABLE IF EXISTS `group_role`;
CREATE TABLE `group_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK71xlt8durutjwkmgcuwvwd7ev`(`group_id`) USING BTREE,
  INDEX `FK871sa69beqv3g5laufcbklhwb`(`role_id`) USING BTREE,
  CONSTRAINT `FK871sa69beqv3g5laufcbklhwb` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK71xlt8durutjwkmgcuwvwd7ev` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of group_role
-- ----------------------------

-- ----------------------------
-- Table structure for group_user
-- ----------------------------
DROP TABLE IF EXISTS `group_user`;
CREATE TABLE `group_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKm4p7t99vp509n4lt2et6hqkgn`(`group_id`) USING BTREE,
  INDEX `FKrqeo92wyuy7jcc54mfbln3wme`(`user_id`) USING BTREE,
  CONSTRAINT `FKrqeo92wyuy7jcc54mfbln3wme` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKm4p7t99vp509n4lt2et6hqkgn` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of group_user
-- ----------------------------
INSERT INTO `group_user` VALUES (1, 1, 1);
INSERT INTO `group_user` VALUES (5, 2, 6);

-- ----------------------------
-- Table structure for groups
-- ----------------------------
DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of groups
-- ----------------------------
INSERT INTO `groups` VALUES (1, 'ADMIN');
INSERT INTO `groups` VALUES (2, 'USER');
INSERT INTO `groups` VALUES (3, 'EMPLOYEE');

-- ----------------------------
-- Table structure for issuedloan
-- ----------------------------
DROP TABLE IF EXISTS `issuedloan`;
CREATE TABLE `issuedloan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double NULL DEFAULT NULL,
  `duration_per_month` double NULL DEFAULT NULL,
  `end_date_of_loan` date NULL DEFAULT NULL,
  `percentage` double NULL DEFAULT NULL,
  `start_date_of_loan` date NULL DEFAULT NULL,
  `customer_data` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK1dp39g60bic229gruj2o3roqr`(`customer_data`) USING BTREE,
  CONSTRAINT `FK1dp39g60bic229gruj2o3roqr` FOREIGN KEY (`customer_data`) REFERENCES `customer_data` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of issuedloan
-- ----------------------------
INSERT INTO `issuedloan` VALUES (6, 1000, 12, '2022-06-25', 24, '2021-06-01', 1);

-- ----------------------------
-- Table structure for issuedloan_data
-- ----------------------------
DROP TABLE IF EXISTS `issuedloan_data`;
CREATE TABLE `issuedloan_data`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount_of_payment` double NULL DEFAULT NULL,
  `interest_charges` double NULL DEFAULT NULL,
  `main_debt` double NULL DEFAULT NULL,
  `payment_date` date NULL DEFAULT NULL,
  `payment_no` double NULL DEFAULT NULL,
  `remaining_debt` double NULL DEFAULT NULL,
  `issuedloan_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK4rsp4r7i08ah2n9nseweba4ni`(`issuedloan_id`) USING BTREE,
  CONSTRAINT `issuedloan_data_ibfk_1` FOREIGN KEY (`issuedloan_id`) REFERENCES `issuedloan` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of issuedloan_data
-- ----------------------------
INSERT INTO `issuedloan_data` VALUES (3, 94.56, 24, 74.56, '2021-06-25', NULL, 925.44, 6);

-- ----------------------------
-- Table structure for payment_data
-- ----------------------------
DROP TABLE IF EXISTS `payment_data`;
CREATE TABLE `payment_data`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double NULL DEFAULT NULL,
  `credit_id` int(11) NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `credit_id`(`credit_id`) USING BTREE,
  CONSTRAINT `payment_data_ibfk_1` FOREIGN KEY (`credit_id`) REFERENCES `issuedloan` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of payment_data
-- ----------------------------
INSERT INTO `payment_data` VALUES (1, 94.56, 6, '2021-07-25');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of roles
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `surname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'Nabiyev', '$2a$10$gIRb38CNZE7O2stp95navuRM/EeQZB09p6OgSshF4Wfty4rrdLTSy', '+994550000000', 'Musa', 'admin');
INSERT INTO `users` VALUES (6, 'test', '$2a$10$gIRb38CNZE7O2stp95navuRM/EeQZB09p6OgSshF4Wfty4rrdLTSy', '+994577000000', 'test', 'test');

SET FOREIGN_KEY_CHECKS = 1;
