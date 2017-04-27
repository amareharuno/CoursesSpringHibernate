package by.netcracker.bsuir.pz3.courses.dao.constantString;

public class CourseTable {

    // table name
    public static final String COURSE_TABLE = "Course";

    // fields
    public static final String ID = "courseId";
    public static final String SUBJECT = "subject";
    public static final String NAME = "courseName";
    public static final String LESSONS_COUNT = "lessonsCount";
    public static final String LESSON_DURATION = "lessonDuration";
    public static final String COURSE_DURATION = "courseDuration";

    // queries
    public static final String GET_COURSES = "from Course";

    // logs
    public static final String ADD_LOG = "Course successfully added. Course details: ";
    public static final String GET_BY_ID_LOG = "Course successfully got. Course details: ";
    public static final String UPDATE_LOG = "Course successfully updated. Course details: ";
    public static final String DELETE_LOG = "Course successfully deleted. Course details: ";
    public static final String COURSE_LIST = "Course list: ";
}
