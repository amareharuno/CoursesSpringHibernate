package by.netcracker.bsuir.pz3.courses.dao.implementation;

import by.netcracker.bsuir.pz3.courses.constant.Logging;
import by.netcracker.bsuir.pz3.courses.constant.Queries;
import by.netcracker.bsuir.pz3.courses.dao.TeacherDao;
import by.netcracker.bsuir.pz3.courses.entity.Teacher;
import by.netcracker.bsuir.pz3.courses.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {

    private static Logger logger = LogManager.getLogger(TeacherDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void addTeacher(Teacher teacher) throws DaoException {
        logger.debug(Logging.TEACHER_DAO_IMPL_ADD);
        try {
            entityManager.persist(teacher);
        } catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(Logging.ADD_FAIL, exception);
        }
        logger.info(Logging.ADD_TEACHER_LOG + teacher);
    }

    public Teacher getTeacherById(int id) throws DaoException {
        logger.debug(Logging.TEACHER_DAO_IMPL_GET);
        Teacher teacher;
        try {
            teacher = entityManager.find(Teacher.class, id);
        } catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(Logging.GET_FAIL, exception);
        }
        logger.info(Logging.GET_TEACHER_BY_ID_LOG + teacher);
        return teacher;
    }

    public void updateTeacher(Teacher teacher) throws DaoException {
        logger.debug(Logging.TEACHER_DAO_IMPL_UPDATE);
        try {
            entityManager.merge(teacher);
        } catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(Logging.UPDATE_FAIL, exception);
        }
        logger.info(Logging.UPDATE_TEACHER_LOG + teacher);
    }

    public void deleteTeacher(int id) throws DaoException {
        logger.debug(Logging.TEACHER_DAO_IMPL_DELETE);

        Teacher teacher;
        try {
            teacher = entityManager.find(Teacher.class, id);
            if (teacher != null) {
                entityManager.remove(teacher);
            }
        } catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(Logging.DELETE_FAIL, exception);
        }
        logger.info(Logging.DELETE_TEACHER_LOG + teacher);
    }

    public List<Teacher> getTeachers() throws DaoException {
        logger.debug(Logging.TEACHER_DAO_IMPL_GET_ALL);
        List<Teacher> teachers;
        try {
            teachers = entityManager.createQuery(Queries.GET_TEACHERS).getResultList();
        } catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(Logging.GET_ALL_FAIL, exception);
        }
        for (Teacher teacher: teachers) {
            logger.info(Logging.TEACHER_LIST_LOG + teacher);
        }
        return teachers;
    }
}
