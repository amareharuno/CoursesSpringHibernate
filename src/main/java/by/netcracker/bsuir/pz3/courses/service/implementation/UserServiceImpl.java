package by.netcracker.bsuir.pz3.courses.service.implementation;

import by.netcracker.bsuir.pz3.courses.entity.Student;
import by.netcracker.bsuir.pz3.courses.entity.Teacher;
import by.netcracker.bsuir.pz3.courses.entity.User;
import by.netcracker.bsuir.pz3.courses.service.StudentService;
import by.netcracker.bsuir.pz3.courses.service.TeacherService;
import by.netcracker.bsuir.pz3.courses.service.UserService;
import by.netcracker.bsuir.pz3.courses.service.constant.LoggingAndExceptionMessage;
import by.netcracker.bsuir.pz3.courses.service.exception.ServiceException;
import by.netcracker.bsuir.pz3.courses.util.RoleChecker;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends ServiceImpl<User> implements UserService {

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Transactional
    @Override
    public void signInUser(String login, String password) throws ServiceException {
        logger.info(LoggingAndExceptionMessage.USER_SIGN_IN);
    }

    @Transactional
    @Override
    public void signUpUser(String login, String password, String name,
                           String lastName, String middleName, String role) throws ServiceException {

        logger.info(LoggingAndExceptionMessage.USER_SIGN_UP);
        User user = new User(login, password, name, lastName, middleName);
        this.add(user);
        if (RoleChecker.INSTANCE.isStudent(role)) {
            Student student = new Student(user);
            studentService.add(student);
        } else if (RoleChecker.INSTANCE.isTeacher(role)){
            Teacher teacher = new Teacher(user);
            teacherService.add(teacher);
        }
    }
}
