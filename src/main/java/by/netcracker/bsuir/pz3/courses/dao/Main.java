package by.netcracker.bsuir.pz3.courses.dao;

import by.netcracker.bsuir.pz3.courses.dao.entity.UserDao;
import by.netcracker.bsuir.pz3.courses.dao.entity.implementation.SqlUserDao;
import by.netcracker.bsuir.pz3.courses.entity.User;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = SqlUserDao.INSTANCE;
        userDao.addUser(new User("login", "password", "name",
                "lname", "mname"));
    }
}
