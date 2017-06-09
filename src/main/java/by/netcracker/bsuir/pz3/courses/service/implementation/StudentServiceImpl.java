package by.netcracker.bsuir.pz3.courses.service.implementation;

import by.netcracker.bsuir.pz3.courses.dao.StudentDao;
import by.netcracker.bsuir.pz3.courses.entity.Student;
import by.netcracker.bsuir.pz3.courses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<Student> implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getByUserId(int userId) {
        return studentDao.getByUserId(userId);
    }
}
