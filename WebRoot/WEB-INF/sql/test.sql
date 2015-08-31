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


-- 导出  表 test.favorite 结构
CREATE TABLE IF NOT EXISTS `favorite` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `product_id` varchar(64) DEFAULT NULL COMMENT '服务id',
  `buyer_openid` varchar(28) DEFAULT NULL COMMENT '用户id',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '收藏时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='收藏';

-- 正在导出表  test.favorite 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `favorite` DISABLE KEYS */;
INSERT INTO `favorite` (`id`, `product_id`, `buyer_openid`, `time`) VALUES
	(2, 'pxgY4xCJRaYAnLCXqqa9zYJzAw5k', 'oxgY4xDnXebndNr-B6r5fRDXrHFo', '2015-08-19 15:00:25'),
	(3, 'pxgY4xHkOZMnQEmUSE8d3H1Otn68', 'oxgY4xDnXebndNr-B6r5fRDXrHFo', '2015-08-19 15:25:34'),
	(4, 'pxgY4xHkOZMnQEmUSE8d3H1Otn68', 'oxgY4xMJB-wNeWM1R_yHJwyI1yEQ', '2015-08-19 15:26:28'),
	(5, 'pxgY4xCJRaYAnLCXqqa9zYJzAw5k', 'oxgY4xMJB-wNeWM1R_yHJwyI1yEQ', '2015-08-19 15:26:46');
/*!40000 ALTER TABLE `favorite` ENABLE KEYS */;


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

-- 正在导出表  test.order_comment 的数据：~10 rows (大约)
/*!40000 ALTER TABLE `order_comment` DISABLE KEYS */;
INSERT INTO `order_comment` (`order_id`, `evaluation`, `stars`, `profnal_score`, `move_score`, `punctual_score`, `description`, `time`, `pic1`, `pic2`, `pic3`) VALUES
	('14139058477811055457', 1, 5.0, 5.0, 5.0, 5.0, '不咋地', '2015-08-16 10:30:05', NULL, NULL, NULL),
	('14139058477811107681', 1, 5.0, 5.0, 5.0, 5.0, '还行 ', '2015-08-17 10:30:05', NULL, NULL, NULL),
	('14139058477811107682', 1, 5.0, 5.0, 5.0, 5.0, '我觉得太牛逼了啊', '2015-08-18 10:30:05', 'http://img3.imgtn.bdimg.com/it/u=3213189824,882695731&fm=21&gp=0.jpg', 'http://img3.imgtn.bdimg.com/it/u=3213189824,882695731&fm=21&gp=0.jpg', 'http://www.wed114.cn/jiehun/uploads/allimg/150117/44_150117112200_1.jpg'),
	('14139058477811174845', 1, 4.0, 4.0, 4.0, 5.0, '亲亲爱爱 美死了 下次还找他', '2015-08-04 15:18:46', '', '', ''),
	('14139058477811179908', 1, 5.0, 5.0, 5.0, 5.0, '嗯 。。。', '2015-08-04 15:18:46', NULL, NULL, NULL),
	('14139058477811388960', 1, 5.0, 5.0, 5.0, 2.0, '11111', '2015-08-01 15:18:46', NULL, NULL, NULL),
	('14139058477811388973', 0, 5.0, 4.0, 4.0, 4.0, 'こんにちは', '2015-08-02 15:18:46', 'http://img3.imgtn.bdimg.com/it/u=3213189824,882695731&fm=21&gp=0.jpg', 'http://img3.imgtn.bdimg.com/it/u=3213189824,882695731&fm=21&gp=0.jpg', NULL),
	('14139058477811391868', 0, 1.0, 3.0, 3.0, 3.0, '哈哈哈', '2015-08-04 15:18:46', NULL, NULL, NULL),
	('14139058477811396388', 0, 5.0, 5.0, 5.0, 5.0, 'ありがど', '2015-08-03 15:18:46', 'http://www.wed114.cn/jiehun/uploads/allimg/150117/44_150117112200_1.jpg', NULL, NULL),
	('14139058477811397061', 1, 5.0, 5.0, 5.0, 3.0, '啦啦啦', '2015-08-05 15:18:46', NULL, NULL, NULL);
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

-- 正在导出表  test.order_extend 的数据：~15 rows (大约)
/*!40000 ALTER TABLE `order_extend` DISABLE KEYS */;
INSERT INTO `order_extend` (`order_id`, `tec_id`, `product_id`, `buyer_openid`, `buyer_nick`, `name`, `order_time`, `order_type`, `address`, `tel`) VALUES
	('14139058477811388960', 1, 'pxgY4xCWoiksX47EHr_7XcFhPci8', 'oxgY4xDnXebndNr-B6r5fRDXrHFo', 'PaladinX', NULL, '2015-08-21 16:00:00', 0, '南京市雨花台区雨花南路32号1幢', '25545569'),
	('14139058477811388973', 1, 'pxgY4xHkOZMnQEmUSE8d3H1Otn68', 'oxgY4xDnXebndNr-B6r5fRDXrHFo', 'PaladinX', NULL, '2015-08-22 17:00:00', 0, '江苏省南京市雨花台区雨花南路', '15950592210'),
	('14139058477811389037', 1, 'pxgY4xHkOZMnQEmUSE8d3H1Otn68', 'oxgY4xDnXebndNr-B6r5fRDXrHFo', 'PaladinX', NULL, '2015-08-22 16:00:00', 0, '江苏省南京市雨花台区雨花南路', '15950592210'),
	('14139058477811390086', 1, 'pxgY4xHkOZMnQEmUSE8d3H1Otn68', 'oxgY4xDnXebndNr-B6r5fRDXrHFo', 'PaladinX', NULL, '2015-08-21 15:00:00', 0, '江苏省南京市雨花台区雨花南路', '15950592210'),
	('14139058477811391868', 1, 'pxgY4xCWoiksX47EHr_7XcFhPci8', 'oxgY4xDnXebndNr-B6r5fRDXrHFo', 'PaladinX', NULL, '2015-08-21 16:00:00', 0, '南京市雨花台区雨花南路32号1幢', '25545569'),
	('14139058477811392557', 1, 'pxgY4xHkOZMnQEmUSE8d3H1Otn68', 'oxgY4xDnXebndNr-B6r5fRDXrHFo', 'PaladinX', NULL, '2015-08-21 17:00:00', 1, '南京市雨花台区凤翔新城', '15950592210'),
	('14139058477811392611', 1, 'pxgY4xHkOZMnQEmUSE8d3H1Otn68', 'oxgY4xDnXebndNr-B6r5fRDXrHFo', 'PaladinX', NULL, '2015-08-21 17:00:00', 1, '南京市雨花台区凤翔新城', '15950592210'),
	('14139058477811396247', 2, 'pxgY4xCWoiksX47EHr_7XcFhPci8', 'oxgY4xMJB-wNeWM1R_yHJwyI1yEQ', 'zhangqw', NULL, '2015-08-23 17:00:00', 1, '南京市建邺区南京市建邺区政府', '15951903466'),
	('14139058477811396334', 2, 'pxgY4xCWoiksX47EHr_7XcFhPci8', 'oxgY4xMJB-wNeWM1R_yHJwyI1yEQ', 'zhangqw', NULL, '2015-08-23 18:00:00', 1, '南京市雨花台区龙淮路-道路', '15951903466'),
	('14139058477811396370', 1, 'pxgY4xHkOZMnQEmUSE8d3H1Otn68', 'oxgY4xDnXebndNr-B6r5fRDXrHFo', 'PaladinX', NULL, '2015-08-21 15:00:00', 0, NULL, NULL),
	('14139058477811396388', 2, 'pxgY4xHkOZMnQEmUSE8d3H1Otn68', 'oxgY4xDnXebndNr-B6r5fRDXrHFo', 'PaladinX', NULL, '2015-08-21 23:00:00', 0, NULL, NULL),
	('14139058477811397025', 2, 'pxgY4xHkOZMnQEmUSE8d3H1Otn68', 'oxgY4xDnXebndNr-B6r5fRDXrHFo', 'PaladinX', NULL, '2015-08-21 23:00:00', 1, '江苏省南京市雨花台区雨花南路58-2号', '15950592210'),
	('14139058477811397038', 1, 'pxgY4xHkOZMnQEmUSE8d3H1Otn68', 'oxgY4xDnXebndNr-B6r5fRDXrHFo', 'PaladinX', NULL, '2015-08-21 23:00:00', 0, NULL, NULL),
	('14139058477811397061', 2, 'pxgY4xCWoiksX47EHr_7XcFhPci8', 'oxgY4xMJB-wNeWM1R_yHJwyI1yEQ', 'zhangqw', NULL, '2015-08-22 23:00:00', 1, '江苏省南京市雨花台区龙淮路', '15951903466'),
	('14139058477811397370', 2, 'pxgY4xLG0WxSLPw6rK2bo1zbI4gk', 'oxgY4xDnXebndNr-B6r5fRDXrHFo', 'PaladinX', NULL, '2015-08-22 15:00:00', 0, NULL, NULL);
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
  `id` int(12) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='技师表';

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='技师与服务关联表';

-- 正在导出表  test.tec_service 的数据：~17 rows (大约)
/*!40000 ALTER TABLE `tec_service` DISABLE KEYS */;
INSERT INTO `tec_service` (`id`, `tec_id`, `product_id`) VALUES
	(1, 1, 'pxgY4xHkOZMnQEmUSE8d3H1Otn68'),
	(2, 1, 'pxgY4xCJRaYAnLCXqqa9zYJzAw5k'),
	(3, 1, 'pxgY4xLG0WxSLPw6rK2bo1zbI4gk'),
	(4, 1, 'pxgY4xDUmHRfbE90Z9gqNO4wkwQU'),
	(5, 1, 'pxgY4xCWoiksX47EHr_7XcFhPci8'),
	(6, 1, 'pxgY4xC4jNrz9_G_MAf6nSOFVhUs'),
	(7, 1, 'pxgY4xO7NfXn27Xj_kEcDD9u0eMs'),
	(8, 1, 'pxgY4xMFRlgnMJuxWiRs56oMWAAY'),
	(9, 1, 'pxgY4xE65f8MG-OS9XL8PTihkJ4E'),
	(10, 1, 'pxgY4xHojg30SJlBXgQnxwi-6AAo'),
	(11, 1, 'pxgY4xIBx9bu7j1r6xw1qRgiNnzw'),
	(12, 2, 'pxgY4xLG0WxSLPw6rK2bo1zbI4gk'),
	(13, 2, 'pxgY4xHkOZMnQEmUSE8d3H1Otn68'),
	(14, 2, 'pxgY4xCJRaYAnLCXqqa9zYJzAw5k'),
	(15, 2, 'pxgY4xDUmHRfbE90Z9gqNO4wkwQU'),
	(16, 2, 'pxgY4xGHkCUTkdvP3lRppvGCBjXs'),
	(17, 2, 'pxgY4xDy7XiXwuTW-tv85Zr-eyxk');
/*!40000 ALTER TABLE `tec_service` ENABLE KEYS */;


-- 导出  触发器 test.copy_to_orderextend 结构
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `copy_to_orderextend` AFTER UPDATE ON `order_extend_tmp` FOR EACH ROW BEGIN
	if new.order_id is not null then
		INSERT INTO order_extend (order_id, buyer_openid, product_id,buyer_nick,tec_id,name,order_time,order_type,address,tel) 
				values (new.order_id, new.buyer_openid, new.product_id,new.buyer_nick,new.tec_id,new.name,new.order_time,new.order_type,new.address,new.tel)
				  ON DUPLICATE KEY UPDATE buyer_openid=new.buyer_openid,product_id=new.product_id, buyer_nick = new.buyer_nick,tec_id=new.tec_id,name=new.name,order_time=new.order_time,order_type=new.order_type,address=new.address,
				  tel = new.tel;
	end if;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
