package by.netcracker.bsuir.pz3.courses.dao.factory;

import by.netcracker.bsuir.pz3.courses.dao.entity.*;
import by.netcracker.bsuir.pz3.courses.dao.entity.sql.*;

public enum  MySqlDaoFactory implements DaoFactory {

    INSTANCE;

    public CourseDao getCourseDao() {
        return SqlCourseDao.INSTANCE;
    }

    public TeacherDao getTeacherDao() {
        return SqlTeaherDao.INSTANCE;
    }

    public StudentDao getStudentDao() {
        return SqlStudentDao.INSTANCE;
    }

    public UserDao getUserDao() {
        return SqlUserDao.INSTANCE;
    }

    public FinishedCourseDao getFinishedCourseDao() {
        return SqlFinishedCourseDao.INSTANCE;
    }
}
