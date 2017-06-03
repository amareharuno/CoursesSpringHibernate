package by.netcracker.bsuir.pz3.courses.dao.implementation;

import by.netcracker.bsuir.pz3.courses.constant.Logging;
import by.netcracker.bsuir.pz3.courses.constant.Queries;
import by.netcracker.bsuir.pz3.courses.dao.UserDao;
import by.netcracker.bsuir.pz3.courses.entity.User;
import by.netcracker.bsuir.pz3.courses.exception.DaoException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static Logger logger = LogManager.getLogger(UserDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void addUser(User user) throws DaoException {

        entityManager.persist(user);
        logger.info(Logging.ADD_USER_LOG + user);
    }

    public User getUserById(int id) throws DaoException {

        User user = entityManager.find(User.class, id);
        logger.info(Logging.GET_USER_BY_ID_LOG + user);

        return user;
    }

    public void updateUser(User user) throws DaoException {

        entityManager.merge(user);
        logger.info(Logging.UPDATE_USER_LOG + user);
    }

    public void deleteUser(int id) throws DaoException {

        User user = entityManager.find(User.class, id);

        if (user != null) {
            entityManager.remove(user);
        }
        logger.info(Logging.DELETE_USER_LOG + user);
    }

    public List<User> getUsers() throws DaoException {

        List<User> users = entityManager.createQuery(Queries.GET_USERS).getResultList();

        for (User user: users) {
            logger.info(Logging.USER_LIST_LOG + user);
        }

        return users;
    }
}
