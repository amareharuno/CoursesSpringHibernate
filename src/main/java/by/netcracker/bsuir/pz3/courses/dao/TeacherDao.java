package by.netcracker.bsuir.pz3.courses.dao;

import by.netcracker.bsuir.pz3.courses.entity.Teacher;
import by.netcracker.bsuir.pz3.courses.exception.DaoException;

import java.util.List;

public interface TeacherDao {

    void addTeacher(Teacher teacher) throws DaoException;
    Teacher getTeacherById(int id) throws DaoException;
    void updateTeacher(Teacher teacher) throws DaoException;
    void deleteTeacher(int id) throws DaoException;

    List<Teacher> getTeachers() throws DaoException;
}
