package by.netcracker.bsuir.pz3.courses.dao.entity.implementation;

import by.netcracker.bsuir.pz3.courses.dao.bdTableInfo.UserTable;
import by.netcracker.bsuir.pz3.courses.dao.entity.UserDao;
import by.netcracker.bsuir.pz3.courses.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public enum UserDaoImpl implements UserDao {

    INSTANCE;

    private final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @PersistenceContext(unitName = "courses_spring")
    private EntityManager entityManager;

//    private SessionFactory sessionFactory;
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    public void addUser(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.persist(user);

        entityManager.persist(user);
        logger.info(UserTable.ADD_LOG + user);
    }

    public User getUserById(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        User user = session.load(User.class, id);

        User user = entityManager.find(User.class, id);
        logger.info(UserTable.GET_BY_ID_LOG + user);

        return user;
    }

    public void updateUser(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.update(user);

        entityManager.merge(user);
        logger.info(UserTable.UPDATE_LOG + user);
    }

    public void deleteUser(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        User user = session.load(User.class, id);

        User user = entityManager.find(User.class, id);

        if (user != null) {
            entityManager.remove(user);
        }
        logger.info(UserTable.DELETE_LOG + user);
    }

    public List<User> getUsers() {
//        Session session = sessionFactory.getCurrentSession();
//        List<User> users = session.createQuery(UserTable.GET_USERS).list();

        List<User> users = entityManager.createQuery(UserTable.GET_USERS).getResultList();

        for (User user: users) {
            logger.info(UserTable.USER_LIST_LOG + user);
        }

        return users;
    }
}
