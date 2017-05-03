package by.netcracker.bsuir.pz3.courses.dao.entity.implementation;

import by.netcracker.bsuir.pz3.courses.dao.bdTableInfo.FinishedCourseTable;
import by.netcracker.bsuir.pz3.courses.dao.entity.FinishedCourseDao;
import by.netcracker.bsuir.pz3.courses.entity.FinishedCourse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public enum SqlFinishedCourseDao implements FinishedCourseDao{

    INSTANCE;

    @PersistenceContext(unitName = "courses_spring")
    private EntityManager entityManager;
    private final Logger logger = LoggerFactory.getLogger(SqlFinishedCourseDao.class);

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
