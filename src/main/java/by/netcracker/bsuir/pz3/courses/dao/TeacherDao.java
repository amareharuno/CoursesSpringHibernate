package by.netcracker.bsuir.pz3.courses.dao;

import by.netcracker.bsuir.pz3.courses.entity.Teacher;

import java.util.List;

public interface TeacherDao {

    void addTeacher(Teacher teacher);
    Teacher getTeacherById(int id);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(int id);

    List<Teacher> getTeachers();
}
