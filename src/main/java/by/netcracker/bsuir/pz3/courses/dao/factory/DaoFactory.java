package by.netcracker.bsuir.pz3.courses.dao.factory;

import by.netcracker.bsuir.pz3.courses.dao.entity.*;

public interface DaoFactory {

    CourseDao getCourseDao();
    TeacherDao getTeacherDao();
    StudentDao getStudentDao();
    UserDao getUserDao();
    FinishedCourseDao getFinishedCourseDao();
}
