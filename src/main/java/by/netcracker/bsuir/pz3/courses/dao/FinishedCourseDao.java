package by.netcracker.bsuir.pz3.courses.dao;

import by.netcracker.bsuir.pz3.courses.entity.FinishedCourse;
import by.netcracker.bsuir.pz3.courses.exception.DaoException;

import java.util.List;

public interface FinishedCourseDao {

    void AddFinishedCourse(FinishedCourse finishedCourse) throws DaoException;
    FinishedCourse getFinishedCourseById(int id) throws DaoException;
    void updateFinishedCourse(FinishedCourse finishedCourse) throws DaoException;
    void deleteFinishedCourse(int id) throws DaoException;

    List<FinishedCourse> getFinishedCourses() throws DaoException;
}
