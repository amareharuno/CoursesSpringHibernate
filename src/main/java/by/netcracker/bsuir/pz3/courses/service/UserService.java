package by.netcracker.bsuir.pz3.courses.service;

import by.netcracker.bsuir.pz3.courses.entity.User;
import by.netcracker.bsuir.pz3.courses.service.exception.ServiceException;

public interface UserService extends Service<User> {
    boolean signUpUser(String login, String password, String name, String lastName, String middleName, String role) throws ServiceException;
    User signInUser(String login, String password) throws ServiceException ;
}
