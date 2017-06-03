package by.netcracker.bsuir.pz3.courses.dao;

import by.netcracker.bsuir.pz3.courses.entity.Course;
import by.netcracker.bsuir.pz3.courses.exception.DaoException;

import java.util.List;

public interface CourseDao {

    void addCourse(Course course) throws DaoException;
    Course getCourseById(int id) throws DaoException;
    void updateCourse(Course course) throws DaoException;
    void deleteCourse(int id) throws DaoException;

    List<Course> getCourses() throws DaoException;
}
