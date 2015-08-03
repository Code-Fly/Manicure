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
-- Table structure for `order_comment`
-- ----------------------------
DROP TABLE IF EXISTS `order_comment`;
CREATE TABLE `order_comment` (
  `order_id` int(36)  COMMENT '订单id',
  `stars` int(2) DEFAULT 5    COMMENT '星数',
  `profnal_score` int(2) DEFAULT 5 COMMENT '专业分数' ,
  `move_score` int(2)  DEFAULT 5 COMMENT '感动分数' ,
  `punctual_score` int(2) DEFAULT 5 COMMENT '守时分数' ,
  `description` varchar(120) DEFAULT NULL COMMENT '评论内容',
  `comment_time`  datetime(6)   DEFAULT NULL COMMENT '评论时间',
  `pic1` VARCHAR(64)  DEFAULT NULL COMMENT '评价图片1',
   `pic2` VARCHAR(64)  DEFAULT NULL COMMENT '评价图片2',
   `pic3` VARCHAR(64)  DEFAULT NULL COMMENT '评价图片3',
  PRIMARY KEY (`order_id`)
)
COMMENT='订单评价表，一个订单一个评价'
ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `order_extend`
-- ----------------------------
DROP TABLE IF EXISTS `order_extend`;
CREATE TABLE `order_extend` (
  `order_id` int(36)  COMMENT '订单id',
  `tec_id` INT(24)  comment '技师id',
  `product_id` VARCHAR(64)  COMMENT '服务id',
  `buyer_openid` varchar(28)  DEFAULT NULL COMMENT '用户id',
  `buyer_nick` varchar (20)  DEFAULT NULL COMMENT '用户微信账号',
  `name` varchar(20) DEFAULT NULL COMMENT '用户名子',
  `order_time`  datetime(6)   DEFAULT NULL COMMENT '预定日期',
  `order_type` int(1)  DEFAULT 1  COMMENT '订单类型 1：上门，2：到门店',
  `address` varchar(36) DEFAULT NULL COMMENT '服务地址（门店或者住址）',
  `tel` varchar(12) DEFAULT NULL COMMENT '电话号码'
  PRIMARY KEY (`order_id`)
)
COMMENT='订单扩展表，主表信息微信提供'
ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `technician`;
CREATE TABLE `technician` (
	`id` INT(9) NOT NULL,
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

-- 技师详细信息试图
CREATE VIEW test.tec_info as 
select tec.*,sum(oc.evaluation) as evaluation,avg(oc.stars) as stars, avg(oc.profnal_score) as profnal_score,avg(oc.move_score) as move_score ,avg(oc.punctual_score) as punctual_score from technician tec,order_extend oe,order_comment oc where tec.id = oe.tec_id and oe.order_id = oc.order_id
