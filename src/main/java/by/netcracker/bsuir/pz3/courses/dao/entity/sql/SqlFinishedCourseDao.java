package by.netcracker.bsuir.pz3.courses.dao.entity.sql;

import by.netcracker.bsuir.pz3.courses.dao.constantString.FinishedCourseTable;
import by.netcracker.bsuir.pz3.courses.dao.entity.FinishedCourseDao;
import by.netcracker.bsuir.pz3.courses.entity.FinishedCourse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public enum SqlFinishedCourseDao implements FinishedCourseDao{

    INSTANCE;

    private final Logger logger = LoggerFactory.getLogger(SqlFinishedCourseDao.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void AddFinishedCourse(FinishedCourse finishedCourse) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(finishedCourse);
        logger.info(FinishedCourseTable.ADD_LOG + finishedCourse);
    }

    public FinishedCourse getFinishedCourseById(int id) {
        Session session = sessionFactory.getCurrentSession();
        FinishedCourse finishedCourse = session.load(FinishedCourse.class, id);
        logger.info(FinishedCourseTable.GET_BY_ID_LOG + finishedCourse);

        return finishedCourse;
    }

    public void updateFinishedCourse(FinishedCourse finishedCourse) {
        Session session = sessionFactory.getCurrentSession();
        session.update(finishedCourse);
        logger.info(FinishedCourseTable.UPDATE_LOG + finishedCourse);
    }

    public void deleteFinishedCourse(int id) {
        Session session = sessionFactory.getCurrentSession();
        FinishedCourse finishedCourse = session.load(FinishedCourse.class, id);

        if (finishedCourse != null) {
            session.delete(finishedCourse);
        }

        logger.info(FinishedCourseTable.DELETE_LOG + finishedCourse);
    }

    public List<FinishedCourse> getFinishedCourses() {
        Session session = sessionFactory.getCurrentSession();
        List<FinishedCourse> finishedCourses = session.createQuery(FinishedCourseTable.GET_FINISHED_COURSES).list();

        for (FinishedCourse finishedCourse : finishedCourses) {
            logger.info(FinishedCourseTable.GET_ALL_LOG + finishedCourse);
        }
        return finishedCourses;
    }
}
