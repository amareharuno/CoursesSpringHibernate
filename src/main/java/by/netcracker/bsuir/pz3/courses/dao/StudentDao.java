package by.netcracker.bsuir.pz3.courses.dao;

import by.netcracker.bsuir.pz3.courses.entity.Student;
import by.netcracker.bsuir.pz3.courses.exception.DaoException;

import java.util.List;

public interface StudentDao {

    void addStudent(Student student) throws DaoException;
    Student getStudentById(int id) throws DaoException;
    void updateStudent(Student student) throws DaoException;
    void deleteStudent(Student id) throws DaoException;

    List<Student> getStudents() throws DaoException;
}
