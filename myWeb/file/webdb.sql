/*
 Navicat Premium Data Transfer

 Source Server         : db
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : webdb

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 02/05/2020 21:52:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `AdminID` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `AdminName` varchar(32) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `AdminPwd` varchar(64) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `AdminType` smallint(0) NULL DEFAULT NULL,
  `LastLoginTime` varchar(50) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`AdminID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'Zuo', 'Changeme_123', 1, '2016-01-01');

-- ----------------------------
-- Table structure for tbl_news
-- ----------------------------
DROP TABLE IF EXISTS `tbl_news`;
CREATE TABLE `tbl_news`  (
  `NewsID` int(0) NOT NULL AUTO_INCREMENT,
  `NewsTitle` varchar(60) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `NewsContent` longtext CHARACTER SET gbk COLLATE gbk_chinese_ci NULL,
  `NewsTime` varchar(50) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `AdminName` varchar(32) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`NewsID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_news
-- ----------------------------
INSERT INTO `tbl_news` VALUES (1, '新闻标题', '新闻内容写到这里面，很多很多', '2020-04-25', '管理员');
INSERT INTO `tbl_news` VALUES (2, '新闻标题2：今天天气怎么样', '内容', '2020-04-24', '主管');
INSERT INTO `tbl_news` VALUES (3, '新闻1+1', '这是测试新闻', '2020-05-02 21:25', 'Zuo');

SET FOREIGN_KEY_CHECKS = 1;
