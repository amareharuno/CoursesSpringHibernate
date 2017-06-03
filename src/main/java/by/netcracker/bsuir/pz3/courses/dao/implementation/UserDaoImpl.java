package by.netcracker.bsuir.pz3.courses.dao.implementation;

import by.netcracker.bsuir.pz3.courses.constant.Logging;
import by.netcracker.bsuir.pz3.courses.constant.Queries;
import by.netcracker.bsuir.pz3.courses.dao.UserDao;
import by.netcracker.bsuir.pz3.courses.entity.User;
import by.netcracker.bsuir.pz3.courses.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static Logger logger = LogManager.getLogger(UserDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void addUser(User user) throws DaoException {
        logger.debug(Logging.COURSE_DAO_IMPL_ADD);
        try {
            getEntityManager().persist(user);
        } catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(Logging.ADD_FAIL, exception);
        }
        logger.info(Logging.ADD_USER_LOG + user);
    }

    public User getUserById(int id) throws DaoException {
        logger.debug(Logging.COURSE_DAO_IMPL_GET);
        User user;
        try {
            user = entityManager.find(User.class, id);
        } catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(Logging.GET_FAIL, exception);
        }
        logger.info(Logging.GET_USER_BY_ID_LOG + user);
        return user;
    }

    public void updateUser(User user) throws DaoException {
        logger.debug(Logging.COURSE_DAO_IMPL_UPDATE);
        try {
            entityManager.merge(user);
        } catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(Logging.UPDATE_FAIL, exception);
        }
        logger.info(Logging.UPDATE_USER_LOG + user);
    }

    public void deleteUser(int id) throws DaoException {
        logger.debug(Logging.COURSE_DAO_IMPL_DELETE);
        User user;

        try {
            user = entityManager.find(User.class, id);
            if (user != null) {
                entityManager.remove(user);
            }
        } catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(Logging.DELETE_FAIL, exception);
        }
        logger.info(Logging.DELETE_USER_LOG + user);
    }

    public List<User> getUsers() throws DaoException {
        logger.debug(Logging.COURSE_DAO_IMPL_GET_ALL);
        List<User> users;
        try {
            users = entityManager.createQuery(Queries.GET_USERS).getResultList();
        } catch (HibernateException exception) {
            logger.debug(exception);
            throw new DaoException(Logging.GET_ALL_FAIL, exception);
        }
        for (User user: users) {
            logger.info(Logging.USER_LIST_LOG + user);
        }
        return users;
    }
}
