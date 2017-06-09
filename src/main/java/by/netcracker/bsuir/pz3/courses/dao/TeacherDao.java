package by.netcracker.bsuir.pz3.courses.dao;

import by.netcracker.bsuir.pz3.courses.entity.Teacher;

public interface TeacherDao extends Dao<Teacher> {
    Teacher getByUserId(int userId);
}
