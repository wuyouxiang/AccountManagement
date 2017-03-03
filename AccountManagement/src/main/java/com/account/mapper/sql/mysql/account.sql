/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : account

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-03-03 18:30:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` char(255) NOT NULL,
  `name` char(255) DEFAULT NULL,
  `remark` char(255) DEFAULT NULL,
  `state` char(255) DEFAULT NULL,
  `type` char(255) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `lastloadtime` date DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `sealed` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('0001', '1', '11', '是', '正式', '2017-03-03', '2017-03-03', '1', '0');
INSERT INTO `account` VALUES ('0002', '2', '22', '否', '正式', '2017-03-03', '2017-03-03', '-1', '1');
INSERT INTO `account` VALUES ('0003', '3', '33', '是', '试用', '2017-03-03', '2017-03-03', '1', '1');
INSERT INTO `account` VALUES ('001', 'admin', '管理者', '正常', '正式', '2017-03-02', '2017-03-03', '-1', '1');
INSERT INTO `account` VALUES ('002', 'sd', '用户1', '正常', '正式', '2017-03-03', '2017-03-03', '-1', '1');
INSERT INTO `account` VALUES ('003', 'user2', '用户2', '封', '正式', '2017-03-01', '2017-03-03', '-1', '1');
INSERT INTO `account` VALUES ('004', null, null, null, null, null, null, '-1', '1');
INSERT INTO `account` VALUES ('005', '我', '我', '我', '正式', '2017-03-03', '2017-03-03', '-1', '1');
INSERT INTO `account` VALUES ('006', '我', '我', '', '0', '2017-03-03', '2017-03-03', '-1', '1');
INSERT INTO `account` VALUES ('008', '', '', '', '0', '2017-03-03', '2017-03-03', '-1', '1');
INSERT INTO `account` VALUES ('1', '', '', '', '正式', '2017-03-03', '2017-03-03', '-1', '1');
INSERT INTO `account` VALUES ('1w', '', '', '', '正式', '2017-03-03', '2017-03-03', '-1', '1');
INSERT INTO `account` VALUES ('2', '', '', '', '正式', '2017-03-03', '2017-03-03', '-1', '1');
INSERT INTO `account` VALUES ('3', '', '', '', '正式', '2017-03-03', '2017-03-03', '-1', '1');
INSERT INTO `account` VALUES ('4', '', '', '', '正式', '2017-03-03', '2017-03-03', '-1', null);
INSERT INTO `account` VALUES ('5', '', '', '', '正式', '2017-03-03', '2017-03-03', '-1', null);
INSERT INTO `account` VALUES ('6', '', '', '', '正式', '2017-03-03', '2017-03-03', '-1', null);
INSERT INTO `account` VALUES ('7', '', '', '', '正式', '2017-03-03', '2017-03-03', '-1', null);
INSERT INTO `account` VALUES ('8', '', '', '', '正式', '2017-03-03', '2017-03-03', '-1', null);
INSERT INTO `account` VALUES ('d', '', '', '', '试用', '2017-03-03', '2017-03-03', '-1', null);
INSERT INTO `account` VALUES ('s', '', '', '', '正式', '2017-03-03', '2017-03-03', '-1', null);
INSERT INTO `account` VALUES ('我', '', '', '', '0', '2017-03-03', '2017-03-03', '-1', null);
INSERT INTO `account` VALUES ('杀', '', '', '', '0', '2017-03-03', '2017-03-03', '-1', null);
