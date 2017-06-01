package by.netcracker.bsuir.pz3.courses.dao;

import by.netcracker.bsuir.pz3.courses.entity.FinishedCourse;

import java.util.List;

public interface FinishedCourseDao {

    void AddFinishedCourse(FinishedCourse finishedCourse);
    FinishedCourse getFinishedCourseById(int id);
    void updateFinishedCourse(FinishedCourse finishedCourse);
    void deleteFinishedCourse(int id);

    List<FinishedCourse> getFinishedCourses();
}
