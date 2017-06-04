package by.netcracker.bsuir.pz3.courses.dao.implementation;

import by.netcracker.bsuir.pz3.courses.dao.constant.LoggingAndExceptionMessage;
import by.netcracker.bsuir.pz3.courses.dao.constant.Queries;
import by.netcracker.bsuir.pz3.courses.dao.CourseDao;
import by.netcracker.bsuir.pz3.courses.entity.Course;
import by.netcracker.bsuir.pz3.courses.dao.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CourseDaoImpl extends DaoImpl<Course> implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    private static Logger logger = LogManager.getLogger(CourseDaoImpl.class);

    public void add(Course course) throws DaoException {
        logger.info(LoggingAndExceptionMessage.COURSE_DAO_IMPL_ADD);
        try {
            entityManager.persist(course);
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.ADD_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.ADD_COURSE_LOG + course);
    }

    public Course getById(int id) throws DaoException {
        logger.info(LoggingAndExceptionMessage.COURSE_DAO_IMPL_GET);
        Course course;
        try {
            course = entityManager.find(Course.class, id);
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.GET_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.GET_COURSE_BY_ID_LOG + course);
        return course;
    }

    public void update(Course course) throws DaoException {
        logger.info(LoggingAndExceptionMessage.COURSE_DAO_IMPL_UPDATE);
        try {
            entityManager.merge(course);
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.UPDATE_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.UPDATE_COURSE_LOG + course);
    }

    public void delete(int id) throws DaoException {
        logger.info(LoggingAndExceptionMessage.COURSE_DAO_IMPL_DELETE);
        Course course;
        try {
            course = entityManager.find(Course.class, id);
            if (course != null) {
                entityManager.remove(course);
            }
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.DELETE_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.DELETE_COURSE_LOG + course);
    }

    public List<Course> getAll() throws DaoException {
        logger.info(LoggingAndExceptionMessage.COURSE_DAO_IMPL_GET_ALL);
        List<Course> courses;
        try {
            courses = entityManager.createQuery(Queries.GET_COURSES).getResultList();
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.GET_ALL_FAIL, exception);
        }
        for (Course course: courses) {
            logger.info(LoggingAndExceptionMessage.COURSE_LIST_LOG + course);
        }
        return courses;
    }
}
