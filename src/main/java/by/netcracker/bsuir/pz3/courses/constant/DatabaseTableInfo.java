package by.netcracker.bsuir.pz3.courses.constant;

public final class DatabaseTableInfo {

    // ----- COURSE TABLE -----
    public static final String COURSE_TABLE = "Course";
    // fields
    public static final String COURSE_ID = "courseId";
    public static final String SUBJECT = "subject";
    public static final String NAME = "courseName";
    public static final String LESSONS_COUNT = "lessonsCount";
    public static final String LESSON_DURATION = "lessonDuration";
    public static final String COURSE_DURATION = "courseDuration";

    // ----- FINISHED COURSE TABLE -----
    public static final String FINISHED_COURSE_TABLE = "FinishedCourse";
    // fields
    public static final String FINISHED_COURSE_ID = "finishedCourseId";
    public static final String ASSESSMENT = "assessment";
    public static final String REVIEW = "review";

    // ----- STUDENT TABLE -----
    public static final String STUDENT_TABLE = "Student";
    // fields
    public static final String STUDENT_ID = "studentId";

    // ----- TEACHER TABLE -----
    public static final String TEACHER_TABLE = "Teacher";
    // fields
    public static final String TEACHER_ID = "teacherId";

    // ----- USER TABLE -----
    public static final String USER_TABLE = "User";
    // fields
    public static final String USER_ID = "userId";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String MIDDLE_NAME = "middleName";

}
