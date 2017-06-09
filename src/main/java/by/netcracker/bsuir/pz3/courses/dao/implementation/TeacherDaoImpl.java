package by.netcracker.bsuir.pz3.courses.dao.implementation;

import by.netcracker.bsuir.pz3.courses.dao.constant.LoggingAndExceptionMessage;
import by.netcracker.bsuir.pz3.courses.dao.constant.Queries;
import by.netcracker.bsuir.pz3.courses.dao.TeacherDao;
import by.netcracker.bsuir.pz3.courses.entity.Teacher;
import by.netcracker.bsuir.pz3.courses.dao.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TeacherDaoImpl extends DaoImpl<Teacher> implements TeacherDao {

    private static Logger logger = LogManager.getLogger(TeacherDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Teacher teacher) throws DaoException {
        logger.info(LoggingAndExceptionMessage.TEACHER_DAO_IMPL_ADD);
        try {
            entityManager.persist(teacher);
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.ADD_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.ADD_TEACHER_LOG + teacher);
    }

    @Override
    public Teacher getById(int id) throws DaoException {
        logger.info(LoggingAndExceptionMessage.TEACHER_DAO_IMPL_GET);
        Teacher teacher;
        try {
            teacher = entityManager.find(Teacher.class, id);
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.GET_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.GET_TEACHER_BY_ID_LOG + teacher);
        return teacher;
    }

    @Override
    public void update(Teacher teacher) throws DaoException {
        logger.info(LoggingAndExceptionMessage.TEACHER_DAO_IMPL_UPDATE);
        try {
            entityManager.merge(teacher);
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.UPDATE_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.UPDATE_TEACHER_LOG + teacher);
    }

    @Override
    public void delete(int id) throws DaoException {
        logger.info(LoggingAndExceptionMessage.TEACHER_DAO_IMPL_DELETE);

        Teacher teacher;
        try {
            teacher = entityManager.find(Teacher.class, id);
            if (teacher != null) {
                entityManager.remove(teacher);
            }
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.DELETE_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.DELETE_TEACHER_LOG + teacher);
    }

    @Override
    public List<Teacher> getAll() throws DaoException {
        logger.info(LoggingAndExceptionMessage.TEACHER_DAO_IMPL_GET_ALL);
        List<Teacher> teachers;
        try {
            teachers = entityManager.createQuery(Queries.GET_TEACHERS).getResultList();
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.GET_ALL_FAIL, exception);
        }
        for (Teacher teacher: teachers) {
            logger.info(LoggingAndExceptionMessage.TEACHER_LIST_LOG + teacher);
        }
        return teachers;
    }

    @Override
    public Teacher getByUserId(int userId) {
        logger.info(LoggingAndExceptionMessage.TEACHER_DAO_IMPL_GET_BY_USER_ID);
        Teacher teacher;
        try {
            Query query = entityManager.createQuery(Queries.GET_TEACHER_BY_USER_ID);
            query.setParameter("userId", userId);
            teacher = (Teacher) query.getSingleResult();
        } catch (NoResultException exception) {
            logger.info(LoggingAndExceptionMessage.GET_TEACHER_BY_BY_USER_ID_FAIL);
            teacher = null;
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.GET_TEACHER_BY_BY_USER_ID_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.GET_TEACHER_BY_BY_USER_ID_LOG + teacher);
        return teacher;
    }
}
