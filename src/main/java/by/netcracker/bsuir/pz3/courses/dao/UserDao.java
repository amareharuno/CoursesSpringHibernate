package by.netcracker.bsuir.pz3.courses.dao;

import by.netcracker.bsuir.pz3.courses.entity.User;
import by.netcracker.bsuir.pz3.courses.exception.DaoException;

import java.util.List;

public interface UserDao {

    void addUser(User user) throws DaoException;
    User getUserById(int id) throws DaoException;
    void updateUser(User user) throws DaoException;
    void deleteUser(int id) throws DaoException;

    List<User> getUsers() throws DaoException;
}
