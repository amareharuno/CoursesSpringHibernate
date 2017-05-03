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
-- Table structure for bdTableInfo `course`
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
  CONSTRAINT `fk_Course_Teacher1` FOREIGN KEY (`Teacher_teacherId`) REFERENCES `teacher` (`teacherId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for bdTableInfo `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for bdTableInfo `finishedcourse`
--

DROP TABLE IF EXISTS `finishedcourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `finishedcourse` (
  `finishedCourseId` int(11) NOT NULL AUTO_INCREMENT,
  `Student_studentId` int(11) NOT NULL,
  `assessment` int(11) DEFAULT NULL,
  `finishedCoursecol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`finishedCourseId`,`Student_studentId`),
  UNIQUE KEY `finishedCourseId_UNIQUE` (`finishedCourseId`),
  KEY `fk_finishedCourse_Student1_idx` (`Student_studentId`),
  CONSTRAINT `fk_finishedCourse_Student1` FOREIGN KEY (`Student_studentId`) REFERENCES `student` (`studentId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for bdTableInfo `finishedcourse`
--

LOCK TABLES `finishedcourse` WRITE;
/*!40000 ALTER TABLE `finishedcourse` DISABLE KEYS */;
/*!40000 ALTER TABLE `finishedcourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for bdTableInfo `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `studentId` int(11) NOT NULL AUTO_INCREMENT,
  `groupNumber` int(10) NOT NULL,
  `User_userId` int(11) NOT NULL,
  PRIMARY KEY (`studentId`,`User_userId`),
  UNIQUE KEY `studentId_UNIQUE` (`studentId`),
  KEY `fk_Student_User1_idx` (`User_userId`),
  CONSTRAINT `fk_Student_User1` FOREIGN KEY (`User_userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for bdTableInfo `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for bdTableInfo `student_has_course`
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
  CONSTRAINT `fk_Student_has_Course_Student1` FOREIGN KEY (`Student_studentId`) REFERENCES `student` (`studentId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_has_Course_Course1` FOREIGN KEY (`Course_courseId`) REFERENCES `course` (`courseId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for bdTableInfo `student_has_course`
--

LOCK TABLES `student_has_course` WRITE;
/*!40000 ALTER TABLE `student_has_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_has_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for bdTableInfo `teacher`
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
  CONSTRAINT `fk_Teacher_User` FOREIGN KEY (`User_userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for bdTableInfo `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for bdTableInfo `user`
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
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `password_UNIQUE` (`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for bdTableInfo `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2017-05-03 22:18:19
