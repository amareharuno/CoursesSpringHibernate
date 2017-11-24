-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: courses_spring
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
  `Teacher_teacherId` int(11) NOT NULL,
  PRIMARY KEY (`courseId`),
  UNIQUE KEY `courseId_UNIQUE` (`courseId`),
  KEY `fk_Course_Teacher1_idx` (`Teacher_teacherId`),
  CONSTRAINT `FKi6hpw72kuo134h5dg3hsne5yk` FOREIGN KEY (`Teacher_teacherId`) REFERENCES `teacher` (`teacherId`),
  CONSTRAINT `fk_Course_Teacher1` FOREIGN KEY (`Teacher_teacherId`) REFERENCES `teacher` (`teacherId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (5,'Literature','Reading',15,30,900,2),(6,'Math','Magic Numbers',20,60,3082,2),(8,'Java','Web dev',15,120,1800,1),(9,'Physics','Big Bang Theory',100,60,6000,4);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `finished_course`
--

DROP TABLE IF EXISTS `finished_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `finished_course` (
  `finishedCourseId` int(11) NOT NULL AUTO_INCREMENT,
  `Student_studentId` int(11) NOT NULL,
  `assessment` int(11) DEFAULT NULL,
  `review` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`finishedCourseId`,`Student_studentId`),
  UNIQUE KEY `finishedCourseId_UNIQUE` (`finishedCourseId`),
  KEY `fk_finishedCourse_Student1_idx` (`Student_studentId`),
  CONSTRAINT `FKk300mv7kt0gby0cv5ka0pof2x` FOREIGN KEY (`Student_studentId`) REFERENCES `student` (`studentId`),
  CONSTRAINT `fk_finishedCourse_Student1` FOREIGN KEY (`Student_studentId`) REFERENCES `student` (`studentId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `finished_course`
--

LOCK TABLES `finished_course` WRITE;
/*!40000 ALTER TABLE `finished_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `finished_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `finishedcourse`
--

DROP TABLE IF EXISTS `finishedcourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `finishedcourse` (
  `finishedCourseId` int(11) NOT NULL AUTO_INCREMENT,
  `assessment` int(11) DEFAULT NULL,
  `review` varchar(255) DEFAULT NULL,
  `Student_studentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`finishedCourseId`),
  KEY `FKk300mv7kt0gby0cv5ka0pof2x` (`Student_studentId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `finishedcourse`
--

LOCK TABLES `finishedcourse` WRITE;
/*!40000 ALTER TABLE `finishedcourse` DISABLE KEYS */;
/*!40000 ALTER TABLE `finishedcourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `studentId` int(11) NOT NULL AUTO_INCREMENT,
  `User_userId` int(11) NOT NULL,
  PRIMARY KEY (`studentId`,`User_userId`),
  UNIQUE KEY `studentId_UNIQUE` (`studentId`),
  KEY `fk_Student_User1_idx` (`User_userId`),
  CONSTRAINT `FK2547a60b9tun4i9rcmkwmvyw5` FOREIGN KEY (`User_userId`) REFERENCES `user` (`userId`),
  CONSTRAINT `fk_Student_User1` FOREIGN KEY (`User_userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,2),(2,5);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_has_course`
--

DROP TABLE IF EXISTS `student_has_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_has_course` (
  `Student_studentId` int(11) NOT NULL,
  `Course_courseId` int(11) NOT NULL,
  PRIMARY KEY (`Student_studentId`,`Course_courseId`),
  KEY `fk_Student_has_Course_Course1_idx` (`Course_courseId`),
  KEY `fk_Student_has_Course_Student1_idx` (`Student_studentId`),
  CONSTRAINT `fk_Student_has_Course_Course1` FOREIGN KEY (`Course_courseId`) REFERENCES `course` (`courseId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_has_Course_Student1` FOREIGN KEY (`Student_studentId`) REFERENCES `student` (`studentId`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  `User_userId` int(11) NOT NULL,
  PRIMARY KEY (`teacherId`,`User_userId`),
  UNIQUE KEY `teacherId_UNIQUE` (`teacherId`),
  KEY `fk_Teacher_User_idx` (`User_userId`),
  CONSTRAINT `FKpoqs6pxgf5cr26tqpeepuw2ok` FOREIGN KEY (`User_userId`) REFERENCES `user` (`userId`),
  CONSTRAINT `fk_Teacher_User` FOREIGN KEY (`User_userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,1),(2,3),(4,6),(5,7);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `middleName` varchar(45) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userId_UNIQUE` (`userId`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'teacher','-1439577118','Teacher','Teacher','Teacher'),(2,'student','-1879145925','Student','Student','Student'),(3,'palinaLock','-995599007','Palina','Lock','Arkadievna'),(5,'amy','96717','Amy','Cooper','Angela'),(6,'sveta','109821025','Sveta','Popova','Vasilievna'),(7,'alisson','-1439577118','Alisson','Kindly','Aleesha');
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

-- Dump completed on 2017-11-24  9:57:29
