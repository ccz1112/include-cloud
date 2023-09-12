/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : nacos

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 12/09/2023 11:36:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_info
-- ----------------------------
DROP TABLE IF EXISTS `config_info`;
CREATE TABLE `config_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_use` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `effect` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_schema` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `encrypted_data_key` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '秘钥',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfo_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info
-- ----------------------------
INSERT INTO `config_info` VALUES (1, 'include-order', 'include', 'server:\n  port: 9100\nmy:\n  property: prod\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', 'e3837fdbb709bd295249fbb8c767bd79', '2023-09-07 07:19:53', '2023-09-12 03:23:29', 'nacos', '127.0.0.1', '', '05b0aec8-43d0-4b42-babb-7dbc3483a212', '', '', '', 'yaml', '', '');
INSERT INTO `config_info` VALUES (2, 'include-system', 'include', 'server:\n  port: 9200\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', '2f63e0ea32a43080eb8e8f18d278b0d7', '2023-09-07 07:19:53', '2023-09-07 07:19:53', NULL, '127.0.0.1', '', '05b0aec8-43d0-4b42-babb-7dbc3483a212', NULL, NULL, NULL, 'yaml', NULL, '');
INSERT INTO `config_info` VALUES (3, 'include-goods', 'include', 'server:\n  port: 9300\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', '78e484aa344598d753dc00b0f59da9a3', '2023-09-07 07:19:53', '2023-09-07 07:19:53', NULL, '127.0.0.1', '', '05b0aec8-43d0-4b42-babb-7dbc3483a212', NULL, NULL, NULL, 'yaml', NULL, '');
INSERT INTO `config_info` VALUES (4, 'include-auth', 'include', 'server:\n  port: 9400\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', '4b71af5762f80e89c5ca88b2da73746a', '2023-09-07 07:19:53', '2023-09-07 07:19:53', NULL, '127.0.0.1', '', '05b0aec8-43d0-4b42-babb-7dbc3483a212', NULL, NULL, NULL, 'yaml', NULL, '');
INSERT INTO `config_info` VALUES (5, 'include-gateway', 'include', 'server:\n  port: 9527\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  application:\n    name: include-geteway\n  cloud:\n    nacos:\n      discovery:\n        server-addr: 127.0.0.1:8848\n    gateway:\n      discovery:\n        locator:\n          enabled: true # 让gateway可以发现nacos中的微服务\n      routes:\n        - id: include-goods\n          uri: lb://include-goods\n          predicates:\n            - Path=/include-goods/**\n          filters:\n            - StripPrefix=1\n        - id: include-order\n          uri: lb://include-order\n          predicates:\n            - Path=/include-order/**\n          filters:\n            - StripPrefix=1\n        - id: include-system # 当前路由的标识, 要求唯一\n          uri: lb://include-system # 请求要转发到的地址,lb指的是从nacos中按照名称获取微服务,并遵循负载均衡策略\n          predicates: # 断言(就是路由转发要满足的条件\n            - Path=/include-system/** # 当请求路径满足Path指定的规则时,才进行路由转发\n          filters: # 过滤器,请求在传递过程中可以通过过滤器对其进行一定的修改\n            - StripPrefix=1 # 转发之前去掉1层路径\n        - id: include-chessRoom # 当前路由的标识, 要求唯一\n          uri: lb://include-chessRoom # 请求要转发到的地址,lb指的是从nacos中按照名称获取微服务,并遵循负载均衡策略\n          predicates: # 断言(就是路由转发要满足的条件\n            - Path=/include-chessRoom/** # 当请求路径满足Path指定的规则时,才进行路由转发\n          filters: # 过滤器,请求在传递过程中可以通过过滤器对其进行一定的修改\n            - StripPrefix=1 # 转发之前去掉1层路径\n        - id: include-auth # 当前路由的标识, 要求唯一\n          uri: lb://include-auth # 请求要转发到的地址,lb指的是从nacos中按照名称获取微服务,并遵循负载均衡策略\n          predicates: # 断言(就是路由转发要满足的条件\n            - Path=/include-auth/** # 当请求路径满足Path指定的规则时,才进行路由转发\n          filters: # 过滤器,请求在传递过程中可以通过过滤器对其进行一定的修改\n            - StripPrefix=1 # 转发之前去掉1层路径\n  redis:\n    port: 6379\n    host: 127.0.0.1\nsecure:\n  ignore:\n    urls: #配置白名单路径\n      - \"/include-system/includeUser/login\"\n      - \"/include-auth/oauth/token\"', '76666d84c3924fe96c84ec82a2afe81c', '2023-09-07 07:19:53', '2023-09-07 07:19:53', NULL, '127.0.0.1', '', '05b0aec8-43d0-4b42-babb-7dbc3483a212', NULL, NULL, NULL, 'yaml', NULL, '');
INSERT INTO `config_info` VALUES (10, 'include-order', 'include', 'server:\n  port: 9100\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', '13da5ffc1ae839bcfcfe425988a27ccf', '2023-09-07 07:27:15', '2023-09-07 07:27:15', NULL, '127.0.0.1', '', '98085a63-0aad-4441-b8f7-30fb972c9128', '', NULL, NULL, 'yaml', NULL, '');
INSERT INTO `config_info` VALUES (11, 'include-system', 'include', 'server:\n  port: 9200\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', '2f63e0ea32a43080eb8e8f18d278b0d7', '2023-09-07 07:27:15', '2023-09-07 07:27:15', NULL, '127.0.0.1', '', '98085a63-0aad-4441-b8f7-30fb972c9128', NULL, NULL, NULL, 'yaml', NULL, '');
INSERT INTO `config_info` VALUES (12, 'include-goods', 'include', 'server:\n  port: 9300\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', '78e484aa344598d753dc00b0f59da9a3', '2023-09-07 07:27:15', '2023-09-07 07:27:15', NULL, '127.0.0.1', '', '98085a63-0aad-4441-b8f7-30fb972c9128', NULL, NULL, NULL, 'yaml', NULL, '');
INSERT INTO `config_info` VALUES (13, 'include-auth', 'include', 'server:\n  port: 9400\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', '4b71af5762f80e89c5ca88b2da73746a', '2023-09-07 07:27:15', '2023-09-07 07:27:15', NULL, '127.0.0.1', '', '98085a63-0aad-4441-b8f7-30fb972c9128', NULL, NULL, NULL, 'yaml', NULL, '');
INSERT INTO `config_info` VALUES (14, 'include-gateway', 'include', 'server:\n  port: 9527\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  application:\n    name: include-geteway\n  cloud:\n    nacos:\n      discovery:\n        server-addr: 127.0.0.1:8848\n    gateway:\n      discovery:\n        locator:\n          enabled: true # 让gateway可以发现nacos中的微服务\n      routes:\n        - id: include-goods\n          uri: lb://include-goods\n          predicates:\n            - Path=/include-goods/**\n          filters:\n            - StripPrefix=1\n        - id: include-order\n          uri: lb://include-order\n          predicates:\n            - Path=/include-order/**\n          filters:\n            - StripPrefix=1\n        - id: include-system # 当前路由的标识, 要求唯一\n          uri: lb://include-system # 请求要转发到的地址,lb指的是从nacos中按照名称获取微服务,并遵循负载均衡策略\n          predicates: # 断言(就是路由转发要满足的条件\n            - Path=/include-system/** # 当请求路径满足Path指定的规则时,才进行路由转发\n          filters: # 过滤器,请求在传递过程中可以通过过滤器对其进行一定的修改\n            - StripPrefix=1 # 转发之前去掉1层路径\n        - id: include-chessRoom # 当前路由的标识, 要求唯一\n          uri: lb://include-chessRoom # 请求要转发到的地址,lb指的是从nacos中按照名称获取微服务,并遵循负载均衡策略\n          predicates: # 断言(就是路由转发要满足的条件\n            - Path=/include-chessRoom/** # 当请求路径满足Path指定的规则时,才进行路由转发\n          filters: # 过滤器,请求在传递过程中可以通过过滤器对其进行一定的修改\n            - StripPrefix=1 # 转发之前去掉1层路径\n        - id: include-auth # 当前路由的标识, 要求唯一\n          uri: lb://include-auth # 请求要转发到的地址,lb指的是从nacos中按照名称获取微服务,并遵循负载均衡策略\n          predicates: # 断言(就是路由转发要满足的条件\n            - Path=/include-auth/** # 当请求路径满足Path指定的规则时,才进行路由转发\n          filters: # 过滤器,请求在传递过程中可以通过过滤器对其进行一定的修改\n            - StripPrefix=1 # 转发之前去掉1层路径\n  redis:\n    port: 6379\n    host: 127.0.0.1\nsecure:\n  ignore:\n    urls: #配置白名单路径\n      - \"/include-system/includeUser/login\"\n      - \"/include-auth/oauth/token\"', '76666d84c3924fe96c84ec82a2afe81c', '2023-09-07 07:27:15', '2023-09-07 07:27:15', NULL, '127.0.0.1', '', '98085a63-0aad-4441-b8f7-30fb972c9128', NULL, NULL, NULL, 'yaml', NULL, '');

-- ----------------------------
-- Table structure for config_info_aggr
-- ----------------------------
DROP TABLE IF EXISTS `config_info_aggr`;
CREATE TABLE `config_info_aggr`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'datum_id',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '内容',
  `gmt_modified` datetime(0) NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfoaggr_datagrouptenantdatum`(`data_id`, `group_id`, `tenant_id`, `datum_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '增加租户字段' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for config_info_beta
-- ----------------------------
DROP TABLE IF EXISTS `config_info_beta`;
CREATE TABLE `config_info_beta`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  `encrypted_data_key` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '秘钥',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfobeta_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_beta' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for config_info_tag
-- ----------------------------
DROP TABLE IF EXISTS `config_info_tag`;
CREATE TABLE `config_info_tag`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfotag_datagrouptenanttag`(`data_id`, `group_id`, `tenant_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_tag' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for config_tags_relation
-- ----------------------------
DROP TABLE IF EXISTS `config_tags_relation`;
CREATE TABLE `config_tags_relation`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `tag_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`nid`) USING BTREE,
  UNIQUE INDEX `uk_configtagrelation_configidtag`(`id`, `tag_name`, `tag_type`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_tag_relation' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for group_capacity
-- ----------------------------
DROP TABLE IF EXISTS `group_capacity`;
CREATE TABLE `group_capacity`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_group_id`(`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '集群、各Group容量信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for his_config_info
-- ----------------------------
DROP TABLE IF EXISTS `his_config_info`;
CREATE TABLE `his_config_info`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nid` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `op_type` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  `encrypted_data_key` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '秘钥',
  PRIMARY KEY (`nid`) USING BTREE,
  INDEX `idx_gmt_create`(`gmt_create`) USING BTREE,
  INDEX `idx_gmt_modified`(`gmt_modified`) USING BTREE,
  INDEX `idx_did`(`data_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '多租户改造' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of his_config_info
-- ----------------------------
INSERT INTO `his_config_info` VALUES (0, 1, 'include-order', 'include', '', 'server:\n  port: 9100\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', '13da5ffc1ae839bcfcfe425988a27ccf', '2023-09-07 15:19:52', '2023-09-07 07:19:53', NULL, '127.0.0.1', 'I', '05b0aec8-43d0-4b42-babb-7dbc3483a212', '');
INSERT INTO `his_config_info` VALUES (0, 2, 'include-system', 'include', '', 'server:\n  port: 9200\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', '2f63e0ea32a43080eb8e8f18d278b0d7', '2023-09-07 15:19:52', '2023-09-07 07:19:53', NULL, '127.0.0.1', 'I', '05b0aec8-43d0-4b42-babb-7dbc3483a212', '');
INSERT INTO `his_config_info` VALUES (0, 3, 'include-goods', 'include', '', 'server:\n  port: 9300\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', '78e484aa344598d753dc00b0f59da9a3', '2023-09-07 15:19:52', '2023-09-07 07:19:53', NULL, '127.0.0.1', 'I', '05b0aec8-43d0-4b42-babb-7dbc3483a212', '');
INSERT INTO `his_config_info` VALUES (0, 4, 'include-auth', 'include', '', 'server:\n  port: 9400\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', '4b71af5762f80e89c5ca88b2da73746a', '2023-09-07 15:19:52', '2023-09-07 07:19:53', NULL, '127.0.0.1', 'I', '05b0aec8-43d0-4b42-babb-7dbc3483a212', '');
INSERT INTO `his_config_info` VALUES (0, 5, 'include-gateway', 'include', '', 'server:\n  port: 9527\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  application:\n    name: include-geteway\n  cloud:\n    nacos:\n      discovery:\n        server-addr: 127.0.0.1:8848\n    gateway:\n      discovery:\n        locator:\n          enabled: true # 让gateway可以发现nacos中的微服务\n      routes:\n        - id: include-goods\n          uri: lb://include-goods\n          predicates:\n            - Path=/include-goods/**\n          filters:\n            - StripPrefix=1\n        - id: include-order\n          uri: lb://include-order\n          predicates:\n            - Path=/include-order/**\n          filters:\n            - StripPrefix=1\n        - id: include-system # 当前路由的标识, 要求唯一\n          uri: lb://include-system # 请求要转发到的地址,lb指的是从nacos中按照名称获取微服务,并遵循负载均衡策略\n          predicates: # 断言(就是路由转发要满足的条件\n            - Path=/include-system/** # 当请求路径满足Path指定的规则时,才进行路由转发\n          filters: # 过滤器,请求在传递过程中可以通过过滤器对其进行一定的修改\n            - StripPrefix=1 # 转发之前去掉1层路径\n        - id: include-chessRoom # 当前路由的标识, 要求唯一\n          uri: lb://include-chessRoom # 请求要转发到的地址,lb指的是从nacos中按照名称获取微服务,并遵循负载均衡策略\n          predicates: # 断言(就是路由转发要满足的条件\n            - Path=/include-chessRoom/** # 当请求路径满足Path指定的规则时,才进行路由转发\n          filters: # 过滤器,请求在传递过程中可以通过过滤器对其进行一定的修改\n            - StripPrefix=1 # 转发之前去掉1层路径\n        - id: include-auth # 当前路由的标识, 要求唯一\n          uri: lb://include-auth # 请求要转发到的地址,lb指的是从nacos中按照名称获取微服务,并遵循负载均衡策略\n          predicates: # 断言(就是路由转发要满足的条件\n            - Path=/include-auth/** # 当请求路径满足Path指定的规则时,才进行路由转发\n          filters: # 过滤器,请求在传递过程中可以通过过滤器对其进行一定的修改\n            - StripPrefix=1 # 转发之前去掉1层路径\n  redis:\n    port: 6379\n    host: 127.0.0.1\nsecure:\n  ignore:\n    urls: #配置白名单路径\n      - \"/include-system/includeUser/login\"\n      - \"/include-auth/oauth/token\"', '76666d84c3924fe96c84ec82a2afe81c', '2023-09-07 15:19:52', '2023-09-07 07:19:53', NULL, '127.0.0.1', 'I', '05b0aec8-43d0-4b42-babb-7dbc3483a212', '');
INSERT INTO `his_config_info` VALUES (0, 9, 'include-order', 'include', '', 'server:\n  port: 9100\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', '13da5ffc1ae839bcfcfe425988a27ccf', '2023-09-07 15:27:14', '2023-09-07 07:27:15', NULL, '127.0.0.1', 'I', '98085a63-0aad-4441-b8f7-30fb972c9128', '');
INSERT INTO `his_config_info` VALUES (0, 10, 'include-system', 'include', '', 'server:\n  port: 9200\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', '2f63e0ea32a43080eb8e8f18d278b0d7', '2023-09-07 15:27:14', '2023-09-07 07:27:15', NULL, '127.0.0.1', 'I', '98085a63-0aad-4441-b8f7-30fb972c9128', '');
INSERT INTO `his_config_info` VALUES (0, 11, 'include-goods', 'include', '', 'server:\n  port: 9300\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', '78e484aa344598d753dc00b0f59da9a3', '2023-09-07 15:27:14', '2023-09-07 07:27:15', NULL, '127.0.0.1', 'I', '98085a63-0aad-4441-b8f7-30fb972c9128', '');
INSERT INTO `his_config_info` VALUES (0, 12, 'include-auth', 'include', '', 'server:\n  port: 9400\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', '4b71af5762f80e89c5ca88b2da73746a', '2023-09-07 15:27:14', '2023-09-07 07:27:15', NULL, '127.0.0.1', 'I', '98085a63-0aad-4441-b8f7-30fb972c9128', '');
INSERT INTO `his_config_info` VALUES (0, 13, 'include-gateway', 'include', '', 'server:\n  port: 9527\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  application:\n    name: include-geteway\n  cloud:\n    nacos:\n      discovery:\n        server-addr: 127.0.0.1:8848\n    gateway:\n      discovery:\n        locator:\n          enabled: true # 让gateway可以发现nacos中的微服务\n      routes:\n        - id: include-goods\n          uri: lb://include-goods\n          predicates:\n            - Path=/include-goods/**\n          filters:\n            - StripPrefix=1\n        - id: include-order\n          uri: lb://include-order\n          predicates:\n            - Path=/include-order/**\n          filters:\n            - StripPrefix=1\n        - id: include-system # 当前路由的标识, 要求唯一\n          uri: lb://include-system # 请求要转发到的地址,lb指的是从nacos中按照名称获取微服务,并遵循负载均衡策略\n          predicates: # 断言(就是路由转发要满足的条件\n            - Path=/include-system/** # 当请求路径满足Path指定的规则时,才进行路由转发\n          filters: # 过滤器,请求在传递过程中可以通过过滤器对其进行一定的修改\n            - StripPrefix=1 # 转发之前去掉1层路径\n        - id: include-chessRoom # 当前路由的标识, 要求唯一\n          uri: lb://include-chessRoom # 请求要转发到的地址,lb指的是从nacos中按照名称获取微服务,并遵循负载均衡策略\n          predicates: # 断言(就是路由转发要满足的条件\n            - Path=/include-chessRoom/** # 当请求路径满足Path指定的规则时,才进行路由转发\n          filters: # 过滤器,请求在传递过程中可以通过过滤器对其进行一定的修改\n            - StripPrefix=1 # 转发之前去掉1层路径\n        - id: include-auth # 当前路由的标识, 要求唯一\n          uri: lb://include-auth # 请求要转发到的地址,lb指的是从nacos中按照名称获取微服务,并遵循负载均衡策略\n          predicates: # 断言(就是路由转发要满足的条件\n            - Path=/include-auth/** # 当请求路径满足Path指定的规则时,才进行路由转发\n          filters: # 过滤器,请求在传递过程中可以通过过滤器对其进行一定的修改\n            - StripPrefix=1 # 转发之前去掉1层路径\n  redis:\n    port: 6379\n    host: 127.0.0.1\nsecure:\n  ignore:\n    urls: #配置白名单路径\n      - \"/include-system/includeUser/login\"\n      - \"/include-auth/oauth/token\"', '76666d84c3924fe96c84ec82a2afe81c', '2023-09-07 15:27:14', '2023-09-07 07:27:15', NULL, '127.0.0.1', 'I', '98085a63-0aad-4441-b8f7-30fb972c9128', '');
INSERT INTO `his_config_info` VALUES (0, 14, '1', 'include', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2023-09-07 17:33:18', '2023-09-07 09:33:19', NULL, '127.0.0.1', 'I', '05b0aec8-43d0-4b42-babb-7dbc3483a212', '');
INSERT INTO `his_config_info` VALUES (15, 15, '1', 'include', '', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2023-09-07 17:33:24', '2023-09-07 09:33:24', NULL, '127.0.0.1', 'D', '05b0aec8-43d0-4b42-babb-7dbc3483a212', '');
INSERT INTO `his_config_info` VALUES (1, 16, 'include-order', 'include', '', 'server:\n  port: 9100\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', '13da5ffc1ae839bcfcfe425988a27ccf', '2023-09-12 11:17:36', '2023-09-12 03:17:37', 'nacos', '127.0.0.1', 'U', '05b0aec8-43d0-4b42-babb-7dbc3483a212', '');
INSERT INTO `his_config_info` VALUES (1, 17, 'include-order', 'include', '', 'server:\n  port: 9100\nmy:\n  property: dev\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', 'dfde3f92d4ec77891548aa8c3736c8c4', '2023-09-12 11:18:42', '2023-09-12 03:18:43', 'nacos', '127.0.0.1', 'U', '05b0aec8-43d0-4b42-babb-7dbc3483a212', '');
INSERT INTO `his_config_info` VALUES (1, 18, 'include-order', 'include', '', 'server:\n  port: 9100\nmy:\n  property: prod\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', 'e3837fdbb709bd295249fbb8c767bd79', '2023-09-12 11:22:49', '2023-09-12 03:22:49', 'nacos', '127.0.0.1', 'U', '05b0aec8-43d0-4b42-babb-7dbc3483a212', '');
INSERT INTO `his_config_info` VALUES (1, 19, 'include-order', 'include', '', 'server:\n  port: 9100\nmy:\n  property: prod\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN\nspring:\n  main:\n    allow-bean-definition-overriding: true\n  application:\n    name: include-order\n  datasource:\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://127.0.0.1:3306/slave?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false\n    username: root\n    password: root\n  redis:\n    port: 6379\n    host: 127.0.0.1\n  rabbitmq:\n    host: 127.0.0.1\n    port: 5672\n    username: guest\n    password: guest\n    publisher-confirms: true\n    virtual-host: /\nmybatis:\n  mapper-locations: classpath:mapper/**.xml\n  configuration:\n    use-generated-keys: true\n    use-column-label: true\n    map-underscore-to-camel-case: true\n    lazy-loading-enabled: true', '9efc7ed02dbc3648b08e1047846b7a18', '2023-09-12 11:23:29', '2023-09-12 03:23:29', 'nacos', '127.0.0.1', 'U', '05b0aec8-43d0-4b42-babb-7dbc3483a212', '');

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `resource` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `action` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  UNIQUE INDEX `uk_role_permission`(`role`, `resource`, `action`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  UNIQUE INDEX `idx_user_role`(`username`, `role`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('nacos', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for tenant_capacity
-- ----------------------------
DROP TABLE IF EXISTS `tenant_capacity`;
CREATE TABLE `tenant_capacity`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数',
  `max_aggr_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '租户容量信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint(20) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_info_kptenantid`(`kp`, `tenant_id`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'tenant_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_info
-- ----------------------------
INSERT INTO `tenant_info` VALUES (1, '1', '05b0aec8-43d0-4b42-babb-7dbc3483a212', 'dev', '测试环境', 'nacos', 1694071236130, 1694071236130);
INSERT INTO `tenant_info` VALUES (2, '1', '98085a63-0aad-4441-b8f7-30fb972c9128', 'prod', '生产环境', 'nacos', 1694071244418, 1694071244418);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', 1);

SET FOREIGN_KEY_CHECKS = 1;
