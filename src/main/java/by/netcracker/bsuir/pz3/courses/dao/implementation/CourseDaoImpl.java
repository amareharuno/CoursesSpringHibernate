package by.netcracker.bsuir.pz3.courses.dao.implementation;

import by.netcracker.bsuir.pz3.courses.constant.Logging;
import by.netcracker.bsuir.pz3.courses.constant.Queries;
import by.netcracker.bsuir.pz3.courses.dao.CourseDao;
import by.netcracker.bsuir.pz3.courses.entity.Course;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    private static Logger logger = LogManager.getLogger(CourseDaoImpl.class);

    public void addCourse(Course course) {
        entityManager.persist(course);
        logger.info(Logging.ADD_COURSE_LOG + course);
    }

    public Course getCourseById(int id) {
        Course course = entityManager.find(Course.class, id);
        logger.info(Logging.GET_COURSE_BY_ID_LOG + course);

        return course;
    }

    public void updateCourse(Course course) {
        entityManager.merge(course);
        logger.info(Logging.UPDATE_COURSE_LOG + course);
    }

    public void deleteCourse(int id) {
        Course course = entityManager.find(Course.class, id);

        if (course != null) {
            entityManager.remove(course);
        }
        logger.info(Logging.DELETE_COURSE_LOG + course);
    }

    public List<Course> getCourses() {
        List<Course> courses = entityManager.createQuery(Queries.GET_COURSES).getResultList();
        for (Course course: courses) {
            logger.info(Logging.COURSE_LIST_LOG + course);
        }

        return courses;
    }
}
