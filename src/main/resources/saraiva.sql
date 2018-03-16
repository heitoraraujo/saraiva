/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : saraiva

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2018-03-16 11:02:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `sku` int(11) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `preco` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
