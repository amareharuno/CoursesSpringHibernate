package by.netcracker.bsuir.pz3.courses.dao.implementation;

import by.netcracker.bsuir.pz3.courses.dao.constant.LoggingAndExceptionMessage;
import by.netcracker.bsuir.pz3.courses.dao.constant.Queries;
import by.netcracker.bsuir.pz3.courses.dao.StudentDao;
import by.netcracker.bsuir.pz3.courses.entity.Student;
import by.netcracker.bsuir.pz3.courses.dao.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StudentDaoImpl extends DaoImpl<Student> implements StudentDao {

    private static Logger logger = LogManager.getLogger(StudentDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Student student) throws DaoException {
        logger.info(LoggingAndExceptionMessage.STUDENT_DAO_IMPL_ADD);
        try {
            entityManager.persist(student);
        }  catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.ADD_FAIL, exception);
        }

        logger.info(LoggingAndExceptionMessage.ADD_STUDENT_LOG);
    }

    public Student getById(int id) throws DaoException {
        logger.info(LoggingAndExceptionMessage.STUDENT_DAO_IMPL_GET);
        Student student;
        try {
            student = entityManager.find(Student.class, id);
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.GET_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.GET_STUDENT_BY_ID_LOG + student);
        return student;
    }

    public void update(Student student) throws DaoException {
        logger.info(LoggingAndExceptionMessage.STUDENT_DAO_IMPL_UPDATE);
        try {
            entityManager.merge(student);
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.UPDATE_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.UPDATE_STUDENT_LOG + student);
    }

    public void delete(int id) throws DaoException {
        logger.info(LoggingAndExceptionMessage.STUDENT_DAO_IMPL_DELETE);
        Student student;
        try {
            student = entityManager.find(Student.class, id);
            if (student != null) {
                entityManager.remove(student);
            }
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.DELETE_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.DELETE_STUDENT_LOG + student);
    }

    public List<Student> getAll() throws DaoException {
        logger.info(LoggingAndExceptionMessage.STUDENT_DAO_IMPL_GET_ALL);
        List<Student> students;
        try {
            students = entityManager.createQuery(Queries.GET_STUDENTS).getResultList();
        }  catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.GET_ALL_FAIL, exception);
        }
        for (Student student : students) {
            logger.info(LoggingAndExceptionMessage.STUDENT_LIST_LOG + student);
        }
        return students;
    }
}
