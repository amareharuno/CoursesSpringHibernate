package by.netcracker.bsuir.pz3.courses.dao.implementation;

import by.netcracker.bsuir.pz3.courses.constant.UserTable;
import by.netcracker.bsuir.pz3.courses.dao.UserDao;
import by.netcracker.bsuir.pz3.courses.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static Logger logger = LogManager.getLogger(UserDaoImpl.class);

    @PersistenceContext(unitName = "courses_spring")
    private EntityManager entityManager;

    public void addUser(User user) {

        entityManager.persist(user);
        logger.info(UserTable.ADD_LOG + user);
    }

    public User getUserById(int id) {

        User user = entityManager.find(User.class, id);
        logger.info(UserTable.GET_BY_ID_LOG + user);

        return user;
    }

    public void updateUser(User user) {

        entityManager.merge(user);
        logger.info(UserTable.UPDATE_LOG + user);
    }

    public void deleteUser(int id) {

        User user = entityManager.find(User.class, id);

        if (user != null) {
            entityManager.remove(user);
        }
        logger.info(UserTable.DELETE_LOG + user);
    }

    public List<User> getUsers() {

        List<User> users = entityManager.createQuery(UserTable.GET_USERS).getResultList();

        for (User user: users) {
            logger.info(UserTable.USER_LIST_LOG + user);
        }

        return users;
    }
}
