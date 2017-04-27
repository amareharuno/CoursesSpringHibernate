package by.netcracker.bsuir.pz3.courses.dao.entity;

import by.netcracker.bsuir.pz3.courses.entity.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);
    User getUserById(int id);
    void updateUser(User user);
    void deleteUser(int id);

    List<User> getUsers();
}
