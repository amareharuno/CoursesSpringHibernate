package by.netcracker.bsuir.pz3.courses.service;

import by.netcracker.bsuir.pz3.courses.entity.User;
import by.netcracker.bsuir.pz3.courses.service.exception.ServiceException;

public interface UserService extends Service<User> {
    void signUpUser(String login, String password, String name, String lastName, String middleName, String role) throws ServiceException;
    void signInUser(String login, String password) throws ServiceException ;
}
