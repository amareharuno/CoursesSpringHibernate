package by.netcracker.bsuir.pz3.courses.dao.implementation;

import by.netcracker.bsuir.pz3.courses.constant.FinishedCourseTable;
import by.netcracker.bsuir.pz3.courses.dao.FinishedCourseDao;
import by.netcracker.bsuir.pz3.courses.entity.FinishedCourse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FinishedCourseDaoImpl implements FinishedCourseDao{

    @PersistenceContext
    private EntityManager entityManager;
    private static Logger logger = LogManager.getLogger(FinishedCourseDao.class);

//    private SessionFactory sessionFactory;
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    public void AddFinishedCourse(FinishedCourse finishedCourse) {
        /*Session session = sessionFactory.getCurrentSession();
        session.persist(finishedCourse);*/

        entityManager.persist(finishedCourse);
        logger.info(FinishedCourseTable.ADD_LOG + finishedCourse);
    }

    public FinishedCourse getFinishedCourseById(int id) {
        /*Session session = sessionFactory.getCurrentSession();
        FinishedCourse finishedCourse = session.load(FinishedCourse.class, id);*/

        FinishedCourse finishedCourse = entityManager.find(FinishedCourse.class, id);
        logger.info(FinishedCourseTable.GET_BY_ID_LOG + finishedCourse);

        return finishedCourse;
    }

    public void updateFinishedCourse(FinishedCourse finishedCourse) {
        /*Session session = sessionFactory.getCurrentSession();
        session.update(finishedCourse);*/

        entityManager.merge(finishedCourse);
        logger.info(FinishedCourseTable.UPDATE_LOG + finishedCourse);
    }

    public void deleteFinishedCourse(int id) {
        /*Session session = sessionFactory.getCurrentSession();
        FinishedCourse finishedCourse = session.load(FinishedCourse.class, id);*/

        FinishedCourse finishedCourse = entityManager.find(FinishedCourse.class, id);

        if (finishedCourse != null) {
            entityManager.remove(finishedCourse);
        }

        logger.info(FinishedCourseTable.DELETE_LOG + finishedCourse);
    }

    public List<FinishedCourse> getFinishedCourses() {
//        Session session = sessionFactory.getCurrentSession();
//        List<FinishedCourse> finishedCourses = session.createQuery(FinishedCourseTable.GET_FINISHED_COURSES).list();

        List<FinishedCourse> finishedCourses = entityManager.createQuery(
                FinishedCourseTable.GET_FINISHED_COURSES).getResultList();
        for (FinishedCourse finishedCourse : finishedCourses) {
            logger.info(FinishedCourseTable.GET_ALL_LOG + finishedCourse);
        }
        return finishedCourses;
    }
}
