/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : runoob

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-11-07 17:05:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `websites`
-- ----------------------------
DROP TABLE IF EXISTS `websites`;
CREATE TABLE `websites` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL DEFAULT '' COMMENT '站点名称',
  `url` varchar(255) NOT NULL DEFAULT '',
  `alexa` int(11) NOT NULL DEFAULT '0' COMMENT 'Alexa 排名',
  `country` char(10) NOT NULL DEFAULT '' COMMENT '国家',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23424 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of websites
-- ----------------------------
INSERT INTO `websites` VALUES ('1', 'kjh', 'kjh', '11', 'jhjh');
INSERT INTO `websites` VALUES ('2', 'sdfd', 'sdf', '122', 'nsf');
INSERT INTO `websites` VALUES ('3', 'asdfd', 'sdfsd', '2452', 'dcdscx');
INSERT INTO `websites` VALUES ('4', 'sdf', 'sdfsd', '123', 'cvvcxv');
INSERT INTO `websites` VALUES ('5', 'hg', 'hgh', '34', ',m,m');
INSERT INTO `websites` VALUES ('6', 'mn', 'mn', '7657', 'mnb n');
