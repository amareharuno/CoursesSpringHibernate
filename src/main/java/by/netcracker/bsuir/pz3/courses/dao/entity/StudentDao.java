package by.netcracker.bsuir.pz3.courses.dao.entity;

import by.netcracker.bsuir.pz3.courses.entity.Student;

import java.util.List;

public interface StudentDao {

    void addStudent(Student student);
    Student getStudentById(int id);
    void updateStudent(Student student);
    void deleteStudent(Student id);

    List<Student> getStudents();
}
