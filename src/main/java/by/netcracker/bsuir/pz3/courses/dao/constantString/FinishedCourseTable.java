package by.netcracker.bsuir.pz3.courses.dao.constantString;

public class FinishedCourseTable {

    // table name
    public static final String FINISHED_COURSE_TABLE = "FinishedCourse";

    // fields
    public static final String ID = "finishedCourseId";
    public static final String ASSESSMENT = "assessment";
    public static final String REVIEW = "review";

    // queries
    public static final String GET_FINISHED_COURSES = "from FinishedCourse";

    // logs
    public static final String ADD_LOG = "Finished course successfully added. Finished course details: ";
    public static final String GET_BY_ID_LOG = "Finished course successfully got. Finished course details: ";
    public static final String UPDATE_LOG = "Finished course successfully updated. Finished course details: ";
    public static final String DELETE_LOG = "Finished course successfully deleted. Details: ";
    public static final String GET_ALL_LOG = "Finished course list: ";
}
