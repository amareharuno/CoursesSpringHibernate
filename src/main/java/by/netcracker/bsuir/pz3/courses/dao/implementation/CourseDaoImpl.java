package by.netcracker.bsuir.pz3.courses.dao.implementation;

import by.netcracker.bsuir.pz3.courses.constant.CourseTable;
import by.netcracker.bsuir.pz3.courses.dao.CourseDao;
import by.netcracker.bsuir.pz3.courses.entity.Course;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {

    @PersistenceContext(unitName = "courses_spring")
    private EntityManager entityManager;

    private static Logger logger = LogManager.getLogger(CourseDaoImpl.class);

    public void addCourse(Course course) {
        entityManager.persist(course);
        logger.info(CourseTable.ADD_LOG + course);
    }

    public Course getCourseById(int id) {
        Course course = entityManager.find(Course.class, id);
        logger.info(CourseTable.GET_BY_ID_LOG + course);

        return course;
    }

    public void updateCourse(Course course) {
        entityManager.merge(course);
        logger.info(CourseTable.UPDATE_LOG + course);
    }

    public void deleteCourse(int id) {
        Course course = entityManager.find(Course.class, id);

        if (course != null) {
            entityManager.remove(course);
        }
        logger.info(CourseTable.DELETE_LOG + course);
    }

    public List<Course> getCourses() {
        List<Course> courses = entityManager.createQuery(CourseTable.GET_COURSES).getResultList();
        for (Course course: courses) {
            logger.info(CourseTable.COURSE_LIST + course);
        }

        return courses;
    }
}
