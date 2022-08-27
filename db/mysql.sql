DROP DATABASE IF EXISTS ssmvaUdU;

CREATE DATABASE ssmvaUdU default character set utf8mb4 collate utf8mb4_general_ci;

USE ssmvaUdU;

DROP TABLE IF EXISTS `yimiaoleixing`;

CREATE TABLE `yimiaoleixing` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`addtime` timestamp NOT NULL default CURRENT_TIMESTAMP,
	`yimiaoleixing` varchar(200)    COMMENT '疫苗类型',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='疫苗类型';

DROP TABLE IF EXISTS `yimiaomingcheng`;

CREATE TABLE `yimiaomingcheng` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`addtime` timestamp NOT NULL default CURRENT_TIMESTAMP,
	`yimiaobianhao` varchar(200)  UNIQUE   COMMENT '疫苗编号',
	`yimiaomingcheng` varchar(200)    COMMENT '疫苗名称',
	`yimiaoleixing` varchar(200)    COMMENT '疫苗类型',
	`kucunshuliang` int    COMMENT '库存数量',
	`jiezhongnianling` varchar(200)    COMMENT '接种年龄',
	`xiangqing` longtext    COMMENT '详情',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='疫苗名称';

DROP TABLE IF EXISTS `zuixingonggao`;

CREATE TABLE `zuixingonggao` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`addtime` timestamp NOT NULL default CURRENT_TIMESTAMP,
	`bianhao` varchar(200)  UNIQUE   COMMENT '编号',
	`biaoti` varchar(200)    COMMENT '标题',
	`tupian` varchar(200)    COMMENT '图片',
	`neirong` longtext    COMMENT '内容',
	`fabushijian` date    COMMENT '发布时间',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='最新公告';

DROP TABLE IF EXISTS `yuangong`;

CREATE TABLE `yuangong` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`addtime` timestamp NOT NULL default CURRENT_TIMESTAMP,
	`gonghao` varchar(200)  UNIQUE   COMMENT '工号',
	`xingming` varchar(200)    COMMENT '姓名',
	`mima` varchar(200)    COMMENT '密码',
	`nianling` varchar(200)    COMMENT '年龄',
	`zhicheng` varchar(200)    COMMENT '职称',
	`lianxidianhua` varchar(200)    COMMENT '联系电话',
	`shenfenzheng` varchar(200)    COMMENT '身份证',
	`jiatingzhuzhi` varchar(200)    COMMENT '家庭住址',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工';

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`addtime` timestamp NOT NULL default CURRENT_TIMESTAMP,
	`title` varchar(200) NOT NULL   COMMENT '标题',
	`picture` varchar(200) NOT NULL   COMMENT '图片',
	`content` longtext NOT NULL   COMMENT '内容',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='新闻资讯';


DROP TABLE IF EXISTS `config`;

CREATE TABLE `config`(
	`id` bigint NOT NULL AUTO_INCREMENT,
	`name` varchar(100) NOT NULL COMMENT '配置参数名称',
	`value` varchar(100) COMMENT '配置参数值',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='配置文件';

insert into config(id,name) values(1,'picture1');
insert into config(id,name) values(2,'picture2');
insert into config(id,name) values(3,'picture3');
insert into config(id,name) values(4,'picture4');
insert into config(id,name) values(5,'picture5');
insert into config(id,name) values(6,'homepage');


DROP TABLE IF EXISTS `users`;

CREATE TABLE `users`(
	`id` bigint NOT NULL AUTO_INCREMENT,
	`username` varchar(100) NOT NULL COMMENT '用户名',
	`password` varchar(100) NOT NULL COMMENT '密码',
	`role` varchar(100) default '管理员' COMMENT '角色',
	`addtime` timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '新增时间',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

insert into users(id,username, password) values(1,'abo','abo');

DROP TABLE IF EXISTS `token`;

CREATE TABLE `token`(
	`id` bigint NOT NULL AUTO_INCREMENT,
	`userid` bigint NOT NULL COMMENT '用户id',
	`username` varchar(100) NOT NULL COMMENT '用户名',
	`tablename` varchar(100) COMMENT '表名',
	`role` varchar(100) COMMENT '角色',
	`token` varchar(200) NOT NULL COMMENT '密码',
	`addtime` timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '新增时间',
	`expiratedtime` timestamp COMMENT '过期时间',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='token表';

