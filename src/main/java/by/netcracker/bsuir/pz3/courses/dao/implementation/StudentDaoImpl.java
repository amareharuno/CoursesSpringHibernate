package by.netcracker.bsuir.pz3.courses.dao.implementation;

import by.netcracker.bsuir.pz3.courses.constant.Logging;
import by.netcracker.bsuir.pz3.courses.constant.Queries;
import by.netcracker.bsuir.pz3.courses.dao.StudentDao;
import by.netcracker.bsuir.pz3.courses.entity.Student;
import by.netcracker.bsuir.pz3.courses.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private static Logger logger = LogManager.getLogger(StudentDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void addStudent(Student student) throws DaoException {
        logger.debug(Logging.STUDENT_DAO_IMPL_ADD);
        try {
            entityManager.persist(student);
        }  catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(Logging.ADD_FAIL, exception);
        }

        logger.info(Logging.ADD_STUDENT_LOG);
    }

    public Student getStudentById(int id) throws DaoException {
        logger.debug(Logging.STUDENT_DAO_IMPL_GET);
        Student student;
        try {
            student = entityManager.find(Student.class, id);
        } catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(Logging.GET_FAIL, exception);
        }
        logger.info(Logging.GET_STUDENT_BY_ID_LOG + student);
        return student;
    }

    public void updateStudent(Student student) throws DaoException {
        logger.debug(Logging.STUDENT_DAO_IMPL_UPDATE);
        try {
            entityManager.merge(student);
        } catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(Logging.UPDATE_FAIL, exception);
        }
        logger.info(Logging.UPDATE_STUDENT_LOG + student);
    }

    public void deleteStudent(Student id) throws DaoException {
        logger.debug(Logging.STUDENT_DAO_IMPL_DELETE);
        Student student;
        try {
            student = entityManager.find(Student.class, id);
            if (student != null) {
                entityManager.remove(student);
            }
        } catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(Logging.DELETE_FAIL, exception);
        }
        logger.info(Logging.DELETE_STUDENT_LOG + student);
    }

    public List<Student> getStudents() throws DaoException {
        logger.debug(Logging.STUDENT_DAO_IMPL_GET_ALL);
        List<Student> students;
        try {
            students = entityManager.createQuery(Queries.GET_STUDENTS).getResultList();
        }  catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(Logging.GET_ALL_FAIL, exception);
        }
        for (Student student : students) {
            logger.info(Logging.STUDENT_LIST_LOG + student);
        }
        return students;
    }
}
