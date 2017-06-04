package by.netcracker.bsuir.pz3.courses.service.implementation;

import by.netcracker.bsuir.pz3.courses.dao.CourseDao;
import by.netcracker.bsuir.pz3.courses.dao.Dao;
import by.netcracker.bsuir.pz3.courses.entity.Course;
import by.netcracker.bsuir.pz3.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseServiceImpl extends ServiceImpl<Course> implements CourseService {

    @Autowired
    public CourseServiceImpl(CourseDao courseDao) {
        super(courseDao);
    }
}
