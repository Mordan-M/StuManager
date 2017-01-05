/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : stu_manager

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2017-01-05 15:51:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adm_id` int(30) NOT NULL,
  `adm_psw` char(32) DEFAULT NULL,
  PRIMARY KEY (`adm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1909', '918546E20133166A008194442E89CA6D');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_id` int(32) NOT NULL,
  `stu_name` varchar(30) NOT NULL,
  `stu_sex` varchar(1) NOT NULL,
  `stu_age` int(3) NOT NULL,
  `stu_phone` char(11) DEFAULT NULL,
  `stu_address` text,
  `class_name` varchar(50) NOT NULL,
  `stu_psw` char(32) DEFAULT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('190920001', 'AI-1号', '女', '21', '15111589634', '无', '计科19010', '3B21CA2145E0E8931C5A093F00E00174');
INSERT INTO `student` VALUES ('190920002', 'AI-2号', '女', '19', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920003', 'AI-3号', '女', '20', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920004', 'AI-4号', '男', '20', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920005', 'AI-5号', '女', '18', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920006', 'AI-6号', '男', '21', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920007', 'AI-7号', '女', '21', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920008', 'AI-8号', '男', '19', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920009', 'AI-9号', '男', '20', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920010', 'AI-10号', '女', '18', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920011', 'AI-11号', '男', '18', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920012', 'AI-12号', '女', '18', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920013', 'AI-13号', '男', '18', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920014', 'AI-14号', '男', '20', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920015', 'AI-15号', '女', '21', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920016', 'AI-16号', '女', '18', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920017', 'AI-17号', '男', '18', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920018', 'AI-18号', '女', '18', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920019', 'AI-19号', '女', '21', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920020', 'AI-20号', '女', '19', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920021', 'AI-21号', '男', '21', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920022', 'AI-22号', '男', '19', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920023', 'AI-23号', '女', '20', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920024', 'AI-24号', '女', '21', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920025', 'AI-25号', '女', '19', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920026', 'AI-26号', '女', '21', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920027', 'AI-27号', '男', '20', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920028', 'AI-28号', '男', '19', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920029', 'AI-29号', '女', '19', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920030', 'AI-30号', '女', '20', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920031', 'AI-31号', '女', '18', '15111589634', '无', '计科19010', '123');
INSERT INTO `student` VALUES ('190920032', 'AI-32号', '女', '20', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920033', 'AI-33号', '男', '20', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920034', 'AI-34号', '女', '20', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920035', 'AI-35号', '男', '21', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920036', 'AI-36号', '男', '20', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920037', 'AI-37号', '女', '20', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920038', 'AI-38号', '女', '18', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920039', 'AI-39号', '男', '18', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920040', 'AI-40号', '女', '18', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920041', 'AI-41号', '女', '18', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920042', 'AI-42号', '男', '21', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920043', 'AI-43号', '男', '18', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920044', 'AI-44号', '女', '20', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920045', 'AI-45号', '男', '19', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920046', 'AI-46号', '男', '20', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920047', 'AI-47号', '女', '19', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920048', 'AI-48号', '男', '18', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920049', 'AI-49号', '男', '19', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920050', 'AI-50号', '男', '20', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920051', 'AI-51号', '男', '20', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920052', 'AI-52号', '男', '20', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920053', 'AI-53号', '女', '20', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920054', 'AI-54号', '男', '21', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920055', 'AI-55号', '男', '20', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920056', 'AI-56号', '女', '20', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920057', 'AI-57号', '女', '18', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920058', 'AI-58号', '女', '20', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920059', 'AI-59号', '男', '18', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920060', 'AI-60号', '女', '18', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920061', 'AI-61号', '女', '19', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920062', 'AI-62号', '男', '19', '15111589634', '无', '计科19011', '123');
INSERT INTO `student` VALUES ('190920063', 'AI-63号', '男', '19', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920064', 'AI-64号', '男', '21', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920065', 'AI-65号', '女', '19', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920066', 'AI-66号', '男', '19', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920067', 'AI-67号', '女', '20', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920068', 'AI-68号', '女', '19', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920069', 'AI-69号', '女', '21', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920070', 'AI-70号', '男', '18', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920071', 'AI-71号', '男', '20', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920072', 'AI-72号', '女', '20', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920073', 'AI-73号', '男', '18', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920074', 'AI-74号', '男', '18', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920075', 'AI-75号', '女', '20', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920076', 'AI-76号', '男', '19', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920077', 'AI-77号', '女', '19', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920078', 'AI-78号', '女', '18', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920079', 'AI-79号', '女', '19', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920080', 'AI-80号', '女', '21', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920081', 'AI-81号', '男', '19', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920082', 'AI-82号', '女', '20', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920083', 'AI-83号', '男', '19', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920084', 'AI-84号', '男', '19', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920085', 'AI-85号', '女', '18', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920086', 'AI-86号', '女', '21', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920087', 'AI-87号', '男', '20', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920088', 'AI-88号', '女', '19', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920089', 'AI-89号', '男', '21', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920090', 'AI-90号', '女', '19', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920091', 'AI-91号', '男', '19', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920092', 'AI-92号', '女', '20', '15111589634', '无', '计科19012', '123');
INSERT INTO `student` VALUES ('190920093', 'AI-93号', '男', '18', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920094', 'AI-94号', '男', '18', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920095', 'AI-95号', '男', '20', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920096', 'AI-96号', '女', '21', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920097', 'AI-97号', '女', '19', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920098', 'AI-98号', '女', '21', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920099', 'AI-99号', '男', '21', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920100', 'AI-100号', '男', '18', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920101', 'AI-101号', '男', '19', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920102', 'AI-102号', '男', '19', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920103', 'AI-103号', '男', '20', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920104', 'AI-104号', '男', '19', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920105', 'AI-105号', '男', '19', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920106', 'AI-106号', '女', '18', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920107', 'AI-107号', '女', '21', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920108', 'AI-108号', '男', '18', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920109', 'AI-109号', '女', '20', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920110', 'AI-110号', '女', '20', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920111', 'AI-111号', '女', '18', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920112', 'AI-112号', '男', '21', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920113', 'AI-113号', '女', '19', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920114', 'AI-114号', '女', '20', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920115', 'AI-115号', '男', '18', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920116', 'AI-116号', '男', '18', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920117', 'AI-117号', '女', '21', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920118', 'AI-118号', '女', '21', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920119', 'AI-119号', '女', '19', '15111589634', '无', '软件19010', '123');
INSERT INTO `student` VALUES ('190920120', 'AI-120号', '男', '20', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920121', 'AI-121号', '女', '20', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920122', 'AI-122号', '男', '20', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920123', 'AI-123号', '女', '19', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920124', 'AI-124号', '男', '19', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920125', 'AI-125号', '男', '18', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920126', 'AI-126号', '男', '18', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920127', 'AI-127号', '男', '21', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920128', 'AI-128号', '女', '18', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920129', 'AI-129号', '男', '21', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920130', 'AI-130号', '女', '21', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920131', 'AI-131号', '男', '19', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920132', 'AI-132号', '男', '19', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920133', 'AI-133号', '女', '19', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920134', 'AI-134号', '男', '19', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920135', 'AI-135号', '女', '19', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920136', 'AI-136号', '女', '21', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920137', 'AI-137号', '男', '19', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920138', 'AI-138号', '女', '19', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920139', 'AI-139号', '女', '18', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920140', 'AI-140号', '女', '21', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920141', 'AI-141号', '男', '20', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920142', 'AI-142号', '男', '20', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920143', 'AI-143号', '女', '21', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920144', 'AI-144号', '男', '18', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920145', 'AI-145号', '女', '19', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920146', 'AI-146号', '男', '19', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920147', 'AI-147号', '女', '20', '15111589634', '无', '软件19011', '123');
INSERT INTO `student` VALUES ('190920148', 'AI-148号', '男', '21', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920149', 'AI-149号', '男', '20', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920150', 'AI-150号', '男', '21', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920151', 'AI-151号', '女', '20', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920152', 'AI-152号', '女', '21', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920153', 'AI-153号', '男', '18', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920154', 'AI-154号', '男', '19', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920155', 'AI-155号', '男', '18', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920156', 'AI-156号', '男', '21', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920157', 'AI-157号', '女', '18', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920158', 'AI-158号', '女', '19', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920159', 'AI-159号', '女', '20', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920160', 'AI-160号', '男', '19', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920161', 'AI-161号', '男', '20', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920162', 'AI-162号', '女', '18', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920163', 'AI-163号', '男', '18', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920164', 'AI-164号', '女', '20', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920165', 'AI-165号', '女', '18', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920166', 'AI-166号', '男', '19', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920167', 'AI-167号', '男', '19', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920168', 'AI-168号', '女', '18', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920169', 'AI-169号', '男', '21', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920170', 'AI-170号', '女', '20', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920171', 'AI-171号', '女', '20', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920172', 'AI-172号', '女', '20', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920173', 'AI-173号', '女', '18', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920174', 'AI-174号', '男', '18', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920175', 'AI-175号', '男', '20', '15111589634', '无', '软件19012', '123');
INSERT INTO `student` VALUES ('190920177', 'AI-177号', '女', '19', '15112458974', '无', '软件19012', '07B4EDCEBD3C9B0231A6D3209A19391B');
