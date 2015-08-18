-- --------------------------------------------------------
-- 主机:                           120.26.100.203
-- 服务器版本:                        5.6.21-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      linux-glibc2.5
-- HeidiSQL 版本:                  8.1.0.4545
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 test 的数据库结构
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;


-- 导出  表 test.business 结构
CREATE TABLE IF NOT EXISTS `business` (
  `id` int(12) NOT NULL COMMENT '商圈id',
  `name` varchar(32) NOT NULL COMMENT '商圈名称',
  `lng` decimal(11,7) DEFAULT NULL COMMENT '经度',
  `lat` decimal(11,7) DEFAULT NULL COMMENT '维度',
  `province` varchar(12) DEFAULT NULL COMMENT '省份',
  `city` varchar(12) DEFAULT NULL COMMENT '市',
  `district` varchar(12) DEFAULT NULL COMMENT '区（县）',
  `street` varchar(12) DEFAULT NULL COMMENT '街道',
  `street_number` varchar(8) DEFAULT NULL COMMENT '街道号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商圈信息';

-- 正在导出表  test.business 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `business` DISABLE KEYS */;
INSERT INTO `business` (`id`, `name`, `lng`, `lat`, `province`, `city`, `district`, `street`, `street_number`) VALUES
	(1, '西直门', 116.3546820, 39.9513400, '北京市', '北京市', '海淀区', '高粱桥斜街', '44号3'),
	(2, '朝阳门', 116.4458060, 39.9338590, '北京市', '北京市', '朝阳区', NULL, NULL);
/*!40000 ALTER TABLE `business` ENABLE KEYS */;


-- 导出  表 test.order_comment 结构
CREATE TABLE IF NOT EXISTS `order_comment` (
  `order_id` varchar(48) NOT NULL DEFAULT '0' COMMENT '订单id',
  `evaluation` int(1) NOT NULL DEFAULT '0' COMMENT '1,好评;0，中评;-1，差评',
  `stars` decimal(2,1) DEFAULT '5.0' COMMENT '星数',
  `profnal_score` decimal(2,1) DEFAULT '5.0' COMMENT '专业分数',
  `move_score` decimal(2,1) DEFAULT '5.0' COMMENT '感动分数',
  `punctual_score` decimal(2,1) DEFAULT '5.0' COMMENT '守时分数',
  `description` varchar(120) DEFAULT NULL COMMENT '评论内容',
  `time` datetime DEFAULT NULL COMMENT '评论时间',
  `pic1` varchar(128) DEFAULT NULL COMMENT '评价图片1',
  `pic2` varchar(128) DEFAULT NULL COMMENT '评价图片2',
  `pic3` varchar(128) DEFAULT NULL COMMENT '评价图片3',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单评价表，一个订单一个评价';

-- 正在导出表  test.order_comment 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `order_comment` DISABLE KEYS */;
INSERT INTO `order_comment` (`order_id`, `evaluation`, `stars`, `profnal_score`, `move_score`, `punctual_score`, `description`, `time`, `pic1`, `pic2`, `pic3`) VALUES
	('14139058477811107682', 1, 5.0, 5.0, 5.0, 5.0, '我觉得太牛逼了啊', '2015-08-18 10:30:05', 'http://img3.imgtn.bdimg.com/it/u=3213189824,882695731&fm=21&gp=0.jpg', 'http://img3.imgtn.bdimg.com/it/u=3213189824,882695731&fm=21&gp=0.jpg', 'http://www.wed114.cn/jiehun/uploads/allimg/150117/44_150117112200_1.jpg'),
	('14139058477811174845', 1, 4.0, 4.5, 4.0, 5.0, '亲亲爱爱 美死了 下次还找他', '2015-08-04 15:18:46', 'http://img3.imgtn.bdimg.com/it/u=3213189824,882695731&fm=21&gp=0.jpg', 'http://www.wed114.cn/jiehun/uploads/allimg/150117/44_150117112200_1.jpg', 'http://www.wed114.cn/jiehun/uploads/allimg/150117/44_150117112200_1.jpg');
/*!40000 ALTER TABLE `order_comment` ENABLE KEYS */;


-- 导出  表 test.order_extend 结构
CREATE TABLE IF NOT EXISTS `order_extend` (
  `order_id` varchar(48) NOT NULL DEFAULT '0' COMMENT '订单id',
  `tec_id` int(12) DEFAULT NULL COMMENT '技师id',
  `product_id` varchar(64) DEFAULT NULL COMMENT '服务id',
  `buyer_openid` varchar(28) DEFAULT NULL COMMENT '用户id',
  `buyer_nick` varchar(20) DEFAULT NULL COMMENT '用户微信账号',
  `name` varchar(20) DEFAULT NULL COMMENT '用户名子',
  `order_time` datetime DEFAULT NULL COMMENT '预定日期',
  `order_type` int(1) DEFAULT '1' COMMENT '订单类型 1：上门，2：到门店',
  `address` varchar(36) DEFAULT NULL COMMENT '服务地址（门店或者住址）',
  `tel` varchar(12) DEFAULT NULL COMMENT '电话号码',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单扩展表，主表信息微信提供14139058477811179908';

-- 正在导出表  test.order_extend 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `order_extend` DISABLE KEYS */;
INSERT INTO `order_extend` (`order_id`, `tec_id`, `product_id`, `buyer_openid`, `buyer_nick`, `name`, `order_time`, `order_type`, `address`, `tel`) VALUES
	('14139058477811107682', 1, 'pxgY4xCJRaYAnLCXqqa9zYJzAw5k', 'oxgY4xDnXebndNr-B6r5fRDXrHFo', 'zhangqw', '张权威', '2015-08-18 10:00:00', 1, ' 南京花花世界', NULL),
	('14139058477811174845', 1, 'pxgY4xHkOZMnQEmUSE8d3H1Otn68', 'oxgY4xMJB-wNeWM1R_yHJwyI1yEQ', 'PaladinX ', '谢开源', '2015-08-06 20:00:00', 1, '南京阎王殿', '13000000'),
	('14139058477811179908', 1, 'pxgY4xHkOZMnQEmUSE8d3H1Otn68', 'oxgY4xMJB-wNeWM1R_yHJwyI1yEQ', 'PaladinX ', '谢开源', '2015-08-01 10:00:00', 1, '南京雨花区吊死公司', '150000000');
/*!40000 ALTER TABLE `order_extend` ENABLE KEYS */;


-- 导出  表 test.order_extend_tmp 结构
CREATE TABLE IF NOT EXISTS `order_extend_tmp` (
  `order_id` varchar(48) DEFAULT NULL COMMENT '订单id',
  `tec_id` int(12) DEFAULT NULL COMMENT '技师id',
  `product_id` varchar(64) NOT NULL DEFAULT '' COMMENT '服务id',
  `buyer_openid` varchar(28) NOT NULL DEFAULT '' COMMENT '用户id',
  `buyer_nick` varchar(20) DEFAULT NULL COMMENT '用户微信账号',
  `name` varchar(20) DEFAULT NULL COMMENT '用户名子',
  `order_time` datetime DEFAULT NULL COMMENT '预定日期',
  `order_type` int(1) DEFAULT '1' COMMENT '订单类型 1：上门，2：到门店',
  `address` varchar(36) DEFAULT NULL COMMENT '服务地址（门店或者住址）',
  `tel` varchar(12) DEFAULT NULL COMMENT '电话号码',
  PRIMARY KEY (`product_id`,`buyer_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单扩展表，主表信息微信提供';

-- 正在导出表  test.order_extend_tmp 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `order_extend_tmp` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_extend_tmp` ENABLE KEYS */;


-- 导出  表 test.technician 结构
CREATE TABLE IF NOT EXISTS `technician` (
  `id` int(12) NOT NULL,
  `name` varchar(16) DEFAULT NULL,
  `service_type` int(2) DEFAULT NULL COMMENT '服务类型',
  `protal_id` varchar(24) DEFAULT NULL COMMENT '技师所在门店id',
  `job_title` varchar(24) DEFAULT '高级职业美甲师' COMMENT '职称',
  `origin` varchar(16) DEFAULT NULL COMMENT '籍贯',
  `constellation` varchar(12) DEFAULT NULL COMMENT '星座',
  `love` varchar(64) DEFAULT NULL COMMENT '爱好',
  `self_desc` varchar(128) DEFAULT NULL COMMENT '自我介绍',
  `header_pic` varchar(128) DEFAULT NULL COMMENT '头像地址',
  `self_pic1` varchar(128) DEFAULT NULL COMMENT '个人图片',
  `self_pic2` varchar(128) DEFAULT NULL,
  `self_pic3` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='技师表';

-- 正在导出表  test.technician 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `technician` DISABLE KEYS */;
INSERT INTO `technician` (`id`, `name`, `service_type`, `protal_id`, `job_title`, `origin`, `constellation`, `love`, `self_desc`, `header_pic`, `self_pic1`, `self_pic2`, `self_pic3`) VALUES
	(1, 'partys', 1, '292301002', '高级职业美甲师', '香格里拉市', '处女座', '看书，弹钢琴，泡妹子。', '我爱美甲就像我爱我家我爱美甲就像我爱我家我爱美甲就像我爱我家', 'http://imgq.duitang.com/uploads/item/201504/30/20150430124048_HsSdU.jpeg', 'http://imgq.duitang.com/uploads/item/201504/30/20150430124048_HsSdU.jpeg', 'http://imgq.duitang.com/uploads/item/201504/30/20150430124048_HsSdU.jpeg', 'http://imgq.duitang.com/uploads/item/201504/30/20150430124048_HsSdU.jpeg'),
	(2, '叶海燕', 1, '292301002', '高级职业美甲师', '香格里拉市', '狮子座', '看电视', '啦啦啦', 'http://imgq.duitang.com/uploads/item/201504/30/20150430124048_HsSdU.jpeg', NULL, NULL, NULL),
	(3, '张君苗', 1, '291943752', '高级职业美甲师', '香格里拉市', '双子座', '洗澡', '呵呵呵', 'http://imgq.duitang.com/uploads/item/201504/30/20150430124048_HsSdU.jpeg', NULL, NULL, NULL);
/*!40000 ALTER TABLE `technician` ENABLE KEYS */;


-- 导出  表 test.tec_business 结构
CREATE TABLE IF NOT EXISTS `tec_business` (
  `id` int(9) NOT NULL,
  `tec_id` int(12) DEFAULT NULL,
  `busns_id` int(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='技师与服务商圈关联表';

-- 正在导出表  test.tec_business 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `tec_business` DISABLE KEYS */;
INSERT INTO `tec_business` (`id`, `tec_id`, `busns_id`) VALUES
	(1, 1, 1),
	(2, 1, 2),
	(3, 2, 2),
	(4, 3, 1);
/*!40000 ALTER TABLE `tec_business` ENABLE KEYS */;


-- 导出  表 test.tec_service 结构
CREATE TABLE IF NOT EXISTS `tec_service` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `tec_id` int(9) NOT NULL COMMENT '技师id',
  `product_id` varchar(64) NOT NULL COMMENT '服务id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='技师与服务关联表';

-- 正在导出表  test.tec_service 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `tec_service` DISABLE KEYS */;
INSERT INTO `tec_service` (`id`, `tec_id`, `product_id`) VALUES
	(1, 1, 'pxgY4xHkOZMnQEmUSE8d3H1Otn68'),
	(2, 1, 'pxgY4xCJRaYAnLCXqqa9zYJzAw5k');
/*!40000 ALTER TABLE `tec_service` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
