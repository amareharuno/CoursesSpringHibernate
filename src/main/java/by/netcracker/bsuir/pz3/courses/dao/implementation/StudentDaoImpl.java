package by.netcracker.bsuir.pz3.courses.dao.implementation;

import by.netcracker.bsuir.pz3.courses.constant.Logging;
import by.netcracker.bsuir.pz3.courses.constant.Queries;
import by.netcracker.bsuir.pz3.courses.dao.StudentDao;
import by.netcracker.bsuir.pz3.courses.entity.Student;
import by.netcracker.bsuir.pz3.courses.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

        entityManager.persist(student);
        logger.info(Logging.ADD_STUDENT_LOG);
    }

    public Student getStudentById(int id) throws DaoException {
        Student student = entityManager.find(Student.class, id);
        logger.info(Logging.GET_STUDENT_BY_ID_LOG + student);
        return student;
    }

    public void updateStudent(Student student) throws DaoException {
        entityManager.merge(student);
        logger.info(Logging.UPDATE_STUDENT_LOG + student);
    }

    public void deleteStudent(Student id) throws DaoException {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }

        logger.info(Logging.DELETE_STUDENT_LOG + student);
    }

    public List<Student> getStudents() throws DaoException {
        List<Student> students = entityManager.createQuery(Queries.GET_STUDENTS).getResultList();
        for (Student student : students) {
            logger.info(Logging.STUDENT_LIST_LOG + student);
        }
        return students;
    }
}
