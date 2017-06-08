package by.netcracker.bsuir.pz3.courses.dao;

import by.netcracker.bsuir.pz3.courses.dao.exception.DaoException;
import by.netcracker.bsuir.pz3.courses.entity.User;

public interface UserDao extends Dao<User> {
    User getUserByLogin(String login) throws DaoException;
}
