package by.netcracker.bsuir.pz3.courses.dao.entity.implementation;

import by.netcracker.bsuir.pz3.courses.dao.table.TeacherTable;
import by.netcracker.bsuir.pz3.courses.dao.entity.TeacherDao;
import by.netcracker.bsuir.pz3.courses.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public enum  SqlTeaherDao implements TeacherDao {

    INSTANCE;

    private final Logger logger = LoggerFactory.getLogger(SqlTeaherDao.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addTeacher(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(teacher);
        logger.info(TeacherTable.ADD_LOG + teacher);
    }

    public Teacher getTeacherById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = session.load(Teacher.class, id);
        logger.info(TeacherTable.GET_BY_ID_LOG + teacher);

        return teacher;
    }

    public void updateTeacher(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.update(teacher);
        logger.info(TeacherTable.UPDATE_LOG + teacher);
    }

    public void deleteTeacher(int id) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = session.load(Teacher.class, id);

        if (teacher != null) {
            session.delete(teacher);
        }

        logger.info(TeacherTable.DELETE_LOG + teacher);
    }

    public List<Teacher> getTeachers() {
        Session session = sessionFactory.getCurrentSession();
        List<Teacher> teachers = session.createQuery(TeacherTable.GET_TEACHERS).list();

        for (Teacher teacher: teachers) {
            logger.info(TeacherTable.TEACHER_LIST + teacher);
        }

        return teachers;
    }
}
