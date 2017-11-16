-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: courses
-- ------------------------------------------------------
-- Server version	6.0.6-alpha-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(45) NOT NULL,
  `courseName` varchar(45) NOT NULL,
  `lessonsCount` int(11) NOT NULL,
  `lessonDuration` int(11) NOT NULL,
  `courseDuration` int(11) NOT NULL,
  `teacher_teacherId` int(11) NOT NULL,
  PRIMARY KEY (`courseId`,`teacher_teacherId`),
  UNIQUE KEY `courseID_UNIQUE` (`courseId`),
  KEY `fk_course_teacher_idx` (`teacher_teacherId`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'math','Numbers',1,60,60,1),(2,'english','courseName2',2,60,120,1),(18,'Math','Magic Numbers',2,75,150,0),(19,'Math','Magic Numbers',2,75,150,0),(20,'Math','Magic Numbers',2,75,150,0),(21,'Math','Magic Numbers',2,75,150,0),(22,'Math','Magic Numbers',2,75,150,0),(23,'Math','Magic Numbers',2,75,150,0),(24,'Math','Magic Numbers',2,75,150,0),(25,'Math','Magic Numbers',2,75,150,0),(26,'Math','Magic Numbers',2,75,150,0),(27,'Math','Magic Numbers',2,75,150,0);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `finished_courses`
--

DROP TABLE IF EXISTS `finished_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `finished_courses` (
  `finishedCourseId` int(11) NOT NULL AUTO_INCREMENT,
  `mark` int(11) NOT NULL,
  `review` varchar(100) NOT NULL,
  `student_studentId` int(11) NOT NULL,
  PRIMARY KEY (`finishedCourseId`,`student_studentId`),
  UNIQUE KEY `finishedCourseID_UNIQUE` (`finishedCourseId`),
  KEY `fk_finished_courses_student1_idx` (`student_studentId`),
  CONSTRAINT `fk_finished_courses_student1` FOREIGN KEY (`student_studentId`) REFERENCES `student` (`studentId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `finished_courses`
--

LOCK TABLES `finished_courses` WRITE;
/*!40000 ALTER TABLE `finished_courses` DISABLE KEYS */;
/*!40000 ALTER TABLE `finished_courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `studentId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `middleName` varchar(45) NOT NULL,
  PRIMARY KEY (`studentId`),
  UNIQUE KEY `studentID_UNIQUE` (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'vjb','dfgjhk','dfghj');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_has_course`
--

DROP TABLE IF EXISTS `student_has_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_has_course` (
  `student_studentId` int(11) NOT NULL,
  `course_courseId` int(11) NOT NULL,
  `course_teacher_teacherId` int(11) NOT NULL,
  PRIMARY KEY (`student_studentId`,`course_courseId`,`course_teacher_teacherId`),
  KEY `fk_student_has_course_course1_idx` (`course_courseId`,`course_teacher_teacherId`),
  KEY `fk_student_has_course_student1_idx` (`student_studentId`),
  CONSTRAINT `fk_student_has_course_course1` FOREIGN KEY (`course_courseId`, `course_teacher_teacherId`) REFERENCES `course` (`courseId`, `teacher_teacherId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_has_course_student1` FOREIGN KEY (`student_studentId`) REFERENCES `student` (`studentId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_has_course`
--

LOCK TABLES `student_has_course` WRITE;
/*!40000 ALTER TABLE `student_has_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_has_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `teacherId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `middleName` varchar(45) NOT NULL,
  PRIMARY KEY (`teacherId`),
  UNIQUE KEY `teacherID_UNIQUE` (`teacherId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Name1','LName1','MName1'),(2,'Name2','LName2','MName2'),(3,'Name3','LName3','MName3'),(4,'Name4','LName4','MName4'),(5,'firstName','lastName','middleName'),(6,'firstName','lastName','middleName'),(7,'firstName','lastName','middleName'),(8,'firstName','lastName','middleName'),(9,'firstName','lastName','middleName'),(10,'firstName','lastName','middleName'),(11,'firstName','lastName','middleName'),(12,'klm','llknn','kllml'),(13,'mlmkl','hghcxc','teacher'),(14,'bvc','llml','ml ;;k'),(15,'firstName','lastName','middleName'),(16,'fhgjhkjlk','gjk','fgh');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `isTeacher` tinyint(4) NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userID_UNIQUE` (`userID`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `password_UNIQUE` (`password`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'login','pass',0),(2,'l','p',0),(3,'lo','pa',0),(4,'log','sdfbnm',0),(5,'logsdfdg','Sdvdvzvzdzd',0),(6,'logsdfdgfxgx','s',0),(7,'111111','sssssssssssssssssssss',0),(8,'gk66',' ,',0),(9,'lllllllll','ppppppppp',0),(10,'26635','m,. blvjgk',0),(11,'as;mcsa;kvdsnnjv','dsvm;dkvma;lmc',0),(12,'sdfghhjkjlk','cvbdgfhgjhkj',0),(13,';lkjvgcfcgvkhblj;','dfvblj;kkjlhkj',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-16 12:50:00
