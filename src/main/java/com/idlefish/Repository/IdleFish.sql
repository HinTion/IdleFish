/*
 Navicat Premium Data Transfer

 Source Server         : idlefish
 Source Server Type    : MySQL
 Source Server Version : 80040
 Source Host           : 120.26.65.82:3306
 Source Schema         : IdleFish

 Target Server Type    : MySQL
 Target Server Version : 80040
 File Encoding         : 65001

 Date: 30/11/2024 19:42:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for messageChat
-- ----------------------------
DROP TABLE IF EXISTS `messageChat`;
CREATE TABLE `messageChat`  (
  `senderID` int NOT NULL,
  `receiverID` int NOT NULL,
  `messageContent` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `messageContentPhoto` blob NULL,
  `messageContentVoice` blob NULL,
  `messageTime` datetime NOT NULL,
  PRIMARY KEY (`senderID`, `receiverID`, `messageTime`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of messageChat
-- ----------------------------
INSERT INTO `messageChat` VALUES (1, 2, '你好', '', '', '2024-11-30 14:36:46');

-- ----------------------------
-- Table structure for messagePreview
-- ----------------------------
DROP TABLE IF EXISTS `messagePreview`;
CREATE TABLE `messagePreview`  (
  `senderID` int NOT NULL,
  `receiverID` int NOT NULL,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userAvatar` blob NULL,
  `messageContent` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `messageContentPhoto` blob NULL,
  `messageLastTime` datetime NULL DEFAULT NULL,
  `messageUnreadCount` int NULL DEFAULT NULL,
  PRIMARY KEY (`senderID`, `receiverID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of messagePreview
-- ----------------------------
INSERT INTO `messagePreview` VALUES (1, 2, 'hhhh', 0xEFBBBF, '', NULL, '2024-11-20 11:11:29', NULL);

SET FOREIGN_KEY_CHECKS = 1;
