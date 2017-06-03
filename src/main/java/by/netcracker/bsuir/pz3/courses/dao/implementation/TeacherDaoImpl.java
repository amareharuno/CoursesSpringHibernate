package by.netcracker.bsuir.pz3.courses.dao.implementation;

import by.netcracker.bsuir.pz3.courses.constant.Logging;
import by.netcracker.bsuir.pz3.courses.constant.Queries;
import by.netcracker.bsuir.pz3.courses.dao.TeacherDao;
import by.netcracker.bsuir.pz3.courses.entity.Teacher;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {

    private static Logger logger = LogManager.getLogger(TeacherDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void addTeacher(Teacher teacher) {

        entityManager.persist(teacher);
        logger.info(Logging.ADD_TEACHER_LOG + teacher);
    }

    public Teacher getTeacherById(int id) {
        Teacher teacher = entityManager.find(Teacher.class, id);
        logger.info(Logging.GET_TEACHER_BY_ID_LOG + teacher);

        return teacher;
    }

    public void updateTeacher(Teacher teacher) {
        entityManager.merge(teacher);
        logger.info(Logging.UPDATE_TEACHER_LOG + teacher);
    }

    public void deleteTeacher(int id) {
        Teacher teacher = entityManager.find(Teacher.class, id);
        if (teacher != null) {
            entityManager.remove(teacher);
        }

        logger.info(Logging.DELETE_TEACHER_LOG + teacher);
    }

    public List<Teacher> getTeachers() {
        List<Teacher> teachers = entityManager.createQuery(Queries.GET_TEACHERS).getResultList();
        for (Teacher teacher: teachers) {
            logger.info(Logging.TEACHER_LIST_LOG + teacher);
        }

        return teachers;
    }
}
