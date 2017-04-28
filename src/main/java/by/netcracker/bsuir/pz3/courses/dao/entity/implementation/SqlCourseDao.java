package by.netcracker.bsuir.pz3.courses.dao.entity.implementation;

import by.netcracker.bsuir.pz3.courses.dao.table.CourseTable;
import by.netcracker.bsuir.pz3.courses.dao.entity.CourseDao;
import by.netcracker.bsuir.pz3.courses.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public enum SqlCourseDao implements CourseDao {

    INSTANCE;

    private static final Logger logger = LoggerFactory.getLogger(SqlCourseDao.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCourse(Course course) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(course);
        logger.info(CourseTable.ADD_LOG + course);
    }

    public Course getCourseById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Course course = session.load(Course.class, id);
        logger.info(CourseTable.GET_BY_ID_LOG + course);

        return course;
    }

    public void updateCourse(Course course) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(course);
        logger.info(CourseTable.UPDATE_LOG + course);
    }

    public void deleteCourse(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Course course = session.load(Course.class, id);

        if (course != null) {
            session.delete(course);
        }
        logger.info(CourseTable.DELETE_LOG + course);
    }

    public List<Course> getCourses() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Course> courses = session.createQuery(CourseTable.GET_COURSES).list(); // unchecked assignment. ?

        for (Course course: courses) {
            logger.info(CourseTable.COURSE_LIST + course);
        }

        return courses;
    }
}
