package by.netcracker.bsuir.pz3.courses.dao.entity;

import by.netcracker.bsuir.pz3.courses.entity.Course;

import java.util.List;

public interface CourseDao {

    void addCourse(Course course);
    Course getCourseById(int id);
    void updateCourse(Course course);
    void deleteCourse(int id);

    List<Course> getCourses();
}
