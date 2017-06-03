package by.netcracker.bsuir.pz3.courses.dao.implementation;

import by.netcracker.bsuir.pz3.courses.constant.StudentTable;
import by.netcracker.bsuir.pz3.courses.dao.StudentDao;
import by.netcracker.bsuir.pz3.courses.entity.Student;
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

    public void addStudent(Student student) {

        entityManager.persist(student);
        logger.info(StudentTable.ADD_LOG);
    }

    public Student getStudentById(int id) {
        Student student = entityManager.find(Student.class, id);
        logger.info(StudentTable.GET_BY_ID_LOG + student);
        return student;
    }

    public void updateStudent(Student student) {
        entityManager.merge(student);
        logger.info(StudentTable.UPDATE_LOG + student);
    }

    public void deleteStudent(Student id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }

        logger.info(StudentTable.DELETE_LOG + student);
    }

    public List<Student> getStudents() {
        List<Student> students = entityManager.createQuery(StudentTable.GET_STUDENTS).getResultList();
        for (Student student : students) {
            logger.info(StudentTable.STUDENT_LIST + student);
        }
        return students;
    }
}
