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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository
public class UserDaoImpl extends DaoImpl<User> implements UserDao {

    private static Logger logger = LogManager.getLogger(UserDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public User getUserByLogin(String login) throws DaoException {
        logger.info(LoggingAndExceptionMessage.USER_DAO_IMPL_GET_USER_BY_LOGIN);
        User user;
        try {
            Query query = entityManager.createQuery(Queries.GET_USER_BY_LOGIN);
            query.setParameter("login", login);
            user = (User) query.getSingleResult();
        } catch (NoResultException exception) {
            logger.info(LoggingAndExceptionMessage.GET_USER_BY_LOGIN_FAIL);
            user = null;
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.GET_USER_BY_LOGIN_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.GET_USER_BY_LOGIN_LOG + user);
        return user;
    }

    @Override
    public User getUserByPassword(String password) throws DaoException {
        logger.info(LoggingAndExceptionMessage.USER_DAO_IMPL_GET_USER_BY_PASSWORD);
        User user;

        List<String> list = new ArrayList<>();
        list.add("Name");
        list.add("Cat");


        System.out.println();

        try {
            Query query = entityManager.createQuery(Queries.GET_USER_BY_PASSWORD);
            query.setParameter("password", password);
            user = (User) query.getSingleResult();
        } catch (NoResultException exception) {
            logger.info(LoggingAndExceptionMessage.GET_USER_BY_PASSWORD_FAIL);
            user = null;
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.GET_USER_BY_PASSWORD_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.GET_USER_BY_PASSWORD_LOG + user);
        return user;
    }

    @Override
    public User getUserByLoginAndPassword(String login, String password) throws DaoException {
        logger.info(LoggingAndExceptionMessage.USER_DAO_IMPL_GET_USER_BY_LOGIN_AND_PASSWORD);
        User user;
        try {
            Query query = entityManager.createQuery(Queries.GET_USER_BY_LOGIN_AND_PASSWORD);
            query.setParameter("password", password);
            query.setParameter("login", login);
            user = (User) query.getSingleResult();
        } catch (NoResultException exception) { // если такой юзер не найден
            logger.info(LoggingAndExceptionMessage.GET_USER_BY_LOGIN_AND_PASSWORD_FAIL);
            user = null;
        } catch (HibernateException exception) {
            logger.error(exception);
            throw new DaoException(LoggingAndExceptionMessage.GET_USER_BY_LOGIN_AND_PASSWORD_FAIL, exception);
        }
        logger.info(LoggingAndExceptionMessage.GET_USER_BY_LOGIN_AND_PASSWORD_LOG + user);
        return user;
    }
}
