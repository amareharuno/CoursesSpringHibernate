package by.netcracker.bsuir.pz3.courses.service.implementation;

import by.netcracker.bsuir.pz3.courses.dao.TeacherDao;
import by.netcracker.bsuir.pz3.courses.entity.Teacher;
import by.netcracker.bsuir.pz3.courses.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends ServiceImpl<Teacher> implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public Teacher getByUserId(int userId) {
        return teacherDao.getByUserId(userId);
    }
}
