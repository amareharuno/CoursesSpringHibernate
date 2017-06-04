package by.netcracker.bsuir.pz3.courses.dao.implementation;

import by.netcracker.bsuir.pz3.courses.constant.LoggingAndExceptionMessage;
import by.netcracker.bsuir.pz3.courses.constant.Queries;
import by.netcracker.bsuir.pz3.courses.dao.FinishedCourseDao;
import by.netcracker.bsuir.pz3.courses.entity.FinishedCourse;
import by.netcracker.bsuir.pz3.courses.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FinishedCourseDaoImpl implements FinishedCourseDao{

    @PersistenceContext
    private EntityManager entityManager;
    private static Logger logger = LogManager.getLogger(FinishedCourseDao.class);

    public void add(FinishedCourse finishedCourse) throws DaoException {
        logger.debug(LoggingAndExceptionMessage.FINISHED_COURSE_DAO_IMPL_ADD);
        try {
            entityManager.persist(finishedCourse);
        } catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(LoggingAndExceptionMessage.ADD_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.ADD_FINISHED_COURSE_LOG + finishedCourse);
    }

    public FinishedCourse getById(int id) throws DaoException {
        logger.debug(LoggingAndExceptionMessage.FINISHED_COURSE_DAO_IMPL_GET);
        FinishedCourse finishedCourse;
        try {
            finishedCourse = entityManager.find(FinishedCourse.class, id);
        } catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(LoggingAndExceptionMessage.GET_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.GET_FINISHED_COURSE_BY_ID_LOG + finishedCourse);
        return finishedCourse;
    }

    public void update(FinishedCourse finishedCourse) throws DaoException {
        logger.debug(LoggingAndExceptionMessage.FINISHED_COURSE_DAO_IMPL_UPDATE);
        try {
            entityManager.merge(finishedCourse);
        } catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(LoggingAndExceptionMessage.UPDATE_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.UPDATE_FINISHED_COURSE_LOG + finishedCourse);
    }

    public void delete(int id) throws DaoException {
        logger.debug(LoggingAndExceptionMessage.FINISHED_COURSE_DAO_IMPL_DELETE);
        FinishedCourse finishedCourse;
        try {
            finishedCourse = entityManager.find(FinishedCourse.class, id);
            if (finishedCourse != null) {
                entityManager.remove(finishedCourse);
            }
        } catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(LoggingAndExceptionMessage.DELETE_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.DELETE_FINISHED_COURSE_LOG + finishedCourse);
    }

    public List<FinishedCourse> getAll() throws DaoException {
        logger.debug(LoggingAndExceptionMessage.FINISHED_COURSE_DAO_IMPL_GET_ALL);
        List<FinishedCourse> finishedCourses;
        try {
            finishedCourses = entityManager.createQuery(Queries.GET_FINISHED_COURSES).getResultList();
        } catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(LoggingAndExceptionMessage.GET_ALL_FAIL, exception);
        }
        for (FinishedCourse finishedCourse : finishedCourses) {
            logger.info(LoggingAndExceptionMessage.GET_ALL_FINISHED_COURSE_LOG + finishedCourse);
        }
        return finishedCourses;
    }
}
