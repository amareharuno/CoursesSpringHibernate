package by.netcracker.bsuir.pz3.courses.service.implementation;

import by.netcracker.bsuir.pz3.courses.dao.StudentDao;
import by.netcracker.bsuir.pz3.courses.dao.TeacherDao;
import by.netcracker.bsuir.pz3.courses.dao.UserDao;
import by.netcracker.bsuir.pz3.courses.entity.Student;
import by.netcracker.bsuir.pz3.courses.entity.Teacher;
import by.netcracker.bsuir.pz3.courses.entity.User;
import by.netcracker.bsuir.pz3.courses.service.UserService;
import by.netcracker.bsuir.pz3.courses.service.constant.LoggingAndExceptionMessage;
import by.netcracker.bsuir.pz3.courses.service.exception.ServiceException;
import by.netcracker.bsuir.pz3.courses.web.constant.RequestParameterOrAttribute;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends ServiceImpl<User> implements UserService {

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private UserDao userDao;

    private Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Transactional
    @Override
    public User signInUser(String login, String password) throws ServiceException {
        logger.info(LoggingAndExceptionMessage.USER_SIGN_IN);
        return userDao.getUserByLoginAndPassword(login, String.valueOf(password.hashCode()));
    }

    @Transactional
    @Override
    public boolean signUpUser(String login, String password, String name,
                              String lastName, String middleName, String role) throws ServiceException {

        logger.info(LoggingAndExceptionMessage.USER_SIGN_UP);

        User userByLogin = userDao.getUserByLogin(login);
        User userByPassword = userDao.getUserByPassword(String.valueOf(password.hashCode()));

        if (userByLogin != null || userByPassword != null) {
            logger.info(LoggingAndExceptionMessage.USER_ALREADY_EXISTS);
            return false;
        } else {
            User user = new User(login, String.valueOf(password.hashCode()), name, lastName, middleName);
            userDao.add(user);
            if (role.equals(RequestParameterOrAttribute.STUDENT)) {
                Student student = new Student(user);
                studentDao.add(student);
            } else if (role.equals(RequestParameterOrAttribute.TEACHER)) {
                Teacher teacher = new Teacher(user);
                teacherDao.add(teacher);
            }
        }
        return true;
    }
}
