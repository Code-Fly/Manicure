/*
Navicat MySQL Data Transfer

Source Server         : chenli
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-07-19 21:31:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderid` int(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `serviceid` int(8) unsigned DEFAULT NULL COMMENT '订单id',
  `time` datetime(6) DEFAULT NULL COMMENT '预约时间',
  `storeid` int(8) unsigned DEFAULT NULL COMMENT '门店id',
  `technicianid` int(8) unsigned DEFAULT NULL COMMENT '技师id',
  `price` decimal(6,2) unsigned DEFAULT NULL COMMENT '服务价格',
  `actprice` decimal(6,2) unsigned DEFAULT NULL COMMENT '实付价格',
  `ticketid` int(8) unsigned DEFAULT NULL COMMENT '优惠券id',
  `userid` int(8) unsigned DEFAULT NULL COMMENT '用户id',
  `state` int(1) unsigned DEFAULT NULL COMMENT '订单状态',
  PRIMARY KEY (`orderid`),
  KEY `serviceid` (`serviceid`),
  CONSTRAINT `serviceid` FOREIGN KEY (`serviceid`) REFERENCES `service` (`serviceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `service`
-- ----------------------------
DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
  `serviceid` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '服务名称',
  `description` varchar(80) DEFAULT NULL COMMENT '服务描述',
  `sales` bigint(8) unsigned DEFAULT NULL COMMENT '销量',
  `price` decimal(6,2) unsigned DEFAULT NULL COMMENT '服务价格',
  `taketime` int(3) unsigned DEFAULT NULL COMMENT '服务花时',
  `keeptime` int(3) unsigned DEFAULT NULL COMMENT '效果持续时间',
  `type` int(8) unsigned DEFAULT NULL COMMENT '服务类型',
  `imageid` int(8) unsigned DEFAULT NULL COMMENT '图片id',
  PRIMARY KEY (`serviceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of service
-- ----------------------------

-- ----------------------------
-- Table structure for `service_comment`
-- ----------------------------
DROP TABLE IF EXISTS `service_comment`;
CREATE TABLE `service_comment` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '服务评价id',
  `serviceid` int(8) unsigned DEFAULT NULL COMMENT '服务id',
  `stars` int(1) unsigned DEFAULT NULL COMMENT '星数',
  `description` varchar(140) DEFAULT NULL COMMENT '评论内容',
  `userid` int(8) unsigned DEFAULT NULL COMMENT '用户id',
  `time` datetime(6) DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`),
  KEY `serviceid2` (`serviceid`),
  CONSTRAINT `serviceid2` FOREIGN KEY (`serviceid`) REFERENCES `service` (`serviceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of service_comment
-- ----------------------------



DROP TABLE IF EXISTS `technician`;
CREATE TABLE `technician` (
	`id` INT(24) NOT NULL,
	`name` VARCHAR(16) NULL DEFAULT NULL,
	`service_type` INT(2) NULL DEFAULT NULL COMMENT '服务类型',
	`protal_id` VARCHAR(24) NULL DEFAULT NULL COMMENT '技师所在门店id',
	`job_title` VARCHAR(24) NOT NULL DEFAULT '高级职业师' COMMENT '职称',
	`origin` VARCHAR(16) NULL DEFAULT NULL COMMENT '籍贯',
	`constellation` VARCHAR(12) NULL DEFAULT NULL COMMENT '星座',
	`love` VARCHAR(64) NULL DEFAULT NULL COMMENT '爱好',
	`self_desc` VARCHAR(128) NULL DEFAULT NULL COMMENT '自我介绍',
	`header_pic` VARCHAR(64) NULL DEFAULT NULL COMMENT '头像地址',
	`self_pic1` VARCHAR(64) NULL DEFAULT NULL COMMENT '个人图片',
	`self_pic2` VARCHAR(64) NULL DEFAULT NULL,
	`self_pic3` VARCHAR(64) NULL DEFAULT NULL,
	 PRIMARY KEY (`id`)
)
COMMENT='技师表'
ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `tec_service`;
CREATE TABLE `tec_service` (
	`id` INT(9) NOT NULL AUTO_INCREMENT,
	`tec_id` INT(9) NOT NULL COMMENT '技师id',
	`product_id` VARCHAR(64) NOT NULL COMMENT '服务id',
	PRIMARY KEY (`id`)
)
COMMENT='技师与服务关联表'
ENGINE=InnoDB DEFAULT CHARSET=utf8;
