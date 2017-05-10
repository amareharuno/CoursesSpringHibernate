package by.netcracker.bsuir.pz3.courses.dao.entity.implementation;

import by.netcracker.bsuir.pz3.courses.dao.bdTableInfo.StudentTable;
import by.netcracker.bsuir.pz3.courses.dao.entity.StudentDao;
import by.netcracker.bsuir.pz3.courses.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public enum StudentDaoImpl implements StudentDao {

    INSTANCE;

    private final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);
    @PersistenceContext(unitName = "courses_spring")
    private EntityManager entityManager;

//    private SessionFactory sessionFactory;

//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    public void addStudent(Student student) {
//        Session session = sessionFactory.getCurrentSession();
//        session.persist(student);

        entityManager.persist(student);
        logger.info(StudentTable.ADD_LOG);
    }

    public Student getStudentById(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        Student student = session.load(Student.class, id);

        Student student = entityManager.find(Student.class, id);
        logger.info(StudentTable.GET_BY_ID_LOG + student);
        return student;
    }

    public void updateStudent(Student student) {
//        Session session = sessionFactory.getCurrentSession();
//        session.update(student);

        entityManager.merge(student);
        logger.info(StudentTable.UPDATE_LOG + student);
    }

    public void deleteStudent(Student id) {
//        Session session = sessionFactory.getCurrentSession();
//        Student student = session.load(Student.class, (Serializable) id); // ??????

        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }

        logger.info(StudentTable.DELETE_LOG + student);
    }

    public List<Student> getStudents() {
//        Session session = sessionFactory.getCurrentSession();
//        List<Student> students = session.createQuery(StudentTable.GET_STUDENTS).list();

        List<Student> students = entityManager.createQuery(StudentTable.GET_STUDENTS).getResultList();
        for (Student student : students) {
            logger.info(StudentTable.STUDENT_LIST + student);
        }
        return students;
    }
}
