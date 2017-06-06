package by.netcracker.bsuir.pz3.courses.service.implementation;

import by.netcracker.bsuir.pz3.courses.entity.Student;
import by.netcracker.bsuir.pz3.courses.entity.User;
import by.netcracker.bsuir.pz3.courses.service.StudentService;
import by.netcracker.bsuir.pz3.courses.service.TeacherService;
import by.netcracker.bsuir.pz3.courses.service.UserService;
import by.netcracker.bsuir.pz3.courses.service.exception.ServiceException;
import by.netcracker.bsuir.pz3.courses.service.util.RoleChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<User> implements UserService {

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @Override
    public void signUpUser(String login, String password, String name,
                           String lastName, String middleName, String role) throws ServiceException {
        User user = new User(login, password, name, lastName, middleName);
        this.add(user);
        if (RoleChecker.INSTANSE.isStudent(role)) {
            Student student = new Student(user);
            studentService.add(student);
        }
    }

    @Override
    public void signInUser(String login, String password) throws ServiceException {

    }

}
