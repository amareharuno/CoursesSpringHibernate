package by.netcracker.bsuir.pz3.courses.dao.implementation;

import by.netcracker.bsuir.pz3.courses.dao.constant.LoggingAndExceptionMessage;
import by.netcracker.bsuir.pz3.courses.dao.constant.Queries;
import by.netcracker.bsuir.pz3.courses.dao.UserDao;
import by.netcracker.bsuir.pz3.courses.entity.User;
import by.netcracker.bsuir.pz3.courses.dao.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl extends DaoImpl<User> implements UserDao {

    private static Logger logger = LogManager.getLogger(UserDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void add(User user) throws DaoException {
        logger.info(LoggingAndExceptionMessage.USER_DAO_IMPL_ADD);
        try {
            entityManager.persist(user);
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.ADD_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.ADD_USER_LOG + user);
    }

    public User getById(int id) throws DaoException {
        logger.info(LoggingAndExceptionMessage.USER_DAO_IMPL_GET);
        User user;
        try {
            user = entityManager.find(User.class, id);
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.GET_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.GET_USER_BY_ID_LOG + user);
        return user;
    }

    public void update(User user) throws DaoException {
        logger.info(LoggingAndExceptionMessage.USER_DAO_IMPL_UPDATE);
        try {
            entityManager.merge(user);
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.UPDATE_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.UPDATE_USER_LOG + user);
    }

    public void delete(int id) throws DaoException {
        logger.info(LoggingAndExceptionMessage.USER_DAO_IMPL_DELETE);
        User user;
        try {
            user = entityManager.find(User.class, id);
            if (user != null) {
                entityManager.remove(user);
            }
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.DELETE_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.DELETE_USER_LOG + user);
    }

    public List<User> getAll() throws DaoException {
        logger.info(LoggingAndExceptionMessage.USER_DAO_IMPL_GET_ALL);
        List<User> users;
        try {
            users = entityManager.createQuery(Queries.GET_USERS).getResultList();
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.GET_ALL_FAIL, exception);
        }
        for (User user: users) {
            logger.info(LoggingAndExceptionMessage.USER_LIST_LOG + user);
        }
        return users;
    }
}
