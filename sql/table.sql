ALTER TABLE `slave`.`include_client`
ADD COLUMN `create_by` varchar(32) NULL COMMENT '创建人' ,
ADD COLUMN `create_time` datetime(0) NULL COMMENT '创建时间' AFTER `create_by`,
ADD COLUMN `update_by` varchar(32) NULL COMMENT '修改人' AFTER `create_time`,
ADD COLUMN `update_time` datetime(0) NULL COMMENT '修改时间' AFTER `update_by`;