CREATE SCHEMA IF NOT EXISTS `usermanage` DEFAULT CHARACTER SET utf8 ;
USE `usermanage` ;
DROP TABLE IF EXISTS `usermanage`.`users` ;

CREATE TABLE IF NOT EXISTS `users` (
	`login_name` VARCHAR(20) NOT NULL COMMENT '登录名',
	`user_name` VARCHAR(20) NOT NULL COMMENT '姓名,非空',
	`login_password` VARCHAR(60) NULL DEFAULT NULL COMMENT '登陆密码,可空',
	`source` VARCHAR(20) NOT NULL COMMENT '来源,非空',
	`create_by` VARCHAR(20) NOT NULL COMMENT '创建人,非空',
	`creation_date` DATETIME NOT NULL COMMENT '创建时间,非空',
	`modified_by` VARCHAR(20) NOT NULL COMMENT '最后修改人,非空',
	`modification_date` DATETIME NOT NULL COMMENT '最后修改时间,非空',
	`delete_status` VARCHAR(10) NOT NULL DEFAULT 'false' COMMENT '删除状态(true已删除,false未删除),非空',
	PRIMARY KEY (`login_id`))
COMMENT='用户信息表'
ENGINE=InnoDB;


DROP TABLE IF EXISTS `usermanage`.`roles` ;

CREATE TABLE IF NOT EXISTS `roles` (
	`role_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`role_name` VARCHAR(20) NOT NULL COMMENT '角色名,非空',
	`source` VARCHAR(20) NOT NULL COMMENT '来源,非空',
	`create_by` VARCHAR(20) NOT NULL COMMENT '创建人,非空',
	`creation_date` DATETIME NOT NULL COMMENT '创建时间,非空',
	`modified_by` VARCHAR(20) NOT NULL COMMENT '最后修改人,非空',
	`modification_date` DATETIME NOT NULL COMMENT '最后修改时间,非空',
	`delete_status` VARCHAR(10) NOT NULL DEFAULT 'false' COMMENT '删除状态(true已删除,false未删除),非空',
	PRIMARY KEY (`role_id`)
)
COMMENT='角色表'
ENGINE=InnoDB;


DROP TABLE IF EXISTS `usermanage`.`usergroup` ;

CREATE TABLE IF NOT EXISTS `usergroup` (
	`usergroup_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`usergroup_name` VARCHAR(20) NOT NULL COMMENT '用户组名,非空',
	`source` VARCHAR(20) NOT NULL COMMENT '来源,非空',
	`create_by` VARCHAR(20) NOT NULL COMMENT '创建人,非空',
	`creation_date` DATETIME NOT NULL COMMENT '创建时间,非空',
	`modified_by` VARCHAR(20) NOT NULL COMMENT '最后修改人,非空',
	`modification_date` DATETIME NOT NULL COMMENT '最后修改时间,非空',
	`delete_status` VARCHAR(10) NOT NULL DEFAULT 'false' COMMENT '删除状态(true已删除,false未删除),非空',
	PRIMARY KEY (`usergroup_id`)
)
COMMENT='用户组表'
ENGINE=InnoDB;


DROP TABLE IF EXISTS `usermanage`.`departments` ;

CREATE TABLE IF NOT EXISTS `departments` (
	`department_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`department_name` VARCHAR(20) NOT NULL COMMENT '部门名,非空',
	`parent_id` INT(11) NOT NULL COMMENT '上级部门id,非空',
	`source` VARCHAR(20) NOT NULL COMMENT '来源,非空',
	`create_by` VARCHAR(20) NOT NULL COMMENT '创建人,非空',
	`creation_date` DATETIME NOT NULL COMMENT '创建时间,非空',
	`modified_by` VARCHAR(20) NOT NULL COMMENT '最后修改人,非空',
	`modification_date` DATETIME NOT NULL COMMENT '最后修改时间,非空',
	`delete_status` VARCHAR(10) NOT NULL DEFAULT 'false' COMMENT '删除状态(true已删除,false未删除),非空',
	PRIMARY KEY (`department_id`)
)
COMMENT='部门表'
ENGINE=InnoDB;


DROP TABLE IF EXISTS `usermanage`.`rusersroles` ;

CREATE TABLE IF NOT EXISTS `rusersroles` (
	`login_id` VARCHAR(20) NOT NULL COMMENT '登陆id,非空',
	`role_id` INT(11) NOT NULL COMMENT '权限id,非空',
	 PRIMARY KEY (`login_id`,`role_id`)
)
COMMENT='用户权限关联表'
ENGINE=InnoDB;

DROP TABLE IF EXISTS `usermanage`.`rusersusergroup` ;

CREATE TABLE IF NOT EXISTS `rusersusergroup` (
	`login_id` VARCHAR(20) NOT NULL COMMENT '登陆id,非空',
	`usergroup_id` INT(11) NOT NULL COMMENT '用户组id,非空',
	 PRIMARY KEY (`login_id`,`usergroup_id`)
)
COMMENT='用户与用户组关联'
ENGINE=InnoDB;

DROP TABLE IF EXISTS `usermanage`.`rusersdepartment` ;

CREATE TABLE IF NOT EXISTS `rusersdepartment` (
	`login_id` VARCHAR(20) NOT NULL COMMENT '登陆id,非空',
	`department_id` INT(11) NOT NULL COMMENT '部门id,非空',
	 PRIMARY KEY (`login_id`,`department_id`)
)
COMMENT='用户与部门关联表联'
ENGINE=InnoDB;

DELETE FROM `users`;
INSERT INTO `users` (`login_id`, `user_name`,`login_password`, `source`,  `create_by`, `creation_date`, `modified_by`,`modification_date`,`delete_status`) VALUES
	('admin', 'admin', '123456',  'cdsweb',  '2014-05-20 22:06:50', 'admin', '2014-05-20 22:06:50','false');
DELETE FROM `roles`;
INSERT INTO `usermanage`.`roles`
(`role_name`,`source`,`create_by`,`creation_date`,`modified_by`,`modification_date`,`delete_status`)
VALUES('管理员','cdsweb','admin','2014-05-20 22:06:50', 'admin', '2014-05-20 22:06:50','false');