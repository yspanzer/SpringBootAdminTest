/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : geekcattle

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2018-02-11 16:07:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adjust
-- ----------------------------
DROP TABLE IF EXISTS `adjust`;
CREATE TABLE `adjust` (
  `uid` varchar(32) NOT NULL,
  `adjust_num` varchar(50) DEFAULT NULL,
  `order_unit` varchar(50) NOT NULL,
  `productname` varchar(60) NOT NULL,
  `factory` varchar(60) DEFAULT NULL,
  `unit` varchar(20) DEFAULT NULL,
  `number` decimal(20,0) DEFAULT NULL,
  `shipment_time` datetime DEFAULT NULL,
  `adjust_begin` datetime DEFAULT NULL,
  `adjust_end` datetime DEFAULT NULL,
  `adjust_man` varchar(20) DEFAULT NULL,
  `adjust_unit` varchar(20) DEFAULT NULL,
  `receipt_man` varchar(20) DEFAULT NULL,
  `receipt_begin` datetime DEFAULT NULL,
  `receipt_end` datetime DEFAULT NULL,
  `purcha_data_man` varchar(20) DEFAULT NULL,
  `purchabillno` varchar(20) DEFAULT NULL,
  `purcha_data_begin` datetime DEFAULT NULL,
  `purcha_data_end` datetime DEFAULT NULL,
  `check_man` varchar(20) DEFAULT NULL,
  `check_begin` datetime DEFAULT NULL,
  `check_end` datetime DEFAULT NULL,
  `distrib_pack_man` varchar(20) DEFAULT NULL,
  `distrib_deli_man` varchar(20) DEFAULT NULL,
  `distrib_begin` datetime DEFAULT NULL,
  `distrib_end` datetime DEFAULT NULL,
  `receipt_addr` varchar(20) DEFAULT NULL,
  `sendout_time` datetime DEFAULT NULL,
  `reciept_man` varchar(20) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `createdat` datetime DEFAULT NULL,
  `updatedat` datetime DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adjust
-- ----------------------------
INSERT INTO `adjust` VALUES ('cbca4222aa314c3f9252228df353823e', 'LOAD201801250001', 'sadfasd', 'fasdfa', 'sdfasdf', 'asdf', '333', '2018-01-25 11:45:00', '2018-01-25 11:40:00', '2018-01-25 11:50:00', 'asdfasdf', 'asdfasdf', 'asdf', '2018-01-25 18:41:00', '2018-01-25 11:45:00', 'adsfasdf', 'asdfasdf', '2018-01-25 10:45:00', '2018-01-25 10:45:00', 'asdfasd', '2018-01-25 11:50:00', '2018-01-25 10:50:00', 'asdfasd', 'fasdfasdf', '2018-01-25 18:55:00', '2018-01-25 11:40:00', 'asdfasdf', '2018-01-25 11:30:00', 'asdfasdf', null, '6', null, '2018-01-25 18:44:16');

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `uid` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `state` tinyint(1) NOT NULL DEFAULT '1',
  `salt` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `is_system` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `unique_username` (`username`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('016465786de84f4b86df6a53ef17d5dd', 'disadd', 'cab4823f8918b645d2ccf2ff7e02f9a8', '1', 'cb89a1e22cd2e9653be06722c5cbd517', '0', '2018-01-23 18:24:59', '2018-02-05 11:37:04');
INSERT INTO `admin` VALUES ('05c8575a130b476486d71ace6b4f51cd', 'reacch', 'cf904320d336ef8af044e56661d3a9de', '1', '49f1a4874499c221c857cdf148c26a25', '0', '2018-01-20 10:45:18', '2018-01-22 11:27:07');
INSERT INTO `admin` VALUES ('09fae61e482147618e1211bd3a140f4e', 'retall', '028a93013ffa81296d0ebbc47d50562d', '1', 'fde9ba2ba2b1950b175010738926344a', '0', '2018-01-20 10:52:24', '2018-01-22 11:28:27');
INSERT INTO `admin` VALUES ('0a592f4cc39a47dca6e2381442e67a8d', 'kevin', '6baf8d8f82ce215691b39e11d1fb15c5', '1', '68f286aac357a9d103043ed2c7006e3a', '0', '2018-02-05 17:19:26', '2018-02-05 17:19:26');
INSERT INTO `admin` VALUES ('1b3542a5949c49acb2d95761b8d99207', 'kevinliang', '06686ed56c37182eebe3f95410e97491', '1', '44d1fe9fa9622e847263124a1028d537', '0', '2018-02-05 17:23:10', '2018-02-05 17:23:10');
INSERT INTO `admin` VALUES ('1b9b5bec89f340c3a9884a87f930795e', 'disinfor', '126e210f0a82a9799782caa156c015ff', '1', 'c9f5c00bab606eae939ca8059a891c61', '0', '2018-01-23 18:26:36', '2018-01-23 18:26:36');
INSERT INTO `admin` VALUES ('21a97c4692f046568e6553d9bbf3bb7e', 'discheck', 'bec98208bf854343d4d8de52d14014a9', '1', '8f284ef59e4096fb371bbed5aa1a9dac', '0', '2018-01-23 18:26:13', '2018-01-26 09:33:12');
INSERT INTO `admin` VALUES ('3e6e40e38f95424abc009863f8a23805', 'disdata', '08e82dbc14578e649a1af811d791068c', '1', 'df3ae85f00691cb998a7144ae492efb4', '0', '2018-01-23 18:25:47', '2018-02-01 10:31:38');
INSERT INTO `admin` VALUES ('4b62780dc5834b9ea73c69ccd7f793c9', 'display', 'c2f7328f79069c1661c354645cc169a9', '1', '4ad22080896d3df7b7077a6e504f8ae5', '0', '2018-01-24 15:53:03', '2018-01-25 08:47:54');
INSERT INTO `admin` VALUES ('78dbae47e7194a838e4f843756b6c3d6', 'gggg', 'fbeff5f1f9fcdd7150a7f0f916dac822', '1', 'b564c0e53a4f7ca6266af6574ca0ba6d', '0', '2017-12-19 17:55:10', '2017-12-19 17:55:10');
INSERT INTO `admin` VALUES ('8b92d62f52e8404e927524d817b3141f', 'dddd', 'ec310c9f6265e21372a7ae80489f65bf', '1', '6a32cbc205a8064316f9f5df822b5a7a', '0', '2017-12-19 17:57:51', '2017-12-19 17:57:51');
INSERT INTO `admin` VALUES ('96f1efcd0e4745dca427e11b2b03afc2', 'adjdis', 'ac42753cba221d3ae0c1fa7b30b1e755', '1', 'b93b128b678752751db72ff15c6a4242', '0', '2018-01-25 18:22:53', '2018-01-25 18:22:53');
INSERT INTO `admin` VALUES ('9c4ce2041a6447a984faea804ff9052c', 'rerece', '3ff5f347e9ac1d329b4ac6800121e389', '1', '0d8a8ebbef93cc62824b4d5a213a9b32', '0', '2018-01-20 10:44:09', '2018-01-20 10:44:09');
INSERT INTO `admin` VALUES ('ad313d38fe9447ce863fe8584743a010', 'admin', 'c5941c5f3bc693a75e6e863bd2c55ce3', '1', '1ab6d62faa91ae7deec76d6f13ef1600', '1', '2016-12-06 11:16:51', '2017-05-11 13:59:25');
INSERT INTO `admin` VALUES ('b1c3d4b81ab84d26968846401878d738', 'adjdata', 'c979011f71b616ba32f82db29933094e', '1', 'c803470df0ab058f718a507a50508e52', '0', '2018-01-25 18:21:21', '2018-01-25 18:21:21');
INSERT INTO `admin` VALUES ('b7124ebeaed14606ba53331601bd1dd2', 'dataadd', 'a24aa8e53c4df1d078af8999dee31456', '1', '97d3a311b98f8f1d139a175e3b4cbbf6', '0', '2017-12-22 10:43:19', '2018-02-01 11:50:33');
INSERT INTO `admin` VALUES ('c140a99fde1f41908dc038fc564e91c9', 'reacba', 'bcbd1eefee93a7b1881ee1ad26a578ec', '1', 'b03db0e30dc633c3b1e67a460ee7054c', '0', '2018-01-20 10:51:37', '2018-01-22 11:27:26');
INSERT INTO `admin` VALUES ('ccdb16b85e2f4c05858a0c0367be0923', 'reacre', 'c265e71e78df94b66c48f0f8052e4ceb', '1', 'db37681cf4eac038b3df20aef48ad940', '0', '2018-01-20 10:44:49', '2018-01-20 18:10:17');
INSERT INTO `admin` VALUES ('d66fe77e7c594ba28497a8a7c16990a1', 'adjcheck', '07a2e77a4a5ce5cd3a4d724e0419c8e9', '1', '582fcb0efd62ca7375dadb8e2318e28d', '0', '2018-01-25 18:22:15', '2018-01-25 18:22:15');
INSERT INTO `admin` VALUES ('d730fede8d6142ab8576b9b14cf8a934', 'ceshi123', 'f0f8031f150bf43268e9b0d1bbe47b9c', '1', '225c8d0b6e09c5903ce62d4afbec0ff1', '0', '2018-02-05 17:24:04', '2018-02-05 17:24:04');
INSERT INTO `admin` VALUES ('dfde3a0859dd44cfaca8e4f7ba445f3e', 'adjadd', 'bf8abe606973b0e72fc8e1dc8d21f243', '1', '9063eefad5ebd65d8dc498b4614855be', '0', '2018-01-25 18:17:27', '2018-01-25 18:17:27');
INSERT INTO `admin` VALUES ('fac4937be5174824a40ab779519be810', 'adjrece', '803292f4c07df0a41ac4507b02faa43d', '1', '16e03a4262150970d8327fd1618bfbfb', '0', '2018-01-25 18:17:53', '2018-01-25 18:17:53');

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `admin_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`admin_id`,`role_id`),
  KEY `admin_role_foreign` (`role_id`) USING BTREE,
  CONSTRAINT `fk_ref_admin` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`uid`),
  CONSTRAINT `fk_ref_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES ('1b3542a5949c49acb2d95761b8d99207', '03578ed5e5bc499f966182ef95ef6f27');
INSERT INTO `admin_role` VALUES ('b7124ebeaed14606ba53331601bd1dd2', '03578ed5e5bc499f966182ef95ef6f27');
INSERT INTO `admin_role` VALUES ('c140a99fde1f41908dc038fc564e91c9', '03578ed5e5bc499f966182ef95ef6f27');
INSERT INTO `admin_role` VALUES ('d730fede8d6142ab8576b9b14cf8a934', '03578ed5e5bc499f966182ef95ef6f27');
INSERT INTO `admin_role` VALUES ('016465786de84f4b86df6a53ef17d5dd', '0a8cac6ee1d346249a9e04aab263da29');
INSERT INTO `admin_role` VALUES ('1b3542a5949c49acb2d95761b8d99207', '0a8cac6ee1d346249a9e04aab263da29');
INSERT INTO `admin_role` VALUES ('b7124ebeaed14606ba53331601bd1dd2', '0a8cac6ee1d346249a9e04aab263da29');
INSERT INTO `admin_role` VALUES ('d730fede8d6142ab8576b9b14cf8a934', '0a8cac6ee1d346249a9e04aab263da29');
INSERT INTO `admin_role` VALUES ('09fae61e482147618e1211bd3a140f4e', '3008910e9eb8408aa1a97c3f6a842f0f');
INSERT INTO `admin_role` VALUES ('b7124ebeaed14606ba53331601bd1dd2', '3008910e9eb8408aa1a97c3f6a842f0f');
INSERT INTO `admin_role` VALUES ('d730fede8d6142ab8576b9b14cf8a934', '3008910e9eb8408aa1a97c3f6a842f0f');
INSERT INTO `admin_role` VALUES ('016465786de84f4b86df6a53ef17d5dd', '36f1dd1296674fc08484c5abf6a5806b');
INSERT INTO `admin_role` VALUES ('05c8575a130b476486d71ace6b4f51cd', '36f1dd1296674fc08484c5abf6a5806b');
INSERT INTO `admin_role` VALUES ('09fae61e482147618e1211bd3a140f4e', '36f1dd1296674fc08484c5abf6a5806b');
INSERT INTO `admin_role` VALUES ('1b9b5bec89f340c3a9884a87f930795e', '36f1dd1296674fc08484c5abf6a5806b');
INSERT INTO `admin_role` VALUES ('21a97c4692f046568e6553d9bbf3bb7e', '36f1dd1296674fc08484c5abf6a5806b');
INSERT INTO `admin_role` VALUES ('3e6e40e38f95424abc009863f8a23805', '36f1dd1296674fc08484c5abf6a5806b');
INSERT INTO `admin_role` VALUES ('4b62780dc5834b9ea73c69ccd7f793c9', '36f1dd1296674fc08484c5abf6a5806b');
INSERT INTO `admin_role` VALUES ('96f1efcd0e4745dca427e11b2b03afc2', '36f1dd1296674fc08484c5abf6a5806b');
INSERT INTO `admin_role` VALUES ('9c4ce2041a6447a984faea804ff9052c', '36f1dd1296674fc08484c5abf6a5806b');
INSERT INTO `admin_role` VALUES ('b1c3d4b81ab84d26968846401878d738', '36f1dd1296674fc08484c5abf6a5806b');
INSERT INTO `admin_role` VALUES ('b7124ebeaed14606ba53331601bd1dd2', '36f1dd1296674fc08484c5abf6a5806b');
INSERT INTO `admin_role` VALUES ('c140a99fde1f41908dc038fc564e91c9', '36f1dd1296674fc08484c5abf6a5806b');
INSERT INTO `admin_role` VALUES ('ccdb16b85e2f4c05858a0c0367be0923', '36f1dd1296674fc08484c5abf6a5806b');
INSERT INTO `admin_role` VALUES ('d66fe77e7c594ba28497a8a7c16990a1', '36f1dd1296674fc08484c5abf6a5806b');
INSERT INTO `admin_role` VALUES ('dfde3a0859dd44cfaca8e4f7ba445f3e', '36f1dd1296674fc08484c5abf6a5806b');
INSERT INTO `admin_role` VALUES ('fac4937be5174824a40ab779519be810', '36f1dd1296674fc08484c5abf6a5806b');
INSERT INTO `admin_role` VALUES ('1b9b5bec89f340c3a9884a87f930795e', '5058ba6d97414951b2cbfb5b3a93e7fc');
INSERT INTO `admin_role` VALUES ('4b62780dc5834b9ea73c69ccd7f793c9', '5058ba6d97414951b2cbfb5b3a93e7fc');
INSERT INTO `admin_role` VALUES ('b1c3d4b81ab84d26968846401878d738', '54ad3227761d4405b8e901df399bcaa0');
INSERT INTO `admin_role` VALUES ('9c4ce2041a6447a984faea804ff9052c', '573bd19983c64ed8be6ad18d679207fb');
INSERT INTO `admin_role` VALUES ('b7124ebeaed14606ba53331601bd1dd2', '573bd19983c64ed8be6ad18d679207fb');
INSERT INTO `admin_role` VALUES ('dfde3a0859dd44cfaca8e4f7ba445f3e', '754c8634319248ff94529c0227e287f2');
INSERT INTO `admin_role` VALUES ('3e6e40e38f95424abc009863f8a23805', '78a26b20bf8a4c5da6f2a30f461513f6');
INSERT INTO `admin_role` VALUES ('4b62780dc5834b9ea73c69ccd7f793c9', '78a26b20bf8a4c5da6f2a30f461513f6');
INSERT INTO `admin_role` VALUES ('016465786de84f4b86df6a53ef17d5dd', '9aac135161e14e87bf9410dfe1ee647b');
INSERT INTO `admin_role` VALUES ('4b62780dc5834b9ea73c69ccd7f793c9', '9aac135161e14e87bf9410dfe1ee647b');
INSERT INTO `admin_role` VALUES ('96f1efcd0e4745dca427e11b2b03afc2', 'a2092065ec2f4864b04058e85e8a4997');
INSERT INTO `admin_role` VALUES ('d66fe77e7c594ba28497a8a7c16990a1', 'b0d6f4e853fa49d082cba3d336ecc015');
INSERT INTO `admin_role` VALUES ('fac4937be5174824a40ab779519be810', 'b4622ba90fbf4ed58a10bb6d2c6e0b31');
INSERT INTO `admin_role` VALUES ('b7124ebeaed14606ba53331601bd1dd2', 'c4d34b511bff480aa28561cf8f59876f');
INSERT INTO `admin_role` VALUES ('ccdb16b85e2f4c05858a0c0367be0923', 'c4d34b511bff480aa28561cf8f59876f');
INSERT INTO `admin_role` VALUES ('78dbae47e7194a838e4f843756b6c3d6', 'cbe8356d64a8433cb5dad5c7fccf8dce');
INSERT INTO `admin_role` VALUES ('8b92d62f52e8404e927524d817b3141f', 'cbe8356d64a8433cb5dad5c7fccf8dce');
INSERT INTO `admin_role` VALUES ('b7124ebeaed14606ba53331601bd1dd2', 'cbe8356d64a8433cb5dad5c7fccf8dce');
INSERT INTO `admin_role` VALUES ('05c8575a130b476486d71ace6b4f51cd', 'd43d3373695049f8adf7f21fd55241a7');
INSERT INTO `admin_role` VALUES ('b7124ebeaed14606ba53331601bd1dd2', 'd43d3373695049f8adf7f21fd55241a7');
INSERT INTO `admin_role` VALUES ('21a97c4692f046568e6553d9bbf3bb7e', 'ed99db1924df4056b40f3400ad4d3299');
INSERT INTO `admin_role` VALUES ('4b62780dc5834b9ea73c69ccd7f793c9', 'ed99db1924df4056b40f3400ad4d3299');

-- ----------------------------
-- Table structure for billno
-- ----------------------------
DROP TABLE IF EXISTS `billno`;
CREATE TABLE `billno` (
  `uid` varchar(32) NOT NULL,
  `billtype` varchar(20) NOT NULL,
  `billmaxno` int(11) NOT NULL,
  `billdate` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of billno
-- ----------------------------
INSERT INTO `billno` VALUES ('5704bc3a93a04ab454003fc9f7299d3c', 'LOOT', '10003', '20180210');
INSERT INTO `billno` VALUES ('5704bc3a93a04df123456fc9f7299d3c', 'LOAD', '10002', '20180125');
INSERT INTO `billno` VALUES ('5704bc3a93a04df454003fc9f7299d3c', 'LOIN', '10006', '20180201');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(32) DEFAULT NULL,
  `dept_code` varchar(16) DEFAULT NULL,
  `dept_desc` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '仓储部', 'C', '公司的仓储部');
INSERT INTO `department` VALUES ('2', '数据部', 'S', '公司的数据部');
INSERT INTO `department` VALUES ('3', '配送部', 'P', '公司的配送部');

-- ----------------------------
-- Table structure for distrib
-- ----------------------------
DROP TABLE IF EXISTS `distrib`;
CREATE TABLE `distrib` (
  `uid` varchar(32) NOT NULL,
  `distrib_num` varchar(50) DEFAULT NULL,
  `order_unit` varchar(50) NOT NULL,
  `productname` varchar(60) NOT NULL,
  `factory` varchar(60) DEFAULT NULL,
  `unit` varchar(20) DEFAULT NULL,
  `number` decimal(20,0) DEFAULT NULL,
  `shipment_time` datetime DEFAULT NULL,
  `order_begin` datetime DEFAULT NULL,
  `order_end` datetime DEFAULT NULL,
  `order_man` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `data_man` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `picker` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `pick_begin` datetime DEFAULT NULL,
  `pick_end` datetime DEFAULT NULL,
  `databillno` varchar(20) DEFAULT NULL,
  `data_begin` datetime DEFAULT NULL,
  `data_end` datetime DEFAULT NULL,
  `distrib_check_man` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `distrib_check_begin` datetime DEFAULT NULL,
  `distrib_check_end` datetime DEFAULT NULL,
  `distrib_pack_man` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `distrib_pack_begin` datetime DEFAULT NULL,
  `distrib_pack_end` datetime DEFAULT NULL,
  `distrib_deli_man` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `distrib_begin` datetime DEFAULT NULL,
  `distrib_end` datetime DEFAULT NULL,
  `receipt_addr` varchar(20) DEFAULT NULL,
  `sendout_time` datetime DEFAULT NULL,
  `reciept_man` varchar(20) DEFAULT NULL,
  `arrival_time` datetime DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `state` tinyint(2) DEFAULT NULL,
  `createdat` datetime DEFAULT NULL,
  `updatedat` datetime DEFAULT NULL,
  `status` int(11) DEFAULT '0' COMMENT '0正常  1删除',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of distrib
-- ----------------------------
INSERT INTO `distrib` VALUES ('1a89531e73314cc4a79437bc5a2a9abc', 'LOOT201801310002', 'aege', 'fagfe', 'agege', 'ageg', '1', null, null, '2018-01-31 09:26:23', '', '李慧', '李慧', '2018-01-31 09:28:19', '2018-01-31 09:28:26', '', '2018-01-31 09:28:41', '2018-01-31 09:28:59', '庞晓燕', '2018-01-31 09:36:31', '2018-01-31 09:36:36', '李慧', '2018-01-31 09:36:44', '2018-01-31 11:14:01', '李慧', '2018-01-31 11:14:05', '2018-01-31 11:14:08', 'agege', '2018-01-31 00:00:00', 'gege', '2018-01-31 00:00:00', null, '13', null, '2018-01-31 11:14:08', '0');
INSERT INTO `distrib` VALUES ('1c31dab4d0634180a3ce79ffeff32681', 'LOOT201801310009', '贺州中医', '冠龙椎体成型', '山东冠龙', '套', '1', '2018-01-31 18:30:05', '2018-01-31 16:22:57', '2018-01-31 16:23:09', '庞晓燕', '李慧', '李慧', '2018-01-31 16:23:31', '2018-01-31 16:23:36', '', '2018-01-31 16:23:42', '2018-01-31 16:23:45', '庞晓燕', '2018-01-31 16:23:48', '2018-01-31 16:23:51', '李慧', '2018-01-31 16:23:55', '2018-01-31 16:23:57', '庞晓燕', '2018-01-31 16:24:00', '2018-01-31 16:24:03', '贺州', '2018-01-31 18:16:32', '古剑军', '2018-01-31 22:18:42', null, '13', '2018-01-31 16:19:11', '2018-01-31 16:24:03', '0');
INSERT INTO `distrib` VALUES ('1d7fcc2411924e4f96d0ce5c1bfabe86', '', '', '', '', '', null, '2018-02-10 11:28:36', null, null, '', '', '', null, null, 'LOOT201802100002', null, null, '', null, null, '', null, null, '', null, null, '', '2018-02-10 11:28:36', '', '2018-02-10 11:28:36', null, '1', '2018-02-10 11:28:41', '2018-02-10 11:28:41', '1');
INSERT INTO `distrib` VALUES ('1f2d2a8f50ab4a829f95bb0431e23c1e', '', '', '', '', '', null, '2018-02-09 16:37:10', null, null, '', '', '', null, null, 'LOOT201802090002', null, null, '', null, null, '', null, null, '', null, null, ' rehr', '2018-02-09 16:37:10', '', '2018-02-09 16:37:10', null, '1', '2018-02-09 16:37:25', '2018-02-09 16:37:25', '1');
INSERT INTO `distrib` VALUES ('2204322e3d254f818017f53760dd76ab', 'LOOT201801300005', '', '', '', '', null, null, '2018-01-31 11:21:18', '2018-01-31 11:21:25', '', '庞晓燕', '', '2018-01-31 15:40:00', '2018-01-31 15:40:06', '', '2018-01-31 16:41:04', '2018-01-31 16:41:15', '陆玲仙', '2018-01-31 16:42:19', '2018-01-31 16:42:28', '', null, null, '', null, null, '', null, '', null, null, '9', '2018-01-30 17:01:40', '2018-01-31 16:42:28', '0');
INSERT INTO `distrib` VALUES ('2236e42a9f8c496d94a03d39ead94b3b', 'LOOT201801310001', '', '', '', '', null, null, '2018-01-31 11:29:23', '2018-01-31 11:29:30', '', '', '', '2018-01-31 11:29:37', '2018-01-31 11:29:40', '', '2018-01-31 15:40:14', null, '', null, null, '', null, null, '', null, null, '', null, '', null, null, '6', '2018-01-31 08:49:19', '2018-01-31 15:40:14', '0');
INSERT INTO `distrib` VALUES ('26538892a5914cf59bba5c45a735e9e2', '', '', '', '', '', null, '2018-02-08 11:30:40', null, null, '', '', '', null, null, 'LOOT201802080003', null, null, '', null, null, '', null, null, '', null, null, '', null, '', null, null, '1', '2018-02-08 11:18:18', '2018-02-08 11:18:18', '1');
INSERT INTO `distrib` VALUES ('2cacfa4a6a664a50aaca324b638dddf7', '02100858001', '', '', '', '', null, '2018-02-10 08:58:02', null, null, '', '', '', null, null, 'LOOT201802100001', null, null, '', null, null, '', null, null, '', null, null, '', '2018-02-10 08:58:02', '', '2018-02-10 08:58:02', null, '1', '2018-02-10 08:58:16', '2018-02-10 08:58:16', '0');
INSERT INTO `distrib` VALUES ('2e601ee87763486bb0e9dc633218e5b0', 'LOOT201801310011', '', '', '', '', null, null, null, null, '庞晓燕', '卢中炜', '李慧', null, null, '', null, null, '黄春云', null, null, '谭嘉', null, null, '侯磊', null, null, '', null, '', null, null, '1', '2018-01-31 18:34:44', '2018-01-31 18:34:44', '0');
INSERT INTO `distrib` VALUES ('2ead739323be463d9726aa182ac9313c', 'LOOT201801310004', '玉林', '钉棒一套', '理贝尔', '玉林骨科', '1', '2018-01-31 00:00:00', '2018-01-31 10:31:07', '2018-01-31 10:31:25', '庞晓燕', '庞晓燕', '李慧', '2018-01-31 10:31:35', '2018-01-31 10:31:45', '', '2018-01-31 10:37:15', '2018-01-31 11:26:06', '李慧', '2018-01-31 11:31:24', '2018-02-07 12:32:42', '冯科杰', '2018-02-07 12:32:58', null, '李慧', null, null, '玉林市一', '2018-01-31 00:55:00', '古剑军', '2018-01-31 11:00:00', null, '10', '2018-01-31 09:30:27', '2018-02-07 12:32:58', '0');
INSERT INTO `distrib` VALUES ('308c078baa364fceb15e37328b0653c9', 'LOOT201801300002', 'rfhre', 'gegae', 'gega', 'ageg', '1', '2018-01-30 16:00:00', '2018-01-30 16:00:36', '2018-01-30 16:01:22', '庞晓燕', '庞晓燕', '庞晓燕', '2018-01-30 16:01:47', '2018-01-30 16:02:01', '', '2018-01-30 16:02:14', '2018-01-30 16:02:23', '庞晓燕', '2018-01-30 16:02:33', '2018-01-30 16:02:46', '庞晓燕', '2018-01-30 16:04:57', '2018-01-30 16:05:04', '庞晓燕', '2018-01-30 16:05:11', '2018-01-30 16:05:15', 'agegae', '2018-01-30 16:00:00', 'ageg', '2018-01-30 16:00:00', null, '13', '2018-01-30 16:00:29', '2018-01-30 16:05:15', '0');
INSERT INTO `distrib` VALUES ('3964dc97aa734909a2fd5fecebdf1c7f', 'xxxxxxxxx2018020500101', 'geg', '', '', '', null, null, '2018-02-08 09:42:51', '2018-02-08 09:42:55', '苏宗花', '', '李慧', '2018-02-08 09:43:08', '2018-02-08 09:43:14', 'LOOT201802050006', null, null, '', null, null, '', null, null, '', null, null, '', null, '', null, null, '5', '2018-02-05 15:58:53', '2018-02-08 09:43:14', '0');
INSERT INTO `distrib` VALUES ('39cbdf673c6e45919bf5c794dece0bef', 'LOOT201801300003', 'age', 'agewgew', 'gegaeg', 'agege', '1', '2018-01-30 16:42:00', '2018-01-30 16:45:29', '2018-01-30 16:45:34', '庞晓燕', '李慧', '李慧', '2018-01-30 16:45:40', '2018-01-30 16:45:43', '', '2018-01-30 16:46:00', '2018-01-30 16:46:03', '庞晓燕', '2018-01-30 16:46:10', '2018-01-30 16:52:35', '李慧', '2018-01-30 16:52:41', '2018-01-30 16:52:48', '庞晓燕', '2018-01-30 16:52:53', '2018-01-30 16:52:56', 'sdagdged', '2018-01-30 16:42:00', '区域代表', '2018-01-30 16:42:00', null, '13', '2018-01-30 16:42:47', '2018-01-30 16:53:02', '0');
INSERT INTO `distrib` VALUES ('3ddbb2557aa645a386af62fd7cf11175', 'ZZZZZ20222200', '457', '', '', '', null, '2018-02-05 15:55:38', null, null, '', '', '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, '', null, null, '1', '2018-02-05 15:55:45', '2018-02-05 15:55:45', '0');
INSERT INTO `distrib` VALUES ('4e87754274b043e88248259ff71aa14c', 'LOOT201801300004', '', '', '', '', null, null, '2018-01-31 16:47:18', '2018-01-31 16:47:28', '', '', '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, '', null, null, '3', '2018-01-30 16:56:34', '2018-01-31 16:47:28', '0');
INSERT INTO `distrib` VALUES ('53afa64a43bf4caabf880ebb15ad45b3', 'LOOT18012927', '玉林骨科', '胫骨钉', '理贝尔', '个', '3', '2018-01-29 17:20:00', '2018-01-30 08:39:46', '2018-01-30 08:47:19', '李慧', '庞晓燕', '李慧', '2018-01-30 08:56:09', '2018-01-30 09:01:33', 'asfdasdfasdf', '2018-01-30 09:21:55', '2018-01-30 09:22:08', '庞晓燕', '2018-01-30 09:22:21', '2018-01-30 09:22:31', '庞晓燕', '2018-01-30 09:22:45', '2018-01-30 09:22:55', '李慧', '2018-01-30 09:23:01', '2018-01-30 09:26:46', '玉林', '2018-01-29 17:21:00', '古剑军', '2018-01-29 17:21:00', null, '13', '2018-01-29 17:21:21', '2018-01-30 09:26:46', '0');
INSERT INTO `distrib` VALUES ('5a091ff73ced4360a6975f745b62bbf8', 'LOOT201801310007', '玉林市一', '钉棒一套', '调整', '套', '1', '2018-01-31 10:28:33', '2018-01-31 10:31:13', '2018-01-31 11:16:59', '庞晓燕', '庞晓燕', '李慧', '2018-01-31 11:17:08', '2018-01-31 11:17:17', '', '2018-02-05 15:42:57', null, '庞晓燕', null, null, '庞晓燕', null, null, '李慧', null, null, '玉林市一', '2018-01-31 10:29:25', '谷建军', '2018-01-31 10:29:32', null, '6', '2018-01-31 10:29:33', '2018-02-05 15:42:57', '0');
INSERT INTO `distrib` VALUES ('5b3f547bd68d44499e9fbe03394f5b00', '', '', '', '', '', null, '2018-02-08 12:32:43', '2018-02-08 12:33:03', null, '苏宗花', '', '', null, null, 'LOOT201802080005', null, null, '', null, null, '', null, null, '', null, null, '', '2018-02-08 12:32:43', '', '2018-02-08 12:32:43', null, '2', '2018-02-08 12:32:45', '2018-02-08 12:33:03', '1');
INSERT INTO `distrib` VALUES ('759ce7aabebc43b1a9d28d591c6f663b', 'LOOT201801310006', 'ddddd', 'dddd', 'ddfdddd', 'ddddd', '10001', '2018-01-31 10:15:36', null, null, '庞晓燕', '庞晓燕', '庞晓燕', null, null, '', null, null, '庞晓燕', null, null, '庞晓燕', null, null, '庞晓燕', null, null, 'ddddddd', '2018-01-31 10:15:28', 'dddddddd', '2018-01-31 10:15:26', null, '1', '2018-01-31 10:16:07', '2018-01-31 10:16:07', '0');
INSERT INTO `distrib` VALUES ('778ee3bf73954b4998d2ca427a3f19a7', '', '', '', '', '', null, null, '2018-02-07 10:39:42', '2018-02-07 10:39:45', '', '黄艳思', '卢中炜', '2018-02-07 10:40:31', '2018-02-07 10:41:00', 'LOOT201802050009', '2018-02-07 10:41:09', '2018-02-07 10:49:56', '', '2018-02-09 16:34:39', '2018-02-09 16:34:50', '冯科杰', '2018-02-09 16:35:03', '2018-02-09 16:35:08', '梁彬', '2018-02-09 16:35:15', '2018-02-09 16:35:45', '', null, '', null, null, '13', '2018-02-05 16:25:47', '2018-02-09 16:35:45', '0');
INSERT INTO `distrib` VALUES ('7b9008e5d17b45b587a00659e93dc777', 'sfegf', '', '', '', '', null, '2018-02-08 13:30:29', '2018-02-08 11:44:54', '2018-02-08 11:56:40', '苏宗花', '', '李慧', '2018-02-08 11:56:46', '2018-02-08 12:45:14', 'LOOT201802080004', '2018-02-09 16:23:24', '2018-02-09 16:23:28', '', '2018-02-09 16:23:31', '2018-02-09 16:23:34', '梁彬', '2018-02-09 16:23:45', '2018-02-09 16:23:52', '秦建军', '2018-02-09 16:24:08', '2018-02-08 11:19:29', '', '2018-02-08 11:35:29', '', '2018-02-08 11:19:29', null, '12', '2018-02-08 11:19:56', '2018-02-09 16:24:08', '0');
INSERT INTO `distrib` VALUES ('88f161cf00dd4202b0d71c95e15691fc', '3255336556322', '', '', '', '', null, null, '2018-02-08 09:38:03', '2018-02-08 09:38:12', '苏宗花', '', '', null, null, 'LOOT201802050007', null, null, '', null, null, '', null, null, '', null, null, '', null, '', null, null, '3', '2018-02-05 16:21:37', '2018-02-08 09:38:12', '0');
INSERT INTO `distrib` VALUES ('8df95a5b1f6e490dbdab33ef87238489', '测试单号201822001', '', '', '', '', null, null, '2018-02-07 14:33:53', '2018-02-07 14:34:09', '苏宗花', '', '李慧', '2018-02-07 14:34:16', null, 'LOOT201802050008', null, null, '', null, null, '', null, null, '', null, null, '', null, '', null, null, '4', '2018-02-05 16:24:27', '2018-02-07 14:34:16', '0');
INSERT INTO `distrib` VALUES ('93fe23d585d34868b95f59e496ad0193', 'LOOT201801310010', '', '', '', '', null, null, '2018-01-31 16:43:40', '2018-01-31 16:47:41', '', '庞晓燕', '庞晓燕', '2018-01-31 16:48:03', '2018-01-31 16:48:23', '', '2018-01-31 16:48:43', '2018-01-31 16:48:51', '李慧', '2018-01-31 16:49:08', '2018-01-31 16:49:14', '', '2018-01-31 16:49:21', '2018-01-31 16:49:26', '陆玲仙', '2018-01-31 16:49:37', '2018-01-31 16:49:55', '', null, '', null, null, '13', '2018-01-31 16:42:57', '2018-01-31 16:49:55', '0');
INSERT INTO `distrib` VALUES ('95591fda705340c4b8686001ebc30de2', 'cdghth', '', '', '', '', null, '2018-02-09 16:17:20', '2018-02-09 16:17:39', null, '庞升瑜', '', '', null, null, 'LOOT201802090001', null, null, '', null, null, '', null, null, '', null, null, '', '2018-02-09 16:17:20', '', '2018-02-09 16:17:20', null, '2', '2018-02-09 16:17:21', '2018-02-09 16:17:39', '0');
INSERT INTO `distrib` VALUES ('a21e45afff7645dda36318b94b5a3c29', 'LOOT201801310005', '哥哥哥', 'dfadfg', '俺哥哥', 'age', '1', '2018-01-31 10:01:49', null, null, '庞晓燕', '李慧', '李慧', null, null, '', null, null, '庞晓燕', null, null, '庞晓燕', null, null, '李慧', null, null, '啊哥哥', '2018-01-31 00:00:00', '个', '2018-01-31 00:00:00', null, '1', '2018-01-31 10:03:38', '2018-01-31 10:03:38', '0');
INSERT INTO `distrib` VALUES ('a5be26bf0629469893e3cbd1050f40e5', 'LOOT201801300001', 'asdfasdf', 'sdfasdfa', 'sdfasdf', 'asdfdf', '3', '2018-01-30 10:39:00', '2018-01-30 10:41:30', '2018-01-30 10:41:41', '', '庞晓燕', '庞晓燕', '2018-01-30 10:42:59', '2018-01-30 10:45:03', '', '2018-01-30 15:40:31', null, '庞晓燕', '2018-01-30 15:59:19', '2018-01-30 16:05:36', '庞晓燕', '2018-01-30 16:05:43', '2018-01-30 16:05:50', '庞晓燕', '2018-01-30 16:07:18', '2018-01-30 16:07:24', 'asdfasdf', '2018-01-30 10:40:00', 'asdfasdf', '2018-01-30 10:40:00', null, '13', null, '2018-01-30 16:07:24', '0');
INSERT INTO `distrib` VALUES ('a9c8e4df88014322aba7fcb95a3490c1', 'fefefefefe', '', '', '', '', null, null, '2018-02-07 09:43:10', '2018-02-07 09:43:14', '', '李慧', '庞晓燕', '2018-02-07 09:43:25', '2018-02-07 09:43:39', 'LOOT201802050010', '2018-02-07 09:44:03', '2018-02-07 09:44:21', '陆玲仙', '2018-02-07 09:44:31', '2018-02-07 10:04:18', '李慧', '2018-02-07 10:04:26', '2018-02-07 10:46:28', '梁彬', '2018-02-07 10:46:35', '2018-02-07 12:32:34', '', null, '', null, null, '13', '2018-02-05 16:40:40', '2018-02-07 12:32:34', '0');
INSERT INTO `distrib` VALUES ('abdc34773e40402b89c95ecf382b6bd0', 'LOOT201801310008', 'gege', 'agege', 'gewe', 'geg', '22', '2018-01-31 11:10:33', '2018-01-31 11:12:40', '2018-01-31 11:12:55', '庞晓燕', '庞晓燕', '李慧', '2018-01-31 11:13:02', '2018-01-31 11:13:06', '', '2018-01-31 11:13:32', '2018-01-31 11:13:45', '李慧', '2018-01-31 11:15:33', '2018-02-05 14:44:40', '李慧', '2018-02-05 15:46:40', '2018-02-05 15:46:46', '李慧', null, null, 'egeg', '2018-01-31 11:10:58', 'ageg', '2018-01-31 11:11:02', null, '11', '2018-01-31 11:12:03', '2018-02-05 15:46:46', '0');
INSERT INTO `distrib` VALUES ('c7878f92711b49d5a7a6419a3374e2e7', null, '', '', '', '', null, '2018-02-08 02:02:00', null, null, '', '', '', null, null, 'LOOT201802080001', null, null, '', null, null, '', null, null, '', null, null, '', null, '', null, null, '1', '2018-02-08 10:31:23', '2018-02-08 10:31:23', '1');
INSERT INTO `distrib` VALUES ('c8980738cea1495fa2886e5d1af5f40f', 'LOOT201802050002', 'eg1aedg21212dsfge33d.ds', '', '', '', null, null, '2018-02-05 15:43:28', null, '', '', '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, '', null, null, '2', '2018-02-05 11:46:36', '2018-02-05 15:43:28', '0');
INSERT INTO `distrib` VALUES ('cf56bc7cd73048f18f96337afb0788e9', 'LOOT18012403', '玉林骨科', '胫骨钉', '理贝尔', '个', '4444', '2018-01-24 10:35:00', '2018-01-24 10:50:00', '2018-01-24 11:45:00', '', '李四', '', null, null, '201801220003', '2018-01-30 15:59:29', '2018-01-24 10:55:00', '王五', '2018-01-30 16:25:59', '2018-01-30 16:26:14', '阿斯蒂芬', '2018-01-30 16:26:24', '2018-01-30 16:26:31', '阿萨德', '2018-01-30 16:26:39', '2018-01-30 16:26:46', '玉林', '2018-01-24 10:55:00', '周的', null, null, '13', null, '2018-01-30 16:26:46', '0');
INSERT INTO `distrib` VALUES ('d423bc7e443e4e478962eba59353624b', 'LOOT201802050003', 'eg1aedg21212dsfge33d.dss', '', '', '', null, null, '2018-02-05 15:38:01', null, '', '', '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, '', null, null, '2', '2018-02-05 11:46:36', '2018-02-05 15:38:01', '0');
INSERT INTO `distrib` VALUES ('d890bd950f6d48a8b70571f1d8a19731', 'AGEG2022136136', 'AGEG', 'GEEG', '', 'AGEG', null, '2018-02-05 15:56:50', null, null, '', '', '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, '', null, null, '1', '2018-02-05 15:56:57', '2018-02-05 15:56:57', '0');
INSERT INTO `distrib` VALUES ('e4bfa397e0f0441ea475b9acb48c317f', 'LOOT201801310003', 'dd', 'dd', 'agege', '1', '1', '1899-12-31 00:00:00', null, null, '庞晓燕', '庞晓燕', '李慧', null, null, '', null, null, '李慧', null, null, '庞晓燕', null, null, '李慧', null, null, 'agege', '1899-12-31 00:00:00', 'age', null, null, '1', '2018-01-31 09:07:26', '2018-01-31 09:07:26', '0');
INSERT INTO `distrib` VALUES ('e7ca4e51b3424c74bec0d64e152165b3', null, '', '', '', '', null, '2018-02-08 04:02:00', null, null, '', '', '', null, null, 'LOOT201802080002', null, null, '', null, null, '', null, null, '', null, null, '', null, '', null, null, '1', '2018-02-08 10:32:36', '2018-02-08 10:32:36', '1');
INSERT INTO `distrib` VALUES ('edad859a7cb348d28b9f721f2fa92fb5', '', '', '', '', '', null, '2018-02-09 16:58:41', null, null, '', '', '', null, null, 'LOOT201802090003', null, null, '', null, null, '', null, null, '', null, null, '惺惺惜惺惺想', '2018-02-09 16:58:41', '', '2018-02-09 16:58:41', null, '1', '2018-02-09 16:58:59', '2018-02-09 16:58:59', '1');
INSERT INTO `distrib` VALUES ('f4317263593843a7845f1a18b2de526d', 'LOOT201802050001', 'gegaewg', 'agegeegeg', '', 'ege', null, '2018-02-05 11:02:21', '2018-02-05 15:40:23', '2018-02-05 15:40:26', '', '', '', '2018-02-05 15:40:35', null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, '', null, null, '4', '2018-02-05 11:02:26', '2018-02-05 15:40:35', '0');
INSERT INTO `distrib` VALUES ('f79e2dcfc7164cc2af5fb4fb984b7094', 'LOOT201802050004', 'AGEGE', 'AGEGE', 'AGEGEAWG', 'GE', '100000', '2018-02-05 15:48:33', '2018-02-07 10:40:22', '2018-02-07 10:47:53', '庞升瑜', '黄艳思', '黄春云', null, null, '', null, null, '卢中炜', null, null, '潘武生', null, null, '冯科杰', null, null, 'NANNING', '2018-02-05 15:49:01', '李大力', '2018-02-05 15:49:11', null, '3', '2018-02-05 15:49:20', '2018-02-07 10:47:53', '0');
INSERT INTO `distrib` VALUES ('f7df836ee37c47fe85e9920396d618d2', 'LOOT201801300006', 'ageage', 'gegaew', 'gewgeawg', 'eg', '111', '2018-01-30 18:33:00', '2018-01-30 18:35:16', '2018-01-30 18:35:48', '庞晓燕', '李慧', '李慧', '2018-01-30 18:35:59', '2018-01-30 18:36:07', '', '2018-01-30 18:36:15', '2018-01-30 18:36:23', '庞晓燕', '2018-01-30 18:36:34', '2018-01-30 18:36:41', '李慧', '2018-01-30 18:36:47', '2018-01-30 18:36:54', '庞晓燕', '2018-01-30 18:37:07', '2018-01-30 18:37:16', 'agege', '2018-01-30 18:33:00', 'aegewag', '2018-01-30 18:33:00', null, '13', '2018-01-30 18:33:59', '2018-01-30 18:37:16', '0');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `uid` varchar(32) NOT NULL,
  `emp_no` varchar(20) NOT NULL,
  `emp_name` varchar(20) NOT NULL,
  `dep_id` varchar(20) DEFAULT NULL,
  `dep_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('5704bc3a93a04df454003fc9f7acc001', 'C001', '庞晓燕', 'C', '仓储部');
INSERT INTO `employee` VALUES ('5704bc3a93a04df454003fc9f7acc002', 'C002', '李慧', 'C', '仓储部');
INSERT INTO `employee` VALUES ('5704bc3a93a04df454003fc9f7acc004', 'C003', '陆玲仙', 'C', '仓储部');

-- ----------------------------
-- Table structure for employee_new
-- ----------------------------
DROP TABLE IF EXISTS `employee_new`;
CREATE TABLE `employee_new` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_code` varchar(16) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工编号',
  `emp_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `emp_desc` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工描述\r\n',
  `emp_state` int(11) DEFAULT '0' COMMENT '是否在岗',
  `dept_id` int(11) DEFAULT NULL COMMENT '员工所属部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee_new
-- ----------------------------
INSERT INTO `employee_new` VALUES ('1', 'C001', '庞晓燕', null, '0', '1');
INSERT INTO `employee_new` VALUES ('2', 'C002', '李慧', null, '0', '1');
INSERT INTO `employee_new` VALUES ('3', 'C003', '卢中炜', null, '0', '1');
INSERT INTO `employee_new` VALUES ('4', 'C004', '黄春云', null, '0', '1');
INSERT INTO `employee_new` VALUES ('5', 'C005', '谭嘉', null, '0', '1');
INSERT INTO `employee_new` VALUES ('6', 'C006', '潘飞', null, '0', '1');
INSERT INTO `employee_new` VALUES ('7', 'C007', '侯磊', null, '0', '1');
INSERT INTO `employee_new` VALUES ('8', 'C008', '孟龙斌', null, '0', '1');
INSERT INTO `employee_new` VALUES ('9', 'C009', '玉宁', null, '0', '1');
INSERT INTO `employee_new` VALUES ('10', 'C010', '傅翎风', null, '0', '1');
INSERT INTO `employee_new` VALUES ('11', 'C011', '冯家柯', null, '0', '1');
INSERT INTO `employee_new` VALUES ('12', 'C012', '李葆洁', null, '0', '1');
INSERT INTO `employee_new` VALUES ('13', 'C013', '覃福豪', null, '0', '1');
INSERT INTO `employee_new` VALUES ('14', 'C014', '吴水理', null, '0', '1');
INSERT INTO `employee_new` VALUES ('15', 'C015', '宁东', null, '0', '1');
INSERT INTO `employee_new` VALUES ('16', 'C016', '庞翠华', null, '0', '1');
INSERT INTO `employee_new` VALUES ('17', 'C017', '庞淑敏', null, '0', '1');
INSERT INTO `employee_new` VALUES ('18', 'C018', '梁坚锋', null, '0', '1');
INSERT INTO `employee_new` VALUES ('19', 'C019', '苏巧圆', null, '0', '1');
INSERT INTO `employee_new` VALUES ('20', 'C020', '黄柳萍', null, '0', '1');
INSERT INTO `employee_new` VALUES ('21', 'C021', '古克豪', null, '0', '1');
INSERT INTO `employee_new` VALUES ('22', 'C022', '宋卉玲', null, '0', '1');
INSERT INTO `employee_new` VALUES ('23', 'C023', '庞升虎', null, '0', '1');
INSERT INTO `employee_new` VALUES ('24', 'C024', '黄福文', null, '0', '1');
INSERT INTO `employee_new` VALUES ('25', 'C025', '庞家剑', null, '0', '1');
INSERT INTO `employee_new` VALUES ('26', 'S001', '庞升瑜', null, '0', '2');
INSERT INTO `employee_new` VALUES ('27', 'S002', '苏宗花', null, '0', '2');
INSERT INTO `employee_new` VALUES ('28', 'S003', '黄艳思', null, '0', '2');
INSERT INTO `employee_new` VALUES ('29', 'S004', '陆伟锋', null, '0', '2');
INSERT INTO `employee_new` VALUES ('30', 'S005', '潘玉月', null, '0', '2');
INSERT INTO `employee_new` VALUES ('31', 'S006', '庞娜', null, '0', '2');
INSERT INTO `employee_new` VALUES ('32', 'S007', '吉丽娟', null, '0', '2');
INSERT INTO `employee_new` VALUES ('33', 'S008', '苏莲', null, '0', '2');
INSERT INTO `employee_new` VALUES ('34', 'S009', '朱依平', null, '0', '2');
INSERT INTO `employee_new` VALUES ('35', 'S010', '淡翠娟', null, '0', '2');
INSERT INTO `employee_new` VALUES ('36', 'S011', '肖胜贤', null, '0', '2');
INSERT INTO `employee_new` VALUES ('37', 'S012', '韦艳', null, '0', '2');
INSERT INTO `employee_new` VALUES ('38', 'S013', '韦秋霞', null, '0', '2');
INSERT INTO `employee_new` VALUES ('39', 'S014', '李晓娟', null, '0', '2');
INSERT INTO `employee_new` VALUES ('40', 'S015', '陆玲仙', null, '0', '2');
INSERT INTO `employee_new` VALUES ('41', 'S016', '邓抒伟', null, '0', '2');
INSERT INTO `employee_new` VALUES ('42', 'S017', '江裕雯', null, '0', '2');
INSERT INTO `employee_new` VALUES ('43', 'S018', '黄秋玲', null, '0', '2');
INSERT INTO `employee_new` VALUES ('44', 'P001', '杨国林', null, '0', '3');
INSERT INTO `employee_new` VALUES ('45', 'P002', '庞采崇', null, '0', '3');
INSERT INTO `employee_new` VALUES ('46', 'P003', '冯科杰', null, '0', '3');
INSERT INTO `employee_new` VALUES ('47', 'P004', '梁彬', null, '0', '3');
INSERT INTO `employee_new` VALUES ('48', 'P005', '潘武生', null, '0', '3');
INSERT INTO `employee_new` VALUES ('49', 'P006', '樊宁', null, '0', '3');
INSERT INTO `employee_new` VALUES ('50', 'P007', '秦建军', null, '0', '3');
INSERT INTO `employee_new` VALUES ('51', 'P008', '丘道升', null, '0', '3');
INSERT INTO `employee_new` VALUES ('52', 'P009', '庞胜雄', null, '0', '3');
INSERT INTO `employee_new` VALUES ('53', 'P010', '杨洲', null, '0', '3');
INSERT INTO `employee_new` VALUES ('54', 'P011', '欧寿康', null, '0', '3');
INSERT INTO `employee_new` VALUES ('55', 'P012', '陈天武', null, '0', '3');
INSERT INTO `employee_new` VALUES ('56', 'P013', '韦海学', null, '0', '3');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `uid` varchar(32) NOT NULL,
  `productname` varchar(60) DEFAULT NULL,
  `spec` varchar(60) DEFAULT NULL,
  `unit` varchar(20) DEFAULT NULL,
  `classify` varchar(60) DEFAULT NULL,
  `price` decimal(20,2) DEFAULT NULL,
  `factory` varchar(60) DEFAULT NULL,
  `contacts` varchar(20) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `createdat` datetime DEFAULT NULL,
  `updatedat` datetime DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `log_id` varchar(32) NOT NULL,
  `log_user` varchar(32) DEFAULT NULL,
  `log_time` datetime DEFAULT NULL,
  `log_ip` varchar(15) DEFAULT NULL,
  `log_action` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('0024fe97cd0a4299b350b4c1809341bf', 'admin', '2018-01-24 08:49:51', '127.0.0.1', '');
INSERT INTO `log` VALUES ('00393d6743374a64845b3bd35e63a7c6', 'disadd', '2018-02-01 12:40:56', '127.0.0.1', '');
INSERT INTO `log` VALUES ('005b650aa29d41c4af6fff117595cb0a', 'admin', '2018-01-23 08:57:22', '127.0.0.1', '');
INSERT INTO `log` VALUES ('006739670616493c95143e33368a2c58', 'disadd', '2018-01-31 15:39:51', '127.0.0.1', '');
INSERT INTO `log` VALUES ('010cd09a311b4142a589372f0e69fe79', 'admin', '2017-12-18 15:18:44', '127.0.0.1', '');
INSERT INTO `log` VALUES ('024021f259444cbfbee7b40a2384d43b', 'admin', '2017-03-09 17:23:54', '127.0.0.1', '');
INSERT INTO `log` VALUES ('0308017e811a4078a589406c8802d072', 'admin', '2018-01-20 18:09:53', '127.0.0.1', '');
INSERT INTO `log` VALUES ('0310664977fc413b8da2343cd27292c1', 'admin', '2018-02-06 09:36:40', '192.168.10.100', '');
INSERT INTO `log` VALUES ('054d85212ecd4c7a9830075f1a5d764b', 'admin', '2017-03-31 09:54:13', '127.0.0.1', '');
INSERT INTO `log` VALUES ('06106f13aff5492d8afaf40101c5f646', 'dataadd', '2018-01-23 11:03:30', '127.0.0.1', '');
INSERT INTO `log` VALUES ('0851c58dcf474e4784396d32496a19c5', 'adjrece', '2018-01-25 18:41:26', '127.0.0.1', '');
INSERT INTO `log` VALUES ('08c3b99103724c80b5bd859df53d9b47', 'adjcheck', '2018-01-25 18:42:48', '127.0.0.1', '');
INSERT INTO `log` VALUES ('0912fa1c7f87460b9ff9fed5c515e29b', 'admin', '2017-05-05 13:47:14', '127.0.0.1', '');
INSERT INTO `log` VALUES ('098c241dd40046ed965b476bfedca991', 'disadd', '2018-01-30 18:49:46', '127.0.0.1', '');
INSERT INTO `log` VALUES ('09d3ea3e99574840a285fcf15642bdee', 'admin', '2017-05-09 16:31:40', '127.0.0.1', '');
INSERT INTO `log` VALUES ('0a2861b55204494eaa210c36172f7dde', 'reacre', '2018-02-01 15:00:47', '127.0.0.1', '');
INSERT INTO `log` VALUES ('0a3ead99969f4b1682cebb771fa431d6', 'admin', '2017-12-22 10:49:59', '127.0.0.1', '');
INSERT INTO `log` VALUES ('0b6a08723fae4ae2921886ec0a9c4dbc', 'admin', '2017-05-09 11:52:13', '127.0.0.1', '');
INSERT INTO `log` VALUES ('0bc44c925bd0468c8fd7781d07e90b1d', 'admin', '2017-03-28 13:38:27', '127.0.0.1', '');
INSERT INTO `log` VALUES ('0bee04278bcb4f608265b165af1cb4a2', 'admin', '2018-01-26 09:32:50', '192.168.10.123', '');
INSERT INTO `log` VALUES ('0db6c0e973eb4aa198a686f4b76e9072', 'disadd', '2018-02-03 08:25:29', '127.0.0.1', '');
INSERT INTO `log` VALUES ('0dbb0fec288b48fb9240e694311e3ae7', 'admin', '2018-01-31 16:31:06', '127.0.0.1', '');
INSERT INTO `log` VALUES ('0dc10963972d408dad7ee5dd94ad9f07', 'admin', '2017-05-24 14:55:17', '127.0.0.1', '');
INSERT INTO `log` VALUES ('0de75e3c82014906bfd2a0e42bae1e36', 'disadd', '2018-02-05 09:47:06', '127.0.0.1', '');
INSERT INTO `log` VALUES ('0f6eb6f696334f62bc1eddeac58fcb2c', 'admin', '2018-01-23 11:49:22', '127.0.0.1', '');
INSERT INTO `log` VALUES ('10c1120b97304c5ab4b4aa46ec03cefa', 'admin', '2018-02-08 08:59:12', '127.0.0.1', '');
INSERT INTO `log` VALUES ('10d57c00076e47a0bb6a7bc49b0c751a', 'disadd', '2018-01-24 14:56:51', '127.0.0.1', '');
INSERT INTO `log` VALUES ('1120b43a0621489b9fe1a5e419a6a46e', 'disdata', '2018-01-26 09:28:59', '192.168.10.123', '');
INSERT INTO `log` VALUES ('1154167ecd174fc990c283c25d66000b', 'admin', '2017-05-11 15:28:38', '127.0.0.1', '');
INSERT INTO `log` VALUES ('1449d89c403d4e5a847d8b4d96ff64ff', 'disadd', '2018-01-30 18:56:06', '127.0.0.1', '');
INSERT INTO `log` VALUES ('15986bdf84f6472fa36ec2326c7c1bc0', 'admin', '2018-01-24 14:40:39', '127.0.0.1', '');
INSERT INTO `log` VALUES ('16bc74e0255546f3833285085e6ef838', 'dataadd', '2018-01-26 09:37:59', '192.168.10.123', '');
INSERT INTO `log` VALUES ('16ecad555b2f43009b13087529606565', 'admin', '2018-01-31 11:33:35', '127.0.0.1', '');
INSERT INTO `log` VALUES ('1909ae0a151d491a819e6f663b88efdd', 'disadd', '2018-01-24 11:19:49', '127.0.0.1', '');
INSERT INTO `log` VALUES ('1a380ccc528946d7aa3fffc5faf21131', 'reacre', '2018-02-03 17:11:34', '192.168.10.107', '');
INSERT INTO `log` VALUES ('1a98c84a82d44c95b8b99fb0de752fda', 'reacba', '2018-02-01 14:53:38', '127.0.0.1', '');
INSERT INTO `log` VALUES ('1b770c2af65f4912842a16ea82d93aa6', 'rerece', '2018-01-20 18:06:23', '127.0.0.1', '');
INSERT INTO `log` VALUES ('1d2a325b218e40a3a02880336f536bca', 'disadd', '2018-01-23 18:26:54', '127.0.0.1', '');
INSERT INTO `log` VALUES ('1de8df2035d04607ad701a70ff02e959', 'admin', '2018-01-22 09:11:17', '127.0.0.1', '');
INSERT INTO `log` VALUES ('1ff7b6b205804f9bad641d9ba2708bd9', 'dataadd', '2018-01-22 16:30:47', '127.0.0.1', '');
INSERT INTO `log` VALUES ('2155ee6ab5e74fdc997d5577addc4f2b', 'admin', '2017-12-21 09:53:57', '127.0.0.1', '');
INSERT INTO `log` VALUES ('218733485e9b4a74b66861754773d9d8', 'reacba', '2018-02-03 08:24:23', '127.0.0.1', '');
INSERT INTO `log` VALUES ('22cb092c60724344b7d5da2793e63bbb', 'disadd', '2018-02-05 09:23:47', '127.0.0.1', '');
INSERT INTO `log` VALUES ('22e38fd437ce4297930f237b6eb443e2', 'adjadd', '2018-01-25 18:24:08', '127.0.0.1', '');
INSERT INTO `log` VALUES ('2365413a52954f329f1c3c29e9d4d51d', 'disadd', '2018-02-05 09:46:07', '127.0.0.1', '');
INSERT INTO `log` VALUES ('24ae4b6af1774b61821b45c6a195692b', 'admin', '2018-02-10 08:52:13', '127.0.0.1', '');
INSERT INTO `log` VALUES ('2552afc1b354470292270e20769bff48', 'reacre', '2018-01-23 10:59:47', '127.0.0.1', '');
INSERT INTO `log` VALUES ('2592141f62e74e8fb68683d8fa8e4a41', 'reacch', '2018-02-01 18:21:34', '127.0.0.1', '');
INSERT INTO `log` VALUES ('25f3ad7609c54d3e994584551068588d', 'reacba', '2018-02-02 08:42:44', '127.0.0.1', '');
INSERT INTO `log` VALUES ('29255bef2347418198067d5a2905aa01', 'reacba', '2018-02-03 08:18:02', '127.0.0.1', '');
INSERT INTO `log` VALUES ('2980175930404af4a3652421e22ce354', 'disadd', '2018-01-30 15:45:16', '127.0.0.1', '');
INSERT INTO `log` VALUES ('2a7fe481ff5a4c3e9b57316edf1c2ecc', 'disadd', '2018-01-31 11:33:25', '127.0.0.1', '');
INSERT INTO `log` VALUES ('2a9165707e4447ee8952b4a3eae3761f', 'rerece', '2018-01-22 11:49:54', '127.0.0.1', '');
INSERT INTO `log` VALUES ('2c13a7a99bd74752814a2ec9c177cf00', 'rerece', '2018-01-20 10:58:32', '127.0.0.1', '');
INSERT INTO `log` VALUES ('2e51a80121a3418a950382ad9e7a6537', 'rerece', '2018-01-20 18:09:45', '127.0.0.1', '');
INSERT INTO `log` VALUES ('2f6575d9a00f47da95c56fc8cee7c835', 'admin', '2017-12-21 15:08:04', '127.0.0.1', '');
INSERT INTO `log` VALUES ('2fcdb3ccf9f947ab8872f8cca251b8cc', 'admin', '2018-01-24 15:11:56', '127.0.0.1', '');
INSERT INTO `log` VALUES ('30f9447c782a492d9c6c3ed8ac3e44dc', 'disadd', '2018-02-01 14:40:06', '127.0.0.1', '');
INSERT INTO `log` VALUES ('313336173edb4615b165dccb34c52d31', 'disadd', '2018-01-29 15:00:58', '127.0.0.1', '');
INSERT INTO `log` VALUES ('31df7670ac494e71ae71b54a06469823', 'display', '2018-01-25 08:48:11', '192.168.10.100', '');
INSERT INTO `log` VALUES ('32066d60b0a54234a8850540f9376059', 'admin', '2018-02-01 11:17:24', '127.0.0.1', '');
INSERT INTO `log` VALUES ('327aff82a42c43cc9ec7ac95114e2be6', 'dataadd', '2018-01-23 08:58:59', '127.0.0.1', '');
INSERT INTO `log` VALUES ('33046a89f98a4c55b86f489ab0d0c899', 'dataadd', '2018-01-22 16:33:16', '127.0.0.1', '');
INSERT INTO `log` VALUES ('33413a1dbbde4d809a7b72f2c055add4', 'admin', '2018-01-25 18:00:45', '127.0.0.1', '');
INSERT INTO `log` VALUES ('33815ae62eea4ae09ea8cf9a42bb9e39', 'reacre', '2018-01-22 17:59:04', '127.0.0.1', '');
INSERT INTO `log` VALUES ('3429b57042f44f1899d26093299caebf', 'disdata', '2018-01-24 09:48:42', '127.0.0.1', '');
INSERT INTO `log` VALUES ('351ce705b3f14478988e5759c2fb7422', 'admin', '2018-02-05 17:23:43', '127.0.0.1', '');
INSERT INTO `log` VALUES ('35b9defc682e49abbe02bac94ba8fb8b', 'disadd', '2018-01-27 08:02:50', '127.0.0.1', '');
INSERT INTO `log` VALUES ('35e2e2798dff4beeac5e682baf2330a2', 'dataadd', '2017-12-22 11:10:44', '127.0.0.1', '');
INSERT INTO `log` VALUES ('3764cd333bd741a9884151801391a552', 'admin', '2018-02-01 14:58:59', '127.0.0.1', '');
INSERT INTO `log` VALUES ('387ff44f47064269a15d6be88a7b3410', 'admin', '2017-12-21 15:07:02', '127.0.0.1', '');
INSERT INTO `log` VALUES ('38f9276a37c3443eb1ecdaba822787e2', 'disdata', '2018-01-24 11:06:36', '127.0.0.1', '');
INSERT INTO `log` VALUES ('396da17f5e91443abcbb39b31a457755', 'disadd', '2018-02-08 16:01:51', '127.0.0.1', '');
INSERT INTO `log` VALUES ('399fbb1842cb46bc80e8f59859694833', 'admin', '2017-12-21 10:30:54', '127.0.0.1', '');
INSERT INTO `log` VALUES ('3abd8c9ea44b4ced884e29d6c38216c4', 'dataadd', '2018-01-20 08:37:23', '127.0.0.1', '');
INSERT INTO `log` VALUES ('3c69625475c14b4490212cdce6037dee', 'reacba', '2018-01-23 11:02:15', '127.0.0.1', '');
INSERT INTO `log` VALUES ('3e15a3b1e26442c49d3183ccf3c4930a', 'disadd', '2018-01-31 08:55:46', '127.0.0.1', '');
INSERT INTO `log` VALUES ('425ec679edb54e5aa8a92a43cf499b25', 'disadd', '2018-01-29 11:36:50', '127.0.0.1', '');
INSERT INTO `log` VALUES ('43043775645e42dd837e363d0c71af5b', 'display', '2018-01-25 10:40:33', '127.0.0.1', '');
INSERT INTO `log` VALUES ('434e830d2f51421286dbdbfac2d6432f', 'reacba', '2018-02-03 08:25:47', '127.0.0.1', '');
INSERT INTO `log` VALUES ('437fca253e714f4ea541f9b798e67803', 'retall', '2018-01-23 11:02:44', '127.0.0.1', '');
INSERT INTO `log` VALUES ('43c43591b82c4f9a83da8a8e906480f2', 'reacba', '2018-02-01 18:19:41', '127.0.0.1', '');
INSERT INTO `log` VALUES ('476dc285dde04684b9452fdc3a296217', 'admin', '2018-01-24 09:57:52', '127.0.0.1', '');
INSERT INTO `log` VALUES ('47bc3fd4573649848db593653315ccb4', 'reacba', '2018-01-22 16:18:57', '127.0.0.1', '');
INSERT INTO `log` VALUES ('48cab9f00d7e4d41b38050f04b0bec2d', 'admin', '2018-01-24 15:14:42', '127.0.0.1', '');
INSERT INTO `log` VALUES ('4bd9c728d6214c4c84c6bd351a3535b7', 'disadd', '2018-02-05 09:29:44', '127.0.0.1', '');
INSERT INTO `log` VALUES ('4ccdab1743804931b3f2daae9fdb8a98', 'dataadd', '2018-01-22 11:51:00', '127.0.0.1', '');
INSERT INTO `log` VALUES ('4e2bcb5cf686408e885f77aa4fa6a7a2', 'admin', '2018-02-11 15:24:14', '127.0.0.1', '');
INSERT INTO `log` VALUES ('4e527c274da0438aab1763b18b292b73', 'reacba', '2018-02-03 09:31:19', '127.0.0.1', '');
INSERT INTO `log` VALUES ('4f0b950dba104933a0c37c7a0883a3b6', 'admin', '2018-02-05 17:30:27', '127.0.0.1', '');
INSERT INTO `log` VALUES ('4fc09d957cce440c9185697637c76203', 'admin', '2018-01-22 16:24:52', '127.0.0.1', '');
INSERT INTO `log` VALUES ('511aa54e5fa44237b2ad62f0ef55966b', 'disadd', '2018-01-31 09:13:18', '127.0.0.1', '');
INSERT INTO `log` VALUES ('517165ae0a7f4bd99b563f3efe083861', 'admin', '2017-12-20 09:46:33', '127.0.0.1', '');
INSERT INTO `log` VALUES ('5520be6dd4f74221974c37284118a334', 'adjcheck', '2018-01-26 09:33:30', '192.168.10.123', '');
INSERT INTO `log` VALUES ('58a03d8aa3704a3699a1fadf33d2b26b', 'admin', '2018-02-10 10:44:53', '127.0.0.1', '');
INSERT INTO `log` VALUES ('5a296d9dfe0e4649a98c286a96574e7d', 'retall', '2018-01-22 17:40:31', '127.0.0.1', '');
INSERT INTO `log` VALUES ('5c3619b431e347e8a1a43960be1920ad', 'admin', '2018-01-25 08:47:29', '127.0.0.1', '');
INSERT INTO `log` VALUES ('5c8ef6d85fdf4820acdeee62d4860be4', 'admin', '2018-01-25 10:33:44', '127.0.0.1', '');
INSERT INTO `log` VALUES ('5cef648431f14fd183a9e5c929370963', 'dataadd', '2018-01-22 18:09:04', '127.0.0.1', '');
INSERT INTO `log` VALUES ('5f566308b5d9448983efda7d4ab1e4cf', 'disadd', '2018-01-24 10:11:26', '127.0.0.1', '');
INSERT INTO `log` VALUES ('61c6a549579b4606822abcf2f60a9886', 'admin', '2017-12-22 09:03:49', '127.0.0.1', '');
INSERT INTO `log` VALUES ('61fcbccf2af048c687db4643f8489aba', 'disadd', '2018-01-24 17:36:42', '192.168.10.101', '');
INSERT INTO `log` VALUES ('629f71b33d2c4e63bfb74457e1b3e30c', 'reacre', '2018-01-22 18:02:25', '127.0.0.1', '');
INSERT INTO `log` VALUES ('632ee377f3d9484890f7699a5bf25c53', 'disadd', '2018-01-30 10:38:37', '127.0.0.1', '');
INSERT INTO `log` VALUES ('64c2cfe755284f1bac011bd6cbcd8f46', 'admin', '2018-01-24 14:35:50', '127.0.0.1', '');
INSERT INTO `log` VALUES ('64e1a2b3e4fd47eb92c41c8ef822d703', 'display', '2018-01-24 17:35:14', '127.0.0.1', '');
INSERT INTO `log` VALUES ('66cdb047fde146aa979e0e296f541901', 'dataadd', '2018-01-23 19:18:24', '127.0.0.1', '');
INSERT INTO `log` VALUES ('680dae402c084e328ed6750c040f118d', 'admin', '2018-01-27 16:12:59', '127.0.0.1', '');
INSERT INTO `log` VALUES ('686df5288c654d35a2d89e817b7d0924', 'disadd', '2018-01-29 15:50:24', '127.0.0.1', '');
INSERT INTO `log` VALUES ('6873fe8ef1ac43e79854d9ee30dc9486', 'admin', '2018-01-20 09:13:27', '127.0.0.1', '');
INSERT INTO `log` VALUES ('697da22f2219494386c3157ec07a529d', 'reacre', '2018-02-03 17:41:54', '127.0.0.1', '');
INSERT INTO `log` VALUES ('69e4a35fa0864f5f9bd5c6cfb34896e7', 'admin', '2018-01-26 09:37:23', '192.168.10.123', '');
INSERT INTO `log` VALUES ('6b34adf710664a6ca58bb6f0c62f9438', 'reacre', '2018-01-22 08:52:06', '127.0.0.1', '');
INSERT INTO `log` VALUES ('6b486618f8074c75927b922a8d7b9f0c', 'reacre', '2018-02-03 17:19:34', '192.168.10.107', '');
INSERT INTO `log` VALUES ('6b793186e94d427d98b6d53f329a75e6', 'admin', '2018-02-05 19:16:56', '192.168.10.100', '');
INSERT INTO `log` VALUES ('6b8c1b78e305438998e7c005fcb3dd2f', 'dataadd', '2018-01-22 16:35:18', '127.0.0.1', '');
INSERT INTO `log` VALUES ('6d80d31116d74a1d8e66c62834da42d6', 'adjadd', '2018-01-25 18:40:27', '127.0.0.1', '');
INSERT INTO `log` VALUES ('6e01a3b7740a4c1180cf940755bb1270', 'disadd', '2018-01-24 08:50:33', '127.0.0.1', '');
INSERT INTO `log` VALUES ('704e44d8ba024863b99fd61b3b63d40f', 'disadd', '2018-02-03 09:24:32', '127.0.0.1', '');
INSERT INTO `log` VALUES ('7194e909c4fd46aeaa6c004417da6c75', 'admin', '2018-02-05 11:36:34', '127.0.0.1', '');
INSERT INTO `log` VALUES ('7449102d79644db6a7ba21606f20beea', 'admin', '2018-02-07 10:53:18', '192.168.10.100', '');
INSERT INTO `log` VALUES ('745b2bebff6149f3b6e53ac378e8c971', 'disadd', '2018-01-29 14:54:00', '127.0.0.1', '');
INSERT INTO `log` VALUES ('7538888459b14d2f8acf44cfd6b41612', 'disadd', '2018-01-29 14:51:29', '127.0.0.1', '');
INSERT INTO `log` VALUES ('75b66c735aef47b79de578d308dd6986', 'admin', '2017-12-21 14:34:41', '127.0.0.1', '');
INSERT INTO `log` VALUES ('762358e0c41b4373b497045e649d29b9', 'reacch', '2018-02-01 18:21:34', '127.0.0.1', '');
INSERT INTO `log` VALUES ('79b459da890c4081aec2409face63768', 'disadd', '2018-02-01 14:54:51', '127.0.0.1', '');
INSERT INTO `log` VALUES ('7a0ad7738be04c128aae69c20d254639', 'disadd', '2018-01-29 15:14:49', '127.0.0.1', '');
INSERT INTO `log` VALUES ('7a15ebd58f094a5c9ef8d5b8e452f857', 'reacre', '2018-01-20 18:10:35', '127.0.0.1', '');
INSERT INTO `log` VALUES ('7a48d736cb86499eaf0f66492840c242', 'reacch', '2018-01-22 11:28:46', '127.0.0.1', '');
INSERT INTO `log` VALUES ('7cd42d39e7bc4983beab1c81be02772b', 'disadd', '2018-02-01 09:26:24', '127.0.0.1', '');
INSERT INTO `log` VALUES ('7ce08629b2ed488d8718acaf40a0759d', 'adjdis', '2018-01-25 18:43:28', '127.0.0.1', '');
INSERT INTO `log` VALUES ('7cea2e50259f49978e6729426f0ff437', 'admin', '2018-01-26 15:40:33', '192.168.10.117', '');
INSERT INTO `log` VALUES ('7e3ecdd954b4419e8bc17ddf1641b058', 'admin', '2018-02-06 18:30:50', '192.168.10.101', '');
INSERT INTO `log` VALUES ('7efae61dd7d04225860f7f1dcfffcd44', 'disadd', '2018-02-01 11:28:44', '127.0.0.1', '');
INSERT INTO `log` VALUES ('80634ce887a04c5d9b7cb8e84986d49b', 'disdata', '2018-01-24 17:41:54', '192.168.10.101', '');
INSERT INTO `log` VALUES ('8090016d79c04f03983d69a1d33f9890', 'disadd', '2018-01-30 15:39:41', '127.0.0.1', '');
INSERT INTO `log` VALUES ('81b1ae390d06434bb4822c3d67671d92', 'reacre', '2018-01-22 15:55:46', '127.0.0.1', '');
INSERT INTO `log` VALUES ('82876d1734284f53b0ec80ccc42e5106', 'dataadd', '2017-12-22 12:00:24', '127.0.0.1', '');
INSERT INTO `log` VALUES ('82f98ca6e8d64c34ab1372b8012789a2', 'disadd', '2018-01-30 16:45:24', '127.0.0.1', '');
INSERT INTO `log` VALUES ('836b4d50629d496987ad6ca5cec2f2f8', 'disadd', '2018-01-24 15:11:22', '127.0.0.1', '');
INSERT INTO `log` VALUES ('84663940f69c4ab79bfad452deb45acf', 'dataadd', '2018-01-25 15:44:26', '127.0.0.1', '');
INSERT INTO `log` VALUES ('84b0d0fc018f45eabe109b6799578a4a', 'admin', '2018-01-31 09:45:21', '127.0.0.1', '');
INSERT INTO `log` VALUES ('84e95b2290304cc5a3a3b8dce070be16', 'dataadd', '2018-01-22 16:00:05', '127.0.0.1', '');
INSERT INTO `log` VALUES ('85ceb35878d9433185e707ea3d6383af', 'disadd', '2018-01-29 15:22:19', '127.0.0.1', '');
INSERT INTO `log` VALUES ('861882dbb6624208b032636d04f1ba81', 'disadd', '2018-01-24 09:27:37', '127.0.0.1', '');
INSERT INTO `log` VALUES ('86265b8d5bd449ae95a58473d7159703', 'dataadd', '2018-01-22 09:17:16', '127.0.0.1', '');
INSERT INTO `log` VALUES ('864865bbc5d9409681442ca87c4f73f6', 'admin', '2018-02-05 19:02:27', '192.168.10.100', '');
INSERT INTO `log` VALUES ('867e5712eeef4fe7bb1d8c29f70258a6', 'discheck', '2018-01-24 10:15:52', '127.0.0.1', '');
INSERT INTO `log` VALUES ('8752935a3b2d48a9a3f70ed1ca5344a7', 'admin', '2017-12-22 09:41:24', '127.0.0.1', '');
INSERT INTO `log` VALUES ('87c917d2a2414e009f59570d0e9fbff1', 'admin', '2018-01-25 17:01:40', '127.0.0.1', '');
INSERT INTO `log` VALUES ('89388bb248ac4d1c982e7155c11863d5', 'display', '2018-02-03 09:49:19', '127.0.0.1', '');
INSERT INTO `log` VALUES ('89a348491c6d4a33bb5834543219643d', 'disadd', '2018-02-01 10:24:25', '127.0.0.1', '');
INSERT INTO `log` VALUES ('89a967a837784928b5a32606d3701ac2', 'admin', '2018-01-24 17:27:57', '127.0.0.1', '');
INSERT INTO `log` VALUES ('8a35b3a646134ca1a072501cc943a7ca', 'disadd', '2018-01-29 15:48:07', '127.0.0.1', '');
INSERT INTO `log` VALUES ('8b067dff48624ee38cd19bbf5ee34034', 'admin', '2018-02-10 10:41:37', '127.0.0.1', '');
INSERT INTO `log` VALUES ('8b227122c7d14df9af624a31eb7866cb', 'admin', '2018-01-29 14:46:29', '127.0.0.1', '');
INSERT INTO `log` VALUES ('8b41683df258497f96d21dde14902552', 'disadd', '2018-01-30 08:39:37', '127.0.0.1', '');
INSERT INTO `log` VALUES ('8d2292ca2e2747b1a963539329dc44e1', 'reacba', '2018-02-05 11:26:32', '127.0.0.1', '');
INSERT INTO `log` VALUES ('8efcdc23895f4d83afa4a72f36809e08', 'admin', '2018-01-23 09:52:51', '192.168.10.117', '');
INSERT INTO `log` VALUES ('8f9d9567e3a04933ae416316d523e9b6', 'rerece', '2018-01-22 17:59:27', '127.0.0.1', '');
INSERT INTO `log` VALUES ('8ff9a616722b41c5ad71e62dcf717735', 'rerece', '2018-01-20 18:04:58', '127.0.0.1', '');
INSERT INTO `log` VALUES ('90dbc0a811364db5b708c573426d07a0', 'reacre', '2018-02-03 16:53:55', '192.168.10.117', '');
INSERT INTO `log` VALUES ('91ae91a40fe84b50a91aa4eca0193203', 'disadd', '2018-02-06 08:57:23', '127.0.0.1', '');
INSERT INTO `log` VALUES ('91eb8116b9e043f7b5f39e3d53ffec1a', 'disadd', '2018-01-24 17:28:27', '127.0.0.1', '');
INSERT INTO `log` VALUES ('9475d22fa2c34e359dec928cbf307158', 'admin', '2018-02-01 11:19:43', '127.0.0.1', '');
INSERT INTO `log` VALUES ('949134074fc544b8b955b88c1d06a4fa', 'disadd', '2018-01-27 10:10:11', '127.0.0.1', '');
INSERT INTO `log` VALUES ('94cf08f95ee94f13899807fab2125851', 'disadd', '2018-02-02 18:23:25', '127.0.0.1', '');
INSERT INTO `log` VALUES ('9631624c30c547b79d9fe7f17314a8e9', 'admin', '2018-02-06 10:28:20', '127.0.0.1', '');
INSERT INTO `log` VALUES ('963a917dfb3c41adb8daed19a651a87c', 'admin', '2018-02-01 11:38:14', '127.0.0.1', '');
INSERT INTO `log` VALUES ('96ac6c23bcfc4c69b5be02d26cf30f23', 'dataadd', '2018-01-20 10:53:22', '127.0.0.1', '');
INSERT INTO `log` VALUES ('96b551164bc64379978c768cf10ff022', 'admin', '2018-02-01 14:42:12', '127.0.0.1', '');
INSERT INTO `log` VALUES ('979ce4894e4c402b8e3cf45a2ef9c1bb', 'disadd', '2018-01-25 18:23:48', '127.0.0.1', '');
INSERT INTO `log` VALUES ('98d600f4f8f549c0a6089f7a57e573b8', 'retall', '2018-01-24 09:23:40', '127.0.0.1', '');
INSERT INTO `log` VALUES ('9a2c1812c81e473aaaca9f89f2218982', 'disadd', '2018-01-24 17:40:40', '192.168.10.101', '');
INSERT INTO `log` VALUES ('9ac28162f32b46458f29606c20d60a56', 'admin', '2018-01-23 11:32:29', '127.0.0.1', '');
INSERT INTO `log` VALUES ('9ae79212e7be4a359509839e2cc69619', 'reacba', '2018-01-22 11:29:52', '127.0.0.1', '');
INSERT INTO `log` VALUES ('9cdfdd0dd8d84ca08e311a5e0335a538', 'admin', '2018-01-20 18:07:49', '127.0.0.1', '');
INSERT INTO `log` VALUES ('9dcc7102ad0a440385a5650e3c5642f3', 'disadd', '2018-02-06 09:30:27', '127.0.0.1', '');
INSERT INTO `log` VALUES ('9e3d12dec02042c59478122784eeddb3', 'admin', '2017-12-22 10:44:27', '127.0.0.1', '');
INSERT INTO `log` VALUES ('9e53c3e99fcb4680b75d10646358030a', 'display', '2018-01-24 15:53:20', '127.0.0.1', '');
INSERT INTO `log` VALUES ('9e9b08e11c234326b4187044b2ee67f0', 'display', '2018-02-03 09:53:55', '127.0.0.1', '');
INSERT INTO `log` VALUES ('9fa481b80fb54612a9c200e3836cbf29', 'reacba', '2018-02-03 08:16:57', '127.0.0.1', '');
INSERT INTO `log` VALUES ('a36d441607e94c9f9434bb3b546eff27', 'admin', '2018-01-19 16:53:43', '127.0.0.1', '');
INSERT INTO `log` VALUES ('a58522cd420745b0b3f5f081ea629aa0', 'dataadd', '2017-12-22 10:43:42', '127.0.0.1', '');
INSERT INTO `log` VALUES ('a654ab146cb44bca8f8066569742de04', 'admin', '2018-01-18 18:52:45', '127.0.0.1', '');
INSERT INTO `log` VALUES ('a7fefabeee1c4fdba7e5a5014bef6e6c', 'admin', '2018-01-20 08:19:51', '127.0.0.1', '');
INSERT INTO `log` VALUES ('a8b5ba7273af420da3ecb828082ddd4b', 'disadd', '2018-01-29 08:52:04', '127.0.0.1', '');
INSERT INTO `log` VALUES ('a98f3fd4336048ce807b4b54ec2af408', 'admin', '2018-01-24 17:41:11', '192.168.10.101', '');
INSERT INTO `log` VALUES ('a9ec13b078d6474cac39ac449369256d', 'display', '2018-01-26 09:41:55', '192.168.10.123', '');
INSERT INTO `log` VALUES ('ab71e034d99043e5b135c3141e831ba0', 'admin', '2017-12-21 09:54:04', '127.0.0.1', '');
INSERT INTO `log` VALUES ('ae27fc46ad354d058ac40eb1c794759c', 'admin', '2018-01-30 16:19:31', '127.0.0.1', '');
INSERT INTO `log` VALUES ('aee7bcb373414dcc85150f8da871e138', 'admin', '2017-12-22 10:42:33', '127.0.0.1', '');
INSERT INTO `log` VALUES ('af7d6c75391b49c78e468efeffce1779', 'disadd', '2018-01-31 16:36:46', '127.0.0.1', '');
INSERT INTO `log` VALUES ('af86146e96364fddb3b8144678a4f772', 'reacre', '2018-01-22 11:04:56', '127.0.0.1', '');
INSERT INTO `log` VALUES ('b15ce9a17f1f4248a0ef3c298808a8b0', 'disadd', '2018-02-01 10:24:25', '127.0.0.1', '');
INSERT INTO `log` VALUES ('b16e9bc21c994226b4ae55eb5a60702b', 'admin', '2018-01-24 17:07:39', '127.0.0.1', '');
INSERT INTO `log` VALUES ('b3278a45cc454db39afa8db69af79f75', 'admin', '2018-02-01 10:28:43', '127.0.0.1', '');
INSERT INTO `log` VALUES ('b4378bcb957d47d5a2fc920ee9d85002', 'reacch', '2018-01-23 11:01:04', '127.0.0.1', '');
INSERT INTO `log` VALUES ('b4aa56722f9947ee81988feb2b3e016f', 'disadd', '2018-01-23 19:17:18', '127.0.0.1', '');
INSERT INTO `log` VALUES ('b4af876f89c4454bbdc8227816cd9499', 'admin', '2018-01-22 16:33:40', '127.0.0.1', '');
INSERT INTO `log` VALUES ('b5be0455c4614ce4896de3a0f576ca20', 'rerece', '2018-01-23 10:58:29', '127.0.0.1', '');
INSERT INTO `log` VALUES ('b6745ac133864286b0b1a2e3d6a71614', 'reacch', '2018-01-22 15:56:38', '127.0.0.1', '');
INSERT INTO `log` VALUES ('b6892929e88c4123a382680a57187148', 'disadd', '2018-02-05 16:04:45', '127.0.0.1', '');
INSERT INTO `log` VALUES ('b70a389ef17c48fc9a8ffcd9044eba8b', 'dataadd', '2017-12-22 10:44:52', '127.0.0.1', '');
INSERT INTO `log` VALUES ('b7324805c55647e2a8731f65b957121c', 'admin', '2018-02-09 16:14:43', '127.0.0.1', '');
INSERT INTO `log` VALUES ('b7ed120fdd2141a2b77b8ff0a8d8eed9', 'display', '2018-02-03 09:56:39', '127.0.0.1', '');
INSERT INTO `log` VALUES ('b83654db2ebf442e8227c2474d12beac', 'ceshi123', '2018-02-05 17:24:20', '127.0.0.1', '');
INSERT INTO `log` VALUES ('b8514531810e4135bee5d8a97c8308e6', 'disadd', '2018-01-30 16:52:28', '192.168.10.107', '');
INSERT INTO `log` VALUES ('b948556a009247e880eaf400800073f3', 'disadd', '2018-01-30 16:41:39', '127.0.0.1', '');
INSERT INTO `log` VALUES ('bc6d9c96a9a146cd86c15b08ae13b0e5', 'admin', '2018-01-20 18:09:13', '127.0.0.1', '');
INSERT INTO `log` VALUES ('bc814fb764a34517880e00e099686121', 'adjadd', '2018-01-26 09:08:48', '192.168.10.123', '');
INSERT INTO `log` VALUES ('bd833c2c246a40e2b43501844338d758', 'disadd', '2018-01-24 10:35:59', '127.0.0.1', '');
INSERT INTO `log` VALUES ('be59fe42dfbe4691a6821a51696c70b8', 'discheck', '2018-01-24 09:49:54', '127.0.0.1', '');
INSERT INTO `log` VALUES ('bf15bb34ba734e21a54282ae2237455f', 'admin', '2018-01-24 15:51:43', '127.0.0.1', '');
INSERT INTO `log` VALUES ('bfe56f40ff144fba8d6a6c8ef589bd4a', 'reacba', '2018-02-01 18:19:41', '127.0.0.1', '');
INSERT INTO `log` VALUES ('c0163804b48948a1953622e2d76ddcc9', 'disadd', '2018-01-31 09:36:20', '127.0.0.1', '');
INSERT INTO `log` VALUES ('c13784d06a33482caa7423642a5a4fc4', 'disadd', '2018-02-03 09:23:03', '127.0.0.1', '');
INSERT INTO `log` VALUES ('c1a4eb9b711e480b89ebd50407e42ca0', 'disadd', '2018-01-24 15:18:01', '127.0.0.1', '');
INSERT INTO `log` VALUES ('c343ca0124184871aba881699c948ed3', 'reacre', '2018-01-24 08:49:06', '127.0.0.1', '');
INSERT INTO `log` VALUES ('c34856708f184b329c3d4a4e0e34211e', 'disadd', '2018-01-26 09:16:13', '192.168.10.123', '');
INSERT INTO `log` VALUES ('c3c01ed33e764a31a1608228789b91ea', 'disadd', '2018-02-03 08:23:30', '127.0.0.1', '');
INSERT INTO `log` VALUES ('c55c294649a3461daea9a9cd5f074e7a', 'disadd', '2018-01-29 14:45:09', '127.0.0.1', '');
INSERT INTO `log` VALUES ('c5f539a28a0d457987a3a108d541eee9', 'dataadd', '2018-01-24 11:10:47', '127.0.0.1', '');
INSERT INTO `log` VALUES ('c68e9ec5a1214cedbaeee3863cfd5664', 'disadd', '2018-02-05 11:02:13', '127.0.0.1', '');
INSERT INTO `log` VALUES ('c74d4859706a476ca8d20d2417a7e4b2', 'rerece', '2018-01-22 15:54:58', '127.0.0.1', '');
INSERT INTO `log` VALUES ('c9b3609da51e414c90c20e546963d672', 'discheck', '2018-01-26 09:34:11', '192.168.10.123', '');
INSERT INTO `log` VALUES ('ca2a31f084964f6a9eba3962728d1ff6', 'retall', '2018-01-22 11:33:18', '127.0.0.1', '');
INSERT INTO `log` VALUES ('caf73e60ecb84c68bf6ac50d83677f56', 'disadd', '2018-01-29 14:59:38', '127.0.0.1', '');
INSERT INTO `log` VALUES ('cb22a6889baa4a6f827e34618707921b', 'admin', '2018-02-09 08:39:55', '127.0.0.1', '');
INSERT INTO `log` VALUES ('cd3a5ba6e703459999d65003c9753e50', 'disdata', '2018-01-24 10:13:42', '127.0.0.1', '');
INSERT INTO `log` VALUES ('d0cc1d3ebcc94eafb7ed6f6fdd0f30b8', 'rerece', '2018-01-22 16:01:07', '127.0.0.1', '');
INSERT INTO `log` VALUES ('d2962549fdab4fd9a8396fedd00665f3', 'disadd', '2018-01-29 15:03:18', '127.0.0.1', '');
INSERT INTO `log` VALUES ('d3170cb1d68042138ce320bc7ee2fd85', 'display', '2018-01-25 08:45:31', '127.0.0.1', '');
INSERT INTO `log` VALUES ('d423c5bbc4b84715978970bc434b85fc', 'disadd', '2018-02-11 15:23:55', '127.0.0.1', '');
INSERT INTO `log` VALUES ('d4f077b8402142b3806e827c1c150a9c', 'disadd', '2018-02-05 11:37:19', '127.0.0.1', '');
INSERT INTO `log` VALUES ('d6ed2abec20e4b3c958dc91857476001', 'admin', '2017-12-21 10:39:47', '127.0.0.1', '');
INSERT INTO `log` VALUES ('d6fa30e1303246b287f1f04e0607433c', 'dataadd', '2017-12-22 11:30:29', '127.0.0.1', '');
INSERT INTO `log` VALUES ('d78e211f5d0d456e89a80543e6a8c436', 'dataadd', '2018-01-24 11:27:34', '127.0.0.1', '');
INSERT INTO `log` VALUES ('d86192b63be647ff90bfa6462abe61a3', 'disadd', '2018-01-27 16:25:05', '127.0.0.1', '');
INSERT INTO `log` VALUES ('d8fa877e2e904e2aa6de9b354fa56e5b', 'dataadd', '2018-01-26 10:13:01', '192.168.10.117', '');
INSERT INTO `log` VALUES ('da85b8128b6f4871bdda069f8d34fe06', 'admin', '2017-12-22 11:22:47', '127.0.0.1', '');
INSERT INTO `log` VALUES ('dd501cd5204a4270b652bcfbc60a350d', 'reacre', '2018-01-22 16:01:45', '127.0.0.1', '');
INSERT INTO `log` VALUES ('de226522e83c4b35b09ed88c0b3ad9ac', 'admin', '2017-12-21 09:46:11', '127.0.0.1', '');
INSERT INTO `log` VALUES ('df7a45f6a6f648aeae8fbc85e8e8609b', 'admin', '2017-12-19 17:11:40', '127.0.0.1', '');
INSERT INTO `log` VALUES ('df9adddc7f8b47699ccbea8da063f07a', 'adjdata', '2018-01-25 18:42:07', '127.0.0.1', '');
INSERT INTO `log` VALUES ('e05d8aad2d8644e98ce5305af3ffd863', 'reacch', '2018-01-22 16:17:20', '127.0.0.1', '');
INSERT INTO `log` VALUES ('e0f8cd5027c44249b9025bcb578598f7', 'discheck', '2018-01-24 11:07:26', '127.0.0.1', '');
INSERT INTO `log` VALUES ('e2338d09f68c42c78fc2c6f88bca30b8', 'admin', '2018-01-24 14:59:46', '127.0.0.1', '');
INSERT INTO `log` VALUES ('e242abca09de4d45aeaece0a936a2843', 'admin', '2018-01-22 16:23:54', '127.0.0.1', '');
INSERT INTO `log` VALUES ('e24f25d74b994734b3b85950836cf4cf', 'admin', '2017-12-21 10:08:14', '127.0.0.1', '');
INSERT INTO `log` VALUES ('e269d7a0ed954916a1b5aa6b33f84076', 'admin', '2018-01-25 11:05:18', '127.0.0.1', '');
INSERT INTO `log` VALUES ('e3db3921ca0548ac85226efeeadb1b36', 'reacba', '2018-01-22 15:57:17', '127.0.0.1', '');
INSERT INTO `log` VALUES ('e4d65f4dc782466c98870b91ea73d00c', 'disadd', '2018-01-30 18:59:09', '127.0.0.1', '');
INSERT INTO `log` VALUES ('e512494d0a05469db69cc7b4516a540b', 'disinfor', '2018-01-24 11:08:04', '127.0.0.1', '');
INSERT INTO `log` VALUES ('e5350b5c944444988a966daea2bc8611', 'admin', '2017-12-19 11:28:40', '127.0.0.1', '');
INSERT INTO `log` VALUES ('e5f29de05c5b435b97163dd47838da25', 'retall', '2018-01-22 15:57:53', '127.0.0.1', '');
INSERT INTO `log` VALUES ('e894a43e7e904693b362a581c74a34b0', 'reacch', '2018-02-01 14:49:50', '127.0.0.1', '');
INSERT INTO `log` VALUES ('e8a978f386c54403bf2b44b8e614f4f4', 'admin', '2018-01-20 18:08:22', '127.0.0.1', '');
INSERT INTO `log` VALUES ('e8ff473176224fb9ad5729db7a3a5448', 'admin', '2017-12-22 12:00:30', '127.0.0.1', '');
INSERT INTO `log` VALUES ('eaa9525f74ba4df6966c74e4d1d571fb', 'disdata', '2018-01-26 09:32:14', '192.168.10.123', '');
INSERT INTO `log` VALUES ('eae52a6ad4cc4c99a76ff3c39ee25db2', 'disadd', '2018-01-29 14:47:02', '127.0.0.1', '');
INSERT INTO `log` VALUES ('eba472e470e94a87b1b57898b1e87d24', 'disadd', '2018-02-03 08:17:38', '127.0.0.1', '');
INSERT INTO `log` VALUES ('eba6182be3824258ba2ad1f06966b1f8', 'admin', '2018-01-24 17:37:18', '192.168.10.101', '');
INSERT INTO `log` VALUES ('ee12d27d6b2b400fbe038c5dca92b708', 'dataadd', '2018-01-22 17:44:00', '127.0.0.1', '');
INSERT INTO `log` VALUES ('ee5f9908bbfd4d31a06f70c2d9182eef', 'disdata', '2018-01-26 09:31:07', '192.168.10.123', '');
INSERT INTO `log` VALUES ('f198aaf0175046b09e19853e89472155', 'admin', '2018-02-05 16:48:15', '127.0.0.1', '');
INSERT INTO `log` VALUES ('f1c2d594065248f0b416f7569a635c1c', 'retall', '2018-01-22 16:21:36', '127.0.0.1', '');
INSERT INTO `log` VALUES ('f23a2dd726b34085a85bc7c6043ad507', 'admin', '2018-01-24 09:54:12', '127.0.0.1', '');
INSERT INTO `log` VALUES ('f35a4bf4fd624bd5a3717b938c17b944', 'admin', '2018-01-26 09:55:14', '192.168.10.117', '');
INSERT INTO `log` VALUES ('f3ce81c65fd542bc9f64f2ac6b866797', 'admin', '2018-01-22 11:26:39', '127.0.0.1', '');
INSERT INTO `log` VALUES ('f452f2785476422f93a2828fb88faad1', 'admin', '2018-01-25 08:46:11', '127.0.0.1', '');
INSERT INTO `log` VALUES ('f4b6bd3bc85346bbbeb4b3957f06521d', 'disadd', '2018-01-30 16:25:43', '127.0.0.1', '');
INSERT INTO `log` VALUES ('f5bfe78633ca479c8081a193a9cccb18', 'disadd', '2018-01-24 15:13:46', '127.0.0.1', '');
INSERT INTO `log` VALUES ('f64faba2f3e44a84a1beb9718607be7b', 'display', '2018-01-26 09:14:14', '192.168.10.123', '');
INSERT INTO `log` VALUES ('f6ab2a5bb336475892466f5cd174886e', 'disadd', '2018-02-05 09:24:59', '127.0.0.1', '');
INSERT INTO `log` VALUES ('f73fe4dfe6e1475fa44d06f08d41230d', 'disadd', '2018-01-24 17:38:39', '192.168.10.101', '');
INSERT INTO `log` VALUES ('f7a2306192e3422c942fe422754cffb0', 'disadd', '2018-02-01 09:12:09', '127.0.0.1', '');
INSERT INTO `log` VALUES ('f83f95fe6123481b946debb4bfefc9c0', 'disinfor', '2018-01-24 09:54:47', '127.0.0.1', '');
INSERT INTO `log` VALUES ('f8b5eba492bd47a192f5e94959925873', 'admin', '2018-02-11 14:57:04', '127.0.0.1', '');
INSERT INTO `log` VALUES ('f9bb8c0c51cc47188f430a8dbba5afa5', 'display', '2018-01-24 17:11:22', '127.0.0.1', '');
INSERT INTO `log` VALUES ('fa44533adafe4a22b8cf7d2337c1f157', 'disadd', '2018-01-30 19:01:04', '127.0.0.1', '');
INSERT INTO `log` VALUES ('fba9d3d95eb6486f8be80df71080d51d', 'disinfor', '2018-01-24 09:53:31', '127.0.0.1', '');
INSERT INTO `log` VALUES ('fc378b08612d411286d4e26ea5821928', 'dataadd', '2018-01-25 17:03:53', '127.0.0.1', '');
INSERT INTO `log` VALUES ('fc9eb505ebb4484cad65e82a69fdd644', 'disdata', '2018-01-24 11:07:09', '127.0.0.1', '');
INSERT INTO `log` VALUES ('fd0fd46a94f74f7bacbff7a765a128c6', 'disadd', '2018-01-31 09:57:38', '127.0.0.1', '');
INSERT INTO `log` VALUES ('fe965bdcdb804c62828cf7829c8161bf', 'disadd', '2018-01-26 15:38:55', '192.168.10.117', '');
INSERT INTO `log` VALUES ('fef11d9c8a5c4afca7ecb808e77b3b9d', 'reacba', '2018-02-02 08:42:44', '127.0.0.1', '');
INSERT INTO `log` VALUES ('ff70dd6e6b544d658e1ff751e3ef8f66', 'disadd', '2018-01-31 08:46:45', '127.0.0.1', '');
INSERT INTO `log` VALUES ('ffd05cff344e4308a25356070ea3d20b', 'admin', '2018-02-07 09:40:58', '127.0.0.1', '');
INSERT INTO `log` VALUES ('ffd8d74ad52846acb761ada74fba9c30', 'admin', '2018-02-10 10:54:54', '127.0.0.1', '');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `uid` varchar(32) NOT NULL,
  `account` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `salt` varchar(32) NOT NULL,
  `state` tinyint(1) NOT NULL DEFAULT '1',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`uid`,`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('053145b33ace4bfa8252286c768857c3', 'aaaa', '44e51db881e0bc6507988f2cd45f51f7', '7d4107fb7c40e626510d6477cc840afe', '1', '2017-12-20 19:34:58', '2017-12-20 19:34:58');
INSERT INTO `member` VALUES ('3eb011e6638b4184aef77c3b095883df', 'flyshy', 'b2e61c4d4362ac061ad3bfe115b7b700', '6cfa0ce808a2ff68e61d248af75243a7', '1', '2017-03-14 09:44:35', '2017-03-14 09:44:35');
INSERT INTO `member` VALUES ('ea9eff120afa40e7af6073878930c021', 'admin', 'f05902e6bbd74844bd5302f90dd01672', '2d8880ea1049cc7e8094629b7716905c', '1', '2017-12-20 19:33:44', '2017-12-20 19:33:44');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `menu_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '资源类型，菜单或都按钮(menu,button)',
  `menu_url` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `menu_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `parent_ids` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `child_num` int(10) NOT NULL DEFAULT '0',
  `listorder` int(10) NOT NULL DEFAULT '0',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('00dc5c51e4824f49a30013385f680b0c', '日志管理', 'auth', '/console/log/index', 'log:index', 'e5f52fe2115e46229c60803e478d2e9a', null, '0', '1', '2017-01-06 14:11:23', '2017-05-08 14:55:21');
INSERT INTO `menu` VALUES ('10daa36798964fa3b2073ae8ee96c82e', '验收退单', 'button', '/console/receipt/form', 'receipt:acba', '71e80d2e0763457580f5be1ce564a470', null, '0', '0', '2017-12-22 11:26:28', '2017-12-22 11:26:28');
INSERT INTO `menu` VALUES ('1cc3d9ad04e4424db1bb086d1678925e', '菜单删除', 'auth', '/console/menu/delete', 'menu:delete', '736bdf0b9aec4c59928a530e34bd9aad', null, '0', '0', '2017-05-10 16:45:30', '2017-05-10 16:45:30');
INSERT INTO `menu` VALUES ('2191c9efc2fa431bb427b81ad938e8aa', '角色保存', 'auth', '/console/role/save', 'role:save', '6cda978dc9404ba2bf5854b74735b0bc', null, '0', '0', '2017-05-10 16:41:21', '2017-05-10 16:41:21');
INSERT INTO `menu` VALUES ('295d8f40824f4de082b558d08a9d211e', '配送管理', 'auth', '/console/distrib/index', 'distrib:Index', 'da86287f51074d68a904e594d53dec4b', null, '4', '0', '2018-01-23 10:31:32', '2018-01-23 10:31:32');
INSERT INTO `menu` VALUES ('362923d31e064f84adb8c23ba91e54d8', '管理员编辑', 'auth', '/console/admin/from', 'admin:edit', 'e0dde3b9227c471eb3bd2ba0a7fab131', null, '0', '0', '2017-05-08 14:57:39', '2017-05-10 16:40:47');
INSERT INTO `menu` VALUES ('3ac96215e82f40b5bfe442e6828641df', '系统管理', 'menu', '/console/system/admin', 'system:admin', '0', null, '3', '1', '2016-12-07 16:00:00', '2017-05-10 16:46:27');
INSERT INTO `menu` VALUES ('41eb3150b1a147f88196ac6bca6e92c8', '调货删除', 'auth', '/console/adjust/delete', 'adjust:delete', 'f24c0f15824f43d5bdbe77e0c837cf5b', null, '0', '0', '2018-01-25 10:01:07', '2018-01-25 10:01:07');
INSERT INTO `menu` VALUES ('4676084626794b5a908dae79d30437a9', '商品删除', 'menu', '/console/goods/delete', 'goods:delete', 'd5c6ed6188ba42faa507751d94ac0be8', null, '0', '0', '2017-12-19 11:44:11', '2017-12-19 11:47:56');
INSERT INTO `menu` VALUES ('579502ee69d24523907e7c242f731db1', '配送保存', 'auth', '/console/distrib/save', 'distrib:save', '295d8f40824f4de082b558d08a9d211e', null, '0', '0', '2018-01-23 10:40:30', '2018-01-23 10:40:30');
INSERT INTO `menu` VALUES ('6085fa446dc04b9e86272cb3c444af06', '验收复核', 'button', '/console/receipt/form', 'receipt:acch', '71e80d2e0763457580f5be1ce564a470', null, '0', '0', '2017-12-22 11:25:37', '2017-12-22 11:25:37');
INSERT INTO `menu` VALUES ('60f58b92f6f145de9346f98ac0ebf57d', '收货删除', 'menu', '/console/receipt/delete', 'receipt:delete', '71e80d2e0763457580f5be1ce564a470', null, '0', '0', '2017-12-20 14:34:59', '2017-12-20 14:34:59');
INSERT INTO `menu` VALUES ('6580896645d046a0acf3c1194d7bbf8e', '管理员删除', 'menu', '/console/admin/delete', 'admin:delete', 'e0dde3b9227c471eb3bd2ba0a7fab131', null, '0', '0', '2017-05-10 16:39:44', '2017-05-10 16:39:44');
INSERT INTO `menu` VALUES ('66e4998df48746ada67a7d7a216d427f', '商品保存', 'auth', '/console/goods/save', 'goods:save', 'd5c6ed6188ba42faa507751d94ac0be8', null, '0', '0', '2017-12-19 11:49:42', '2017-12-19 11:51:24');
INSERT INTO `menu` VALUES ('69c530e9f50640dbb7886907908a27d3', '商品编辑', 'auth', '/console/goods/form', 'goods:edit', 'd5c6ed6188ba42faa507751d94ac0be8', null, '0', '0', '2017-12-19 11:51:39', '2017-12-19 12:02:03');
INSERT INTO `menu` VALUES ('6cda978dc9404ba2bf5854b74735b0bc', '角色管理', 'auth', '/console/role/index', 'role:index', '3ac96215e82f40b5bfe442e6828641df', null, '4', '2', '2016-12-07 16:47:40', '2016-12-07 16:47:40');
INSERT INTO `menu` VALUES ('71e80d2e0763457580f5be1ce564a470', '收货管理', 'auth', '/console/receipt/index', 'receipt:Index', 'da86287f51074d68a904e594d53dec4b', null, '9', '0', '2017-12-20 10:26:36', '2017-12-20 10:26:36');
INSERT INTO `menu` VALUES ('736bdf0b9aec4c59928a530e34bd9aad', '菜单管理', 'auth', '/console/menu/index', 'menu:index', '3ac96215e82f40b5bfe442e6828641df', null, '3', '3', '2016-12-07 16:50:17', '2016-12-07 16:50:17');
INSERT INTO `menu` VALUES ('73f4f7b679e8416580ae28850eacf2fb', '理货上架', 'button', '/console/receipt/form', 'receipt:tall', '71e80d2e0763457580f5be1ce564a470', null, '0', '0', '2017-12-22 11:27:10', '2017-12-22 11:27:10');
INSERT INTO `menu` VALUES ('74d4b8f33f2449fc91711a2207661c7a', '收货编辑', 'menu', '/console/receipt/form', 'receipt:edit', '71e80d2e0763457580f5be1ce564a470', null, '0', '0', '2017-12-20 14:33:35', '2017-12-20 14:33:35');
INSERT INTO `menu` VALUES ('85dad2bd9023451fab632dcfc4357d3b', '管理员保存', 'auth', '/console/admin/save', 'admin:save', 'e0dde3b9227c471eb3bd2ba0a7fab131', null, '0', '0', '2017-05-10 16:38:07', '2017-05-10 16:41:00');
INSERT INTO `menu` VALUES ('896c599a60584116ad901aa88930a393', '收货保存', 'menu', '/console/receipt/save', 'receipt:save', '71e80d2e0763457580f5be1ce564a470', null, '0', '0', '2017-12-20 14:34:09', '2017-12-20 14:34:09');
INSERT INTO `menu` VALUES ('8a653e3fb15642d9be6aad13b02009fb', '角色授权', 'auth', '/console/role/grant', 'role:grant', '6cda978dc9404ba2bf5854b74735b0bc', null, '0', '0', '2017-05-10 16:42:37', '2017-05-10 16:42:37');
INSERT INTO `menu` VALUES ('96f3f71736c04178a8431b85f8177471', '调货保存', 'auth', '/console/adjust/save', 'adjust:save', 'f24c0f15824f43d5bdbe77e0c837cf5b', null, '0', '0', '2018-01-25 09:59:16', '2018-01-25 09:59:16');
INSERT INTO `menu` VALUES ('984909260a06410d9be37c300e3df09d', '会员管理', 'menu', '/console/member/default', 'member:default', '0', null, '1', '0', '2017-05-10 16:50:16', '2017-05-10 16:51:06');
INSERT INTO `menu` VALUES ('99ce3da65c874972a497afa082de91d3', '验收退货', 'button', '/console/receipt/index', 'receipt:acre', '71e80d2e0763457580f5be1ce564a470', null, '0', '0', '2017-12-22 11:24:39', '2017-12-22 11:24:39');
INSERT INTO `menu` VALUES ('9c80141f46684e77b91bb1eaf616c64c', '配送编辑', 'auth', '/console/distrib/form', 'distrib:edit', '295d8f40824f4de082b558d08a9d211e', null, '0', '0', '2018-01-23 10:39:24', '2018-01-23 10:39:24');
INSERT INTO `menu` VALUES ('9f41af1454d046b596023a2822c5078c', '角色编辑', 'auth', '/console/role/from', 'role:edit', '6cda978dc9404ba2bf5854b74735b0bc', null, '0', '0', '2017-05-08 14:59:25', '2017-05-08 14:59:25');
INSERT INTO `menu` VALUES ('aab7966c97db4643a36cb5afa24be38b', '角色删除', 'menu', '/console/role/delete', 'role:delete', '6cda978dc9404ba2bf5854b74735b0bc', null, '0', '0', '2017-05-10 16:43:37', '2017-05-10 16:43:37');
INSERT INTO `menu` VALUES ('b57e4acaf6ba4fb9833848d84026bca4', '接货', 'button', '/console/receipt/index', 'receipt:rece', '71e80d2e0763457580f5be1ce564a470', null, '0', '0', '2017-12-22 11:23:51', '2017-12-22 11:23:51');
INSERT INTO `menu` VALUES ('b6380b73c98542c8b9bb412f6ac7f960', '收货信息管理', 'menu', '/console/receipt/index', 'receipt:index', 'cd97ab504f78465e8d879633325bf6aa', null, '0', '0', '2017-12-18 17:12:33', '2017-12-19 16:07:02');
INSERT INTO `menu` VALUES ('bb56e8331d034936ac861a256278b119', '添加配送', 'button', '/console/distrib/form', 'distrib:add', '295d8f40824f4de082b558d08a9d211e', null, '0', '0', '2018-01-24 10:04:20', '2018-01-24 10:04:20');
INSERT INTO `menu` VALUES ('bbef15c25ad940998f46a4707a2596b3', '流程显示', 'auth', '/console/display/index', 'display:index', 'da86287f51074d68a904e594d53dec4b', null, '0', '0', '2018-01-24 14:43:51', '2018-01-24 15:16:07');
INSERT INTO `menu` VALUES ('c4ba872ba46c43cf8cfdc12135a7ef84', '添加收货', 'button', '/console/receipt/form', 'receipt:add', '71e80d2e0763457580f5be1ce564a470', null, '0', '0', '2017-12-22 10:39:32', '2017-12-22 10:39:32');
INSERT INTO `menu` VALUES ('c5cca135ee534bfeb482fb04b9311982', '菜单编辑', 'auth', '/console/menu/from', 'menu:from', '736bdf0b9aec4c59928a530e34bd9aad', null, '0', '0', '2016-12-07 16:51:31', '2017-05-08 15:00:02');
INSERT INTO `menu` VALUES ('c5fdf29ff1df4ff6a096bd802b2916ec', '厂商管理', 'menu', '/console/factory/index', 'factory:index', 'cd97ab504f78465e8d879633325bf6aa', null, '0', '0', '2017-12-18 17:07:52', '2017-12-19 16:06:35');
INSERT INTO `menu` VALUES ('cd97ab504f78465e8d879633325bf6aa', '基础信息', 'menu', '/console/basic/default', 'basic:default', '0', null, '3', '0', '2017-12-18 16:55:43', '2017-12-18 16:55:43');
INSERT INTO `menu` VALUES ('d5c6ed6188ba42faa507751d94ac0be8', '商品管理', 'auth', '/console/goods/index', 'goods:index', 'cd97ab504f78465e8d879633325bf6aa', null, '3', '0', '2017-12-18 17:01:30', '2017-12-19 16:06:20');
INSERT INTO `menu` VALUES ('da86287f51074d68a904e594d53dec4b', '物流中心', 'menu', '/console/logistics/default', 'logistics:default', '0', null, '4', '0', '2017-12-20 09:53:05', '2017-12-20 09:53:05');
INSERT INTO `menu` VALUES ('e0dde3b9227c471eb3bd2ba0a7fab131', '管理员管理', 'auth', '/console/admin/index', 'admin:index', '3ac96215e82f40b5bfe442e6828641df', null, '3', '1', '2016-12-07 16:45:47', '2017-05-10 16:39:08');
INSERT INTO `menu` VALUES ('e4250fda016e449fbbd32f4a319a7a8b', '配送删除', 'auth', '/console/distrib/delete', 'distrib:delete', '295d8f40824f4de082b558d08a9d211e', null, '0', '0', '2018-01-23 10:43:01', '2018-01-23 10:43:01');
INSERT INTO `menu` VALUES ('e5f52fe2115e46229c60803e478d2e9a', '扩展设置', 'menu', '/console/system/setting', 'system:setting', '0', null, '1', '3', '2016-12-07 16:36:42', '2017-05-10 16:50:00');
INSERT INTO `menu` VALUES ('e85b2fb3e6ee4d0a9711c577bc842821', '会员管理', 'auth', '/console/member/index', 'member:index', '984909260a06410d9be37c300e3df09d', null, '0', '0', '2017-05-10 16:51:20', '2017-05-10 16:51:20');
INSERT INTO `menu` VALUES ('f24c0f15824f43d5bdbe77e0c837cf5b', '调货管理', 'auth', '/console/transfer/index', 'adjust:Index', 'da86287f51074d68a904e594d53dec4b', null, '4', '0', '2018-01-25 09:54:33', '2018-01-25 09:54:33');
INSERT INTO `menu` VALUES ('f4237d06c0c94906bdc04f5ed19cbaeb', '菜单保存', 'auth', '/console/menu/save', 'menu:save', '736bdf0b9aec4c59928a530e34bd9aad', null, '0', '0', '2017-05-10 16:44:51', '2017-05-10 16:44:51');
INSERT INTO `menu` VALUES ('f9988bccaef64a53a9917bb496a9b03f', '添加调货', 'button', '/console/adjust/form', 'adjust:add', 'f24c0f15824f43d5bdbe77e0c837cf5b', null, '0', '0', '2018-01-25 10:05:11', '2018-01-25 10:05:11');
INSERT INTO `menu` VALUES ('fa1929b2d2264461bfdad173a9fb3a4c', '调货编辑', 'auth', '/console/adjust/form', 'adjust:edit', 'f24c0f15824f43d5bdbe77e0c837cf5b', null, '0', '0', '2018-01-25 09:58:31', '2018-01-25 09:58:31');

-- ----------------------------
-- Table structure for receipt
-- ----------------------------
DROP TABLE IF EXISTS `receipt`;
CREATE TABLE `receipt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(32) NOT NULL,
  `receipt_num` varchar(50) DEFAULT NULL,
  `delivery_unit` varchar(50) NOT NULL,
  `delivery_time` datetime DEFAULT NULL,
  `productname` varchar(60) NOT NULL,
  `factory` varchar(60) DEFAULT NULL,
  `unit` varchar(20) DEFAULT NULL,
  `number` decimal(20,0) DEFAULT NULL,
  `receipt_addr` varchar(50) DEFAULT NULL,
  `receipt_time` datetime DEFAULT NULL,
  `receipt_man` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `receipt_time_begin` datetime DEFAULT NULL,
  `receipt_time_end` datetime DEFAULT NULL,
  `accep_re_man` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `accep_re_begin` datetime DEFAULT NULL,
  `accep_re_end` datetime DEFAULT NULL,
  `accep_check_man` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `accep_check_begin` datetime DEFAULT NULL,
  `accep_check_end` datetime DEFAULT NULL,
  `accep_back_man` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `accep_back_begin` datetime DEFAULT NULL,
  `accep_back_end` datetime DEFAULT NULL,
  `tally_man` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `tally_begin` datetime DEFAULT NULL,
  `tally_end` datetime DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  `createdat` datetime DEFAULT NULL,
  `updatedat` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of receipt
-- ----------------------------
INSERT INTO `receipt` VALUES ('1', '8d39472457cb42e280aa51d9b1f0d52e', 'gerg', 'erghergre', '2018-02-01 18:58:44', 'agegeegeg', '理贝尔', 'gege', '122', '玉林', '2018-02-01 18:59:06', '庞晓燕', '2018-02-02 10:39:07', '2018-02-02 11:26:55', '李慧', '2018-02-02 11:33:34', '2018-02-02 11:34:10', '卢中炜', '2018-02-02 11:36:06', '2018-02-02 11:36:11', '黄春云', '2018-02-02 11:36:15', '2018-02-02 11:36:21', '孟龙斌', '2018-02-02 11:36:25', '2018-02-02 11:36:28', null, '11', '2018-02-01 18:59:24', '2018-02-02 10:39:08');
INSERT INTO `receipt` VALUES ('2', 'adae3ca6762147f1a4d478496149cfcb', 'vdfdf', 'dddfwsdwd', '2018-02-02 08:43:17', 'ddd', '5156456', 'ddddd', '100', '454154', '2018-02-02 08:43:27', '谭嘉', '2018-02-02 15:21:15', '2018-02-02 15:50:28', '卢中炜', '2018-02-02 15:52:18', '2018-02-02 15:52:24', '卢中炜', '2018-02-02 15:52:32', '2018-02-02 17:02:32', '谭嘉', '2018-02-02 17:33:50', '2018-02-03 08:19:01', '孟龙斌', '2018-02-03 09:42:09', '2018-02-03 09:42:14', null, '11', '2018-02-02 08:43:46', '2018-02-02 08:43:46');
INSERT INTO `receipt` VALUES ('3', 'f7235597031941dea1f52d817cb7d31a', 'no201708001001', 'geage', '2018-02-02 09:00:37', 'gegae', 'aege', 'geage', null, 'gege', '2018-02-02 09:00:47', '庞晓燕', '2018-02-02 15:27:13', '2018-02-02 15:27:27', '潘飞', '2018-02-02 15:27:34', '2018-02-02 15:28:33', '卢中炜', '2018-02-02 15:54:35', '2018-02-02 17:02:36', '庞晓燕', '2018-02-02 17:02:44', '2018-02-02 17:02:48', '谭嘉', '2018-02-02 17:02:52', '2018-02-02 17:02:55', null, '11', '2018-02-02 09:00:53', '2018-02-02 09:00:53');
INSERT INTO `receipt` VALUES ('4', 'a65af50e5a0c40638cc4a7a75360c236', '', '', null, '', '', '', null, '', null, '', '2018-02-02 17:11:46', '2018-02-02 17:11:51', '', '2018-02-02 17:14:29', null, '', null, null, '', null, null, '', null, null, null, '4', '2018-02-02 16:22:57', '2018-02-02 16:22:57');
INSERT INTO `receipt` VALUES ('5', '496fbc52434b4fdf8a40d7292a693fdf', 'geg', 'egege', '2018-02-02 16:23:12', 'agege', 'agegaeg', 'agee', '233', '玉林车站', '2018-02-02 16:23:26', '庞晓燕', '2018-02-02 16:27:13', '2018-02-02 16:28:44', '李慧', '2018-02-02 16:45:07', '2018-02-02 16:45:59', '孟龙斌', null, null, '潘飞', null, null, '冯家柯', null, null, null, '5', '2018-02-02 16:23:42', '2018-02-02 16:23:42');
INSERT INTO `receipt` VALUES ('6', '9944444145c74c559f10dfe2684d7550', '', 'asdfasdf', '2018-02-03 16:54:07', 'asdfasdf', 'asdfsdf', 'sadf', '33', 'asdfsadf', null, '', '2018-02-07 12:44:07', '2018-02-07 12:44:31', '卢中炜', '2018-02-07 13:03:44', '2018-02-07 13:04:01', '李慧', '2018-02-07 13:04:22', null, '', null, null, '', null, null, null, '6', '2018-02-03 16:54:24', '2018-02-03 16:54:24');
INSERT INTO `receipt` VALUES ('7', '68ea1c9e548b40db95b1d4cb78bae503', '201802031710001', '玉林市一', '2018-02-03 17:12:26', '玉林正骨水', '正骨水厂', '瓶', '1', '江南站', '2018-02-03 17:13:07', '庞家剑', '2018-02-03 17:14:10', '2018-02-03 17:14:23', '黄福文', '2018-02-03 17:14:38', '2018-02-03 17:42:36', '宋卉玲', '2018-02-03 17:42:57', '2018-02-07 11:55:35', '宁东', '2018-02-07 13:00:56', '2018-02-07 13:00:58', '侯磊', null, null, null, '9', '2018-02-03 17:13:28', '2018-02-03 17:13:28');
INSERT INTO `receipt` VALUES ('8', '469e4e1ec0f5410c99a65607400155ab', 'ZXDB12132163165', '南宁市一', '2018-02-05 11:29:35', '肱骨钉', '理贝尔', '套', '1', '琅东站', '2018-02-05 11:29:32', '庞晓燕', '2018-02-05 11:30:41', '2018-02-05 11:30:44', '庞晓燕', '2018-02-05 11:30:52', '2018-02-05 11:30:56', '庞晓燕', '2018-02-05 15:45:59', '2018-02-05 15:46:04', '庞晓燕', '2018-02-07 10:04:51', '2018-02-07 11:40:15', '庞晓燕', '2018-02-07 11:43:15', '2018-02-09 08:40:10', null, '11', '2018-02-05 11:30:31', '2018-02-05 11:30:31');
INSERT INTO `receipt` VALUES ('9', 'b175080ecd4d4c9e95c1c41d25be4be2', 'ageewg', 'gege', '2018-02-07 12:45:33', '', '', '', null, '', null, '', '2018-02-07 12:45:56', '2018-02-07 12:52:03', '庞晓燕', '2018-02-07 12:52:08', '2018-02-07 12:52:17', '谭嘉', '2018-02-07 14:36:37', null, '', null, null, '', null, null, null, '6', '2018-02-07 12:45:37', '2018-02-07 12:45:37');
INSERT INTO `receipt` VALUES ('10', 'a5127068e1fb4022b2f7b100ca966bc3', 'ccc', '', null, '', '', '', null, '', null, '', '2018-02-07 12:52:32', '2018-02-07 12:56:43', '卢中炜', '2018-02-08 09:30:04', null, '', null, null, '', null, null, '', null, null, null, '4', '2018-02-07 12:52:24', '2018-02-07 12:52:24');
INSERT INTO `receipt` VALUES ('11', 'a9aa3abfc7454b4fb5975bc9e80e6776', '', '', null, '', '', '', null, '', null, '陈天武', '2018-02-08 12:29:34', null, '', null, null, '', null, null, '', null, null, '', null, null, null, '2', '2018-02-08 09:33:20', '2018-02-08 09:33:20');
INSERT INTO `receipt` VALUES ('12', '3a8aa09e9e7241ad8534ecca60e097a0', '', '', null, '', '', '', null, '', null, '冯科杰', '2018-02-08 12:29:21', null, '', null, null, '', null, null, '', null, null, '', null, null, null, '2', '2018-02-08 09:47:49', '2018-02-08 09:47:49');
INSERT INTO `receipt` VALUES ('13', '27fcdd7e3d1046f9ae29cafb6f1d2232', '', 'gaege', null, 'gegew', '', '', null, '', null, '', '2018-02-08 11:56:30', '2018-02-08 12:26:01', '潘飞', '2018-02-08 12:26:09', '2018-02-08 12:26:19', '孟龙斌', '2018-02-08 12:26:25', null, '', null, null, '', null, null, null, '6', '2018-02-08 11:56:16', '2018-02-08 11:56:16');
INSERT INTO `receipt` VALUES ('14', '16b9aad8783040b8b65930a8dd27d4a9', '', '', null, '', '', '', null, '', null, '', '2018-02-08 12:26:37', null, '', null, null, '', null, null, '', null, null, '', null, null, null, '2', '2018-02-08 12:26:30', '2018-02-08 12:26:30');

-- ----------------------------
-- Table structure for receipt_copy
-- ----------------------------
DROP TABLE IF EXISTS `receipt_copy`;
CREATE TABLE `receipt_copy` (
  `uid` varchar(32) NOT NULL,
  `receipt_num` varchar(50) DEFAULT NULL,
  `delivery_unit` varchar(50) NOT NULL,
  `productname` varchar(60) NOT NULL,
  `factory` varchar(60) DEFAULT NULL,
  `unit` varchar(20) DEFAULT NULL,
  `number` decimal(20,0) DEFAULT NULL,
  `delivery_time` datetime DEFAULT NULL,
  `receipt_addr` varchar(50) DEFAULT NULL COMMENT '接货地点',
  `receipt_time` datetime DEFAULT NULL COMMENT '预计接货时间',
  `receipt_man` varchar(20) DEFAULT NULL,
  `receipt_time_begin` datetime DEFAULT NULL,
  `receipt_time_end` datetime DEFAULT NULL,
  `accep_re_man` varchar(20) DEFAULT NULL,
  `accep_re_begin` datetime DEFAULT NULL,
  `accep_re_end` datetime DEFAULT NULL,
  `accep_check_man` varchar(20) DEFAULT NULL,
  `accep_check_begin` datetime DEFAULT NULL,
  `accep_check_end` datetime DEFAULT NULL,
  `accep_back_man` varchar(20) DEFAULT NULL,
  `accep_back_begin` datetime DEFAULT NULL,
  `accep_back_end` datetime DEFAULT NULL,
  `tally_man` varchar(20) DEFAULT NULL,
  `tally_begin` datetime DEFAULT NULL,
  `tally_end` datetime DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `createdat` datetime DEFAULT NULL,
  `updatedat` datetime DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of receipt_copy
-- ----------------------------
INSERT INTO `receipt_copy` VALUES ('024b979e1cfc46e7a925e412256c2e9c', 'LOIN201801230001', '玉林骨科', '胫骨钉', '理贝尔', '套', '1', '2018-01-23 10:35:00', '琅东站', '2018-01-23 10:45:00', '张三', null, null, '李四', '2018-01-23 11:55:00', '2018-01-23 11:55:00', '王五', '2018-01-23 22:15:00', '2018-01-23 11:01:00', '安居房', '2018-01-23 11:40:00', '2018-01-23 11:45:00', '阿斯蒂芬', '2018-01-23 10:40:00', '2018-01-23 11:40:00', null, '7', null, '2018-01-23 11:03:10');
INSERT INTO `receipt_copy` VALUES ('12b7ddb6f992480d925d7beb64cbeda0', 'LOIN201801220002', '玉林骨科', '胫骨钉', '理贝尔', '套', '1', '2018-01-22 05:15:00', '琅东站', '1899-12-31 09:25:00', '4444', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2018-01-22 10:21:07');
INSERT INTO `receipt_copy` VALUES ('247c4c2fef0e495eaf195a936757bbae', 'LOIN201712210004', '', 'asdfaasdfas阿斯顿发生大幅度', null, '', '3', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2017-12-21 16:54:35', '2017-12-21 16:54:35');
INSERT INTO `receipt_copy` VALUES ('31fa6db7fc194717948c78d877a6f362', 'LOIN201801220001', 'asdfasdf', 'asdfasdf', null, 'asdfasdf', '343', '2018-01-22 05:10:00', 'adsfasd', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2018-01-22 09:14:04', '2018-01-22 09:14:04');
INSERT INTO `receipt_copy` VALUES ('3458c866373d46a3b366610713c954d8', 'LOIN201712210001', '', 'asdf阿斯顿发生的速度', '', '', null, null, '', null, '', null, null, '', null, null, '', null, null, '', null, null, '阿斯蒂芬', '2018-01-22 10:40:00', '2018-01-22 10:40:00', null, '7', null, '2018-01-22 17:41:21');
INSERT INTO `receipt_copy` VALUES ('34a250ed59004065b20b34ecfcda0ba4', 'LOIN201801220005', 'AAAAAA', 'aAAAA', 'AAAA', 'AA', '222', '2018-01-22 10:25:00', '琅东站', '2018-01-22 10:55:00', '张三', null, null, '李四', '2018-01-22 08:55:00', '2018-01-22 10:50:00', '王五', '2018-01-22 09:25:00', '2018-01-22 10:50:00', '赵六', '2018-01-22 10:40:00', '2018-01-22 11:55:00', '李七', '2018-01-22 11:15:00', '2018-01-22 11:55:00', null, '7', null, '2018-01-22 16:42:03');
INSERT INTO `receipt_copy` VALUES ('41147ff2debc4a0d8a0a6438412768ca', 'LOIN201712210005', '', 'asdasdf按时打发打发', null, '', null, '2017-12-21 08:15:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '5', '2017-12-21 19:11:28', '2017-12-21 19:11:28');
INSERT INTO `receipt_copy` VALUES ('44d919c1e1d4400990650aac960edc04', 'LOIN201801180001', '三方大供应链10楼', '2163136', null, '31361', '6131', '1899-12-31 18:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '4', '2018-01-18 18:53:45', '2018-01-18 18:53:45');
INSERT INTO `receipt_copy` VALUES ('5a42b1a9940848c3b79276b3a368b344', 'LOIN201712210001', '', 'asdfas阿斯顿发送到', null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '4', '2017-12-21 17:44:25', '2017-12-21 17:44:25');
INSERT INTO `receipt_copy` VALUES ('60de6ff8c5b741f4b2d323c034fff4f0', 'LOIN201712210004', '', 'asdfa阿萨德法师打发', '', '', null, '2017-12-21 22:20:18', '', null, '', null, null, '', null, null, 'dsfsdf', '2017-12-21 22:20:18', '2017-12-21 22:20:18', 'asdf', '2017-12-21 22:20:18', '2017-12-21 22:20:18', 'fsdf', '2017-12-21 22:20:18', '2017-12-21 22:20:18', null, '6', null, '2018-01-22 15:58:11');
INSERT INTO `receipt_copy` VALUES ('6204d8672b9a448fabc3cfd5b94126e1', 'LOIN201801180002', 'agegaew', 'gewgewgea', null, 'ewgewgewg', '10', '2017-12-21 08:15:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', '2018-01-18 18:54:31', '2018-01-18 18:54:31');
INSERT INTO `receipt_copy` VALUES ('797d1f874c344b8db5b63450deb28a2d', 'LOIN201801220006', '玉林骨科', '胫骨钉', '理贝尔', '套', '1', '2018-01-22 10:40:00', '琅东站', '2018-01-22 10:45:00', '水电费', null, null, '的开发', '2018-01-22 10:25:00', '2018-01-22 10:55:00', '', null, null, '', null, null, '', null, null, null, '3', null, '2018-01-22 18:08:46');
INSERT INTO `receipt_copy` VALUES ('8e91e41e2bc346b79bb2900a68dd1dd7', 'LOIN201712220002', '', '阿斯蒂芬的顶顶顶顶顶', null, '', null, '2017-12-22 20:15:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', '2017-12-22 11:11:08', '2017-12-22 11:11:08');
INSERT INTO `receipt_copy` VALUES ('a10a0f11a34f4e28aeccd9059b5d174a', 'LOIN2017-12-210003', '', 'asdfa按时打发打发', null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', '2017-12-21 16:43:59', '2017-12-21 16:43:59');
INSERT INTO `receipt_copy` VALUES ('b85505858a4b4028a632d7dca946f938', 'LOIN201801220003', 'ag阿斯蒂芬', 'asdf', 'asfd', '', null, '2018-01-22 09:45:00', '阿斯蒂芬', null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, null, '1', '2018-01-22 15:14:18', '2018-01-22 15:14:18');
INSERT INTO `receipt_copy` VALUES ('bc277e0ed42d45d19b51f6b588152165', 'LOIN201801230002', 'sdf', 'sfd', 'asdf', '', '2', '2018-01-23 11:30:00', 'asdf', null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, null, '1', '2018-01-23 18:50:19', '2018-01-23 18:50:19');
INSERT INTO `receipt_copy` VALUES ('da368d6099b841f38446067f834329b8', 'LOIN201801200001', 'AAAAA', 'aAAAAA', null, 'aAAAA', '333', '2017-12-27 04:10:00', 'AAAAA', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', null, '2018-01-20 16:35:21');
INSERT INTO `receipt_copy` VALUES ('f6f66005b5024d7fa386920d50815cea', 'LOIN201801220004', 'asdf', 'asdf', 'asdf', '', null, '2018-01-22 10:10:00', '', '2018-01-22 09:20:00', 'fdg', null, null, 'asdfasf', '2018-01-22 10:10:00', '2018-01-22 10:10:00', '', null, null, '', null, null, '', null, null, null, '3', null, '2018-01-22 15:56:16');
INSERT INTO `receipt_copy` VALUES ('f7bc3870a3c14b89a48e712fd230229d', 'LOIN201801200002', 'asdf', 'asdf', null, '个', '3', '2018-01-20 10:25:00', '阿斯蒂芬', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', null, '2018-01-20 16:31:05');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `role_desc` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT '1',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_name_unique` (`role_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('03578ed5e5bc499f966182ef95ef6f27', '采购数据验退', '收货验收退单、起止时间', '1', '2018-01-20 10:50:13', '2018-01-20 10:50:13');
INSERT INTO `role` VALUES ('0a8cac6ee1d346249a9e04aab263da29', '收货数据录入', '收货录入、收货验收单人员、起止时间', '1', '2017-12-22 09:08:10', '2018-01-20 10:36:56');
INSERT INTO `role` VALUES ('3008910e9eb8408aa1a97c3f6a842f0f', '仓储上架', '收货理货上架人员、起止时间', '1', '2017-12-22 09:15:24', '2018-01-20 10:38:18');
INSERT INTO `role` VALUES ('36f1dd1296674fc08484c5abf6a5806b', '系统管理员', '系统管理员', '1', '2016-12-07 08:53:57', '2017-05-11 13:59:03');
INSERT INTO `role` VALUES ('5058ba6d97414951b2cbfb5b3a93e7fc', '配送物流数据', '配送物流数据', '1', '2018-01-23 18:18:38', '2018-01-23 18:18:38');
INSERT INTO `role` VALUES ('54ad3227761d4405b8e901df399bcaa0', '调货数据', '调货数据', '1', '2018-01-25 18:02:04', '2018-01-25 18:02:04');
INSERT INTO `role` VALUES ('573bd19983c64ed8be6ad18d679207fb', '配送接货', '收货接货人员时间', '1', '2017-12-22 09:09:05', '2018-01-20 10:40:36');
INSERT INTO `role` VALUES ('754c8634319248ff94529c0227e287f2', '调货制单', '调货制单', '1', '2018-01-25 18:01:25', '2018-01-25 18:01:25');
INSERT INTO `role` VALUES ('78a26b20bf8a4c5da6f2a30f461513f6', '数据部数据', '配送数据部数据', '1', '2018-01-23 18:15:47', '2018-01-23 18:15:47');
INSERT INTO `role` VALUES ('9aac135161e14e87bf9410dfe1ee647b', '配送单据录入', '配送单据录入', '1', '2018-01-23 18:14:03', '2018-01-23 18:14:03');
INSERT INTO `role` VALUES ('a2092065ec2f4864b04058e85e8a4997', '调货配送', '调货配送', '1', '2018-01-25 18:02:42', '2018-01-25 18:02:42');
INSERT INTO `role` VALUES ('b0d6f4e853fa49d082cba3d336ecc015', '调货验货', '调货验货', '1', '2018-01-25 18:02:22', '2018-01-25 18:02:22');
INSERT INTO `role` VALUES ('b4622ba90fbf4ed58a10bb6d2c6e0b31', '调货接货', '调货接货', '1', '2018-01-25 18:01:40', '2018-01-25 18:01:40');
INSERT INTO `role` VALUES ('c4d34b511bff480aa28561cf8f59876f', '采购仓储验退', '收货验收退货人员、起止时间', '1', '2017-12-22 09:10:28', '2018-01-20 10:39:45');
INSERT INTO `role` VALUES ('cbe8356d64a8433cb5dad5c7fccf8dce', '普通管理员', '普通管理员', '1', '2016-12-07 13:21:21', '2017-05-05 12:58:38');
INSERT INTO `role` VALUES ('d43d3373695049f8adf7f21fd55241a7', '采购仓储验核', '收货验收复核人员、起止时间', '1', '2017-12-22 09:11:15', '2018-01-20 10:37:43');
INSERT INTO `role` VALUES ('ed99db1924df4056b40f3400ad4d3299', '仓储配货复核', '配送仓储配货复核', '1', '2018-01-23 18:16:36', '2018-01-23 18:16:36');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `menu_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`),
  KEY `role_menu_foreign` (`menu_id`) USING BTREE,
  CONSTRAINT `fk_ref_menu` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`),
  CONSTRAINT `fk_ref_role2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('cbe8356d64a8433cb5dad5c7fccf8dce', '00dc5c51e4824f49a30013385f680b0c');
INSERT INTO `role_menu` VALUES ('03578ed5e5bc499f966182ef95ef6f27', '10daa36798964fa3b2073ae8ee96c82e');
INSERT INTO `role_menu` VALUES ('0a8cac6ee1d346249a9e04aab263da29', '10daa36798964fa3b2073ae8ee96c82e');
INSERT INTO `role_menu` VALUES ('5058ba6d97414951b2cbfb5b3a93e7fc', '295d8f40824f4de082b558d08a9d211e');
INSERT INTO `role_menu` VALUES ('78a26b20bf8a4c5da6f2a30f461513f6', '295d8f40824f4de082b558d08a9d211e');
INSERT INTO `role_menu` VALUES ('9aac135161e14e87bf9410dfe1ee647b', '295d8f40824f4de082b558d08a9d211e');
INSERT INTO `role_menu` VALUES ('ed99db1924df4056b40f3400ad4d3299', '295d8f40824f4de082b558d08a9d211e');
INSERT INTO `role_menu` VALUES ('754c8634319248ff94529c0227e287f2', '41eb3150b1a147f88196ac6bca6e92c8');
INSERT INTO `role_menu` VALUES ('5058ba6d97414951b2cbfb5b3a93e7fc', '579502ee69d24523907e7c242f731db1');
INSERT INTO `role_menu` VALUES ('78a26b20bf8a4c5da6f2a30f461513f6', '579502ee69d24523907e7c242f731db1');
INSERT INTO `role_menu` VALUES ('9aac135161e14e87bf9410dfe1ee647b', '579502ee69d24523907e7c242f731db1');
INSERT INTO `role_menu` VALUES ('ed99db1924df4056b40f3400ad4d3299', '579502ee69d24523907e7c242f731db1');
INSERT INTO `role_menu` VALUES ('0a8cac6ee1d346249a9e04aab263da29', '6085fa446dc04b9e86272cb3c444af06');
INSERT INTO `role_menu` VALUES ('d43d3373695049f8adf7f21fd55241a7', '6085fa446dc04b9e86272cb3c444af06');
INSERT INTO `role_menu` VALUES ('0a8cac6ee1d346249a9e04aab263da29', '60f58b92f6f145de9346f98ac0ebf57d');
INSERT INTO `role_menu` VALUES ('03578ed5e5bc499f966182ef95ef6f27', '71e80d2e0763457580f5be1ce564a470');
INSERT INTO `role_menu` VALUES ('0a8cac6ee1d346249a9e04aab263da29', '71e80d2e0763457580f5be1ce564a470');
INSERT INTO `role_menu` VALUES ('3008910e9eb8408aa1a97c3f6a842f0f', '71e80d2e0763457580f5be1ce564a470');
INSERT INTO `role_menu` VALUES ('573bd19983c64ed8be6ad18d679207fb', '71e80d2e0763457580f5be1ce564a470');
INSERT INTO `role_menu` VALUES ('c4d34b511bff480aa28561cf8f59876f', '71e80d2e0763457580f5be1ce564a470');
INSERT INTO `role_menu` VALUES ('d43d3373695049f8adf7f21fd55241a7', '71e80d2e0763457580f5be1ce564a470');
INSERT INTO `role_menu` VALUES ('0a8cac6ee1d346249a9e04aab263da29', '73f4f7b679e8416580ae28850eacf2fb');
INSERT INTO `role_menu` VALUES ('3008910e9eb8408aa1a97c3f6a842f0f', '73f4f7b679e8416580ae28850eacf2fb');
INSERT INTO `role_menu` VALUES ('03578ed5e5bc499f966182ef95ef6f27', '74d4b8f33f2449fc91711a2207661c7a');
INSERT INTO `role_menu` VALUES ('0a8cac6ee1d346249a9e04aab263da29', '74d4b8f33f2449fc91711a2207661c7a');
INSERT INTO `role_menu` VALUES ('3008910e9eb8408aa1a97c3f6a842f0f', '74d4b8f33f2449fc91711a2207661c7a');
INSERT INTO `role_menu` VALUES ('573bd19983c64ed8be6ad18d679207fb', '74d4b8f33f2449fc91711a2207661c7a');
INSERT INTO `role_menu` VALUES ('c4d34b511bff480aa28561cf8f59876f', '74d4b8f33f2449fc91711a2207661c7a');
INSERT INTO `role_menu` VALUES ('d43d3373695049f8adf7f21fd55241a7', '74d4b8f33f2449fc91711a2207661c7a');
INSERT INTO `role_menu` VALUES ('03578ed5e5bc499f966182ef95ef6f27', '896c599a60584116ad901aa88930a393');
INSERT INTO `role_menu` VALUES ('0a8cac6ee1d346249a9e04aab263da29', '896c599a60584116ad901aa88930a393');
INSERT INTO `role_menu` VALUES ('3008910e9eb8408aa1a97c3f6a842f0f', '896c599a60584116ad901aa88930a393');
INSERT INTO `role_menu` VALUES ('573bd19983c64ed8be6ad18d679207fb', '896c599a60584116ad901aa88930a393');
INSERT INTO `role_menu` VALUES ('c4d34b511bff480aa28561cf8f59876f', '896c599a60584116ad901aa88930a393');
INSERT INTO `role_menu` VALUES ('d43d3373695049f8adf7f21fd55241a7', '896c599a60584116ad901aa88930a393');
INSERT INTO `role_menu` VALUES ('54ad3227761d4405b8e901df399bcaa0', '96f3f71736c04178a8431b85f8177471');
INSERT INTO `role_menu` VALUES ('754c8634319248ff94529c0227e287f2', '96f3f71736c04178a8431b85f8177471');
INSERT INTO `role_menu` VALUES ('a2092065ec2f4864b04058e85e8a4997', '96f3f71736c04178a8431b85f8177471');
INSERT INTO `role_menu` VALUES ('b0d6f4e853fa49d082cba3d336ecc015', '96f3f71736c04178a8431b85f8177471');
INSERT INTO `role_menu` VALUES ('b4622ba90fbf4ed58a10bb6d2c6e0b31', '96f3f71736c04178a8431b85f8177471');
INSERT INTO `role_menu` VALUES ('cbe8356d64a8433cb5dad5c7fccf8dce', '984909260a06410d9be37c300e3df09d');
INSERT INTO `role_menu` VALUES ('0a8cac6ee1d346249a9e04aab263da29', '99ce3da65c874972a497afa082de91d3');
INSERT INTO `role_menu` VALUES ('c4d34b511bff480aa28561cf8f59876f', '99ce3da65c874972a497afa082de91d3');
INSERT INTO `role_menu` VALUES ('5058ba6d97414951b2cbfb5b3a93e7fc', '9c80141f46684e77b91bb1eaf616c64c');
INSERT INTO `role_menu` VALUES ('78a26b20bf8a4c5da6f2a30f461513f6', '9c80141f46684e77b91bb1eaf616c64c');
INSERT INTO `role_menu` VALUES ('9aac135161e14e87bf9410dfe1ee647b', '9c80141f46684e77b91bb1eaf616c64c');
INSERT INTO `role_menu` VALUES ('ed99db1924df4056b40f3400ad4d3299', '9c80141f46684e77b91bb1eaf616c64c');
INSERT INTO `role_menu` VALUES ('0a8cac6ee1d346249a9e04aab263da29', 'b57e4acaf6ba4fb9833848d84026bca4');
INSERT INTO `role_menu` VALUES ('573bd19983c64ed8be6ad18d679207fb', 'b57e4acaf6ba4fb9833848d84026bca4');
INSERT INTO `role_menu` VALUES ('9aac135161e14e87bf9410dfe1ee647b', 'bb56e8331d034936ac861a256278b119');
INSERT INTO `role_menu` VALUES ('9aac135161e14e87bf9410dfe1ee647b', 'bbef15c25ad940998f46a4707a2596b3');
INSERT INTO `role_menu` VALUES ('0a8cac6ee1d346249a9e04aab263da29', 'c4ba872ba46c43cf8cfdc12135a7ef84');
INSERT INTO `role_menu` VALUES ('03578ed5e5bc499f966182ef95ef6f27', 'da86287f51074d68a904e594d53dec4b');
INSERT INTO `role_menu` VALUES ('0a8cac6ee1d346249a9e04aab263da29', 'da86287f51074d68a904e594d53dec4b');
INSERT INTO `role_menu` VALUES ('3008910e9eb8408aa1a97c3f6a842f0f', 'da86287f51074d68a904e594d53dec4b');
INSERT INTO `role_menu` VALUES ('5058ba6d97414951b2cbfb5b3a93e7fc', 'da86287f51074d68a904e594d53dec4b');
INSERT INTO `role_menu` VALUES ('54ad3227761d4405b8e901df399bcaa0', 'da86287f51074d68a904e594d53dec4b');
INSERT INTO `role_menu` VALUES ('573bd19983c64ed8be6ad18d679207fb', 'da86287f51074d68a904e594d53dec4b');
INSERT INTO `role_menu` VALUES ('754c8634319248ff94529c0227e287f2', 'da86287f51074d68a904e594d53dec4b');
INSERT INTO `role_menu` VALUES ('78a26b20bf8a4c5da6f2a30f461513f6', 'da86287f51074d68a904e594d53dec4b');
INSERT INTO `role_menu` VALUES ('9aac135161e14e87bf9410dfe1ee647b', 'da86287f51074d68a904e594d53dec4b');
INSERT INTO `role_menu` VALUES ('a2092065ec2f4864b04058e85e8a4997', 'da86287f51074d68a904e594d53dec4b');
INSERT INTO `role_menu` VALUES ('b0d6f4e853fa49d082cba3d336ecc015', 'da86287f51074d68a904e594d53dec4b');
INSERT INTO `role_menu` VALUES ('b4622ba90fbf4ed58a10bb6d2c6e0b31', 'da86287f51074d68a904e594d53dec4b');
INSERT INTO `role_menu` VALUES ('c4d34b511bff480aa28561cf8f59876f', 'da86287f51074d68a904e594d53dec4b');
INSERT INTO `role_menu` VALUES ('d43d3373695049f8adf7f21fd55241a7', 'da86287f51074d68a904e594d53dec4b');
INSERT INTO `role_menu` VALUES ('ed99db1924df4056b40f3400ad4d3299', 'da86287f51074d68a904e594d53dec4b');
INSERT INTO `role_menu` VALUES ('5058ba6d97414951b2cbfb5b3a93e7fc', 'e4250fda016e449fbbd32f4a319a7a8b');
INSERT INTO `role_menu` VALUES ('78a26b20bf8a4c5da6f2a30f461513f6', 'e4250fda016e449fbbd32f4a319a7a8b');
INSERT INTO `role_menu` VALUES ('9aac135161e14e87bf9410dfe1ee647b', 'e4250fda016e449fbbd32f4a319a7a8b');
INSERT INTO `role_menu` VALUES ('ed99db1924df4056b40f3400ad4d3299', 'e4250fda016e449fbbd32f4a319a7a8b');
INSERT INTO `role_menu` VALUES ('cbe8356d64a8433cb5dad5c7fccf8dce', 'e5f52fe2115e46229c60803e478d2e9a');
INSERT INTO `role_menu` VALUES ('cbe8356d64a8433cb5dad5c7fccf8dce', 'e85b2fb3e6ee4d0a9711c577bc842821');
INSERT INTO `role_menu` VALUES ('54ad3227761d4405b8e901df399bcaa0', 'f24c0f15824f43d5bdbe77e0c837cf5b');
INSERT INTO `role_menu` VALUES ('754c8634319248ff94529c0227e287f2', 'f24c0f15824f43d5bdbe77e0c837cf5b');
INSERT INTO `role_menu` VALUES ('a2092065ec2f4864b04058e85e8a4997', 'f24c0f15824f43d5bdbe77e0c837cf5b');
INSERT INTO `role_menu` VALUES ('b0d6f4e853fa49d082cba3d336ecc015', 'f24c0f15824f43d5bdbe77e0c837cf5b');
INSERT INTO `role_menu` VALUES ('b4622ba90fbf4ed58a10bb6d2c6e0b31', 'f24c0f15824f43d5bdbe77e0c837cf5b');
INSERT INTO `role_menu` VALUES ('754c8634319248ff94529c0227e287f2', 'f9988bccaef64a53a9917bb496a9b03f');
INSERT INTO `role_menu` VALUES ('54ad3227761d4405b8e901df399bcaa0', 'fa1929b2d2264461bfdad173a9fb3a4c');
INSERT INTO `role_menu` VALUES ('754c8634319248ff94529c0227e287f2', 'fa1929b2d2264461bfdad173a9fb3a4c');
INSERT INTO `role_menu` VALUES ('a2092065ec2f4864b04058e85e8a4997', 'fa1929b2d2264461bfdad173a9fb3a4c');
INSERT INTO `role_menu` VALUES ('b0d6f4e853fa49d082cba3d336ecc015', 'fa1929b2d2264461bfdad173a9fb3a4c');
INSERT INTO `role_menu` VALUES ('b4622ba90fbf4ed58a10bb6d2c6e0b31', 'fa1929b2d2264461bfdad173a9fb3a4c');

-- ----------------------------
-- Table structure for transfer_info
-- ----------------------------
DROP TABLE IF EXISTS `transfer_info`;
CREATE TABLE `transfer_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bizno` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '业务单号',
  `orderunit` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '订货单位',
  `ordertime` datetime DEFAULT NULL,
  `product_name` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `unit` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `manufacture` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '厂家',
  `transferunit` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '调货单位',
  `transferman` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '调货人',
  `transfer_time_begin` datetime DEFAULT NULL COMMENT '调货开始',
  `transfer_time_end` datetime DEFAULT NULL COMMENT '调货结束',
  `fetch_goods_man` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '拿货人',
  `fetch_goods_begin` datetime DEFAULT NULL COMMENT '拿货开始',
  `fetch_goods_end` datetime DEFAULT NULL,
  `data_man` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '采购数据人',
  `data_time_begin` datetime DEFAULT NULL,
  `data_time_end` datetime DEFAULT NULL,
  `check_man` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '复核',
  `check_time_begin` datetime DEFAULT NULL,
  `check_time_end` datetime DEFAULT NULL,
  `recheck_man` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `recheck_time_begin` datetime DEFAULT NULL,
  `recheck_time_end` datetime DEFAULT NULL,
  `pack_man` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pack_time_begin` datetime DEFAULT NULL,
  `pack_time_end` datetime DEFAULT NULL,
  `delivery_man` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `delivery_time_begin` datetime DEFAULT NULL,
  `delivery_time_end` datetime DEFAULT NULL,
  `receive_address` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `receive_time` datetime DEFAULT NULL,
  `receive_man` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `receive_end_time` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `remark` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `billno` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of transfer_info
-- ----------------------------
INSERT INTO `transfer_info` VALUES ('1', null, null, null, null, null, 'ege', null, null, null, null, null, null, null, null, null, null, null, null, ',', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `transfer_info` VALUES ('2', '843043073e044421ae643c13e8f3c4f6', '', 'gege', null, '', '', null, '', '', '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, null, null, null, null, null, null);
INSERT INTO `transfer_info` VALUES ('3', '94dcb4e9fd6145f492e71b70016c223c', 'aege', '', null, '', '', null, '', '', '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, null, null, null, null, null, null);
INSERT INTO `transfer_info` VALUES ('4', '517dbd7efe0d484486a9cc271092385c', '', 'gege', null, '', '', null, '', '', '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, null, null, null, null, null, null);
INSERT INTO `transfer_info` VALUES ('5', 'f2eb70289e1445e9b15f673f80e41b5b', '', '', '2018-02-08 09:21:15', '', '', null, '', '', '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, null, null, null, null, null, null);
INSERT INTO `transfer_info` VALUES ('6', 'f8083d6a92e040da93cf87d0f89ae116', '', '', '2018-02-08 12:45:22', '', '', null, '', '', '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, null, null, null, null, null, null);
INSERT INTO `transfer_info` VALUES ('7', '1a4d0240ac0c4266aa4cf675f9b4081f', 'agegege', 'gegegeg', '2018-02-08 12:54:54', 'agegege', 'gegege', '1', 'gegegege', 'gege', 'gege', null, null, 'gegeg', null, null, 'egeg', null, null, 'ge', null, null, 'ge', null, null, 'ge', null, null, 'agege', null, null, 'gegege', null, null, null, null, null, null, null, null);
INSERT INTO `transfer_info` VALUES ('8', '82c3b32f2af449be997cc50e600461da', '', '', null, '', '', null, '', '', '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, '', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for user_emp
-- ----------------------------
DROP TABLE IF EXISTS `user_emp`;
CREATE TABLE `user_emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '登录用户的ID',
  `emp_id` int(11) DEFAULT NULL COMMENT '员工ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_emp
-- ----------------------------
INSERT INTO `user_emp` VALUES ('1', '016465786de84f4b86df6a53ef17d5dd', '1');
INSERT INTO `user_emp` VALUES ('2', '1b3542a5949c49acb2d95761b8d99207', '2');
INSERT INTO `user_emp` VALUES ('3', 'd730fede8d6142ab8576b9b14cf8a934', '4');
