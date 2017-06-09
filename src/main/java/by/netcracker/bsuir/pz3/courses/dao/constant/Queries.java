package by.netcracker.bsuir.pz3.courses.dao.constant;

public final class Queries {
    public static final String GET_COURSES = "from Course";
    public static final String GET_FINISHED_COURSES = "from FinishedCourse";
    public static final String GET_STUDENTS = "from Student ";
    public static final String GET_TEACHERS = "from Teacher";
    public static final String GET_USERS = "from User";
    public static final String GET_USER_BY_LOGIN = "SELECT user FROM User user WHERE user.login = :login";
    public static final String GET_USER_BY_LOGIN_AND_PASSWORD = "SELECT user FROM User user WHERE user.password = :password AND user.login = :login";
    public static final String GET_USER_BY_PASSWORD = "SELECT user FROM User user WHERE user.password = :password";
    public static final String GET_TEACHER_BY_USER_ID = "SELECT teacher FROM Teacher teacher WHERE teacher.user.id = :userId";
    public static final String GET_STUDENT_BY_USER_ID = "SELECT student FROM Student student WHERE student.user.id = :userId";
}
