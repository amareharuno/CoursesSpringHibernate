package by.netcracker.bsuir.pz3.courses.dao.constantString;

public class UserTable {

    public static final String USER_TABLE = "User";

    // Column's name
    public static final String ID = "userId";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String MIDDLE_NAME = "middleName";

    public static final String ADD_LOG = "User successfully added. Details: ";
    public static final String GET_BY_ID_LOG = "User successfully got. Details: ";
    public static final String UPDATE_LOG = "User updated successfully. Details: ";
    public static final String DELETE_LOG = "User successfully deleted. Details:..?";
    public static final String USER_LIST_LOG = "User list: ";

    public static final String GET_USERS = "from User";

    // Query
//    public static final String GET_USER_BY_ID = "SELECT * FROM `courses`.`user` WHERE `userId`=?;";
//    public static final String CREATE_USER = "INSERT INTO `courses`.`user` (`login`, `password`, " +
//            "`isTeacher`) VALUES (?, ?, ?);";
//    public static final String DELETE_USER = "DELETE FROM `courses`.`user` WHERE `userId`=?;";
//    public static final String UPDATE_USER = "UPDATE `courses`.`user` SET `login`=?, `password`=?, " +
//            "`isTeacher`=? WHERE `userId`=?;";
//    public static final String GET_USERS = "SELECT * FROM courses.user;";
//    public static final String GET_USER_BY_LOGIN_INFO = "SELECT * FROM `courses`.`user` WHERE `login`=? AND `password`=?;";
}
