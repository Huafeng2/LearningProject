/*
Navicat MySQL Data Transfer

Source Server         : LOCALHOST
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : mrbbs

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-08-20 14:39:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `base_userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `base_userinfo`;
CREATE TABLE `base_userinfo` (
  `base_id` varchar(64) NOT NULL,
  `base_name` varchar(10) DEFAULT NULL,
  `base_sex` char(10) DEFAULT NULL,
  `base_age` int(11) DEFAULT NULL,
  `base_fatieshu` int(11) DEFAULT NULL,
  `base_huitieshu` int(11) DEFAULT NULL,
  `base_photo` varchar(255) DEFAULT NULL,
  `base_shenfenzheng` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`base_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_userinfo
-- ----------------------------
INSERT INTO `base_userinfo` VALUES ('1', '小明明', '男', '18', '15', '65', null, '220105198888882011', 'admin1');

-- ----------------------------
-- Table structure for `forum_banzhu`
-- ----------------------------
DROP TABLE IF EXISTS `forum_banzhu`;
CREATE TABLE `forum_banzhu` (
  `banzhu_id` int(11) NOT NULL AUTO_INCREMENT,
  `main_type` varchar(64) NOT NULL,
  `username` varchar(20) NOT NULL,
  `creatime` datetime NOT NULL,
  `creatuser` varchar(64) NOT NULL,
  PRIMARY KEY (`banzhu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='版主版块对照表';

-- ----------------------------
-- Records of forum_banzhu
-- ----------------------------
INSERT INTO `forum_banzhu` VALUES ('1', 'javase', 'admin1', '2016-07-05 00:00:00', 'admin1');

-- ----------------------------
-- Table structure for `forum_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `forum_dictionary`;
CREATE TABLE `forum_dictionary` (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_group` varchar(45) DEFAULT NULL,
  `dict_key` varchar(45) DEFAULT NULL,
  `dict_value` varchar(45) DEFAULT NULL,
  `dict_parent` varchar(64) DEFAULT NULL,
  `dict_order` int(11) DEFAULT NULL,
  `dict_isleaf` char(1) DEFAULT NULL,
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_dictionary
-- ----------------------------
INSERT INTO `forum_dictionary` VALUES ('1', 'dict', '0', '数据字典', '0', '0', null);
INSERT INTO `forum_dictionary` VALUES ('2', 'forumType', 'forumType', '论坛主版块', '1', '1', 'n');
INSERT INTO `forum_dictionary` VALUES ('3', 'forumType', 'forumJava', 'Java专区', '2', '2', 'n');
INSERT INTO `forum_dictionary` VALUES ('4', 'forumType', 'forumDB', '数据库专区', '2', '3', 'n');
INSERT INTO `forum_dictionary` VALUES ('5', 'java', 'javase', 'Java SE 专区版块', '3', '4', 'y');
INSERT INTO `forum_dictionary` VALUES ('6', 'database', 'mysql', 'MySQL', '4', '5', 'y');
INSERT INTO `forum_dictionary` VALUES ('7', 'java', 'javaee', 'PHP 专区版块', '3', '6', 'y');
INSERT INTO `forum_dictionary` VALUES ('8', 'java', 'javakj', '.Net 专区版块', '3', '7', 'y');
INSERT INTO `forum_dictionary` VALUES ('9', 'java', 'javaxj', 'Java新技术', '3', '8', 'y');
INSERT INTO `forum_dictionary` VALUES ('10', 'fenlei', 'default', '默认', '0', '1', 'y');
INSERT INTO `forum_dictionary` VALUES ('11', 'fenlei', 'xinjishu', '新技术', '0', '2', 'y');
INSERT INTO `forum_dictionary` VALUES ('12', 'fenlei', 'xinqingtucao', '心情吐槽', '0', '3', 'y');
INSERT INTO `forum_dictionary` VALUES ('13', 'feilei', 'jishujianjie', '趋势分析', '0', '4', 'y');
INSERT INTO `forum_dictionary` VALUES ('14', 'fenlei', 'jishutuijian', '技术推荐', '0', '5', 'y');

-- ----------------------------
-- Table structure for `forum_info`
-- ----------------------------
DROP TABLE IF EXISTS `forum_info`;
CREATE TABLE `forum_info` (
  `info_id` int(11) NOT NULL AUTO_INCREMENT,
  `info_reply` int(11) NOT NULL,
  `info_see` int(11) NOT NULL,
  `info_lastuser` varchar(20) NOT NULL,
  `info_lastime` datetime NOT NULL,
  `main_id` varchar(64) NOT NULL,
  PRIMARY KEY (`info_id`),
  KEY `info_main_id_idx` (`main_id`),
  CONSTRAINT `info_main_id` FOREIGN KEY (`main_id`) REFERENCES `forum_main` (`main_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='记录帖子的一些常用状态.';

-- ----------------------------
-- Records of forum_info
-- ----------------------------
INSERT INTO `forum_info` VALUES ('1', '18', '1800', '于国良', '2016-08-01 09:23:44', 'tes0t');
INSERT INTO `forum_info` VALUES ('2', '0', '0', 'admin1', '2016-07-28 16:30:32', '12ssss');
INSERT INTO `forum_info` VALUES ('3', '0', '0', '于国良', '2016-07-29 13:44:16', '411f0b59-c0d3-4f6e-a002-6054800fbe54');
INSERT INTO `forum_info` VALUES ('4', '2', '0', '于国良', '2016-08-01 09:33:43', '88139580-2c69-4705-88cc-375aab0e50ba');
INSERT INTO `forum_info` VALUES ('5', '0', '0', '于国良', '2016-07-29 13:50:51', 'af161b40-ffa0-4995-b137-38a0b4d864f6');
INSERT INTO `forum_info` VALUES ('6', '0', '0', '于国良', '2016-08-01 09:45:06', '5348304d-363c-4979-aed9-d64d6e224bf2');
INSERT INTO `forum_info` VALUES ('7', '0', '0', '于国良', '2016-08-01 09:48:51', '1503b5d3-e077-426a-bb32-a72895c2b4a7');
INSERT INTO `forum_info` VALUES ('8', '0', '0', '于国良', '2016-08-01 09:48:57', '381b0555-4733-4630-bdbf-4d348ce692c8');
INSERT INTO `forum_info` VALUES ('9', '0', '0', '于国良', '2016-08-01 09:49:05', 'ffc895a6-d1b5-4f02-8ce5-a7b49f0d0e7f');
INSERT INTO `forum_info` VALUES ('10', '0', '0', '于国良', '2016-08-01 09:49:12', '10c56f09-49b4-4fc1-9f36-8e3392743355');
INSERT INTO `forum_info` VALUES ('11', '0', '0', '于国良', '2016-08-01 09:49:17', '22081b0a-1d2e-4193-883b-adfb026a6a54');
INSERT INTO `forum_info` VALUES ('12', '0', '0', '于国良', '2016-08-01 09:49:44', 'ad21925a-4ca9-4b42-b74e-40be4d289731');
INSERT INTO `forum_info` VALUES ('13', '0', '0', '于国良', '2016-08-01 09:49:49', 'dda1a45e-e5fb-4be8-babb-884d519a5036');
INSERT INTO `forum_info` VALUES ('14', '0', '0', '于国良', '2016-08-01 09:49:54', 'c800976b-4be9-490e-be1e-9196e5b6f40c');
INSERT INTO `forum_info` VALUES ('15', '0', '0', '于国良', '2016-08-01 09:49:59', '7e382ebb-60e7-45c8-8ba8-9ac0d22fd970');
INSERT INTO `forum_info` VALUES ('16', '0', '0', '于国良', '2016-08-01 09:50:06', '282018a5-c4dd-406c-b23d-822438de6b69');
INSERT INTO `forum_info` VALUES ('17', '0', '0', '于国良', '2016-08-01 09:50:11', 'e3aed7e7-2cbf-4b18-9512-5941ac6fbea9');
INSERT INTO `forum_info` VALUES ('18', '0', '0', '于国良', '2016-08-01 09:55:08', 'c98e1069-3925-42f3-adb6-e972ff002143');
INSERT INTO `forum_info` VALUES ('19', '0', '0', '于国良', '2016-08-01 09:55:17', '5b8e6912-4c09-41f0-a925-bac90705ab2e');
INSERT INTO `forum_info` VALUES ('20', '0', '0', '于国良', '2016-08-01 09:55:29', '24db7769-91c8-4cf2-8ca6-4a082dfdcfdf');
INSERT INTO `forum_info` VALUES ('21', '1', '0', '请叫我大王', '2016-08-01 14:33:55', 'a5f5fa9c-bc83-43f6-9f86-14ec9244e624');
INSERT INTO `forum_info` VALUES ('22', '0', '0', '于国良', '2016-08-01 11:45:03', '5d922927-289d-4e2c-9f40-10eedeeb61eb');
INSERT INTO `forum_info` VALUES ('23', '0', '0', '于国良', '2016-08-01 11:47:51', '4e0aa497-1e6e-4e73-94e3-1ee99749ad85');
INSERT INTO `forum_info` VALUES ('24', '1', '0', '111111', '2016-08-08 14:51:56', '8cd6d48e-2b43-4ec7-b7f1-3fec7fb19b7c');
INSERT INTO `forum_info` VALUES ('25', '0', '0', '于国良', '2016-08-08 15:33:21', '63498240-6d46-4365-8508-1eae17444567');
INSERT INTO `forum_info` VALUES ('26', '0', '0', '于国良', '2016-08-19 14:25:08', '38182220-a8a8-4cf0-af22-2667c702b64e');
INSERT INTO `forum_info` VALUES ('27', '0', '0', '于国良', '2016-08-19 14:28:38', 'a9e85e79-d547-46b6-92cc-d80211490211');

-- ----------------------------
-- Table structure for `forum_main`
-- ----------------------------
DROP TABLE IF EXISTS `forum_main`;
CREATE TABLE `forum_main` (
  `main_id` varchar(64) NOT NULL,
  `main_title` varchar(80) NOT NULL,
  `main_flag` varchar(64) NOT NULL COMMENT 'main_flag  这是一个标记,记录用户发布在哪个论坛区.',
  `main_type` varchar(64) NOT NULL COMMENT 'main_type 记录用户发表在论坛区的哪个栏目下',
  `main_content` text NOT NULL COMMENT '内容',
  `main_creatime` datetime NOT NULL COMMENT '创建时间',
  `main_creatuser` varchar(64) NOT NULL,
  `main_recommend` int(11) NOT NULL COMMENT '精华帖,int类型,精华帖分类型.',
  `main_delete` char(1) NOT NULL COMMENT '是不是被删除的帖子.删除的帖子为y,正常为n',
  `main_nickname` varchar(20) DEFAULT NULL,
  `main_zan` int(11) DEFAULT NULL,
  PRIMARY KEY (`main_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='论坛主表';

-- ----------------------------
-- Records of forum_main
-- ----------------------------
INSERT INTO `forum_main` VALUES ('10c56f09-49b4-4fc1-9f36-8e3392743355', 'eeeeeeeeeeeeeee', 'xinqingtucao', 'javase', '<p>eeeeeeeeeeeeeeeeeee<br/></p>', '2016-08-01 09:49:12', 'admin1', '5', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('12ssss', 'ssssssss', 'ssssss', 'sssssss', 'sssssssssssssssssss', '2016-07-28 15:58:34', 'dd', '5', 'n', 'sss', '0');
INSERT INTO `forum_main` VALUES ('1503b5d3-e077-426a-bb32-a72895c2b4a7', 'eeeeeeeeeeeeeeeeeee', 'xinjishu', 'javase', '<p>eeeeeeeeeeeeeeeeee<br/></p>', '2016-08-01 09:48:51', 'admin1', '5', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('22081b0a-1d2e-4193-883b-adfb026a6a54', 'eeeeeeeeeeee', 'xinqingtucao', 'javase', '<p>eeeeeeeeeeeeeeeeeeeeeee<br/></p>', '2016-08-01 09:49:17', 'admin1', '5', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('24db7769-91c8-4cf2-8ca6-4a082dfdcfdf', 'ddddcccccccccc', 'default', 'javase', '<p>cccccccccccccccccccccccccccccccccccccccccccccccccccccc<br/></p>', '2016-08-01 09:55:29', 'admin1', '5', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('282018a5-c4dd-406c-b23d-822438de6b69', 'ffffffffff', 'default', 'javase', '<p>ffffffffffff<br/></p>', '2016-08-01 09:50:06', 'admin1', '5', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('38182220-a8a8-4cf0-af22-2667c702b64e', '测试论坛123456', 'default', 'javaxj', '<pre class=\"brush:java;toolbar:false\">&lt;div&nbsp;class=&quot;container-fluid&quot;&gt;\r\n	&lt;div&nbsp;id=&quot;carousel-example-generic&quot;&nbsp;class=&quot;carousel&nbsp;slide&quot;&nbsp;data-ride=&quot;carousel&quot;&gt;\r\n	&nbsp;&nbsp;\r\n	&lt;/div&gt;\r\n&lt;/div&gt;</pre><pre class=\"brush:jfx;toolbar:false\">@RequestMapping(value=&quot;/updateRole&quot;,method=RequestMethod.POST)\r\n	@ResponseBody\r\n	public&nbsp;Map&lt;String,Boolean&gt;&nbsp;updateRole&nbsp;(Integer&nbsp;roleId,Integer&nbsp;loginId,String&nbsp;username){\r\n		Map&lt;String,Boolean&gt;&nbsp;resultMap&nbsp;=&nbsp;new&nbsp;HashMap&lt;&gt;();\r\n		\r\n		Map&lt;String,Object&gt;&nbsp;parm&nbsp;=&nbsp;new&nbsp;HashMap&lt;&gt;();\r\n		parm.put(&quot;roleId&quot;,&nbsp;roleId);\r\n		parm.put(&quot;loginId&quot;,&nbsp;loginId);\r\n		parm.put(&quot;username&quot;,&nbsp;username);\r\n		if&nbsp;(userloginService.updateSys_login_roleSelective(parm)==1){\r\n			resultMap.put(&quot;success&quot;,&nbsp;true);\r\n		}else{\r\n			resultMap.put(&quot;success&quot;,&nbsp;false);\r\n		};\r\n		\r\n		return&nbsp;resultMap;\r\n	}</pre><p><br/></p>', '2016-08-19 14:25:08', 'admin1', '1', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('381b0555-4733-4630-bdbf-4d348ce692c8', 'eeeeeeeeeeeeee', 'xinqingtucao', 'javase', '<p>eeeeeeeeeeeeeeeeeeee<br/></p>', '2016-08-01 09:48:57', 'admin1', '5', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('411f0b59-c0d3-4f6e-a002-6054800fbe54', 'sssss', 'default', 'javase', '<p><br/>ssssssssssssssssss</p>', '2016-07-29 13:44:13', 'admin1', '5', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('4e0aa497-1e6e-4e73-94e3-1ee99749ad85', '欢迎光临Java Framework专区版块', 'xinjishu', 'javakj', '<p>&nbsp;&nbsp;&nbsp;&nbsp;欢迎<br/></p>', '2016-08-01 11:47:51', 'admin1', '1', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('5348304d-363c-4979-aed9-d64d6e224bf2', 'sssssssssssssssss', 'default', 'javase', '<p>ssssssssssssssssssssssssssssss<br/></p>', '2016-08-01 09:45:06', 'admin1', '5', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('5b8e6912-4c09-41f0-a925-bac90705ab2e', 'ddddddddddddd', 'default', 'javase', '<p>ddccccccccccccccccccccc<br/></p>', '2016-08-01 09:55:17', 'admin1', '1', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('5d922927-289d-4e2c-9f40-10eedeeb61eb', '欢迎光临Java EE 版块专区', 'xinjishu', 'javaee', '<p>&nbsp;&nbsp;&nbsp;&nbsp;欢迎.<br/></p>', '2016-08-01 11:45:03', 'admin1', '1', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('63498240-6d46-4365-8508-1eae17444567', '', 'default', 'javaxj', '<pre class=\"brush:java;toolbar:false\">dafdsafasd&nbsp;a&nbsp;a&nbsp;dasfdas</pre><p>dasfdas afdasfd afdasfad f</p><pre class=\"brush:html;toolbar:false\">dasfdasfdas&nbsp;fasdfs</pre><p><img src=\"http://img.baidu.com/hi/jx2/j_0027.gif\"/></p>', '2016-08-08 15:33:21', 'admin1', '5', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('7e382ebb-60e7-45c8-8ba8-9ac0d22fd970', 'fffffffffffffffffffffffffff', 'default', 'javase', '<p>ddddddddddddddddddddddddddddd<br/></p>', '2016-08-01 09:49:59', 'admin1', '5', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('88139580-2c69-4705-88cc-375aab0e50ba', 'sssssssssssssss', 'default', 'javase', '<p>sdjkl jsklj sklsj skl;j s;ljkd jhdj <br/></p><p>d&#39;d jdl jdd</p><p>&#39;djljd d;k</p><p>&#39;d&#39;lkdljd djkdjd</p><p>&#39;d dkd jkwj kljq qjk qkjq qk jqkq jqk qjk jwk k</p><p>&#39;d jkdj dkj d;d jjdk djdjd &#39;</p><p>q&#39; <br/></p><p>qjk jkq jk&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;jkl; j&#39;w j</p><p>ws <br/></p><p>sjl <br/></p><p>sjl <br/></p><p>s;j s</p><p>sjl <br/></p><p>;sjl <br/></p><p>;sjl <br/></p><p>sjl <br/></p><p>sjl <br/></p><p>;sj shjs hws</p><p>[ws <br/></p><p>&#39; wsjklws hkws hwj ;wjw<br/></p>', '2016-07-29 13:48:49', 'admin1', '5', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('8cd6d48e-2b43-4ec7-b7f1-3fec7fb19b7c', '080480180810', 'xinjishu', 'javase', '<p>441441414<br/></p>', '2016-08-01 14:25:21', 'aa789456', '1', 'n', 'aa123456', '0');
INSERT INTO `forum_main` VALUES ('a5f5fa9c-bc83-43f6-9f86-14ec9244e624', 'dcada', 'default', 'javase', '<p>sssssssssssssssssssssssssssssssssssxxxxxxxxxxxxxxxxxxxvvvvvvvvzzz<br/></p>', '2016-08-01 09:55:44', 'admin1', '5', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('a9e85e79-d547-46b6-92cc-d80211490211', '信息惺惺惜惺惺', 'xinjishu', 'javase', '<p>常常常常常常常常常常</p>', '2016-08-19 14:28:38', 'admin1', '5', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('ad21925a-4ca9-4b42-b74e-40be4d289731', 'fffffffffffffffff', 'jishutuijian', 'javase', '<p>ffffffffffffffffffffffffffffffffffffffffffffffffffffff<br/></p>', '2016-08-01 09:49:44', 'admin1', '5', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('af161b40-ffa0-4995-b137-38a0b4d864f6', 'ssssss', 'default', 'javase', '<p>sssssssssssss<br/></p>', '2016-07-29 13:50:51', 'admin1', '5', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('c800976b-4be9-490e-be1e-9196e5b6f40c', 'fffffffffffffffffffff', 'default', 'javase', '<p>fvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv<br/></p>', '2016-08-01 09:49:54', 'admin1', '5', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('c98e1069-3925-42f3-adb6-e972ff002143', 'ddddddd', 'default', 'javase', '<p>dddddddddddddddd<br/></p>', '2016-08-01 09:55:08', 'admin1', '1', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('dda1a45e-e5fb-4be8-babb-884d519a5036', 'fffffffffffffffff', 'default', 'javase', '<p>fffffffffffffffffffffffffffffffffffffff<br/></p>', '2016-08-01 09:49:49', 'admin1', '5', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('e3aed7e7-2cbf-4b18-9512-5941ac6fbea9', 'fffffffffffffffffff', 'default', 'javase', '<p>ffffffffffffffffffffff<br/></p>', '2016-08-01 09:50:11', 'admin1', '5', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('ffc895a6-d1b5-4f02-8ce5-a7b49f0d0e7f', 'eeeeeeeeeeeeeeeeeeee', 'xinqingtucao', 'javase', '<p>eeeeeeeeeeeeeeeeeeeeeeeeeeeeee<br/></p>', '2016-08-01 09:49:05', 'admin1', '5', 'n', '于国良', '0');
INSERT INTO `forum_main` VALUES ('tes0t', 'Java 8 核心技术简述', 'admin', 'javase', 'fffff156156666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666516516516<br><br><br><br><br>565165', '2016-07-25 14:02:39', 'admin1', '1', 'n', 'ddddd', '12');

-- ----------------------------
-- Table structure for `forum_minfo`
-- ----------------------------
DROP TABLE IF EXISTS `forum_minfo`;
CREATE TABLE `forum_minfo` (
  `minfo_id` int(11) NOT NULL AUTO_INCREMENT,
  `main_type` varchar(64) NOT NULL,
  `minfo_reply` int(11) DEFAULT '0',
  `minfo_banzhu` varchar(64) DEFAULT NULL,
  `minfo_creatime` datetime DEFAULT NULL,
  `minfo_creatuser` varchar(64) DEFAULT NULL,
  `minfo_order` int(11) DEFAULT '5',
  `minfo_see` int(11) DEFAULT '0',
  `minfo_photo` varchar(255) DEFAULT NULL COMMENT '版块标志图片',
  `minfo_title` varchar(80) DEFAULT NULL,
  `minfo_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`minfo_id`),
  UNIQUE KEY `main_type_UNIQUE` (`main_type`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='主表信息';

-- ----------------------------
-- Records of forum_minfo
-- ----------------------------
INSERT INTO `forum_minfo` VALUES ('1', 'javase', '23', 'javasebz', '2016-07-26 10:19:56', 'dd', '1', '467', '', 'Java SE 专区版块', '27');
INSERT INTO `forum_minfo` VALUES ('2', 'javaee', '0', 'javaeebz', '2016-08-01 11:42:50', 'admin1', '5', '7', null, 'Java EE 专区版块', '1');
INSERT INTO `forum_minfo` VALUES ('3', 'javakj', '0', 'javakjbz', '2016-08-01 11:45:48', 'admin1', '5', '5', null, 'Java Framework 专区版块', '1');
INSERT INTO `forum_minfo` VALUES ('4', 'javaxj', '0', 'javaxjbz', '2016-08-01 13:28:33', 'admin1', '5', '12', null, 'Java 新技术推荐', '2');

-- ----------------------------
-- Table structure for `forum_second`
-- ----------------------------
DROP TABLE IF EXISTS `forum_second`;
CREATE TABLE `forum_second` (
  `sec_id` varchar(64) NOT NULL,
  `main_id` varchar(64) NOT NULL,
  `sec_sequence` int(11) NOT NULL,
  `sec_content` text NOT NULL,
  `sec_creatuser` varchar(20) NOT NULL,
  `sec_creatime` datetime NOT NULL,
  `sec_nickname` varchar(20) NOT NULL,
  `sec_resequence` int(11) NOT NULL COMMENT '回复多少楼,默认回复主贴0,如果该值大于0那么会生成一个索引',
  `sec_delete` char(1) NOT NULL COMMENT '是否删除默认n未删除,删除是y,如果该值是y那么显示该楼层已被删除',
  `sec_reid` varchar(64) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sec_id`),
  KEY `sec_main_id_idx` (`main_id`),
  CONSTRAINT `sec_main_id` FOREIGN KEY (`main_id`) REFERENCES `forum_main` (`main_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_second
-- ----------------------------
INSERT INTO `forum_second` VALUES ('03d59969-a02c-4a45-b7d8-bc6a4820ff2b', 'tes0t', '15', '<p>ddddddddddddddddddccccccccccccccvvvvvvvvvvvvvv<br/></p>', 'admin1', '2016-08-01 09:18:36', '于国良', '0', 'n', 'tes0t', 'admin1');
INSERT INTO `forum_second` VALUES ('1', 'tes0t', '1', 'ddddddddd', 'admin1', '2016-07-27 11:28:33', '于国良', '0', 'n', '0', 'admin1');
INSERT INTO `forum_second` VALUES ('2', 'tes0t', '2', 'sss', 'admin1', '2016-07-27 13:06:58', 'ddddd', '0', 'n', '0', 'admin1');
INSERT INTO `forum_second` VALUES ('240bc1e2-c86e-465b-8264-7bbf19d4ec0e', 'tes0t', '6', '<p>sssssssss456456465<br/></p>', 'admin1', '2016-08-01 09:12:47', '于国良', '0', 'n', 'tes0t', 'admin1');
INSERT INTO `forum_second` VALUES ('247867dd-980b-427b-ae1e-bd18c9a0571b', 'tes0t', '13', '<p>dddddddddddddddddddddddqqqqqqqqqqaaaaaaaaaaaaaaaaa<br/></p>', 'admin1', '2016-08-01 09:18:20', '于国良', '0', 'n', 'tes0t', 'admin1');
INSERT INTO `forum_second` VALUES ('3', 'tes0t', '3', 'ddd', 'admin1', '2016-07-29 18:34:26', '于国良', '0', 'n', '0', 'admin1');
INSERT INTO `forum_second` VALUES ('324f5b41-1ad0-49cb-b4e8-725a81d8f9ee', 'tes0t', '8', '<p>ssssssssssssssssssssssssssssssssssssssssssssss<br/></p>', 'admin1', '2016-08-01 09:17:47', '于国良', '0', 'n', 'tes0t', 'admin1');
INSERT INTO `forum_second` VALUES ('394d8674-166a-47b0-9fe9-963b3a9162f9', '8cd6d48e-2b43-4ec7-b7f1-3fec7fb19b7c', '0', '<p>&lt;script&gt;alert(1);&lt;/script&gt;</p>', '111111', '2016-08-08 14:51:56', '111111', '0', 'n', '8cd6d48e-2b43-4ec7-b7f1-3fec7fb19b7c', '111111');
INSERT INTO `forum_second` VALUES ('40b1c778-d6ce-4230-a57d-f2e8794e7b25', 'tes0t', '7', '<p>445564564105615615616515615616515<br/></p>', 'admin1', '2016-08-01 09:17:31', '于国良', '0', 'n', 'tes0t', 'admin1');
INSERT INTO `forum_second` VALUES ('46fba5aa-ba93-400e-bf5a-8e80fe18ee78', 'tes0t', '9', '<p>ssssssssssssssssssssssssssssssssssssssssss<br/></p>', 'admin1', '2016-08-01 09:17:53', '于国良', '0', 'n', 'tes0t', 'admin1');
INSERT INTO `forum_second` VALUES ('49743c12-7627-45b6-a585-f6485ce354e7', 'tes0t', '4', '<p>wsssssssssssssssswwwq<br/></p>', 'admin1', '2016-08-01 08:54:43', '于国良', '503', 'n', 'tes0t', 'admin1');
INSERT INTO `forum_second` VALUES ('66a633dd-e8ee-4117-92a1-1aacffe7381d', 'tes0t', '5', '<p>sssssssssssssssss<br/></p>', 'admin1', '2016-08-01 08:50:00', '于国良', '502', 'n', 'tes0t', 'admin1');
INSERT INTO `forum_second` VALUES ('67808d48-b19e-41be-aa44-4aaac6318321', 'tes0t', '16', '<p>wwwwwwwwwwwwwwwwwwwwwwsss<br/></p>', 'admin1', '2016-08-01 09:23:16', '于国良', '0', 'n', 'tes0t', 'admin1');
INSERT INTO `forum_second` VALUES ('69d23042-e04a-494d-ad3e-51fde9863fcf', 'tes0t', '10', '<p>ddddddddddddddddddddddddddddddddddddddddddd<br/></p>', 'admin1', '2016-08-01 09:17:59', '于国良', '0', 'n', 'tes0t', 'admin1');
INSERT INTO `forum_second` VALUES ('8d53251c-759c-449b-8880-78c359a93150', 'tes0t', '11', '<p>cxssvdsaxcsads<br/></p>', 'admin1', '2016-08-01 09:18:06', '于国良', '0', 'n', 'tes0t', 'admin1');
INSERT INTO `forum_second` VALUES ('956927a6-2c51-4694-98ad-f75c200ce412', 'tes0t', '14', '<p>ddddddddddddddddddddddccccccccccccccc<br/></p>', 'admin1', '2016-08-01 09:18:28', '于国良', '0', 'n', 'tes0t', 'admin1');
INSERT INTO `forum_second` VALUES ('a582ddf8-653c-472d-ad5c-80dec65e7cea', '88139580-2c69-4705-88cc-375aab0e50ba', '0', '<p>sssssssssssssssssssssssssssss<br/></p>', 'admin1', '2016-08-01 09:33:39', '于国良', '0', 'n', '88139580-2c69-4705-88cc-375aab0e50ba', 'admin1');
INSERT INTO `forum_second` VALUES ('ba3b7e44-aaa4-41fd-b894-6c40856598e6', 'tes0t', '12', '<p>ddddddddddddddddddddccccccccccccccccccccccc<br/></p>', 'admin1', '2016-08-01 09:18:13', '于国良', '0', 'n', 'tes0t', 'admin1');
INSERT INTO `forum_second` VALUES ('c5fcfc4e-99df-4d4f-828d-65f48ce576c0', 'a5f5fa9c-bc83-43f6-9f86-14ec9244e624', '0', '<p>我们回复吗？我是谁呦，怎么看见了取消精华帖功能？？</p>', '请叫我大王', '2016-08-01 14:33:55', '请叫我大王', '0', 'n', 'a5f5fa9c-bc83-43f6-9f86-14ec9244e624', '请叫我大王');
INSERT INTO `forum_second` VALUES ('cfbf9350-55c3-4e72-8ffe-ff9325ac1c36', 'tes0t', '17', '<p>eeeeeeeeeeeeeeeeeeeee<br/></p>', 'admin1', '2016-08-01 09:23:44', '于国良', '0', 'n', 'tes0t', 'admin1');
INSERT INTO `forum_second` VALUES ('e5e834bd-c876-4595-817f-9a3413ab2b21', 'tes0t', '5', '<p>15156156165165165165165<br/></p>', 'admin1', '2016-08-01 09:12:00', '于国良', '0', 'n', 'tes0t', 'admin1');
INSERT INTO `forum_second` VALUES ('e8e81e66-b556-41c4-b402-994e6799c94b', '88139580-2c69-4705-88cc-375aab0e50ba', '1', '<p>ddddddddddcccccccccccc<br/></p>', 'admin1', '2016-08-01 09:33:43', '于国良', '0', 'n', '88139580-2c69-4705-88cc-375aab0e50ba', 'admin1');

-- ----------------------------
-- Table structure for `sys_login`
-- ----------------------------
DROP TABLE IF EXISTS `sys_login`;
CREATE TABLE `sys_login` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(64) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `wxname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`login_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='登录信息表';

-- ----------------------------
-- Records of sys_login
-- ----------------------------
INSERT INTO `sys_login` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '1', '于国良');
INSERT INTO `sys_login` VALUES ('4', 'admin1', '21232f297a57a5a743894a0e4a801fc3', null, '于国良');
INSERT INTO `sys_login` VALUES ('5', 'admin2', '21232f297a57a5a743894a0e4a801fc3', null, '于国良');
INSERT INTO `sys_login` VALUES ('6', 'admin3', '21232f297a57a5a743894a0e4a801fc3', null, '于国良');
INSERT INTO `sys_login` VALUES ('9', 'wowowowo1', 'wowowowo1', 'ww.d.com', '于国良');
INSERT INTO `sys_login` VALUES ('10', 'admin1111111111111', 'a4cd5336c221f502d58db914176803de', '80303857@qq.com', '于国良');
INSERT INTO `sys_login` VALUES ('11', 'admin123456', '4aa40bbb89a90e0596efe94492bb75d9', '80303857@qq.com', '于国良');
INSERT INTO `sys_login` VALUES ('12', 'eeeeeeeeeeeeeeeeeee', 'fa979dc5558ca5c885015a28cde96934', 'eee@qq.com', '于国良');
INSERT INTO `sys_login` VALUES ('13', 'ssssssssssssssss', '16fcb1091f8a0cc70c96e2ff97fdd213', 'ssssssss@qq.com', '于国良');
INSERT INTO `sys_login` VALUES ('14', 'dd4d54d64d56', 'aa104ca5cac492b9590eadc61434c96f', '80303857@qq.com', '于国良');
INSERT INTO `sys_login` VALUES ('15', 'ddxxccc111', '6161ca39d753103c23c785ad98be1b4d', 'dd@qq.com', '于国良');
INSERT INTO `sys_login` VALUES ('16', 'ddddd3333', '54ee1aad7dacbd6f09600edc582061c0', '80303857@qq.com', '于国良');
INSERT INTO `sys_login` VALUES ('17', '444eee', 'cd87cd5ef753a06ee79fc75dc7cfe66c', 'eee@qq.com', '于国良');
INSERT INTO `sys_login` VALUES ('18', 'ttxn74567', '79f0dfe4577224a01852eeab6d430ebd', 'ttxn7456@sina.com', '于国良');
INSERT INTO `sys_login` VALUES ('19', 'adminss0123', '1eea36fbd4f4919251e3192dce2da380', '80303857@qq.com', '于国良');
INSERT INTO `sys_login` VALUES ('21', 'administrator', '200ceb26807d6bf99fd6f4f0d1ca54d4', '80303857@qq.com', '于国良');
INSERT INTO `sys_login` VALUES ('22', 'adminyuguo21', '21232f297a57a5a743894a0e4a801fc3', '80303857@qq.com', '于国良');
INSERT INTO `sys_login` VALUES ('23', 'aa123456aa', '8a6f2805b4515ac12058e79e66539be9', '80303857@qq.com', 'aa123456');
INSERT INTO `sys_login` VALUES ('24', 'aaxxss', 'e10adc3949ba59abbe56e057f20f883e', 'aa123456@qq.com', 'ss');
INSERT INTO `sys_login` VALUES ('25', 'aa789456', '21232f297a57a5a743894a0e4a801fc3', 'aaa@qq.com', 'aa123456');
INSERT INTO `sys_login` VALUES ('26', '请叫我大王', 'e10adc3949ba59abbe56e057f20f883e', '893808512@qq.com', '请叫我大王');
INSERT INTO `sys_login` VALUES ('27', '111111', '96e79218965eb72c92a549dd5a330112', '111111@111.com', '111111');

-- ----------------------------
-- Table structure for `sys_login_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_role`;
CREATE TABLE `sys_login_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='用户较色对照表';

-- ----------------------------
-- Records of sys_login_role
-- ----------------------------
INSERT INTO `sys_login_role` VALUES ('1', '1', '1', 'admin1');
INSERT INTO `sys_login_role` VALUES ('2', '21', '2', 'administrator');
INSERT INTO `sys_login_role` VALUES ('3', '22', '3', 'adminyuguo21');
INSERT INTO `sys_login_role` VALUES ('4', '23', '3', 'aa123456aa');
INSERT INTO `sys_login_role` VALUES ('5', '24', '3', 'aaxxss');
INSERT INTO `sys_login_role` VALUES ('6', '25', '3', 'aa789456');
INSERT INTO `sys_login_role` VALUES ('7', '26', '3', '请叫我大王');
INSERT INTO `sys_login_role` VALUES ('8', '27', '3', '111111');

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(20) NOT NULL,
  `permission_menu_name` varchar(20) NOT NULL,
  `permission_menu_pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`permission_id`),
  UNIQUE KEY `permission_name_UNIQUE` (`permission_name`),
  UNIQUE KEY `permission_menu_name_UNIQUE` (`permission_menu_name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='权限';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('0', 'quanxian', '权限设置', null);
INSERT INTO `sys_permission` VALUES ('1', 'xinwgl', '新闻管理1', '0');
INSERT INTO `sys_permission` VALUES ('2', 'yonggxx', '用工信息', '0');
INSERT INTO `sys_permission` VALUES ('3', 'zhaopxx', '招聘信息', '0');
INSERT INTO `sys_permission` VALUES ('4', 'qiywh', '企业文化', '0');
INSERT INTO `sys_permission` VALUES ('6', 'zengj', '增加', '1');
INSERT INTO `sys_permission` VALUES ('7', 'maic', '卖场', '0');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) NOT NULL,
  `role_des` varchar(20) NOT NULL,
  `role_pid` int(11) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_des_UNIQUE` (`role_des`),
  UNIQUE KEY `role_name_UNIQUE` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('0', 'role', '权限分配', '-1');
INSERT INTO `sys_role` VALUES ('1', 'admin', '管理员', '0');
INSERT INTO `sys_role` VALUES ('2', 'guest', '嘉宾', '0');
INSERT INTO `sys_role` VALUES ('3', 'vip', '会员', '0');

-- ----------------------------
-- Table structure for `sys_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  `role_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='角色，权限对照表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('13', '1', '1', 'admin');
INSERT INTO `sys_role_permission` VALUES ('14', '1', '6', 'admin');
INSERT INTO `sys_role_permission` VALUES ('15', '1', '2', 'admin');
INSERT INTO `sys_role_permission` VALUES ('16', '1', '3', 'admin');
INSERT INTO `sys_role_permission` VALUES ('17', '1', '4', 'admin');
INSERT INTO `sys_role_permission` VALUES ('18', '1', '7', 'admin');
