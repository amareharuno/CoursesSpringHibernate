package by.netcracker.bsuir.pz3.courses.dao.implementation;

import by.netcracker.bsuir.pz3.courses.constant.Logging;
import by.netcracker.bsuir.pz3.courses.constant.Queries;
import by.netcracker.bsuir.pz3.courses.dao.FinishedCourseDao;
import by.netcracker.bsuir.pz3.courses.entity.FinishedCourse;
import by.netcracker.bsuir.pz3.courses.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FinishedCourseDaoImpl implements FinishedCourseDao{

    @PersistenceContext
    private EntityManager entityManager;
    private static Logger logger = LogManager.getLogger(FinishedCourseDao.class);

    public void AddFinishedCourse(FinishedCourse finishedCourse) throws DaoException {
        entityManager.persist(finishedCourse);
        logger.info(Logging.ADD_FINISHED_COURSE_LOG + finishedCourse);
    }

    public FinishedCourse getFinishedCourseById(int id) throws DaoException {
        FinishedCourse finishedCourse = entityManager.find(FinishedCourse.class, id);
        logger.info(Logging.GET_FINISHED_COURSE_BY_ID_LOG + finishedCourse);

        return finishedCourse;
    }

    public void updateFinishedCourse(FinishedCourse finishedCourse) throws DaoException {
        entityManager.merge(finishedCourse);
        logger.info(Logging.UPDATE_FINISHED_COURSE_LOG + finishedCourse);
    }

    public void deleteFinishedCourse(int id) throws DaoException {
        FinishedCourse finishedCourse = entityManager.find(FinishedCourse.class, id);

        if (finishedCourse != null) {
            entityManager.remove(finishedCourse);
        }

        logger.info(Logging.DELETE_FINISHED_COURSE_LOG + finishedCourse);
    }

    public List<FinishedCourse> getFinishedCourses() throws DaoException {
        List<FinishedCourse> finishedCourses = entityManager.createQuery(Queries.GET_FINISHED_COURSES)
                .getResultList();
        for (FinishedCourse finishedCourse : finishedCourses) {
            logger.info(Logging.GET_ALL_FINISHED_COURSE_LOG + finishedCourse);
        }
        return finishedCourses;
    }
}
